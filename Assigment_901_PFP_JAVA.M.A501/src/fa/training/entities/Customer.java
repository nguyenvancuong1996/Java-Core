package fa.training.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fa.training.utils.Validator;

public class Customer {
	private String name;
	private String phoneNumber;
	private String address;
	private List<Order> listOrders = new ArrayList<Order>();

	public Customer() {
		super();
	}

	public Customer(String name, String phoneNumber, String address, List<Order> listOrders) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.listOrders = listOrders;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order> getListOrders() {
		return listOrders;
	}

	public void setListOrders(List<Order> listOrders) {
		this.listOrders = listOrders;
	}

	@Override
	public String toString() {
		String listOrdersString = "";

		for (Order eachOrder : listOrders) {
			listOrdersString += eachOrder.toString() + "\t";
		}

		return "Customer [name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", listOrders="
				+ listOrdersString + "]";
	}

	public void input() {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		boolean validate;
		System.out.println("---Enter Customer Information: ");
		System.out.println("Enter name: ");
		this.setName(scanner.nextLine());

		validate = false;
		String phone = null;
		do {
			System.out.println("Enter phone: ");
			phone = scanner.nextLine();
			validate = Validator.isValidPhoneNumber(phone);
		} while (!validate);
		this.phoneNumber = phone;

		System.out.println("Enter address");
		this.setAddress(scanner.nextLine());

		boolean statusEnd = false;
		List<Order> listOrders = new ArrayList<Order>();
		do {
			System.out.println("Enter order info (press Enter to continue or press 'n' if finish list order) ");
			if (scanner.nextLine().toLowerCase().equals("n")) {
				statusEnd = true;
				continue;
			}

			// input order number
			System.out.println("+number : ");
			validate = false;
			String numberOrder;
			do {
				numberOrder = scanner.nextLine();
				validate = Validator.isValidOrderNumber(numberOrder);
			} while (!validate);

			// input order date
			String dateStr;
			Date date = null;
			validate = false;
			do {
				System.out.println("+date : ");
				dateStr = scanner.nextLine();
				validate = Validator.isValidDate(dateStr);
				try {
					date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
				} catch (ParseException e) {
					validate = false;
				}

			} while (!validate);

			// add number and date to order
			Order order = new Order(numberOrder, date);
			listOrders.add(order);

		} while (!statusEnd);

		this.setListOrders(listOrders);
	}

}
