package com.goat.B.B06.item04;

/**
 * Created by 64274 on 2019/7/16.
 *
 组合模式定义了包含人力资源部和财务部这些基本对象和分公司、办事处等组合对象的类层次结构。
 基本对象可以被组合成更复杂的组合对象，而这个组合对象又可以被组合，这样不断地递归下去，
 客户代码中，任何用到基本对象的地方都可以使用组合对象了。
 用户不关心到底是处理一个叶节点还是处理一个组合组件，也就用不着为定义组合而写一些选择判断语句了。
 组合模式让客户可以一致地使用组合结构和单个对象。
 只要写一套代码，就可以在不同层次级别中使用，而不用对不同层次的再重复开发一套代码
 */
public class App {

    public static void main(String[] args) {

        ConcreteCompany root = new ConcreteCompany("北京总公司");
        root.add(new HRDepartment("总公司人力资源部"));
        root.add(new FinanceDepartment("总公司财务部"));

        ConcreteCompany comp = new ConcreteCompany("华东分公司");
        comp.add(new HRDepartment("华东分公司人力资源部"));
        comp.add(new FinanceDepartment("华东分公司财务部"));
        root.add(comp);//将子公司添加到总公司

        ConcreteCompany comp1 = new ConcreteCompany("南京办事处");
        comp1.add(new HRDepartment("南京事处人力资源部"));
        comp1.add(new FinanceDepartment("南京办事处财务部"));
        root.add(comp1);//将子公司添加到总公司

        ConcreteCompany comp2 = new ConcreteCompany("杭州办事处");
        comp2.add(new HRDepartment("杭州办事处人力资源部"));
        comp2.add(new FinanceDepartment("杭州办事处财务部"));
        root.add(comp2);//将子公司添加到总公司

        System.out.println("结构图：");
        root.display(1);

        System.out.println("职责：");
        root.lineOfDuty();

    }
}
