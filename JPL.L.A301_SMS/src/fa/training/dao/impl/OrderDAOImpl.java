package fa.training.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fa.training.common.CommonDao;
import fa.training.dao.OrderDAO;
import fa.training.entities.Order;

public class OrderDAOImpl extends CommonDao implements OrderDAO {

	@Override
	public List<Order> getAllOrdersByCustomerId(int customerId) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			super.getConnection();
			String sql = "SELECT orderId, orderDate,customerId,employeeId,total FROM Order1 WHERE customerId=?";// tao cau truy van nhu																				// trong sql
			ps = super.con.prepareStatement(sql);//
			ps.setInt(1, customerId);
			rs = ps.executeQuery();
			List<Order> listOrder = new ArrayList<>();
			while (rs.next()) {
				Order order = new Order();
				order.setOrderId(rs.getInt("orderId"));
				order.setCustomerId(rs.getInt("customerId"));
				order.setDate(rs.getString("orderDate"));
				order.setEmployeeId(rs.getInt("employeeId"));
				order.setTotal(rs.getDouble("total"));
				listOrder.add(order);
			}
			return listOrder;
		} catch (Exception e) {
			System.out.println(e);// neu gap loi thi se tra ve null va in ra loi
			return null;
		} finally {
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
