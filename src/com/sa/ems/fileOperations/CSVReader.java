package com.sa.ems.fileOperations;

import com.sa.ems.HelperMethods;
import com.sa.ems.models.Department;
import com.sa.ems.models.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements CustomReader {

	@Override
	public List<? extends Serializable> read(String filename) {
		List<Employee> employees = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				if (HelperMethods.isInt(values[0]) == false) {
					HelperMethods.hasHeaders=true;
					HelperMethods.headers=line;
				}

				if (HelperMethods.isInt(values[0])) {
					employees.add(new Employee(Integer.parseInt(values[0]),
							values[1],
							LocalDate.parse(values[2], DateTimeFormatter.ofPattern("yyyy-MM-dd")),
							Department.valueOf(values[4]),
							values[5],
							Double.parseDouble(values[6])));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return employees;
	}
}


