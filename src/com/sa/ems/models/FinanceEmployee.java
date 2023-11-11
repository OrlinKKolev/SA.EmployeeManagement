package com.sa.ems.models;


import java.time.LocalDate;

public class FinanceEmployee extends  Employee{
	public FinanceEmployee(int id, String name, LocalDate startDate, String role, double salary) {
		super(id, name, startDate, Department.FINANCES, role, salary);
	}
}
