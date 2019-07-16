package com.goat.B.B06.item04;

/**
 * Created by 64274 on 2019/7/16.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/16---8:54
 */
//人力资源部
public class HRDepartment extends Company {

    public HRDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company c) {
    }

    @Override
    public void remove(Company c) {
    }

    // 履行职责
    @Override
    public void lineOfDuty() {
        System.out.println(name + "员工招聘管理培训");
    }
}