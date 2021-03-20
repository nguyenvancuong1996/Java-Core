package fa.training.main;

import java.util.List;
import java.util.Scanner;

import fa.training.services.CustomerService;
import fa.training.services.OrderService;
import fa.training.utils.Validator;

public class Test {

	public static void main(String[] args) {
//		CustomerService customerService = new CustomerService();
//		customerService.save(customerService.createCustomer());
//		
//		customerService.display(customerService.readFile());
//		customerService.findAll();
//		
//		System.out.println("search");
//		OrderService orderService = new OrderService();
//		orderService.search("1234");
		menu();

	}

	static void menu() {
		CustomerService customerService = new CustomerService();
		OrderService orderService = new OrderService();
		List<String> listCustomers;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int optionSelected;
		String phone = null;
		do {
			System.out.println("Choose function: ");
			System.out.println("1. Add new Customer");
			System.out.println("2. Show all Customer");
			System.out.println("3. Search Customer");
			System.out.println("4. Remove Customer");
			System.out.println("5. Exit");
			optionSelected = scanner.nextInt();
			scanner.nextLine();
			switch (optionSelected) {
			case 1:
				listCustomers = customerService.createCustomer();
				customerService.save(listCustomers);
				break;
			case 2:
				listCustomers = customerService.findAll();
				customerService.display(listCustomers);
				break;
			case 3:
				phone = null;
				do {
					System.out.println("Enter phone to search: ");
					phone = scanner.nextLine();
					listCustomers = orderService.search(phone);
					customerService.display(listCustomers);
				} while (!Validator.isValidPhoneNumber(phone));

				break;
			case 4:
				phone = null;
				do {
					System.out.println("Enter phone to remove: ");
					phone = scanner.nextLine();
					orderService.remove(phone);
				} while (!Validator.isValidPhoneNumber(phone));

				break;
			case 5:
				System.out.println("---End of Program---");
				break;
			default:
				optionSelected = 5;
				break;
			}

		} while (optionSelected != 5);

	}

}
