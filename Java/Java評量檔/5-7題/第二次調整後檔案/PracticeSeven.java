package com.cathaybk.practice.nt50342.b;

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

public class PracticeSeven {

	private static final String CONN_URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	private static final String USER_NAME = "student";
	private static final String PASSWORD = "student123456";
	private static final String SELECT_CARS_SQL = "select * from STUDENT.CARS";
	private static final String QUERY_CARS_SQL = "select MANUFACTURER, TYPE, MIN_PRICE, PRICE from STUDENT.CARS where MANUFACTURER = ? AND TYPE = ?";
	private static final String INSERT_CAR_SQL = "insert into STUDENT.CARS (MANUFACTURER, TYPE, PRICE, MIN_PRICE) values (?, ?, ?, ?)";
	private static final String UPDATE_CAR_SQL = "update STUDENT.CARS set PRICE = ?, MIN_PRICE = ? where MANUFACTURER = ? and TYPE = ?";
	private static final String DELETE_CAR_SQL = "delete from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?";
	private static final String CHECK_CAR_EXISTS_SQL = "select count(*) from STUDENT.CARS where MANUFACTURER = ? and TYPE = ?";

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(SELECT_CARS_SQL)) {

			ResultSet rs = pstmt.executeQuery();
			List<Map<String, String>> carMapList = new ArrayList<>();
			while (rs.next()) {
				Map<String, String> carMap = new HashMap<>();
				carMap.put("MANUFACTURER", rs.getString("MANUFACTURER"));
				carMap.put("TYPE", rs.getString("TYPE"));
				carMap.put("MIN_PRICE", rs.getString("MIN_PRICE"));
				carMap.put("PRICE", rs.getString("PRICE"));
				carMapList.add(carMap);
			}

			StringBuilder sb = new StringBuilder();
			for (Map<String, String> map : carMapList) {
				sb.append("製造商：").append(map.get("MANUFACTURER")).append("，型號：").append(map.get("TYPE")).append("，售價：")
						.append(map.get("PRICE")).append("，底價：").append(map.get("MIN_PRICE"));
				System.out.println(sb.toString());
				sb.setLength(0);
			}
		} catch (SQLException e) {
			System.out.println("連線失敗");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("未知的錯誤");
		}

		try (Scanner methodScanner = new Scanner(System.in)) {
			System.out.println("請選擇以下指令輸入：select、insert、update、delete");
			String methodChoice = methodScanner.next();
			switch (methodChoice) {
			case "select":
				queryMethod();
				break;
			case "insert":
				insertMethod();
				break;
			case "update":
				updateMethod();
				break;
			case "delete":
				deleteMethod();
				break;
			default:
				System.out.println("無效的指令");
				break;
			}
		}
	}

	private static void queryMethod() {
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				Scanner queryScanner = new Scanner(System.in)) {

			System.out.print("請輸入製造商：");
			String queryManuScan = queryScanner.next();
			System.out.print("請輸入類型：");
			String queryTypeScan = queryScanner.next();

			if (!isCarExist(conn, queryManuScan, queryTypeScan)) {
				System.out.println("查詢的資料不存在！");
				return;
			}

			try (PreparedStatement pstmt = conn.prepareStatement(QUERY_CARS_SQL)) {
				pstmt.setString(1, queryManuScan);
				pstmt.setString(2, queryTypeScan);
				ResultSet queryResultSet = pstmt.executeQuery();
				while (queryResultSet.next()) {
					System.out.printf("製造商：%s，型號：%s，售價：%s，底價：%s%n", queryResultSet.getString("MANUFACTURER"),
							queryResultSet.getString("TYPE"), queryResultSet.getString("PRICE"),
							queryResultSet.getString("MIN_PRICE"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void insertMethod() {
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(INSERT_CAR_SQL);
				Scanner queryScanner = new Scanner(System.in)) {

			conn.setAutoCommit(false);

			System.out.print("請輸入製造商：");
			String insertManuScan = queryScanner.next();
			System.out.print("請輸入類型：");
			String insertTypeScan = queryScanner.next();
			System.out.print("請輸入售價：");
			Double insertPriceScan = queryScanner.nextDouble();
			System.out.print("請輸入底價：");
			Double insertMinPriceScan = queryScanner.nextDouble();

			if (isCarExist(conn, insertManuScan, insertTypeScan)) {
				System.out.println("資料已存在，無法新增！");
				return;
			}

			pstmt.setString(1, insertManuScan);
			pstmt.setString(2, insertTypeScan);
			pstmt.setDouble(3, insertPriceScan);
			pstmt.setDouble(4, insertMinPriceScan);
			pstmt.executeUpdate();
			System.out.println("新增成功");
			conn.commit();
		} catch (SQLException e) {
			System.out.println("新增失敗");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("數據庫連接錯誤");
		}
	}

	private static void updateMethod() {
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				Scanner queryScanner = new Scanner(System.in)) {

			conn.setAutoCommit(false);

			System.out.print("請輸入製造商：");
			String updateManuScan = queryScanner.next();

			System.out.print("請輸入類型：");
			String updateTypeScan = queryScanner.next();

			if (!isCarExist(conn, updateManuScan, updateTypeScan)) {
				System.out.println("要更新的資料不存在！");
				return;
			}

			System.out.print("請輸入新的售價：");
			Double updatePriceScan = queryScanner.nextDouble();
			System.out.print("請輸入新的底價：");
			Double updateMinPriceScan = queryScanner.nextDouble();

			Map<String, Object> updateMap = new HashMap<>();
			updateMap.put("PRICE", updatePriceScan);
			updateMap.put("MIN_PRICE", updateMinPriceScan);

			update(conn, updateMap, updateManuScan, updateTypeScan);

			System.out.println("更新成功");
			conn.commit();
		} catch (SQLException e) {
			System.out.println("更新失敗");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("數據庫連接錯誤");
		}
	}

	private static void update(Connection conn, Map<String, Object> updateData, String manufacturer, String type)
			throws SQLException {
		try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_CAR_SQL)) {
			pstmt.setDouble(1, (Double) updateData.get("PRICE"));
			pstmt.setDouble(2, (Double) updateData.get("MIN_PRICE"));
			pstmt.setString(3, manufacturer);
			pstmt.setString(4, type);
			pstmt.executeUpdate();
		}
	}

	private static void deleteMethod() {
		try (Connection conn = DriverManager.getConnection(CONN_URL, USER_NAME, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(DELETE_CAR_SQL);
				Scanner queryScanner = new Scanner(System.in)) {

			conn.setAutoCommit(false);

			System.out.print("請輸入製造商：");
			String deleteManuScan = queryScanner.next();
			System.out.print("請輸入類型：");
			String deleteTypeScan = queryScanner.next();

			if (!isCarExist(conn, deleteManuScan, deleteTypeScan)) {
				System.out.println("要刪除的資料不存在！");
				return;
			}

			pstmt.setString(1, deleteManuScan);
			pstmt.setString(2, deleteTypeScan);
			pstmt.executeUpdate();
			System.out.println("資料已刪除");
			conn.commit();
		} catch (SQLException e) {
			System.out.println("刪除失敗");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("數據庫連接錯誤");
		}
	}

	private static boolean isCarExist(Connection conn, String manufacturer, String type) {
		try (PreparedStatement pstmt = conn.prepareStatement(CHECK_CAR_EXISTS_SQL)) {
			pstmt.setString(1, manufacturer);
			pstmt.setString(2, type);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}