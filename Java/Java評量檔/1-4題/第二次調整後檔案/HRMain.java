package com.cathaybk.practice.nt50342.b;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class HRMain {
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Sales("張志誠", "信用卡部", 35000, 6000));
		employeeList.add(new Sales("林大鈞", "保代部", 38000, 4000));
		employeeList.add(new Supervisor("李中白", "資訊部", 65000));
		employeeList.add(new Supervisor("林小中", "理財部", 80000));
		for (Employee employee : employeeList) {
			employee.printInfo();
		}

		try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("C:\\Users\\Admin\\Desktop\\Java班\\git_upload\\Java\\output.csv"),
				StandardCharsets.UTF_8))) {
			int payment;
			for (Employee employee : employeeList) {
				if (employee instanceof Supervisor) {
					Supervisor supervisor = (Supervisor) employee;
					payment = supervisor.getPayment();

				} else {
					Sales sales = (Sales) employee;
					payment = sales.getPayment();
				}
				bufferedWriter.write(new StringBuilder().append(employee.getName()).append(",").append(payment)
						.append("\n").toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}