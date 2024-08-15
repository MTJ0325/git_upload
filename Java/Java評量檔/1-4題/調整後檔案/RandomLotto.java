package com.cathaybk.practice.nt50342.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomLotto {

	public static void main(String[] args) {
		Random random = new Random();
		Set<Integer> numbers = new HashSet<>();

		while (numbers.size() < 6) {
			int rand = random.nextInt(49) + 1;
			numbers.add(rand);
		}

		List<Integer> numberList = new ArrayList<>(numbers);

		System.out.println("排序前的數字:");
		for (int number : numberList) {
			System.out.print(number + " ");
		}
		System.out.println();

		Collections.sort(numberList);

		System.out.println("排序後的數字:");
		for (int number : numberList) {
			System.out.print(number + " ");
		}
		System.out.println();
	}
}
