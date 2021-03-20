package fa.training.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.entities.Customer;
import fa.training.services.CustomerService;

public class Test {
	public static void main(String[] args) {
		String nhapcode;
		CustomerService customerService = new CustomerService();
		Scanner scanner = new Scanner(System.in);
		List<Customer> list = new ArrayList();
		// Tao menu
		try {

			do {
				System.out.println("---------------------MENU--------------------");
				System.out.println("1. add customer :" + "\n2. Show customer :" + "\n3. Search customer :\n"
						+ "4. Remove customer :" + "\n5. Exit");

				System.out.print("Select: ");
				nhapcode = scanner.nextLine();
				switch (nhapcode) {
				case "1":
					// add vao file sava de luu trong file txt
					list = new CustomerService().getListCustomer();
					if (customerService.checkfile()) {
						List<Customer> list1 = customerService.readFiled();
						for (Customer x : list1) {
							list.add(x);
						}
					}
					customerService.save(list);
					break;
				case "2":
					if(customerService.checkfile()) {
					System.out.println("Customer Name \t\t " + "Address \t\t" + "Phone Number \t\t" + "OrderList \t\t");
					List<Customer> list1 = new CustomerService().readFiled();
					for (Customer x : list1) {
						System.out.println(x.toString());
					}
					}
					else {
						System.out.println("Filed is empty!!");
					}
					break;
				case "3":
					if(customerService.checkfile()) {
					System.out.println("Nhap so phone : ");
					String phone = scanner.nextLine();
					customerService.searchCustomer(phone);
					}
					else {
						System.out.println("File is empty!!!");
					}
					break;
				case "4":
					if(customerService.checkfile()) {
					System.out.println("Remove customer number phone :");
					String phone1 = scanner.nextLine();
					customerService.removeCustomer(phone1);
					}
					else {
						System.out.println("File is empty!!!");
					}
					break;
                case "5":
                	nhapcode = "5";
					break;
				default:
					System.out.println("YOU INPUT WRONG PLEASE INPUT AGAIN!!");
				}
			} while (nhapcode != "5");
		} catch (Exception e) {
		}
		scanner.close();
	}

}
