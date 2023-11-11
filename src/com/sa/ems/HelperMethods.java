package com.sa.ems;

import com.sa.ems.models.Department;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HelperMethods {

	public static boolean hasHeaders = false;
	public static String headers;

	//checks if string is parsable to int
	public static boolean isInt(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			int isInt = Integer.parseInt(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	//choose department as int from list
	public static Department getDepartments(Scanner sc) {
		List<Department> departmentList = Arrays.asList(Department.values());
		int i = 0;
		for (var element : departmentList) {
			System.out.printf("%d: %s %n", i + 1, departmentList.get(i));
			i++;
		}
		var index = Integer.parseInt(sc.nextLine());
		return departmentList.get(index - 1);
	}

	//search for existing id in the records with or without headers
	public static int searchId(int id) {
		int row = 0;
		if (hasHeaders) {
			boolean notFound = true;
			for (int i = 1; i < StaffManagementApp.employees.size(); i++) {
				String[] elements = StaffManagementApp.employees.get(i).toString().split(",");
				if (Integer.parseInt(elements[0]) == id) {
					System.out.printf("id %d successfully found in the records, please follow the instructions %n", id);
					notFound = false;
					row = i;
					break;
				}
			}
			if (notFound) {
				System.out.println("No such id in the records");
			}
		} else {
			boolean notFound = true;
			for (int i = 0; i < StaffManagementApp.employees.size(); i++) {
				String[] elements = StaffManagementApp.employees.get(i).toString().split(",");
				if (Integer.parseInt(elements[0]) == id) {
					System.out.printf("id %d successfully found in the records, please follow the instructions %n", id);
					notFound = false;
					break;
				}
			}
			if (notFound) {
				System.out.println("No such id in the records");
			}
		}

		return row;
	}


}
