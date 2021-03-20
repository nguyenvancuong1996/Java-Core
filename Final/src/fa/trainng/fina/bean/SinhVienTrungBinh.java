package fa.trainng.fina.bean;

import java.util.Date;

public class SinhVienTrungBinh extends SinhVien {
	private double diemToeic;
	private double diemDauVao;

	public double getDiemToeic() {
		return diemToeic;
	}

	public void setDiemToeic(double diemToeic) {
		this.diemToeic = diemToeic;
	}

	public double getDiemDauVao() {
		return diemDauVao;
	}

	public void setDiemDauVao(double diemDauVao) {
		this.diemDauVao = diemDauVao;
	}

	public SinhVienTrungBinh(String hoTen, Date ngaySinh, String gioiTinh, String soDienThoai, String truongHoc,
			String xepLoaiToiNghiep, double diemToeic, double diemDauVao) {
		super(hoTen, ngaySinh, gioiTinh, soDienThoai, truongHoc, xepLoaiToiNghiep);
		this.diemToeic = diemToeic;
		this.diemDauVao = diemDauVao;
	}

	public SinhVienTrungBinh() {

	}

	@Override
	public String toString() {
		return "SinhVienTrungBinh [" + super.toString() + "diemToeic=" + diemToeic + ", diemDauVao=" + diemDauVao + "]";
	}

	@Override
	public void HienThi() {
		System.out.println(this.toString());

	}

}
