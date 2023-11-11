package com.sa.ems.models;

import java.time.LocalDate;
import java.util.Date;

public class HREmployee extends Employee{
	public HREmployee(int id, String name, LocalDate startDate,  String role, double salary) {
		super(id, name, startDate,  Department.HR, role, salary);
	}
}
