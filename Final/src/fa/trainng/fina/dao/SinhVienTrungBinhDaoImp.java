package fa.trainng.fina.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import fa.trainng.fina.bean.SinhVienTrungBinh;
import fa.trainng.fina.conn.ConnDB;
import fa.trainng.fina.validate.Validate;

public class SinhVienTrungBinhDaoImp extends ConnDB implements SinhVienTrungBinhDao {
	Validate validate = new Validate();

	@Override
	public boolean xuongDB(SinhVienTrungBinh sinhVienTB) {
		PreparedStatement ps = null;
		Connection con = super.getConnection();
		try {
			super.getConnection();
			String sql = "INSERT INTO SinhVien(hoTen,ngaySinh,gioiTinh,soDienThoai,truongHoc,xepLoaiTotNghiep,diemToeic,diemDauVao)VALUES(?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setNString(1, sinhVienTB.getHoTen());
			Date date = validate.convertJavaDateToSqlDate(sinhVienTB.getNgaySinh());
			ps.setDate(2, date);
			ps.setString(3, sinhVienTB.getGioiTinh());
			ps.setNString(4, sinhVienTB.getSoDienThoai());
			ps.setNString(5, sinhVienTB.getTruongHoc());
			ps.setNString(6, sinhVienTB.getXepLoaiToiNghiep());
			ps.setDouble(7, sinhVienTB.getDiemToeic());
			ps.setDouble(8, sinhVienTB.getDiemDauVao());
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
