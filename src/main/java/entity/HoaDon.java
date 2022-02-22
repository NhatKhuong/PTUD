package entity;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import dao.Ipml.CT_HoaDonImpl;

/**
 * @author Đỗ Trung Ngọc, Đặng Nhật Khương, Trần Tấn Phước
 * @version 1.0
 * @created 26-10-2021
 */

@Entity
public class HoaDon {
	@Id
	private String maHD;
	@Column(columnDefinition = "Date", nullable = false)
	private Date ngayLapHD;
	@Column(columnDefinition = "float", nullable = false)
	private Float thueVAT;
	@ManyToOne
	@JoinColumn(name = "maNV")
	private NhanVien nhanVien;
	@ManyToOne
	@JoinColumn(name = "maKH")
	private KhachHang khachHang;
	@Column(columnDefinition = "real")
	private double tienNhan;
	
	
	
	public HoaDon() {
		super();
	}
	public HoaDon(String maHD, Date ngayLapHD, Float thueVAT, NhanVien nhanVien, KhachHang khachHang, double tienNhan) {
		super();
		this.maHD = maHD;
		this.ngayLapHD = ngayLapHD;
		this.thueVAT = thueVAT;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.tienNhan = tienNhan;
		
	}
	public double getTienNhan() {
		return tienNhan;
	}
	public void setTienNhan(double tienNhan) {
		this.tienNhan = tienNhan;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public Date getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public Float getThueVAT() {
		return thueVAT;
	}
	public void setThueVAT(Float thueVAT) {
		this.thueVAT = thueVAT;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", ngayLapHD=" + ngayLapHD + ", thueVAT=" + thueVAT + ", nhanVien=" + nhanVien
				+ ", khachHang=" + khachHang + "]";
	}
	
	/**
	 * 
	 * @return double (tổng tiền các sản phẩm của hóa đơn)
	 */
	public double tinhTongTien() {
		CT_HoaDonImpl chiTietHDDao = new CT_HoaDonImpl();
		List<CT_HoaDon> list = chiTietHDDao.getDanhSachChiTietHoaDon(this.maHD);
		double tongTien = 0;
		for (CT_HoaDon ct_HoaDon : list) {
			tongTien += ct_HoaDon.tinhThanhTien();
		}
		return tongTien;
	}
	
	/**
	 * 
	 * @return double (tổng tiền của hóa đơn bao gồm cả thuế)
	 */
	public double tinhTongTien_VAT() {
		return tinhTongTien() + this.thueVAT*tinhTongTien();
	}
		
}
