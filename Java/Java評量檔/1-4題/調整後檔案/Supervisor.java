package com.cathaybk.practice.nt50342.b;

public class Supervisor extends Employee {
	private int payment;

	public Supervisor(String name, String department, int salary) {
		super(name, department, salary);
		this.payment = calculatePayment();
	}

	public Object getPayment() {
		return payment;
	}

	@Override
	public int calculatePayment() {
		return getSalary();
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("總計: " + getPayment());
	}
}