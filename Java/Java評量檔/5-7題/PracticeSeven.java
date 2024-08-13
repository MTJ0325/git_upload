package com.cathaybk.practice.nt50342.b;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 練習十七
 */
public class PracticeSeven {

	private static final String CONN_URL = "jdbc:oracle:thin:@//localhost:1521/XE";

	private static final String USER_NAME = "student";

	private static final String PASSWORD = "student123456";

	private static final String SELECT_CARS_SQL = "select * from STUDENT.CARS ";

	public static void main(String[] args) {
		// 1. 取得連線
		// 2. 寫入 SQL 指令
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(SELECT_CARS_SQL);) {
//   pstmt.setString(1, "Toyota");

			// 3. 執行 SQL（上一步寫入的）指令
			ResultSet rs = pstmt.executeQuery(); // ResultSet物件儲存查詢結果

			List<Map<String, String>> carMapList = new ArrayList<>();
			while (rs.next()) {
				Map<String, String> carMap = new HashMap<>();
				carMap.put("MANUFACTURER", rs.getString("MANUFACTURER")); // rs.getString("DB_COLUMN_NAME")
				carMap.put("TYPE", rs.getString("TYPE"));
				carMap.put("MIN_PRICE", rs.getString("MIN_PRICE"));
				carMap.put("PRICE", rs.getString("PRICE"));
				carMapList.add(carMap);
			}

			StringBuilder sb = new StringBuilder();
			for (Map<String, String> map : carMapList) {
				BigDecimal price = new BigDecimal(map.get("PRICE")); // map.get("自己儲存的 KEY 值")
				BigDecimal minPrice = new BigDecimal(map.get("MIN_PRICE"));
				sb.append("製造商：").append(map.get("MANUFACTURER")).append("，型號：").append(map.get("TYPE")).append("，售價：")
						.append(price.toPlainString()).append("，底價：").append(minPrice.toPlainString());
				System.out.println(sb.toString());
				sb.setLength(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (Scanner methodScanner = new Scanner(System.in)) {
			System.out.println("請選擇以下指令輸入：select、insert、update、delete");
			String methodChoice = methodScanner.next();
			switch (methodChoice) {
			case "select":
				querymethod();
				break;
			case "insert":
				insertmethod();
				break;
			case "update":
				updatemethod();
				break;
			case "delete":
				deletemethod();
				break;
			default:

				break;
			}
		}
	}


	private static void querymethod() {
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(
						"select MANUFACTURER,TYPE,MIN_PRICE,PRICE from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?");
				Scanner queryScanner = new Scanner(System.in);) {
			System.out.print("請輸入製造商：");
			String queryManuScan = queryScanner.next();
			System.out.print("請輸入類型：");
			String queryTypeScan = queryScanner.next();
			pstmt.setString(1, queryManuScan);
			pstmt.setString(2, queryTypeScan);
			ResultSet queryResultSet = pstmt.executeQuery();
			while (queryResultSet.next()) {
				System.out.printf("製造商：%s，型號：%s，售價：%s，底價：%s", queryResultSet.getString("MANUFACTURER"),
						queryResultSet.getString("TYPE"), queryResultSet.getString("PRICE"),
						queryResultSet.getString("MIN_PRICE"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	private static void insertmethod() {
		try {
			Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			try (PreparedStatement pstmt = conn.prepareStatement(
					"insert into STUDENT.CARS ( MANUFACTURER , TYPE , PRICE , MIN_PRICE) values (  ? ,? ,? ,?)");
					Scanner queryScanner = new Scanner(System.in);) {
				conn.setAutoCommit(false);
				System.out.print("請輸入製造商：");
				String insertManuScan = queryScanner.next();
				System.out.print("請輸入類型：");
				String insertTypeScan = queryScanner.next();
				System.out.print("請輸入售價：");
				Double insertPriceScan = queryScanner.nextDouble();
				System.out.print("請輸入底價：");
				Double insertMinPriceScan = queryScanner.nextDouble();
				pstmt.setString(1, insertManuScan);
				pstmt.setString(2, insertTypeScan);
				pstmt.setDouble(3, insertPriceScan);
				pstmt.setDouble(4, insertMinPriceScan);
				pstmt.executeUpdate();
				System.out.println("新增成功");
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				System.out.println("新增失敗");
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("數據庫連接錯誤");
		}

	}

	private static void updatemethod() {
		try {
			Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			try (PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE STUDENT.CARS SET PRICE = ? , MIN_PRICE =? WHERE MANUFACTURER = ? and TYPE = ?");
					Scanner queryScanner = new Scanner(System.in);) {
				conn.setAutoCommit(false);
				System.out.print("請輸入製造商：");
				String updateManuScan = queryScanner.next();
				System.out.print("請輸入類型：");
				String updateTypeScan = queryScanner.next();
				System.out.print("請輸入售價：");
				Double updatePriceScan = queryScanner.nextDouble();
				System.out.print("請輸入底價：");
				Double updateMinPriceScan = queryScanner.nextDouble();
				pstmt.setString(3, updateManuScan);
				pstmt.setString(4, updateTypeScan);
				pstmt.setDouble(1, updatePriceScan);
				pstmt.setDouble(2, updateMinPriceScan);
				pstmt.executeUpdate();
				System.out.println("更新成功");
				conn.commit();

			} catch (SQLException e) {
				conn.rollback();
				System.out.println("更新失敗");
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("數據庫連接錯誤");
		}

	}

	private static void deletemethod() {
		try {
			Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
			try (PreparedStatement pstmt = conn
					.prepareStatement("delete from STUDENT.CARS WHERE MANUFACTURER = ? and TYPE = ?");
					Scanner queryScanner = new Scanner(System.in);) {
				conn.setAutoCommit(false);
				System.out.print("請輸入製造商：");
				String deletemethodManuScan = queryScanner.next();
				System.out.print("請輸入類型：");
				String deletemethodTypeScan = queryScanner.next();
				pstmt.setString(1, deletemethodManuScan);
				pstmt.setString(2, deletemethodTypeScan);
				pstmt.executeUpdate();
				System.out.println("資料已刪除");
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				System.out.println("刪除失敗");
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("數據庫連接錯誤");
		}

	}

}