package com.goat.C.C01;

/**
 * Created by Administrator on 2020/2/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/6---20:10
 *
 *  Type接口是java编程语言中所有类型的公共高级接口，它们包括原始类型、参数化类型、数组类型、类型变量和基本类型。
 *  所有已知的实现类有GenericArrayType, ParameterizedType, TypeVariable, WildcardType；
 *
 * ParameterizedType: 表示一种参数化的类型，比如Collection
 * GenericArrayType: 表示一种元素类型是参数化类型或者类型变量的数组类型
 * TypeVariable: 是各种类型变量的公共父接口
 * WildcardType: 代表一种通配符类型表达式，比如?, ? extends Number, ? super Integer【wildcard是一个单词：就是“通配符”】
 *
 * Type所有类型指代的有：
 * 原始类型 (raw types)【对应Class】，
 * 参数化类型 (parameterizedtypes)【对应ParameterizedType】，
 * 数组类型 (array types)【对应GenericArrayType】，
 * 类型变量 (type variables)【对应TypeVariable】，
 * 基本数据类型(primitivetypes)【仍然对应Class】
 */
public class App {}
