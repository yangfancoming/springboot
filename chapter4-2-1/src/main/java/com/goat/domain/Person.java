package com.goat.domain;



import javax.persistence.*;

/**
 * Created by 64274 on 2018/10/17.
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/10/17---16:47
 */
@Entity
@Table(name = "t_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "my_age") //name 属性 用于设置映射数据库表的列名
    private Integer age;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="pet_id") // 本表中指向另一个表的外键。
    //    @NotFound(action= NotFoundAction.IGNORE)
    private Pet pet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", age='" + age + '\'' + '}';
    }
}
