package com.cathaybk.practice.nt50342.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomLotto {

    public static void main(String[] args) {
        Random random = new Random(); // 新建一個 Random 物件，用於生成隨機數
        List<Integer> numbers = new ArrayList<>(); // 新建一個 ArrayList 用來存放隨機生成的數字

        // 隨機生成 5 個 1 到 49 的數字
        for (int i = 0; i < 5; i++) {
            int rand = random.nextInt(49) + 1; // 生成 1 到 49 的隨機整數
            numbers.add(rand); // 將隨機數字加入 List 中
        }

        // 把 List 中的數字進行排序
        Collections.sort(numbers); // 使用 Collections.sort 將 List 中的數字排序

        // 輸出排序後的數字
        for (int number : numbers) {
            System.out.print(number + " "); // 印出每個數字，並在數字之間加上空格
        }
    }
}