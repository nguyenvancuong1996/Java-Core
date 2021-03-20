package fa.training.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.common.CommonDao;
import fa.training.dao.LineltemDAO;
import fa.training.entities.LineItem;


public class LineItemDAOImpl extends CommonDao implements LineltemDAO {

	@Override
	public List<LineItem> getAllItemsByOrderId(int orderId) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			super.getConnection();
			String sql= "SELECT orderID, productID, quantity, price FROM LineItem WHERE orderId=?";
			ps= super.con.prepareStatement(sql);
			ps.setInt(1, orderId);
			rs = ps.executeQuery();
			List<LineItem> listItem = new ArrayList<>();
			while (rs.next()) {
				LineItem linkitemobj = new LineItem();
				linkitemobj.setOrderId(rs.getInt("orderId"));
				linkitemobj.setProductId(rs.getInt("productID"));
				linkitemobj.setQuantity(rs.getInt("quantity"));
				linkitemobj.setPrice(rs.getDouble("price"));
				listItem.add(linkitemobj);
			}
			return listItem;
		} catch (Exception e) {
			System.out.println(e);// neu gap loi thi se tra ve null va in ra loi
			return null;
		}finally {
			try {
				rs.close();
				ps.close();
				super.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	}
	
	
	
}
