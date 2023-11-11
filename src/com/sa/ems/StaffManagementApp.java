package com.sa.ems;

import com.sa.ems.fileOperations.CSVReader;
import com.sa.ems.fileOperations.CSVWriter;
import com.sa.ems.fileOperations.CustomReader;
import com.sa.ems.fileOperations.CustomWriter;

import com.sa.ems.models.StaffManager;
import com.sa.ems.models.interfaces.Manager;


import java.io.Serializable;

import java.time.LocalDate;
import java.util.*;

public class StaffManagementApp {
	public static List<Serializable> employees = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CustomReader reader = new CSVReader();
		var resources = reader.read("./src/resources/files/employees.csv");
		employees.add(HelperMethods.headers);
		employees.addAll(resources);
		Manager manager = new StaffManager(15, "Han Solo", LocalDate.of(2013, 12, 11), "CTO", 6623.13);

		System.out.println("Welcome to Staff Management System");
		boolean isRunning = true;
		while (isRunning) {
			displayCommands();
			int command = Integer.parseInt(sc.nextLine());
			switch (command) {
				case 1:
					manager.listEmployees();
					break;
				case 2:
					manager.addEmployee(sc);
					break;
				case 3:
					manager.editEmployee(sc);
					break;
				case 4:
					manager.fireEmployee(sc);
					break;
				case 9:
					saveAndExit();
				case 0:
					return;
			}
		}
	}

	private static void displayCommands() {
		System.out.println("Choose an option from the list below:");
		System.out.println("1. List");
		System.out.println("2. Add");
		System.out.println("3. Edit");
		System.out.println("4. Fire employee");
		System.out.println("9. Save and Exit");
		System.out.println("0. Abort");
	}

	public static void saveAndExit() {
		CustomWriter writer = new CSVWriter();
		writer.write(employees, "./src/resources/files/employees.csv");

	}

}
