package com.goat.chapter118.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 64274 on 2019/10/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/23---17:46
 */
public class SlDept implements java.io.Serializable {

    private static final long serialVersionUID = 3537237434024057830L;

    private String name;

    private Set<SlEmployee> slEmployees = new HashSet<>(0);

    public SlDept() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SlEmployee> getSlEmployees() {
        return slEmployees;
    }

    public void setSlEmployees(Set<SlEmployee> slEmployees) {
        this.slEmployees = slEmployees;
    }

}
