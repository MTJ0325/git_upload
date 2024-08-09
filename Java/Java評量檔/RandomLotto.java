package com.cathaybk.practice.nt50342.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomLotto {

	public static void main(String[] args) {
		Random random = new Random();
		List<Integer> numbers = new ArrayList<>();


		for (int i = 0; i < 5; i++) {
			int rand = random.nextInt(49) + 1;
			numbers.add(rand);
		}


		Collections.sort(numbers);

		for (int number : numbers) {
			System.out.print(number + " ");
			

		}
	}
	
}
