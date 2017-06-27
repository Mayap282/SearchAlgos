package edu.chap7.generics;

public class Employee {
	private String name;
	private Integer employeeId;
	private String gender;
	
	public Employee(String name,Integer employeeId,String gender) {
		this.name=name;
		this.employeeId=employeeId;
		this.gender=gender;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	

}
