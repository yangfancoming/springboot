package cn.goatool.core.reflect;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * Created by Administrator on 2020/2/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/6---18:05
 */
public class TypeParameterResolver {

    private TypeParameterResolver() {
        super();
    }


    public static Type resolveReturnType(Method method, Type srcType) {
        Type returnType = method.getGenericReturnType();
        Class<?> declaringClass = method.getDeclaringClass();
        return resolveType(returnType, srcType, declaringClass);
    }

    /** 主要是根据字段类型来匹配是属于哪个类型的，然后返回
     * 获取类型信息
     * @param type 根据是否有泛型信息签名选择传入泛型类型或简单类型
     * @param srcType 引用字段/方法的类（可能是子类，字段和方法在父类声明）
     * @param declaringClass 字段/方法声明的类
     * @return
     */
    private static Type resolveType(Type type, Type srcType, Class<?> declaringClass) {
        if (type instanceof TypeVariable) {
            return resolveTypeVar((TypeVariable<?>) type, srcType, declaringClass);
        } else if (type instanceof ParameterizedType) {
            return resolveParameterizedType((ParameterizedType) type, srcType, declaringClass);
        } else if (type instanceof GenericArrayType) {
            return resolveGenericArrayType((GenericArrayType) type, srcType, declaringClass);
        } else {
            return type;
        }
    }


    private static Type resolveGenericArrayType(GenericArrayType genericArrayType, Type srcType, Class<?> declaringClass) {
        Type componentType = genericArrayType.getGenericComponentType();
        Type resolvedComponentType = null;
        if (componentType instanceof TypeVariable) {
            resolvedComponentType = resolveTypeVar((TypeVariable<?>) componentType, srcType, declaringClass);
        } else if (componentType instanceof GenericArrayType) {
            resolvedComponentType = resolveGenericArrayType((GenericArrayType) componentType, srcType, declaringClass);
        } else if (componentType instanceof ParameterizedType) {
            resolvedComponentType = resolveParameterizedType((ParameterizedType) componentType, srcType, declaringClass);
        }
        if (resolvedComponentType instanceof Class) {
            return Array.newInstance((Class<?>) resolvedComponentType, 0).getClass();
        } else {
            return new GenericArrayTypeImpl(resolvedComponentType);
        }
    }

    /**
     resolveTypeVar 用于解析泛型类型变量参数类型，如果字段或方法在当前类中声明，
     则返回泛型类型的上界或 Object 类型；如果在父类中声明，则递归解析父类；
     父类也无法解析，则递归解析实现的接口。
     */
    private static Type resolveTypeVar(TypeVariable<?> typeVar, Type srcType, Class<?> declaringClass) {
        Type result;
        Class<?> clazz;
        if (srcType instanceof Class) {
            // 原始类型
            clazz = (Class<?>) srcType;
        } else if (srcType instanceof ParameterizedType) {
            // 泛型类型，如 TestObj<String>
            ParameterizedType parameterizedType = (ParameterizedType) srcType;
            // 取原始类型TestObj
            clazz = (Class<?>) parameterizedType.getRawType();
        } else {
            throw new IllegalArgumentException("The 2nd arg must be Class or ParameterizedType, but was: " + srcType.getClass());
        }

        if (clazz == declaringClass) {
            // 字段就是在当前引用类中声明的
            Type[] bounds = typeVar.getBounds();
            if (bounds.length > 0) {
                // 返回泛型类型变量上界，如：T extends String，则返回String
                return bounds[0];
            }
            // 没有上界返回Object
            return Object.class;
        }
        // 字段/方法在父类中声明，递归查找父类泛型
        Type superclass = clazz.getGenericSuperclass();
        result = scanSuperTypes(typeVar, srcType, declaringClass, clazz, superclass);
        if (result != null) {
            return result;
        }
        // 递归泛型接口
        Type[] superInterfaces = clazz.getGenericInterfaces();
        for (Type superInterface : superInterfaces) {
            result = scanSuperTypes(typeVar, srcType, declaringClass, clazz, superInterface);
            if (result != null) {
                return result;
            }
        }
        return Object.class;
    }

    private static ParameterizedType resolveParameterizedType(ParameterizedType parameterizedType, Type srcType, Class<?> declaringClass) {
        Class<?> rawType = (Class<?>) parameterizedType.getRawType();
        Type[] typeArgs = parameterizedType.getActualTypeArguments();
        Type[] args = testMe(typeArgs, srcType, declaringClass);
        return new ParameterizedTypeImpl(rawType, null, args);
    }

    private static Type[] resolveWildcardTypeBounds(Type[] bounds, Type srcType, Class<?> declaringClass) {
        return testMe(bounds,srcType,declaringClass);
    }

    // -modify 抽取重复代码
    private static Type[] testMe(Type[] bounds, Type srcType, Class<?> declaringClass) {
        Type[] result = new Type[bounds.length];
        for (int i = 0; i < bounds.length; i++) {
            if (bounds[i] instanceof TypeVariable) {
                result[i] = resolveTypeVar((TypeVariable<?>) bounds[i], srcType, declaringClass);
            } else if (bounds[i] instanceof ParameterizedType) {
                result[i] = resolveParameterizedType((ParameterizedType) bounds[i], srcType, declaringClass);
            } else if (bounds[i] instanceof WildcardType) {
                result[i] = resolveWildcardType((WildcardType) bounds[i], srcType, declaringClass);
            } else {
                result[i] = bounds[i];
            }
        }
        return result;
    }

