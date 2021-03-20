package fa.trainng.fina.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import fa.trainng.fina.bean.SinhVien;
import fa.trainng.fina.bean.SinhVienKhaGioi;
import fa.trainng.fina.bean.SinhVienTrungBinh;
import fa.trainng.fina.dao.SinhVienKhaGioiDaoImpl;
import fa.trainng.fina.dao.SinhVienTrungBinhDaoImp;
import fa.trainng.fina.exception.InvalidDOBException;
import fa.trainng.fina.exception.InvalidFullNameException;
import fa.trainng.fina.exception.InvalidPhoneNumberException;
import fa.trainng.fina.validate.Validate;

public class SinhVienService {
	static Scanner nhap = new Scanner(System.in);
	static Validate validate = new Validate();

	public static Date chuyendoiDate(String date) {
		Date ngay = null;
		try {
			ngay = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (Exception e) {
			System.out.println(e);
		}
		return ngay;
	}

	public static double diemTB(String diem) {
		double diem1 = 0;
		try {
			diem1 = Double.valueOf(diem);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return diem1;
	}

	public static List<SinhVienKhaGioi> getListSinhVienKhaGioiVCS() {
		List<SinhVienKhaGioi> listSinhVien = new ArrayList<SinhVienKhaGioi>();
		try {
			File file = new File("D:\\Mai\\SinhVienGioi.csv");
			InputStream inputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(inputStreamReader);
			String line = "";

			while ((line = reader.readLine()) != null) {
				SinhVienKhaGioi sinhVienKhaiGioi = new SinhVienKhaGioi();
				String[] arr = line.split(",");
				sinhVienKhaiGioi.setHoTen(arr[0]);
				Date date = chuyendoiDate(arr[1]);
				sinhVienKhaiGioi.setNgaySinh(date);
				sinhVienKhaiGioi.setGioiTinh(arr[2]);
				sinhVienKhaiGioi.setSoDienThoai(arr[3]);
				sinhVienKhaiGioi.setTruongHoc(arr[4]);
				sinhVienKhaiGioi.setXepLoaiToiNghiep(arr[5]);
				double diem = diemTB(arr[6]);
				sinhVienKhaiGioi.setDiemTB(diem);
				sinhVienKhaiGioi.setLoaiHocBong(arr[7]);
				listSinhVien.add(sinhVienKhaiGioi);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listSinhVien;

	}

	public static List<SinhVienTrungBinh> getListSinhVienTB() {
		List<SinhVienTrungBinh> listSinhVien = new ArrayList<SinhVienTrungBinh>();
		try {
			File file = new File("D:\\Mai\\SinhVienTrungBinh.csv");
			InputStream inputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(inputStreamReader);
			String line = "";

			while ((line = reader.readLine()) != null) {
				SinhVienTrungBinh SinhVienTB = new SinhVienTrungBinh();
				String[] arr = line.split(",");
				SinhVienTB.setHoTen(arr[0]);
				Date date = chuyendoiDate(arr[1]);
				SinhVienTB.setNgaySinh(date);
				SinhVienTB.setGioiTinh(arr[2]);
				SinhVienTB.setSoDienThoai(arr[3]);
				SinhVienTB.setTruongHoc(arr[4]);
				SinhVienTB.setXepLoaiToiNghiep(arr[5]);
				double diemtp = diemTB(arr[6]);
				SinhVienTB.setDiemToeic(diemtp);
				double diemdauvao = diemTB(arr[7]);
				SinhVienTB.setDiemDauVao(diemdauvao);
				listSinhVien.add(SinhVienTB);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listSinhVien;

	}

	public static SinhVien createSinhVien() {
		String ten = null;
		do {
			try {
				System.out.println("Nhap ten Sinh Vien:");
				ten = nhap.nextLine();
				if (!validate.kiemHoTen(ten)) {
					throw new InvalidFullNameException("Ten khong dung dinh dang");
				}
			} catch (InvalidFullNameException e) {
				System.err.println(e);
			}
		} while (!validate.kiemHoTen(ten));
		String date = null;
		do {
			try {
				System.out.println("Nhap ngay sinh Sinh Vien:");
				date = nhap.nextLine();
				if (!(validate.validateJavaDate(date) && validate.checkYear(date.substring(6, 10)))) {
					throw new InvalidFullNameException("ngay sinh khong dung dinh dang");
				}
			} catch (InvalidFullNameException e) {
				System.err.println(e);
			}
		} while (!(validate.validateJavaDate(date) && validate.checkYear(date.substring(6, 10))));
		System.out.println("Nhap nhap gioi tinh:");
		String giotinh = nhap.nextLine();
		String sdt = null;
		do {
			try {
				System.out.println("Nhap so dien thoai:");
				sdt = nhap.nextLine();
				if (!validate.kiemTraSDT(sdt)) {
					throw new InvalidPhoneNumberException("So dien thoai khong dung dinh dang!!");
				}
			} catch (InvalidPhoneNumberException e) {
				System.err.println(e);
			}
		} while (!validate.kiemTraSDT(sdt));
		System.out.println("Nhap ten truong da  hoc");
		String truong = nhap.nextLine();
		System.out.println("Nhap xep loai tot nghiep:");
		String xeploai = nhap.nextLine();
		int choce = 0;
		do {
			System.out.println("Nhap 1:--> de nhap hoc sinh gioi Nhap  2:--> de nhap sinh vien trung binh");
			choce = nhap.nextInt();
		} while (choce > 2 && choce < 0);
		if (choce == 1) {
			SinhVienKhaGioi one = new SinhVienKhaGioi();
			one.setHoTen(ten);
			one.setNgaySinh(chuyendoiDate(date));
			one.setGioiTinh(giotinh);
			one.setSoDienThoai(sdt);
			one.setTruongHoc(truong);
			one.setXepLoaiToiNghiep(xeploai);
			System.out.println("Nhap diem trung binh");
			double diemtb = nhap.nextDouble();
			one.setDiemTB(diemtb);
			nhap.nextLine();
			System.out.println("Nhap ten hoc bong:");
			String tenhocbong = nhap.nextLine();
			one.setLoaiHocBong(tenhocbong);
			return one;
		}
		if (choce == 2) {
			SinhVienTrungBinh one = new SinhVienTrungBinh();
			one.setHoTen(ten);
			one.setNgaySinh(chuyendoiDate(date));
			one.setGioiTinh(giotinh);
			one.setSoDienThoai(sdt);
			one.setTruongHoc(truong);
			one.setXepLoaiToiNghiep(xeploai);
			System.out.println("Nhap diem toec");
			double diemtoec = nhap.nextDouble();
			nhap.nextLine();
			one.setDiemToeic(diemtoec);
			System.out.println("Nhap diem thi dau vao");
			double diemdauvao = nhap.nextDouble();
			one.setDiemDauVao(diemdauvao);
			nhap.nextLine();
			return one;
		}
		return null;

	}

	public List<SinhVien> getListSinhVien() {
		List<SinhVien> list = new ArrayList<SinhVien>();
		String choice;
		do {
			System.out.println("Nhap du lieu cho sinh vien:");
			SinhVien one = createSinhVien();
			list.add(one);
			System.out.println("Ban n/N de dung lai:");
			choice = nhap.nextLine();
		} while (!choice.equalsIgnoreCase("n"));
		return list;
	}

}
