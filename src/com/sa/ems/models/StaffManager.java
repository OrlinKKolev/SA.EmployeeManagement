package com.sa.ems.models;

import com.sa.ems.HelperMethods;
import com.sa.ems.StaffManagementApp;
import com.sa.ems.models.interfaces.Manager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StaffManager extends Employee implements Manager {

	public StaffManager(int id, String name, LocalDate startDate, String role, double salary) {
		super(id, name, startDate, Department.MANAGEMENT, role, salary);
	}


	@Override
	public void addEmployee(Scanner sc) {
		System.out.println("Enter id:");
		id = Integer.parseInt(sc.nextLine());
		System.out.println("Choose Department:");
		department = HelperMethods.getDepartments(sc);
		System.out.println("Enter role:");
		role = sc.nextLine();
		System.out.println("Enter name:");
		name = sc.nextLine();
		System.out.println("Enter start date in YYYY-MM-DD format:");
		startDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println("Enter salary:");
		salary = Double.parseDouble(sc.nextLine());
		Employee emp = new Employee(id, name, startDate, department, role, salary);
		StaffManagementApp.employees.add(emp);
	}

	@Override
	public void editEmployee(Scanner sc) {
		System.out.println("Enter id:");
		id = Integer.parseInt(sc.nextLine());
		int indexInList = HelperMethods.searchId(id);
		StaffManagementApp.employees.remove(indexInList);
		System.out.println("Choose Department:");
		department = HelperMethods.getDepartments(sc);
		System.out.println("Enter role:");
		role = sc.nextLine();
		System.out.println("Enter name:");
		name = sc.nextLine();
		System.out.println("Enter start date in YYYY-MM-DD format:");
		startDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println("Enter salary:");
		salary = Double.parseDouble(sc.nextLine());
		Employee emp = new Employee(id, name, startDate, department, role, salary);
		StaffManagementApp.employees.add(emp);
	}

	@Override
	public void fireEmployee(Scanner sc) {
		System.out.println("Enter id:");
		id = Integer.parseInt(sc.nextLine());
		int indexInList = HelperMethods.searchId(id);
		String[] values = StaffManagementApp.employees.get(indexInList).toString().split(",");
		StaffManagementApp.employees.remove(indexInList);
		name = values[1];
		startDate= LocalDate.parse(values[2]);
		department= Department.valueOf(values[4]);
		role=values[5];
		salary= Double.parseDouble(values[6]);
		System.out.printf("Enter end date for %s in YYYY-MM-DD format:%n",name);
		endDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Employee emp = new Employee(id, name, startDate,endDate, department, role, salary);
		StaffManagementApp.employees.add(emp);
	}

	@Override
	public void listEmployees() {
		int i = 0;
		for (var emp : StaffManagementApp.employees) {
			System.out.println(StaffManagementApp.employees.get(i));
			i++;
		}

	}
}
