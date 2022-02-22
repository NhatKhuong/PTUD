package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Đỗ Trung Ngọc, Đặng Nhật Khương, Trần Tấn Phước
 * @version 1.0
 * @created 26-10-2021
 */

@Entity
public class DiaChi {
	@Id
	private String maDiaChi;
	@Column(columnDefinition = "nvarchar(255)", nullable = false)
	private String tinhTP;
	@Column(columnDefinition = "nvarchar(255)", nullable = false)
	private String quanHuyen;
	@Column(columnDefinition = "nvarchar(255)", nullable = false)
	private String phuongXa;
	
	
	public DiaChi() {
		super();
	}


	public DiaChi(String maDiaChi, String tinhTP, String quanHuyen, String phuongXa) {
		super();
		this.maDiaChi = maDiaChi;
		this.tinhTP = tinhTP;
		this.quanHuyen = quanHuyen;
		this.phuongXa = phuongXa;
	}
	

	public String getMaDiaChi() {
		return maDiaChi;
	}


	public void setMaDiaChi(String maDiaChi) {
		this.maDiaChi = maDiaChi;
	}


	public String getTinhTP() {
		return tinhTP;
	}


	public void setTinhTP(String tinhTP) {
		this.tinhTP = tinhTP;
	}


	public String getQuanHuyen() {
		return quanHuyen;
	}


	public void setQuanHuyen(String quanHuyen) {
		this.quanHuyen = quanHuyen;
	}


	public String getPhuongXa() {
		return phuongXa;
	}


	public void setPhuongXa(String phuongXa) {
		this.phuongXa = phuongXa;
	}


	@Override
	public String toString() {
		return "DiaChi [maDiaChi=" + maDiaChi + ", tinhTP=" + tinhTP + ", quanHuyen=" + quanHuyen + ", phuongXa="
				+ phuongXa + "]";
	}
	
	
}
