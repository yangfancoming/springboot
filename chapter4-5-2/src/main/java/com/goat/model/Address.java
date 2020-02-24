package com.goat.model;

public class Address {
	
	private String aCode;
	private String add;

    public Address() {
    }

    public Address(String aCode, String add) {
        this.aCode = aCode;
        this.add = add;
    }

    public String getaCode() {
		return aCode;
	}
	public void setaCode(String aCode) {
		this.aCode = aCode;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	
	

}
