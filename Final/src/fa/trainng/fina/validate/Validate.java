package fa.trainng.fina.validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Validate {
	public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {//
		return new java.sql.Date(date.getTime());
	}

	public boolean kiemHoTen(String hovaten) {
		if (hovaten.length() >= 10 && hovaten.length() <= 50) {
			return true;
		} else {
			return false;
		}
	}

	public boolean kiemTraSDT(String sdt) {// : 090, 098, 091, 031, 035 038.
		boolean check;
		String match = "((090|098|091|031|035|038)\\d{7})";
		check = sdt.matches(match);
		return check;
	}

	public boolean validateJavaDate(String strDate) {
		SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
		sdfrmt.setLenient(false);
		try {
			Date javaDate = sdfrmt.parse(strDate);
			if (checkYear(strDate.substring(6, 10))) {
				return true;
			}
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	public boolean checkYear(String year) {
		LocalDate time = LocalDate.now();
		try {
			int year1 = Integer.parseInt(year);
			int yearnow = time.getYear();
			if (year1 > 1900 && year1 <= yearnow) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean checkemail(String email) {
		boolean check;
		String mathc = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\\\.[A-Za-z]{2,4}$";
		check = email.matches(mathc);
		return check;
	}

}
