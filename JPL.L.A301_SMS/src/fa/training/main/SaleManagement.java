package fa.training.main;

import java.util.ArrayList;
import java.util.List;

import fa.training.dao.CustomerDAO;
import fa.training.dao.LineltemDAO;
import fa.training.dao.OrderDAO;
import fa.training.dao.impl.CustomerDAOlmpl;
import fa.training.dao.impl.LineItemDAOImpl;
import fa.training.dao.impl.OrderDAOImpl;
import fa.training.entities.Customer;
import fa.training.entities.LineItem;
import fa.training.entities.Order;


public class SaleManagement {
	public static void main(String[] args) {
		LineltemDAO order22 = new LineItemDAOImpl();
	// Khởi tạo một đối tượng của interface trỏ đến lớp con thực thi hàm của nó
	//dung obj tao trc do get phuong thuc cua class con thực thị tu interface
		List<LineItem> one = order22.getAllItemsByOrderId(1);
		
		try {
			 System.out.println("vo day");
			for(LineItem x : one) {
			System.out.println(x.toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
//	  System.out.println("the funtion fo system :");
//	  System.out.println("Show list all customers");
//	  System.out.println("Show list all orders by customerId");
//	  System.out.println("Show list all lineitems for an order by orderId");
//	  System.out.println("Compute order total");
//	  System.out.println("Add a customer into the database");
//	  System.out.println("Delete a customer from the database");
//	  System.out.println("Update a customer in the database");
//	  System.out.println("Create an order into the database");
//	  System.out.println("Create a lineitem into the database");
//	  System.out.println("Update an order total into the database ");
	}
}
