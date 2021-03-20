package fa.training.dao;

import java.util.List;

import fa.training.entities.Order;

public interface OrderDAO {
	List<Order> getAllOrdersByCustomerId(int customerId);
}
