package com.cathaybk.practice.nt50342.b;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class HRMain {
    public static void main(String[] args) {
        // 新建一個員工列表
        List<Employee> employees = new ArrayList<>();

        // 加入不同類型的員工到列表中
        employees.add(new Sales("張志城", "信用卡部", 35000, 6000));
        employees.add(new Sales("林大鈞", "保代部", 38000, 4000));
        employees.add(new Supervisor("李中白", "資訊部", 65000));
        employees.add(new Supervisor("林小中", "理財部", 80000));

        // 印出每個員工的資訊
        for (Employee employee : employees) {
            employee.printInfo(); // 調用每個員工的 printInfo 方法
            System.out.println();
        }

        // 設定輸出的 CSV 文件路徑
        String filePath = "C:\\Users\\Admin\\Desktop\\Java班\\git_upload\\Java\\output.csv";

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(filePath, true), "UTF-8"))) {

            // 寫入 CSV 文件的標題
            writer.write("Name,Payment");
            writer.newLine();

            // 寫入每個員工的姓名和計算後的薪資
            for (Employee employee : employees) {
                writer.write(String.format("%s,%d", employee.getName(), employee.calculatePayment()));
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace(); // 輸出錯誤訊息
        }
    }
}