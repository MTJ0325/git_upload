package com.cathaybk.practice.nt50342.b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class CSVSorter {

	public static void main(String[] args) {
		List<Map<String, String>> carList = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream("C:\\Users\\Admin\\Desktop\\Java班\\git_upload\\Java\\cars.csv"),
				StandardCharsets.UTF_8))) {

			reader.readLine();
			String line;
			while ((line = reader.readLine()) != null) {
				Map<String, String> map = new LinkedHashMap<>();
				String[] items = line.split(",");
				map.put("Manufacturer", items[0].trim());
				map.put("TYPE", items[1].trim());
				map.put("Min.PRICE", items[2].trim());
				map.put("Price", items[3].trim());
				carList.add(map);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		carList.sort(new Comparator<Map<String, String>>() {
			@Override
			public int compare(Map<String, String> o1, Map<String, String> o2) {
				BigDecimal price1 = new BigDecimal(o1.get("Price"));
				BigDecimal price2 = new BigDecimal(o2.get("Price"));
				return price2.compareTo(price1);
			}
		});

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(
				"C:\\Users\\Admin\\Desktop\\Java班\\git_upload\\Java\\cars2.csv", StandardCharsets.UTF_8))) {

			writer.write("Manufacturer,TYPE,Min.PRICE,Price\n");
			for (Map<String, String> map : carList) {
				writer.write(String.format("%s,%s,%s,%s\n", map.get("Manufacturer"), map.get("TYPE"),
						map.get("Min.PRICE"), map.get("Price")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			carList.sort(new Comparator<Map<String, String>>() {
				@Override
				public int compare(Map<String, String> o1, Map<String, String> o2) {
					return o1.get("Manufacturer").compareTo(o2.get("Manufacturer"));
				}
			});

			TreeSet<String> manufacturers = new TreeSet<>();
			for (Map<String, String> car : carList) {
				manufacturers.add(car.get("Manufacturer"));
			}

			System.out.printf("%-15s%-8s%-12s%-7s\n", "Manufacturer", "TYPE", "Min.PRICE", "Price");
			BigDecimal totalPrice = BigDecimal.ZERO;
			BigDecimal totalMinPrice = BigDecimal.ZERO;

			for (String manufacturer : manufacturers) {
				BigDecimal manufacturerTotalPrice = BigDecimal.ZERO;
				BigDecimal manufacturerTotalMinPrice = BigDecimal.ZERO;
				for (Map<String, String> car : carList) {
					if (manufacturer.equals(car.get("Manufacturer"))) {
						System.out.printf("%2s%-12s%-10s%5s%10s\n", "", car.get("Manufacturer"), car.get("TYPE"),
								car.get("Min.PRICE"), car.get("Price"));
						manufacturerTotalPrice = manufacturerTotalPrice.add(new BigDecimal(car.get("Price")));
						manufacturerTotalMinPrice = manufacturerTotalMinPrice.add(new BigDecimal(car.get("Min.PRICE")));
					}
				}
				System.out.printf("小計%-11s%-10s%5s%10s\n", "", "", manufacturerTotalMinPrice, manufacturerTotalPrice);
				totalPrice = totalPrice.add(manufacturerTotalPrice);
				totalMinPrice = totalMinPrice.add(manufacturerTotalMinPrice);
			}
			System.out.printf("合計%-11s%-10s%5s%10s\n", "", "", totalMinPrice, totalPrice);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
