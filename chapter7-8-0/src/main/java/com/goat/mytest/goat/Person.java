package com.goat.mytest.goat;

import com.goat.mytest.fly.DeviceType;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {

	private Integer id;
    private Integer age;
	private String name;
	private String city;
	private DeviceType deviceType;
	private Dept dept;
    private List<Order> orders;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(Integer id, String name, String city, Integer age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public Person(Integer id, Integer age, String name, String city, DeviceType deviceType) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.city = city;
        this.deviceType = deviceType;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}
