package com.goat.model;

import java.math.BigDecimal;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "persons")
public class Person {

	private ObjectId id;

	private String username;

	private String country;

	private Address address;

	private Favorites favorites;

	private int age;

	private BigDecimal salary;

	private float lenght;

    public Person() {
    }

    public Person(String username, String country, int age, BigDecimal salary, float lenght) {
        this.username = username;
        this.country = country;
        this.age = age;
        this.salary = salary;
        this.lenght = lenght;
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Favorites getFavorites() {
		return favorites;
	}

	public void setFavorites(Favorites favorites) {
		this.favorites = favorites;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public float getLenght() {
		return lenght;
	}

	public void setLenght(float lenght) {
		this.lenght = lenght;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", username=" + username + ", country=" + country + ", address=" + address
				+ ", favorites=" + favorites + ", age=" + age + ", salary=" + salary + ", lenght=" + lenght + "]";
	}

}
