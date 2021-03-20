package fa.training.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fa.training.utils.Constants;

public class OrderService {
	public List<String> search(String phone) {
		CustomerService customerService = new CustomerService();
		List<String> listCustomer = customerService.readFile();
		List<String> foundListCustomers = new ArrayList<String>();
		for (String eachCustomer : listCustomer) {
			if (eachCustomer.contains(phone)) {
				foundListCustomers.add(eachCustomer);
			}
		}
		return foundListCustomers;
	}

	public boolean remove(String phone) {
		boolean removed = false;
		CustomerService customerService = new CustomerService();
		List<String> listCustomer = customerService.readFile();
		List<String> newListCustomer = new ArrayList<String>();
		for (String customer : listCustomer) {
			if (customer.contains(phone)) {
				removed = true;
			} else {
				newListCustomer.add(customer);
			}
		}

		if (newListCustomer.isEmpty()) {
			BufferedWriter bufferedWriter;
			try {
				bufferedWriter = new BufferedWriter(new FileWriter(Constants.FILE_PATH, false));
				bufferedWriter.write("");
				bufferedWriter.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Constants.FILE_PATH, false))) {
				for (String str : newListCustomer) {
					bufferedWriter.write(str + "\n");
					bufferedWriter.flush();
				}
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}

		return removed;
	}
}
