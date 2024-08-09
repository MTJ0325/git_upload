package com.cathaybk.practice.nt50342.b;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class HRMain {
	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();

		employees.add(new Sales("張志城", "信用卡部", 35000, 6000));
		employees.add(new Sales("林大鈞", "保代部", 38000, 4000));
		employees.add(new Supervisor("李中白", "資訊部", 65000));
		employees.add(new Supervisor("林小中", "理財部", 80000));

		for (Employee employee : employees) {
			employee.printInfo();
			System.out.println();
		}

		String filePath = "C:\\Users\\Admin\\Desktop\\Java班\\git_upload\\Java\\output.csv";

		try (BufferedWriter writer = new BufferedWriter(
		        new OutputStreamWriter(new FileOutputStream(filePath, true), "UTF-8"))) {

		    writer.write("Name,Payment");
		    writer.newLine();

		    for (Employee employee : employees) {
		        writer.write(String.format("%s,%d", employee.getName(), employee.calculatePayment()));
		        writer.newLine();
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
}


