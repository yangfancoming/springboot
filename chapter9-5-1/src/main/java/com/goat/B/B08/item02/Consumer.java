package com.goat.B.B08.item02;

/**
 * Created by 64274 on 2019/10/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/10---17:04
 */
public class Consumer {

    private String name;
    private Integer star;
    private Integer existsYears;
    private Integer combos;

    public Consumer(String name, Integer star, Integer existsYears, Integer combos) {
        this.name = name;
        this.star = star;
        this.existsYears = existsYears;
        this.combos = combos;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getExistsYears() {
        return existsYears;
    }

    public void setExistsYears(Integer existsYears) {
        this.existsYears = existsYears;
    }

    public Integer getCombos() {
        return combos;
    }

    public void setCombos(Integer combos) {
        this.combos = combos;
    }
}
