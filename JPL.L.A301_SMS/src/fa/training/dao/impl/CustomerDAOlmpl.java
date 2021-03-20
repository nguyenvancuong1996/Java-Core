package fa.training.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fa.training.common.CommonDao;
import fa.training.dao.CustomerDAO;
import fa.training.entities.Customer;

//ke thua thu commonDao de su dung tat cac phuong thuc cua thang cha
public class CustomerDAOlmpl extends CommonDao implements CustomerDAO {

	public List<Customer> getAllCustomer() {
		ResultSet rs = null;
		PreparedStatement ps = null;//prepareStatement thu hien cau cau truy van
		try {
			super.getConnection();//super tro den getconnection tron commonDao
			String sql = "SELECT customerId,customerName FROM Customer";//tao cau truy van nhu trong sql
			ps = super.con.prepareStatement(sql);//prepareStatement thu hien cau cau truy van
			rs = ps.executeQuery();//tao ra ResultSet de nhan ket qua tra ve tu cau truy van tu PreparedStatement thuc thien
			List<Customer> list = new ArrayList<Customer>();//tao list de nhan ket qua tu ban customer
			while (rs.next()) {//tao mot con tro den tro den ket qua tra ve,con tro se di tung row mot
				Customer one = new Customer();//tao ra mot doi tuong de luu ve du lieu cho customer tai vi tri con tro
				one.setCustomerId(rs.getInt("customerId"));//lay du lieu costomerId tai column customerId cung kieu du lieu
				one.setCustomerName(rs.getString("customerName"));//
				list.add(one);//
			}
			return list;//tra ve cai list comtomer
		} catch (Exception e) {
			System.out.println(e);//neu gap loi thi se tra ve null va in ra loi
			return null;
		} finally {//
			try {
				rs.close();
				ps.close();
				super.closeConnection();
			} catch (Exception e2) {
				System.out.println(e2);
			}

		}

	}

}
