package com.cathaybk.practice.nt50342.b;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class CSVSorter {
	public static void main(String[] args) {
		List<Map<String, String>> lists;
		try (InputStreamReader isr = new InputStreamReader(
				new FileInputStream("C:\\Users\\Admin\\Desktop\\Java班\\git_upload\\Java\\cars.csv"));
				BufferedReader br = new BufferedReader(isr);
				BufferedWriter bw = new BufferedWriter(
						new FileWriter("C:\\Users\\Admin\\Desktop\\Java班\\git_upload\\Java\\cars2.csv"))) {
			String line;

			if ((line = br.readLine()) != null) {
			}
			lists = new ArrayList<>();
			while ((line = br.readLine()) != null) {
				String item[] = line.split(",");
				String manufacturer = item[0].trim();
				String type = item[1].trim();
				String min_price = item[2].trim();
				String price = item[3].trim();
				lists.add(new HashMap<String, String>() {
					private static final long serialVersionUID = 1L;

					{
						put("manufacturer", manufacturer);
						put("type", type);
						put("min_price", min_price);
						put("price", price);
					}
				});
			}
			Collections.sort(lists,
					(o1, o2) -> new BigDecimal(o2.get("price")).compareTo(new BigDecimal(o1.get("price"))));

			bw.write("Manufacturer,TYPE,Min.PRICE,Price\n");
			StringBuilder sb = new StringBuilder();
			for (Map<String, String> map : lists) {
				sb.append(map.get("manufacturer")).append(",").append(map.get("type")).append(",")
						.append(map.get("min_price")).append(",").append(map.get("price")).append("\n");
				bw.write(sb.toString());
				sb.setLength(0);
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		System.out.printf("%-14s%-9s%11s%7s\n", "Manufacturer", "TYPE", "Min.PRICE", "Price");
		ArrayList<BigDecimal> totalCarsPrice = new ArrayList<>();
		ArrayList<BigDecimal> totalCarsMinPrice = new ArrayList<>();
		Map<String, List<Map<String, String>>> groupByManufacturer = lists.stream()
				.collect(Collectors.groupingBy(map -> map.get("manufacturer"), TreeMap::new, Collectors.toList()));
		groupByManufacturer.forEach((manufacturer, cars) -> {
			BigDecimal total_manu_price = BigDecimal.ZERO;
			BigDecimal total_manu_min_price = BigDecimal.ZERO;
			for (Map<String, String> map : cars) {
				System.out.printf("%-14s%-9s%11s%7s\n", manufacturer, map.get("type"), map.get("min_price"),
						map.get("price"));
				total_manu_price = total_manu_price.add(new BigDecimal(map.get("price")));
				total_manu_min_price = total_manu_min_price.add(new BigDecimal(map.get("min_price")));
			}
			System.out.printf("%-22s%11s%7s\n", "小計", total_manu_min_price, total_manu_price);
			totalCarsPrice.add(total_manu_price);
			totalCarsMinPrice.add(total_manu_min_price);
		});
		System.out.printf("%-22s%11s%7s\n", "合計", totalCarsMinPrice.stream().reduce(BigDecimal.ZERO, BigDecimal::add),
				totalCarsPrice.stream().reduce(BigDecimal.ZERO, BigDecimal::add));

	}
}