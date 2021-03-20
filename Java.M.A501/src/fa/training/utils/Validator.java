package fa.training.utils;

public class Validator {
	public static boolean checkNumberPhone(String checkPhone) {
		if (checkPhone.startsWith("0") && checkPhone.matches("[0-9]+") && checkPhone.length() == 10) {
			return true;
		}
		System.out.println();
		return false;

	}
  
	public static boolean checkNumberOrder(String checkNumberOrder) {
		if (checkNumberOrder.length() == 10) {
			return true;
		}
		return false;
	}

	public boolean validatorTypingData(String selects) {
		if (selects.equalsIgnoreCase("n")) {
			return false;
		} else {
			return true;
		}
	}
}
