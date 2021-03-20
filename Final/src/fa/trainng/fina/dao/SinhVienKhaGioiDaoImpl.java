package fa.trainng.fina.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import fa.trainng.fina.bean.SinhVienKhaGioi;
import fa.trainng.fina.conn.ConnDB;
import fa.trainng.fina.validate.Validate;

public class SinhVienKhaGioiDaoImpl extends ConnDB implements SinhVienKhaGioiDao {
     Validate validate = new Validate();
	@Override
	public boolean xuongDB(SinhVienKhaGioi sinhVienKhaGioi) {
		PreparedStatement ps = null;
		Connection con = super.getConnection();
		try {
			super.getConnection();
			String sql = "INSERT INTO SinhVien(hoTen,ngaySinh,gioiTinh,soDienThoai,truongHoc,xepLoaiTotNghiep,diemTB,loaiHocBong)VALUES(?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setNString(1, sinhVienKhaGioi.getHoTen());
//			Date ngay =  new SimpleDateFormat("dd/MM/yyyy").parse(sinhVienKhaGioi.getNgaySinh());
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
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			try {
				ps.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

}
