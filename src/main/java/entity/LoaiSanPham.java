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
public class LoaiSanPham {
	@Id
	private String maLoai;
	@Column(columnDefinition = "nvarchar(255)", nullable = false)
	private String tenLoai;
	public LoaiSanPham() {
		super();
	}
	public LoaiSanPham(String maLoai, String tenLoai) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	@Override
	public String toString() {
		return "LoaiSanPham [maLoai=" + maLoai + ", tenLoai=" + tenLoai + "]";
	}
	
}