    private static Type resolveWildcardType(WildcardType wildcardType, Type srcType, Class<?> declaringClass) {
        Type[] lowerBounds = resolveWildcardTypeBounds(wildcardType.getLowerBounds(), srcType, declaringClass);
        Type[] upperBounds = resolveWildcardTypeBounds(wildcardType.getUpperBounds(), srcType, declaringClass);
        return new WildcardTypeImpl(lowerBounds, upperBounds);
    }

    private static Type scanSuperTypes(TypeVariable<?> typeVar, Type srcType, Class<?> declaringClass, Class<?> clazz, Type superclass) {
        if (superclass instanceof ParameterizedType) {
            // 父类是泛型类型
            ParameterizedType parentAsType = (ParameterizedType) superclass;
            Class<?> parentAsClass = (Class<?>) parentAsType.getRawType();
            // 父类中的泛型类型变量集合
            TypeVariable<?>[] parentTypeVars = parentAsClass.getTypeParameters();
            if (srcType instanceof ParameterizedType) {
                // 子类可能对父类泛型变量做过替换，使用替换后的类型
                parentAsType = translateParentTypeVars((ParameterizedType) srcType, clazz, parentAsType);
            }
            if (declaringClass == parentAsClass) {
                // 字段/方法在当前父类中声明
                for (int i = 0; i < parentTypeVars.length; i++) {
                    if (typeVar == parentTypeVars[i]) {
                        // 使用变量对应位置的真正类型（可能已经被替换），如父类 A<T>，子类 B extends A<String>，则返回String
                        return parentAsType.getActualTypeArguments()[i];
                    }
                }
            }
            // 字段/方法声明的类是当前父类的父类，继续递归
            if (declaringClass.isAssignableFrom(parentAsClass)) {
                return resolveTypeVar(typeVar, parentAsType, declaringClass);
            }
        } else if (superclass instanceof Class && declaringClass.isAssignableFrom((Class<?>) superclass)) {
            // 父类是原始类型，继续递归父类
            return resolveTypeVar(typeVar, superclass, declaringClass);
        }
        return null;
    }

    private static ParameterizedType translateParentTypeVars(ParameterizedType srcType, Class<?> srcClass, ParameterizedType parentType) {
        Type[] parentTypeArgs = parentType.getActualTypeArguments();
        Type[] srcTypeArgs = srcType.getActualTypeArguments();
        TypeVariable<?>[] srcTypeVars = srcClass.getTypeParameters();
        Type[] newParentArgs = new Type[parentTypeArgs.length];
        boolean noChange = true;
        for (int i = 0; i < parentTypeArgs.length; i++) {
            if (parentTypeArgs[i] instanceof TypeVariable) {
                for (int j = 0; j < srcTypeVars.length; j++) {
                    if (srcTypeVars[j] == parentTypeArgs[i]) {
                        noChange = false;
                        newParentArgs[i] = srcTypeArgs[j];
                    }
                }
            } else {
                newParentArgs[i] = parentTypeArgs[i];
            }
        }
        return noChange ? parentType : new ParameterizedTypeImpl((Class<?>)parentType.getRawType(), null, newParentArgs);
    }

    static class ParameterizedTypeImpl implements ParameterizedType {
        private Class<?> rawType;

        private Type ownerType;

        private Type[] actualTypeArguments;

        public ParameterizedTypeImpl(Class<?> rawType, Type ownerType, Type[] actualTypeArguments) {
            super();
            this.rawType = rawType;
            this.ownerType = ownerType;
            this.actualTypeArguments = actualTypeArguments;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return actualTypeArguments;
        }

        @Override
        public Type getOwnerType() {
            return ownerType;
        }

        @Override
        public Type getRawType() {
            return rawType;
        }

        @Override
        public String toString() {
            return "ParameterizedTypeImpl [rawType=" + rawType + ", ownerType=" + ownerType + ", actualTypeArguments=" + Arrays.toString(actualTypeArguments) + "]";
        }
    }


    static class WildcardTypeImpl implements WildcardType {

        private Type[] lowerBounds;

        private Type[] upperBounds;

        WildcardTypeImpl(Type[] lowerBounds, Type[] upperBounds) {
            super();
            this.lowerBounds = lowerBounds;
            this.upperBounds = upperBounds;
        }

        @Override
        public Type[] getLowerBounds() {
            return lowerBounds;
        }

        @Override
        public Type[] getUpperBounds() {
            return upperBounds;
        }
    }

    static class GenericArrayTypeImpl implements GenericArrayType {
        private Type genericComponentType;

        GenericArrayTypeImpl(Type genericComponentType) {
            super();
            this.genericComponentType = genericComponentType;
        }

        @Override
        public Type getGenericComponentType() {
            return genericComponentType;
        }
    }

}
