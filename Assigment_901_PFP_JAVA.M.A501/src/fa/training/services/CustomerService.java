package fa.training.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fa.training.entities.Customer;
import fa.training.utils.Constants;

public class CustomerService {

	public List<String> createCustomer() {
		List<String> listCustomers = new ArrayList<String>();
		// @SuppressWarnings("resource")
		// Scanner scanner = new Scanner(System.in);
		// do {
		Customer customer = new Customer();
		customer.input();
		listCustomers.add(customer.toString());
		// System.out.println("---Press Enter to continue input next Customer or press
		// 'n' to end");
		// }while(!scanner.nextLine().toLowerCase().equals("n"));

		return listCustomers;
	}

	public String save(List<String> customers) {
//		Scanner scanner = new Scanner(System.in);
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Constants.FILE_PATH, true))) {
			for (String str : customers) {
				bufferedWriter.write(str + "\n");
				bufferedWriter.flush();
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return null;
	}

	public void display(List<String> listCustomers) {
		for (String eachCustomer : listCustomers) {
			System.out.println(eachCustomer);
		}
		if (listCustomers.isEmpty()) {
			System.out.println("Not found customer data");
		}
	}

	public List<String> readFile() {
		List<String> list = new ArrayList<String>();
//		StringBuilder sb = new StringBuilder();
		String strLine = "";
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Constants.FILE_PATH))) {
			while ((strLine = bufferedReader.readLine()) != null) {
//				sb.append(strLine);
//				sb.append(System.lineSeparator());
				list.add(strLine);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	public List<String> findAll() {
		List<String> listCustomers = readFile();
		return listCustomers;
	}
}
