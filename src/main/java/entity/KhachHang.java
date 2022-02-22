package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Đỗ Trung Ngọc, Đặng Nhật Khương, Trần Tấn Phước
 * @version 1.0
 * @created 26-10-2021
 */

@Entity
public class KhachHang {
	@Id
	private String maKH;
	@Column(columnDefinition = "nvarchar(255)", nullable = false)
	private String hoTen;
	
	private boolean gioiTinh;
	@Column(columnDefinition = "varchar(25)", nullable = false,unique = true)
	private String sdt;
	@ManyToOne
	@JoinColumn(name = "maDiaChi")
	DiaChi diaChi;
	public KhachHang() {
		super();
	}
	public KhachHang(String maKH, String hoTen, String sdt, DiaChi diaChi) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}
	
	public KhachHang(DiaChi diaChi, String hoTen, String sdt,String maKH , boolean gioiTinh) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public DiaChi getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", hoTen=" + hoTen + ", sdt=" + sdt + ", diaChi=" + diaChi + "]";
	}
	
}
