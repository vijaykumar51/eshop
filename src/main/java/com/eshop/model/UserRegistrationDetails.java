package com.eshop.model;

public class UserRegistrationDetails {

	private String name;
	private int age;
	private String contactNo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "UserRegistrationDetails [name=" + name + ", age=" + age + ", contactNo=" + contactNo + "]";
	}
	
}
