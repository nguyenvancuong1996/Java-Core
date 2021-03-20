package fa.training.comman.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class CommonDAO {

	public Connection getConnection() {
	  Connection con = null;
		try {
			String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLFPT";
			con = DriverManager.getConnection(connectionUrl, "sa", "fadn@2020");
			System.out.println("Connect thanh cong");
		} catch (Exception e) {
			System.out.println("Khong thanh cong");
			System.out.println(e);

		}
		return con;
	}

}
