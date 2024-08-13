package com.cathaybk.practice.nt50342.b;

public class NineNineTable {

    public static void main(String[] args) {
        int maxWidth = 0; // 用於記錄每個表項的最大寬度

        // 首先先確定每個表項的最大寬度
        for (int multiplier = 1; multiplier <= 9; multiplier++) {
            for (int multiplicand = 2; multiplicand <= 9; multiplicand++) {
                int product = multiplicand * multiplier;
                
                // 計算當前表項的長度，包括等號和空格
                int length = (multiplicand + "*" + multiplier + "=" + (product < 10 ? " " : "") + product + " ").length();
                // 更新最大寬度
                if (length > maxWidth) {
                    maxWidth = length;
                }
            }
        }

        // 使用最大寬度格式化並打印九九乘法表
        for (int multiplier = 1; multiplier <= 9; multiplier++) {
            for (int multiplicand = 2; multiplicand <= 9; multiplicand++) {
                int product = multiplicand * multiplier;
                
                // 新建格式化的表項字串
                String entry = multiplicand + "*" + multiplier + "=" + (product < 10 ? " " : "") + product;
                // 印出表項，確保每個表項的寬度一致
                System.out.print(String.format("%-" + maxWidth + "s", entry));
            }
            System.out.println(); // 每行結束後換行
        }
    }
}

