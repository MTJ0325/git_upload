package com.cathaybk.practice.nt50342.b;

public class Supervisor extends Employee {

    public Supervisor(String name, String department, int salary) {
        super(name, department, salary);
    }

    // 計算總薪資，只包括薪水，沒有額外的獎金
    public int calculatePayment() {
        return getSalary();
    }

    // 印出員工資訊，包括總薪資
    public void printInfo() {
        super.printInfo();
        System.out.println("總計: " + calculatePayment());
    }
}