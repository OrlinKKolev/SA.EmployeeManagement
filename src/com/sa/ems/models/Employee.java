package com.sa.ems.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {
	int id;
	String name;
	LocalDate startDate;
	LocalDate endDate;
	Department department;
	String role;
	double salary;
	boolean isFired;

	public Employee(int id, String name, LocalDate startDate, Department department, String role, double salary) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
//		this.endDate = endDate;
		this.department = department;
		this.role = role;
		this.salary = salary;
		this.isFired = false;
	}

	public Employee(int id, String name, LocalDate startDate, LocalDate endDate, Department department, String role, double salary) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.department = department;
		this.role = role;
		this.salary = salary;
		this.isFired = true;
	}

	@Override
	public String toString() {

		return this.id + "," + this.name + "," + this.startDate + "," + this.endDate + "," + this.department+
		"," + this.role +"," + this.salary+"," + this.isFired;
	}

}
