package com.goat.domain;



import javax.persistence.*;

/**
 * Created by 64274 on 2018/10/17.
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/10/17---16:47
 *   sos  在一个实体文件中，注解要么全部放在字段上，要么全部放在get方法上，不能混合使用！
 */
@Entity
@Table(name = "cum_demo")
public class CumDemo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer money;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
