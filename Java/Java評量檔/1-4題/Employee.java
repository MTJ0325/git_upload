package com.cathaybk.practice.nt50342.b;

public abstract class Employee implements IWork {
    private String name; // 員工姓名
    private String department; // 員工部門
    private int salary; // 員工薪水

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

    // 印出基本員工資訊，包括姓名、部門和薪水
    public void printInfo() {
        System.out.println("姓名: " + name + " 部門: " + department + "\n月薪: " + salary);
    }

    // 抽象方法，子類別需要實現此方法用來計算總薪資
    public abstract int calculatePayment();
}