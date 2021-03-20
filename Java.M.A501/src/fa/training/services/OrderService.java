package fa.training.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import fa.training.entities.Order;
import fa.training.utils.Validator;

public class OrderService {
	public ArrayList<Order> inputOrder() {
		Validator validator = new Validator();
		Scanner scanner = new Scanner(System.in);
		Order order = new Order();
		ArrayList<Order> listorder = new ArrayList<>();
		String day;
		String check;
		String ordernumber;
		Date dateOrder = null;
		System.out.println("Input order:");
		do {
			SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
			do {
				System.out.println("Input order number:");
				ordernumber = scanner.nextLine();
			} while (!validator.checkNumberOrder(ordernumber));
			order.setNumber(ordernumber);
			boolean status = false;
			// kiem tra du lieu nhap ngay va number order
			do {
				try {
					System.out.println("nhap ngay orde dd/MM/yyyy : ");
					day = scanner.nextLine();
					dateOrder = (Date) DateFor.parse(day);
					status = true;
				} catch (ParseException e) {
					System.out.println("Vui long nhap lai");
					status = false;
				}
			} while (!status);
			order.setDate(dateOrder);
			listorder.add(order);
			System.out.println("INPUT N TO STOP!!");
			check = scanner.nextLine();
		} while (!(check.equals("N")||check.equals("n")));
		return listorder;

	}

}
