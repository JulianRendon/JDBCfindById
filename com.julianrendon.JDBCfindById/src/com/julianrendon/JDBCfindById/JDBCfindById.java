package com.julianrendon.JDBCfindById;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCfindById {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		Connection conn = DriverManager.getConnection(url, "hr", "oracle");
		conn.setAutoCommit(false);

		String query = "select first_name, last_name " + "from employees " + "where employee_id = ?";

		System.out.println("query: " + query);
		System.out.println("First Name " + "Last Name");

		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, 100);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("first_name") + "       " + rs.getString("last_name"));
		}

		ps.setInt(1, 101);
		rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("first_name") + "       " + rs.getString("last_name"));
		}
		ps.close();
		System.out.println("Ok.");

	}

}
