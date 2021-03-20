package fa.trainng.fina.bean;

import java.util.Date;

public class SinhVienKhaGioi extends SinhVien {
	private double diemTB;
	private String loaiHocBong;

	public double getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(double diemTB) {
		this.diemTB = diemTB;
	}

	public String getLoaiHocBong() {
		return loaiHocBong;
	}

	public void setLoaiHocBong(String loaiHocBong) {
		this.loaiHocBong = loaiHocBong;
	}

	public SinhVienKhaGioi(String hoTen, Date ngaySinh, String gioiTinh, String soDienThoai, String truongHoc,
			String xepLoaiToiNghiep, double diemTB, String loaiHocBong) {
		super(hoTen, ngaySinh, gioiTinh, soDienThoai, truongHoc, xepLoaiToiNghiep);
		this.diemTB = diemTB;
		this.loaiHocBong = loaiHocBong;
	}

	public SinhVienKhaGioi() {

	}

	@Override
	public String toString() {
		return "SinhVienKhaGioi [" + super.toString() + "diemTB=" + diemTB + ", loaiHocBong=" + loaiHocBong + "]";
	}

	@Override
	public void HienThi() {
		System.out.println(this.toString());

	}

}
