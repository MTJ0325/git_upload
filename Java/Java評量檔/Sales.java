package com.cathaybk.practice.nt50342.b;

public class Sales extends Employee {
    private int bonus; // 業績獎金

    public Sales(String name, String department, int salary, int salesAmount) {
        super(name, department, salary);
        // 計算業績獎金（業績的 5%）
        this.bonus = (int)(salesAmount * 0.05);
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    // 計算總薪資，包括薪水和業績獎金
    public int calculatePayment() {
        return getSalary() + bonus;
    }

    // 印出員工資訊，包括業績獎金和總薪資
    public void printInfo() {
        super.printInfo();
        System.out.println("業績獎金: " + bonus + "\n總計: " + calculatePayment());
    }
}

