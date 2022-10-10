package common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {
	public static Connection getConnection() {
		final String URL = "";
		final String USER = "";
		final String PASS = "";
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static PreparedStatement getPstmt(Connection conn, String sql) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
		
	}
	

	

	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		close(conn, pstmt, null);
	}
	
	public static void close(PreparedStatement pstmt, ResultSet rs) {
		close(null, pstmt, rs);
	}
	
	public static void close( ResultSet rs) {
		close(null, null, rs);
	}
}
