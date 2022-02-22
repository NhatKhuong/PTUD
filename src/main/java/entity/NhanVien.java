package entity;


import java.util.Date;
import java.util.Objects;

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
public class NhanVien {
	@Id
	private String maNV;
	@Column(columnDefinition = "nvarchar(255)", nullable = false)
	private String hoTen;
	@Column(columnDefinition = "varchar(25)", nullable = false,unique = true)
	private String matKhau;
	@Column(columnDefinition = "bit", nullable = false)
	private boolean trangThai;
	@Column(columnDefinition = "varchar(25)", nullable = false,unique = true)
	private String sdt;
	@Column(columnDefinition = "bit", nullable = false)
	private boolean gioiTinh;
	@Column(columnDefinition = "Date", nullable = false)
	private Date ngaySinh;
	@Column(columnDefinition = "bit", nullable = false)
	private boolean chucVu;
	@Column(columnDefinition = "varchar(25)", nullable = false,unique = true)
	private String cmnd;
	@Column(columnDefinition = "varchar(255)")
	private String hinhAnh;
	
	@ManyToOne
	@JoinColumn(name = "maDiaChi")
	DiaChi diaChi;
	
	public NhanVien() {
		super();
	}
	
	
	public NhanVien(String maNV, String hoTen, String matKhau, boolean trangThai, String sdt, boolean gioiTinh,
			Date ngaySinh, boolean chucVu, String cmnd, String hinhAnh, DiaChi diaChi) {
		super();
		this.maNV = maNV;
		this.hoTen = hoTen;
		this.matKhau = matKhau;
		this.trangThai = trangThai;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.chucVu = chucVu;
		this.cmnd = cmnd;
		this.hinhAnh = hinhAnh;
		this.diaChi = diaChi;
	}


	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isChucVu() {
		return chucVu;
	}
	public void setChucVu(boolean chucVu) {
		this.chucVu = chucVu;
	}
	public String getcmnd() {
		return cmnd;
	}
	public void setcmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	
	public DiaChi getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}

	
	public String getCmnd() {
		return cmnd;
	}


	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}


	public String getHinhAnh() {
		return hinhAnh;
	}


	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}


	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoTen=" + hoTen + ", matKhau=" + matKhau + ", trangThai=" + trangThai
				+ ", sdt=" + sdt + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", chucVu=" + chucVu
				+ ", cmnd=" + cmnd + ", hinhAnh=" + hinhAnh + ", diaChi=" + diaChi + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}
	
	
	
	
	
	
}
