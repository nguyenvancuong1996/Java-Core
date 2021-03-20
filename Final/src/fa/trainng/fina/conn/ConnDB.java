package fa.trainng.fina.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnDB {
	public Connection getConnection() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Final";
		try {
			conn = DriverManager.getConnection(connectionUrl, "sa", "fadn@2020");
		} catch (SQLException e) {
     		e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return conn;
	}

}
