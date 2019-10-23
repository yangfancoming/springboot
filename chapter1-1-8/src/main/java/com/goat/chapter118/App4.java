package com.goat.chapter118;

import com.goat.chapter118.model.SlDept;
import com.goat.chapter118.model.SlEmployee;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import org.junit.Test;

/**
 * Created by 64274 on 2019/10/23.
 *
 * @ Description: 在Ognl表达式用调用方法，大家都知道方法分为静态方法和非静态方法
 * @ author  山羊来了
 * @ date 2019/10/23---15:58
 */
public class App4 {


    @Test
    public void test3() throws OgnlException {

        // 新建一个部门对象并设置部门名称
        SlDept dept = new SlDept();
        dept.setName("上海部");

        // 新建一个员工对象并设置员工姓名
        SlEmployee emp = new SlEmployee();
        emp.setName("李小龙");
        emp.setSlDept(dept);
        emp.setAge("22");
        // 构建一个OgnlContext对象
        OgnlContext context = new OgnlContext();

        // 将上述部门和员工对象放入Ognl上下文环境中
        context.put("dept", dept);
        context.put("emp", emp);

        // 将员工设置为跟对象
        context.setRoot(emp);

        // 从根对象中直接获取部门名称长度，非静态方法
        Object expression = Ognl.parseExpression("slDept.name.length()");
        Object length = Ognl.getValue(expression, context, context.getRoot());
        System.out.println(length);

        // 在Ognl表达式中使用静态方法
        expression = Ognl.parseExpression("@java.lang.Integer@valueOf(age)");
        length = Ognl.getValue(expression, context, context.getRoot());
        System.out.println(length);
    }

}
