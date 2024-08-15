package com.cathaybk.practice.nt50342.b;

import java.time.LocalDate;
import java.util.Scanner;

public class calendar {
	public static void main(String[] args) {

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("輸入介於1-12間的整數m: ");
			int month = scanner.nextInt();

			if (month < 1 || month > 12) {
				System.out.println("輸入的月份不在有效範圍內。");
				return;
			}
			int year = LocalDate.now().getYear();

			LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
			int lastDayOfMonth = firstDayOfMonth.lengthOfMonth();

			String monthYearHeader = String.format("%d年%d月", year, month);
			int headerWidth = 20;
			int padding = (headerWidth - monthYearHeader.length()) / 2;
			System.out.printf("%" + (padding + monthYearHeader.length()) + "s%n", monthYearHeader);

			System.out.println("---------------------");
			System.out.println("日  一  二  三 四  五  六");
			System.out.println("=====================");

			int startDay = firstDayOfMonth.getDayOfWeek().getValue() % 7;

			for (int i = 0; i < startDay; i++) {
				System.out.print("   ");
			}

			for (int day = 1; day <= lastDayOfMonth; day++) {
				System.out.printf("%2d ", day);

				if ((startDay + day) % 7 == 0) {
					System.out.println();
				}
			}

			if ((startDay + lastDayOfMonth) % 7 != 0) {
				System.out.println();
			}
		}

	}
}
