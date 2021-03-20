package assignment.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QLFPT";
	private static final String userName = "sa";
	private static final String password = "12345";

	public static Connection getConnectionDB() {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(URL, userName, password);
			System.out.println("Ket noi thanh cong");
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
			System.out.println("Ket noi that bai");
		}
		return conn;
	}

	public static void close(Connection conn) throws SQLException {
		if (conn != null) {
			conn.close();
		}
	}

	public static void close(Statement stmt) throws SQLException {
		if (stmt != null) {
			stmt.close();
		}
	}

	public static void close(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}

	public static void close(PreparedStatement pst) throws SQLException {
		if (pst != null) {
			pst.close();
		}
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		close(rs);
		close(stmt);
		close(conn);

	}

	public static void close(Connection conn, PreparedStatement pst, ResultSet rs) throws SQLException {
		close(rs);
		close(pst);
		close(conn);
	}

}
