package com.cathaybk.practice.nt50342.b;

public class Sales extends Employee {
	private int bonus;
	private int payment;

	public Sales(String name, String department, int salary, int salesAmount) {
		super(name, department, salary);
		this.bonus = (int) (salesAmount * 0.05);
		this.payment = calculatePayment();
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
		this.payment = calculatePayment();
	}

	public Object getPayment() {
		return payment;
	}

	@Override
	public int calculatePayment() {
		return getSalary() + bonus;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("業績獎金: " + bonus + "\n總計: " + getPayment());
	}
}
