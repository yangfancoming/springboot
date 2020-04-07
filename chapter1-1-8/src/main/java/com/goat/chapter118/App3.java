package com.goat.chapter118;

import com.goat.chapter118.model.SlDept;
import com.goat.chapter118.model.SlEmployee;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import org.junit.Test;

/**
 * Created by 64274 on 2019/10/23.
 * 1.获取普通对象的属性值方式
 * 2.获取根对象的属性值的方式，有两种
 * @ author  山羊来了
 * @ date 2019/10/23---15:58
 */
public class App3 {

    @Test
    public void test1() throws OgnlException {
        Object obj = Ognl.getValue("'helloworld'.length()", null);
        System.out.println(obj);
    }

    /**
     * dept对象就是放置到OgnlContext中的普通对象，对于这种普通对象，只能通过“#dept.name”的方式去获取属性值，
     * 需要注意的是dept指的是放置到上下文中key的值，另外在Dept类型中要提供getName方法；
    */
    @Test
    public void test2() throws OgnlException {
        // 新建一个部门对象并设置部门名称
        SlDept dept = new SlDept("销售部");
        // 新建一个员工对象并设置员工姓名
        SlEmployee emp = new SlEmployee(dept,"张三");
        // 构建一个OgnlContext对象，并将上述部门和员工对象放入Ognl上下文环境中
        OgnlContext context = new OgnlContext();
        context.put("dept", dept);
        context.put("emp", emp);

        // 将员工设置为根节点
        context.setRoot(emp);


        // 第一种 从普通对象中直接获取部门名称
        Object expression1 = Ognl.parseExpression("#dept.name");
        // 解析树状表达式，返回结果
        System.out.println( Ognl.getValue(expression1, context, context.getRoot()));
        // 第二种 间接获取部门名称
        Object expression4 =  Ognl.parseExpression("#emp.slDept.name");
        System.out.println(Ognl.getValue(expression4, context, context.getRoot()));
        System.out.println("-------------------------------------------");

        // 第三种 从根对象中直接获取部门名称
        Object expression5=  Ognl.parseExpression("slDept.name");
        System.out.println(Ognl.getValue(expression5, context, context.getRoot()));
        System.out.println("-------------------------------------------");
        /**
         * 获取根对象的属性值的方式，有两种：
         * 原理是这样的，如果Ognl在解析表达式的时候发现表达式开头带有"#"，会去普通对象中，去寻找，
         * 如果没有"#"，则会默认去根对象中去寻找，由于根对象只有一个，所以只需要属性名字
        */
        // 第一种
        Object expression2 = Ognl.parseExpression("#emp.name");
        System.out.println(Ognl.getValue(expression2, context, context.getRoot()));
        System.out.println("-------------------------------------------");

        // 第二种，直接写属性名称就可以，注意：这个时候就不要加“#”
        Object expression3 = Ognl.parseExpression("name");
        System.out.println(Ognl.getValue(expression3, context, context.getRoot()));
    }

}
