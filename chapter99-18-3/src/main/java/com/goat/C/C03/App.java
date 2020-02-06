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
     *  从打印结果来看, getActualTypeArguments()返回Type[]，即“<>”里的参数，比如Map<String,Integer>
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
