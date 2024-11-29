package com.shinhan.myapp.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 0.class path?óê JDBC library Ï∂îÍ?
		
		// 1.driver load
		Class.forName("oracle.jdbc.OracleDriver");
		
		// 2.DB?ó∞Í≤?
		String url="jdbc:oracle:thin:@localhost:1521:xe", userid="hr", userpw="hr";
		Connection conn = DriverManager.getConnection(url,userid,userpw);
		String sql="select * from departments";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println(rs.getString("department_name"));
		}
		rs.close();
		st.close();
		conn.close();
	}
}
