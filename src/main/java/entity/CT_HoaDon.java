package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Đỗ Trung Ngọc, Đặng Nhật Khương, Trần Tấn Phước
 * @version 1.0
 * @created 26-10-2021
 */

@Entity
@IdClass(CT_HoaDonPK.class)
public class CT_HoaDon {
	@Column(columnDefinition = "int", nullable = false)
	private int soLuong;
	@Column(columnDefinition = "real", nullable = false)
	private double gia;
	@ManyToOne
	@JoinColumn(name = "maHD")
	@Id
	private HoaDon hoaDon;
	@ManyToOne
	@JoinColumn(name = "maSP")
	@Id
	private SanPham sanPham;
	
	
	
	
	public CT_HoaDon() {
		super();
	}
	public CT_HoaDon(int soLuong, double gia, HoaDon hoaDon, SanPham sanPham) {
		super();
		this.soLuong = soLuong;
		this.gia = gia;
		this.hoaDon = hoaDon;
		this.sanPham = sanPham;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	@Override
	public String toString() {
		return "CT_HoaDon [soLuong=" + soLuong + ", gia=" + gia + ", hoaDon=" + hoaDon + ", sanPham=" + sanPham + "]";
	}
	
	public double tinhThanhTien() {
		return this.soLuong*this.gia; 
	}
	
}
