package com.cathaybk.practice.nt50342.b;

public abstract class Employee implements IWork {
	private String name;
	private String department;
	private int salary;

	public Employee(String name, String department, int salary) {
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void printInfo() {
		System.out.println("姓名: " + name + " 部門: " + department + "\n月薪: " + salary);
	}

	public abstract int calculatePayment();

	protected abstract Object getPayment();
}