package fa.training.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import fa.training.entities.Customer;
import fa.training.entities.Order;
import fa.training.utils.Constants;
import fa.training.utils.Validator;

public class CustomerService {
	// tao 1 customer\
	Scanner scanner = new Scanner(System.in);
	public List<Customer> getListCustomer() {
		String choice;
		@SuppressWarnings({ "unchecked", "rawtypes" })
		List<Customer> list = new ArrayList();
		do {
			System.out.println("INPUT INFORMATION OF CUSTOMER!!!");
			Customer one = inputCustomer();
			list.add(one);
			System.out.println("INPUT yes TO STOP!!");
			choice = scanner.nextLine();
		} while (!choice.equals("yes"));
		return list;
	}

	@SuppressWarnings("static-access")
	public Customer inputCustomer() {
		Customer customer = new Customer();
		Validator validay = new Validator();
		@SuppressWarnings("unused")
		Order order = new Order();
		String phone;

		System.out.println("Nhap ten customer :");
		String name = scanner.nextLine();
		customer.setName(name);
		do {
			System.out.println("Nhap so dien thoai : ");
			phone = scanner.nextLine();
		} while (!validay.checkNumberPhone(phone));
		customer.setPhone(phone);
		System.out.println("Nhap dia chi :");
		String diachi = scanner.nextLine();
		customer.setAddress(diachi);
		List<Order> list = new OrderService().inputOrder();
		customer.setList(list);
		return customer;
	}

	// file luu lai cac customer
	public void save(List<Customer> listCustomer) {
		try {
			FileOutputStream fout = new FileOutputStream(Constants.FILE_PATH);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(listCustomer);
			oos.close();
			System.out.println("thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// CAU 3
	public List<Customer> readFiled() {
		List<Customer> customerLst = new ArrayList<Customer>();
		try {
			FileInputStream fileIn = new FileInputStream(Constants.FILE_PATH);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			@SuppressWarnings("unchecked")
			ArrayList<Customer> readObject = (ArrayList<Customer>) in.readObject();
			customerLst = readObject;
			in.close();
		} catch (Exception e) {
			System.out.println("No customer");
		}
		return customerLst;
	}

	public void searchCustomer(String phone) {
		List<Customer> listcustomer = new ArrayList<Customer>();
		listcustomer = readFiled();
		List<Customer> searchListOfCustomer = listcustomer.stream().filter(t -> phone.equals(t.getPhone()))
				.collect(Collectors.toList());
		searchListOfCustomer.forEach(System.out::println);
	}

	public void removeCustomer(String phone1) {
		List<Customer> listcustomer = new ArrayList<Customer>();
		listcustomer = readFiled();
		// c2
		listcustomer.removeIf(t -> phone1.equals(t.getPhone()));
		save(listcustomer);
	}

	public boolean checkfile() {
		File one = new File(Constants.FILE_PATH);
		if (one.length() == 0) {
			return false;
		} else {
			return true;
		}

	}
}
