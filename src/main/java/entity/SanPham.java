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
public class SanPham {
	@Id
	private String maSP;
	@Column(columnDefinition = "nvarchar(255)", nullable = false)
	private String tenSP;
	@Column(columnDefinition = "int", nullable = false)
	private int soLuong;
	@Column(columnDefinition = "nvarchar(255)", nullable = false)
	private String mauSac;
	@Column(columnDefinition = "nvarchar(255)", nullable = false)
	private String chatLieu;
	@Column(columnDefinition = "varchar(25)", nullable = false)
	private String kichThuoc;
	@Column(columnDefinition = "real", nullable = false)
	private double donGia;
	@Column(columnDefinition = "nvarchar(255)", nullable = false)
	private String nhanHieu;
	@Column(columnDefinition = "binary(5000)", nullable = false)
	private String hinhAnh;
	@ManyToOne
	@JoinColumn(name = "maLoai")
	private LoaiSanPham loaiSanPham;
	@Column(columnDefinition = "bit")
	private boolean trangThaiKD;
	
	public SanPham() {
		super();
	}

	public SanPham(String maSP, String tenSP, int soLuong, String mauSac, String chatLieu, String kichThuoc,
			double donGia, String nhanHieu, String hinhAnh, LoaiSanPham loaiSanPham, boolean trangThaiKD) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.mauSac = mauSac;
		this.chatLieu = chatLieu;
		this.kichThuoc = kichThuoc;
		this.donGia = donGia;
		this.nhanHieu = nhanHieu;
		this.hinhAnh = hinhAnh;
		this.loaiSanPham = loaiSanPham;
		this.trangThaiKD = trangThaiKD;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	public String getChatLieu() {
		return chatLieu;
	}

	public void setChatLieu(String chatLieu) {
		this.chatLieu = chatLieu;
	}

	public String getKichThuoc() {
		return kichThuoc;
	}

	public void setKichThuoc(String kichThuoc) {
		this.kichThuoc = kichThuoc;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getNhanHieu() {
		return nhanHieu;
	}

	public void setNhanHieu(String nhanHieu) {
		this.nhanHieu = nhanHieu;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	public boolean isTrangThaiKD() {
		return trangThaiKD;
	}

	public void setTrangThaiKD(boolean trangThaiKD) {
		this.trangThaiKD = trangThaiKD;
	}

	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", soLuong=" + soLuong + ", mauSac=" + mauSac
				+ ", chatLieu=" + chatLieu + ", kichThuoc=" + kichThuoc + ", donGia=" + donGia + ", nhanHieu="
				+ nhanHieu + ", hinhAnh=" + hinhAnh + ", loaiSanPham=" + loaiSanPham + ", trangThaiKD=" + trangThaiKD
				+ "]";
	}
	
	
}
