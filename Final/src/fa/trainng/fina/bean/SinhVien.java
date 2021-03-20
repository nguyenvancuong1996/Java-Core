package fa.trainng.fina.bean;

import java.util.Date;

public abstract class SinhVien {
	private String hoTen;
	private Date ngaySinh;
	private String gioiTinh;
	private String soDienThoai;
	private String truongHoc;
	private String xepLoaiToiNghiep;

	public abstract void HienThi();

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTruongHoc() {
		return truongHoc;
	}

	public void setTruongHoc(String truongHoc) {
		this.truongHoc = truongHoc;
	}

	public String getXepLoaiToiNghiep() {
		return xepLoaiToiNghiep;
	}

	public void setXepLoaiToiNghiep(String xepLoaiToiNghiep) {
		this.xepLoaiToiNghiep = xepLoaiToiNghiep;
	}

	public SinhVien(String hoTen, Date ngaySinh, String gioiTinh, String soDienThoai, String truongHoc,
			String xepLoaiToiNghiep) {

		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.truongHoc = truongHoc;
		this.xepLoaiToiNghiep = xepLoaiToiNghiep;
	}
	public SinhVien() {

	}

	@Override
	public String toString() {
		return "Ho va ten:" + hoTen + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", soDienThoai="
				+ soDienThoai + ", truongHoc=" + truongHoc + ", xepLoaiToiNghiep=" + xepLoaiToiNghiep;
	}

}
