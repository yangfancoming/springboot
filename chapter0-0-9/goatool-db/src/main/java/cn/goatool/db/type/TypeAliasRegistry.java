
package cn.goatool.db.type;



import cn.goatool.core.io.Resources;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.util.*;

/**
 TypeAliasRegistry（类型别名注册器）
 在类型别名注册器类TypeAliasRegistry的无参构造器中进行了大量的基础类型别名的注册（设置），涉及到的有：
 　　　　1.字符串类型（别名类似string）
 　　　　2.基本类型包装器类型及其数组类型（别名类似byte、byte[]）
 　　　　3.基本类型及其数组类型（别名类似_byte、_byte[]）
 　　　　4.日期类型及其数组类型（别名类似date、date[]）
 　　　　5.大数字类型及其数组类型（别名类似bigdecimal、bigdecimal[]）
 　　　　6.Object类型及其数组类型（别名类似object、object[]）
 　　　　7.集合类型（别名类似collection、map、list、hsahmap、arraylist、iterator）
 　　　　8.ResultSet结果集类型（别名为ResultSet）
 　注意：这并不是全部的MyBatis内置的类型别名，还有一部分类型别名是在创建Configuration实例的时候在其无参构造器中进行注册的，这里暂不介绍。
*/
public class TypeAliasRegistry {
  //这就是核心所在啊， 原来别名就仅仅通过一个HashMap来实现， key为别名， value就是别名对应的类型（class对象）
  private final Map<String, Class<?>> typeAliases = new HashMap<>();

  //构造函数里注册系统内置的类型别名
  public TypeAliasRegistry() {
    //字符串类型
    registerAlias("string", String.class);
    //基本包装类型
    registerAlias("byte", Byte.class);
    registerAlias("long", Long.class);
    registerAlias("short", Short.class);
    registerAlias("int", Integer.class);
    registerAlias("integer", Integer.class);
    registerAlias("double", Double.class);
    registerAlias("float", Float.class);
    registerAlias("boolean", Boolean.class);
    //基本数组包装类型
    registerAlias("byte[]", Byte[].class);
    registerAlias("long[]", Long[].class);
    registerAlias("short[]", Short[].class);
    registerAlias("int[]", Integer[].class);
    registerAlias("integer[]", Integer[].class);
    registerAlias("double[]", Double[].class);
    registerAlias("float[]", Float[].class);
    registerAlias("boolean[]", Boolean[].class);
    //加个下划线，就变成了基本类型
    registerAlias("_byte", byte.class);
    registerAlias("_long", long.class);
    registerAlias("_short", short.class);
    registerAlias("_int", int.class);
    registerAlias("_integer", int.class);
    registerAlias("_double", double.class);
    registerAlias("_float", float.class);
    registerAlias("_boolean", boolean.class);
    //加个下划线，就变成了基本数组类型
    registerAlias("_byte[]", byte[].class);
    registerAlias("_long[]", long[].class);
    registerAlias("_short[]", short[].class);
    registerAlias("_int[]", int[].class);
    registerAlias("_integer[]", int[].class);
    registerAlias("_double[]", double[].class);
    registerAlias("_float[]", float[].class);
    registerAlias("_boolean[]", boolean[].class);
    //日期数字型
    registerAlias("date", Date.class);
    registerAlias("decimal", BigDecimal.class);
    registerAlias("bigdecimal", BigDecimal.class);
    registerAlias("biginteger", BigInteger.class);
    registerAlias("object", Object.class);
    //集合型
    registerAlias("date[]", Date[].class);
    registerAlias("decimal[]", BigDecimal[].class);
    registerAlias("bigdecimal[]", BigDecimal[].class);
    registerAlias("biginteger[]", BigInteger[].class);
    registerAlias("object[]", Object[].class);
    //还有个ResultSet型
    registerAlias("map", Map.class);
    registerAlias("hashmap", HashMap.class);
    registerAlias("list", List.class);
    registerAlias("arraylist", ArrayList.class);
    registerAlias("collection", Collection.class);
    registerAlias("iterator", Iterator.class);

    registerAlias("ResultSet", ResultSet.class);
  }

  //取出 已经注册的类型别名
  @SuppressWarnings("unchecked")
  public <T> Class<T> resolveAlias(String string) {  // throws class cast exception as well if types cannot be assigned
    try {
      if (string == null) {
        return null;
      }
      // issue #748
      /**
       先转成小写再解析 这里转个小写也有bug？见748号bug(在google code上)
       https://code.google.com/p/mybatis/issues
       比如 如果本地语言是Turkish，那i转成大写就不是I了，而是另外一个字符（İ）。这样土耳其的机器就用不了mybatis了！这是一个很大的bug，但是基本上每个人都会犯......
      */
      String key = string.toLowerCase(Locale.ENGLISH);
      Class<T> value;
      //原理就很简单了，从HashMap里找对应的键值，找到则返回类型别名对应的Class
      if (typeAliases.containsKey(key)) {
        value = (Class<T>) typeAliases.get(key);
      } else {
        //找不到，再试着将String直接转成Class(这样怪不得我们也可以直接用java.lang.Integer的方式定义，也可以就int这么定义)
        value = (Class<T>) Resources.classForName(string);
      }
      return value;
    } catch (ClassNotFoundException e) {
      throw new TypeException("Could not resolve type alias '" + string + "'.  Cause: " + e, e);
    }
  }


  public void registerAlias(Class<?> type) {
    String alias = type.getSimpleName();
    // 判断 @Alias("what")
    Alias aliasAnnotation = type.getAnnotation(Alias.class);
    if (aliasAnnotation != null) {
      // 面试题  mybatis 配置别名的三种方式中 优先级最高的为 @Alias("what") 注解！
      alias = aliasAnnotation.value();
    }
    registerAlias(alias, type);
  }

  //注册类型别名
  public void registerAlias(String alias, Class<?> value) {
    if (alias == null) {
      throw new TypeException("The parameter alias cannot be null");
    }
    // issue #748
    String key = alias.toLowerCase(Locale.ENGLISH);
    /**
     如果已经存在key了，且value和之前不一致，报错
     这里逻辑略显复杂，感觉没必要，一个key对一个value呗，存在key直接报错不就得了
    */
    if (typeAliases.containsKey(key) && typeAliases.get(key) != null && !typeAliases.get(key).equals(value)) {
      throw new TypeException("The alias '" + alias + "' is already mapped to the value '" + typeAliases.get(key).getName() + "'.");
    }
    typeAliases.put(key, value);
  }

  public void registerAlias(String alias, String value) {
    try {
      registerAlias(alias, Resources.classForName(value));
    } catch (ClassNotFoundException e) {
      throw new TypeException("Error registering type alias " + alias + " for " + value + ". Cause: " + e, e);
    }
  }

  /**
   * @since 3.2.2
   */
  public Map<String, Class<?>> getTypeAliases() {
    return Collections.unmodifiableMap(typeAliases);
  }

}
