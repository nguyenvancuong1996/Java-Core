package fa.training.entities;

//orderId (int), orderDate (Date), customerId (int), employeeId (int), total (double)
public class Order {
	private int orderId;
	private String Date;
	private int customerId;
	private int employeeId;
	private double total;

	public Order() {

	}
	public Order(int orderId, String date, int customerId, int employeeId, double total) {
		this.orderId = orderId;
		Date = date;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.total = total;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public int getCustomerId() {
		
		return customerId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", Date=" + Date + ", customerId=" + customerId + ", employeeId="
				+ employeeId + ", total=" + total + "]";
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
