package com.goat.xml.bean;

public class Student {

	private int rollNumber;
	private String firstName;
	private String lastName;
	private String nickName;
	private int marks;

    public Student() {
    }

    public Student(int rollNumber, String firstName, String lastName, String nickName, int marks) {
        this.rollNumber = rollNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.marks = marks;
    }

    public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public String toString() {
		return "Student[Roll number="+getRollNumber()+", First name="+getFirstName()+", Last name="+getLastName()+", Nick name="+getNickName()+", Marks="+getMarks()+"]";
	}
	
}
