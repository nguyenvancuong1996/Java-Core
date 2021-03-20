package fa.trainng.fina.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fa.trainng.fina.bean.SinhVien;
import fa.trainng.fina.bean.SinhVienKhaGioi;
import fa.trainng.fina.bean.SinhVienTrungBinh;
import fa.trainng.fina.dao.SinhVienDAOimp;
import fa.trainng.fina.dao.SinhVienDao;
import fa.trainng.fina.dao.SinhVienKhaGioiDao;
import fa.trainng.fina.dao.SinhVienKhaGioiDaoImpl;
import fa.trainng.fina.dao.SinhVienTrungBinhDao;
import fa.trainng.fina.dao.SinhVienTrungBinhDaoImp;
import fa.trainng.fina.service.SinhVienService;
import fa.trainng.fina.validate.Validate;

public class testmain {
	public static boolean validateJavaDate(String strDate) {
		SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
		sdfrmt.setLenient(false);
		try {
			Date javaDate = sdfrmt.parse(strDate);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	public static boolean checkYear(String year) {
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
			return false;
		}
	}

	public static void main(String[] args) {
		SinhVienService sinhVienService = new SinhVienService();
		SinhVienDao sinhVienDao = new SinhVienDAOimp();
//		SinhVienTrungBinhDao sinhVienTrungBinhDao = new SinhVienTrungBinhDaoImp();
//		SinhVienKhaGioiDao sinhVienKhaGioiDao = new SinhVienKhaGioiDaoImpl();
//		List<SinhVienTrungBinh> list = sinhVienService.getListSinhVienTB();
//		List<SinhVienKhaGioi> list1 = sinhVienService.getListSinhVienKhaGioiVCS();
////		for (SinhVienTrungBinh x : list) {
////		   
////		}
//		System.out.println("----------------------------------------------");
////		for (SinhVienKhaGioi x : list1) { cho data sinh vien gioi xuong database
////			 sinhVienKhaGioiDao.xuongDB(x);
////		}
//		for (SinhVienTrungBinh x : list) {// cho data sinh vien gioi xuong database
//		 sinhVienTrungBinhDao.xuongDB(x);
//	   }
//		Scanner nhap = new Scanner(System.in);
//		String date;
//		do {
//			System.out.println("Nhap date check");
//			date = nhap.nextLine();
//		} while (!(validateJavaDate(date) && checkYear(date.substring(6,10))));
//		System.out.println(date);
		List<SinhVien> list  = sinhVienService.getListSinhVien();
		for(SinhVien x:list) {
			sinhVienDao.themSinhVien(x);
		}
		
			
		

	}
}
