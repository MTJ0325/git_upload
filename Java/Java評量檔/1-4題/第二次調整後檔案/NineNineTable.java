package com.cathaybk.practice.nt50342.b;

public class NineNineTable {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		for (int multiplier = 1; multiplier <= 9; multiplier++) {
			for (int multiplicand = 2; multiplicand <= 9; multiplicand++) {
				int product = multiplicand * multiplier;

				sb.setLength(0); 
				sb.append(multiplicand).append('*').append(multiplier).append('=');

				if (product < 10) {
					sb.append(' ');
				}

				sb.append(product).append(' ');

				String entry = sb.toString();
				System.out.printf("%-" + 7 + "s", entry);
			}
			System.out.println();
		}
	}
}
