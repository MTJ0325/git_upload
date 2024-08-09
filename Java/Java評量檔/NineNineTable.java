package com.cathaybk.practice.nt50342.b;

public class NineNineTable {

    public static void main(String[] args) {
        int maxWidth = 0;


        for (int multiplier = 1; multiplier <= 9; multiplier++) {
            for (int multiplicand = 2; multiplicand <= 9; multiplicand++) {
                int product = multiplicand * multiplier;
         
                int length = (multiplicand + "*" + multiplier + "=" + (product < 10 ? " " : "") + product + " ").length();
                if (length > maxWidth) {
                    maxWidth = length;
                }
            }
        }

   
        for (int multiplier = 1; multiplier <= 9; multiplier++) {
            for (int multiplicand = 2; multiplicand <= 9; multiplicand++) {
                int product = multiplicand * multiplier;
         
                String entry = multiplicand + "*" + multiplier + "=" + (product < 10 ? " " : "") + product;
                System.out.print(String.format("%-" + maxWidth + "s", entry));
            }
            System.out.println();
        }
    }
}


