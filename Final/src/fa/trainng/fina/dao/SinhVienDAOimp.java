package fa.trainng.fina.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import fa.trainng.fina.bean.SinhVien;
import fa.trainng.fina.bean.SinhVienKhaGioi;
import fa.trainng.fina.bean.SinhVienTrungBinh;
import fa.trainng.fina.conn.ConnDB;
import fa.trainng.fina.validate.Validate;

public class SinhVienDAOimp extends ConnDB implements SinhVienDao {
	Validate validate = new Validate();

	@Override
	public boolean themSinhVien(SinhVien one) {
		Connection con = getConnection();
		PreparedStatement ps = null;
		try {
			if (one instanceof SinhVienKhaGioi) {
				SinhVienKhaGioi sinhVienKhaGioi = (SinhVienKhaGioi) one;
				String sql = "INSERT INTO SinhVien(hoTen,ngaySinh,gioiTinh,soDienThoai,truongHoc,xepLoaiTotNghiep,diemTB,loaiHocBong)VALUES(?,?,?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setNString(1, sinhVienKhaGioi.getHoTen());
				Date date = validate.convertJavaDateToSqlDate(sinhVienKhaGioi.getNgaySinh());
				ps.setDate(2, date);
				ps.setString(3, sinhVienKhaGioi.getGioiTinh());
				ps.setNString(4, sinhVienKhaGioi.getSoDienThoai());
				ps.setNString(5, sinhVienKhaGioi.getTruongHoc());
				ps.setNString(6, sinhVienKhaGioi.getXepLoaiToiNghiep());
				ps.setDouble(7, sinhVienKhaGioi.getDiemTB());
				ps.setNString(8, sinhVienKhaGioi.getLoaiHocBong());
				ps.execute();
				System.out.println("thanh cong");
				return true;
			}
			if (one instanceof SinhVienTrungBinh) {
				SinhVienTrungBinh sinhvientrungbinh = (SinhVienTrungBinh) one;
				String sql = "INSERT INTO SinhVien(hoTen,ngaySinh,gioiTinh,soDienThoai,truongHoc,xepLoaiTotNghiep,diemToeic,diemDauVao)VALUES(?,?,?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setNString(1, sinhvientrungbinh.getHoTen());
				Date date = validate.convertJavaDateToSqlDate(sinhvientrungbinh.getNgaySinh());
				ps.setDate(2, date);
				ps.setString(3, sinhvientrungbinh.getGioiTinh());
				ps.setNString(4, sinhvientrungbinh.getSoDienThoai());
				ps.setNString(5, sinhvientrungbinh.getTruongHoc());
				ps.setNString(6, sinhvientrungbinh.getXepLoaiToiNghiep());
				ps.setDouble(7, sinhvientrungbinh.getDiemToeic());
				ps.setDouble(8, sinhvientrungbinh.getDiemDauVao());
				ps.execute();
				System.out.println("thanh cong");
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println("Input files have unknow errors !!!");
			return false;
		}

	}

}
