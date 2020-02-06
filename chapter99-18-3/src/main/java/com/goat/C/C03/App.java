package com.goat.C.C03;

import com.goat.C.common.ParameterizedBean;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2020/2/6.
 *
 * @ Description: ParameterizedType 参数化类型 测试
 * ParameterizedType接口类型的含义：
 * 表示参数化类型。比如：Map这种参数化类型
 *
 * public static  E methodIV(   ArrayList<arraylist> al1,   ArrayList al2,   ArrayList al3,   ArrayList <? extends Number> al4,   ArrayList al5){}
 * {1}. 对于ArrayList<arraylist>，通过getActualTypeArguments()返回之后，脱去最外层的<>之后，剩余的类型是ArrayList。因此对这个参数的返回类型是ParameterizedType
 *
 * {2}. 对于ArrayList，通过getActualTypeArguments()返回之后，脱去最外层的<>之后，剩余的类型是E。因此对这个参数的返回类型是TypeVariable
 *
 * {3}. 对于ArrayList，通过getActualTypeArguments()返回之后，脱去最外层的<>之后，剩余的类型是String。因此对这个参数的返回类型是Class
 *
 * {4}. 对于ArrayList <? extends Number>，通过getActualTypeArguments()返回之后，脱去最外层的<>之后，剩余的类型是? Extends Number。因此对这个参数的返回类型是WildcardType
 *
 * {5}. 对于ArrayList，通过getActualTypeArguments()返回之后，脱去最外层的<>之后，剩余的类型是E[]。因此对这个参数的返回类型是GenericArrayType。
 *
 * 所以，可能获得各种各样类型的实际参数，所以为了统一，采用直接父类数组Type[]进行接收。
 *
 * @ author  山羊来了
 * @ date 2020/2/6---19:38
 */
public class App {

    Field[] fields = ParameterizedBean.class.getDeclaredFields();

    // 从打印结果看来,具有<>符号的变量 才是参数化类型
    @Test
    public void parameterizedTypeTest(){
        for(Field f:fields){
            //是否是ParameterizedType
            System.out.print(f.getName()+":"+(f.getGenericType() instanceof ParameterizedType) + "\n");
        }
    }

    /**
     *  从打印结果来看, 获取参数化类型<>中的实际类型 ，getActualTypeArguments()返回Type[]，即“<>”里的参数，比如Map<String,Integer>
     *     List<String> list1; // 变量：java.util.List<java.lang.String>     	 类型：java.lang.String
     *     Map<String,Long> map1;  // 变量：java.util.Map<java.lang.String, java.lang.Long>     	 类型：java.lang.String	 类型：java.lang.Long
     *     Map.Entry<Long,Short> map3;  // 变量：java.util.Map.java.util.Map$Entry<java.lang.Long, java.lang.Short>     	 类型：java.lang.Long	 类型：java.lang.Short
     */
    @Test
    public void getActualTypeArgumentsTest() {
        for (Field f : fields) {
            if (f.getGenericType() instanceof ParameterizedType) {
                ParameterizedType pType = (ParameterizedType) f.getGenericType();
                System.out.print("变量：" + pType.getTypeName() + "     ");
                Type[] types = pType.getActualTypeArguments();
                for (Type t : types) {
                    System.out.print("\t 类型：" + t.getTypeName());
                }
            }
            System.out.print("\n");
        }
    }

    /**
     *  从打印结果来看, getRawType()返回Tpye，得到“<>”前面的类型，比如List<String> 返回 java.util.List
     *     List<String> list1; // java.util.List
     *     Map<String,Long> map1;  // java.util.Map
     *     Map.Entry<Long,Short> map3;  // java.util.Map$Entry
    */
    @Test
    public void getRawTypeTest() {
        for(Field f:fields){
            if(f.getGenericType() instanceof ParameterizedType){
                ParameterizedType pType = (ParameterizedType) f.getGenericType();
                System.out.print("变量："+f.getName());
                System.out.print("RawType："+pType.getRawType().getTypeName());
            }
            System.out.print("\n");
        }
    }

    /**
     *  从打印结果来看, getOwnerType()返回Type，O<T>.I<S>类型变量调用时会返回O<T>，比如Map.Entry<Long,Short>
     *     List<String> list1; // 变量：list1	OwnerType:Null
     *     Map<String,Long> map1;  // 变量：map1	OwnerType:Null
     *     Map.Entry<Long,Short> map3;  // 变量：map3	OwnerType：java.util.Map
     */
    @Test
    public void getOwnerTypeTest() {
        for(Field f:fields){
            if(f.getGenericType() instanceof ParameterizedType){
                ParameterizedType pType = (ParameterizedType) f.getGenericType();
                System.out.print("变量："+f.getName() + "\t");
                Type t = pType.getOwnerType();
                if(t == null){
                    System.out.print("OwnerType:Null     ");
                }else{
                    System.out.print("OwnerType："+t.getTypeName());
                }
            }
            System.out.print("\n");
        }
    }
}
