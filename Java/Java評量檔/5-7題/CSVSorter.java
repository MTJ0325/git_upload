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
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class CSVSorter {

	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(
					new FileInputStream("C:\\Users\\Admin\\Desktop\\Java班\\git_upload\\Java\\cars.csv"));// 檔案讀取路徑
			BufferedReader reader = new BufferedReader(isr);
			String line;
			List<Map<String, String>> carList = new ArrayList<>();
			reader.readLine(); // Skip the header line
			while ((line = reader.readLine()) != null) {
				Map<String, String> map = new LinkedHashMap<>();
				String[] item = line.split(",");
				/** 讀取 **/
				String Manufacturer = item[0].trim();
				String TYPE = item[1].trim();
				String minPRICE = item[2].trim();
				String Price = item[3].trim();
				map.put("Manufacturer", Manufacturer);
				map.put("TYPE", TYPE);
				map.put("Min.PRICE", minPRICE);
				map.put("Price", Price);
				carList.add(map);
			}

			// Sort carList by Price in descending order
			Collections.sort(carList, new Comparator<Map<String, String>>() {
				@Override
				public int compare(Map<String, String> o1, Map<String, String> o2) {
					BigDecimal prBigDecimalo1 = new BigDecimal(o1.get("Price"));
					BigDecimal prBigDecimalo2 = new BigDecimal(o2.get("Price"));
					return prBigDecimalo2.compareTo(prBigDecimalo1); // Note the reversed order
				}
			});

			StringBuilder csvContent = new StringBuilder();
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(
					"C:\\Users\\Admin\\Desktop\\Java班\\git_upload\\Java\\cars2.csv", StandardCharsets.UTF_8))) {

				csvContent.append("Manufacturer").append(",").append("TYPE").append(",").append("Min.PRICE").append(",")
						.append("Price").append(",").append("\n");
				for (Map<String, String> map : carList) {
					csvContent.append(map.get("Manufacturer")).append(",").append(map.get("TYPE")).append(",")
							.append(map.get("Min.PRICE")).append(",").append(map.get("Price")).append(",").append("\n");
				}
				writer.write(csvContent.toString());
				csvContent.setLength(0);
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				Collections.sort(carList, new Comparator<Map<String, String>>() {
					@Override
					public int compare(Map<String, String> o1, Map<String, String> o2) {
						return o1.get("Manufacturer").compareTo(o2.get("Manufacturer"));
					}
				});
				TreeSet<String> carset = new TreeSet<>();

				for (Map<String, String> carsetmanuString : carList) {
					carset.add(carsetmanuString.get("Manufacturer"));
				}

				System.out.printf("%-15s%-8s%-12s%-7s\n", "Manufacturer", "TYPE", "Min.PRICE", "Price");
				BigDecimal totalPricebigDecimal = new BigDecimal(0);
				BigDecimal totalMinPricebigDecimal = new BigDecimal(0);

				for (String eachkey : carset) { // 每一項key值
					BigDecimal eachPriceBigDecimal = new BigDecimal(0);// 小記
					BigDecimal eachMinPriceBigDecimal = new BigDecimal(0);
					for (Map<String, String> eachvalueMap : carList) {
						if (eachkey.equals(eachvalueMap.get("Manufacturer"))) {
							System.out.printf("%2s%-12s%-10s%5s%10s\n", "", eachvalueMap.get("Manufacturer"),
									eachvalueMap.get("TYPE"), eachvalueMap.get("Min.PRICE"), eachvalueMap.get("Price"));
							eachPriceBigDecimal = eachPriceBigDecimal.add(new BigDecimal(eachvalueMap.get("Price")));
							eachMinPriceBigDecimal = eachMinPriceBigDecimal
									.add(new BigDecimal(eachvalueMap.get("Min.PRICE")));
						}
					}
					System.out.printf("小計%-11s%-10s%5s%10s\n", "", "", eachMinPriceBigDecimal, eachPriceBigDecimal);
					totalPricebigDecimal = totalPricebigDecimal.add(eachPriceBigDecimal);
					totalMinPricebigDecimal = totalMinPricebigDecimal.add(eachMinPriceBigDecimal);
				}
				System.out.printf("合計%-11s%-10s%5s%10s\n", "", "", totalMinPricebigDecimal, totalPricebigDecimal);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
