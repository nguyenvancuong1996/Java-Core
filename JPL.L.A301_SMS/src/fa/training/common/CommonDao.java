package fa.training.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommonDao {
public Connection con = null;

	public boolean getConnection() {
		try {
			String connectionUrl = "jdbc:jtds:sqlserver://localhost:1433;databaseName=QLBANHANG";
			con = DriverManager.getConnection(connectionUrl, "sa", "1234");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
  public void closeConnection() throws SQLException {
	  if(con!=null) {
		  this.con.close();
	  }
  }
}
