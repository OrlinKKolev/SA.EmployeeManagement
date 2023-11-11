package com.sa.ems.models;

import java.time.LocalDate;
import java.util.Date;

public class ITEmployee extends Employee {
	public ITEmployee(int id, String name, LocalDate startDate, String role, double salary) {
		super(id, name, startDate, Department.IT, role, salary);
	}
}
