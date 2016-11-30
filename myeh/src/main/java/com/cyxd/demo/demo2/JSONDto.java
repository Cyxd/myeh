package com.cyxd.demo.demo2;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class JSONDto {

	private String id;
	private String name;
	private Integer age;
	private Integer departMent;
	private String salary;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public Integer getDepartMent() {
		return departMent;
	}

	public String getSalary() {
		return salary;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setDepartMent(Integer departMent) {
		this.departMent = departMent;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public JSONDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JSONDto(String id, String name, Integer age, Integer departMent,
			String salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.departMent = departMent;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
