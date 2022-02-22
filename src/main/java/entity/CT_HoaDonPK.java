package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author Đỗ Trung Ngọc, Đặng Nhật Khương, Trần Tấn Phước
 * @version 1.0
 * @created 26-10-2021
 */

@Embeddable
public class CT_HoaDonPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hoaDon;
	private String sanPham;
	public CT_HoaDonPK() {
		super();
	}
	public CT_HoaDonPK(String hoaDon, String sanPham) {
		super();
		this.hoaDon = hoaDon;
		this.sanPham = sanPham;
	}
	public String getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(String hoaDon) {
		this.hoaDon = hoaDon;
	}
	public String getSanPham() {
		return sanPham;
	}
	public void setSanPham(String sanPham) {
		this.sanPham = sanPham;
	}
	@Override
	public String toString() {
		return "CT_HoaDonPK [hoaDon=" + hoaDon + ", sanPham=" + sanPham + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hoaDon == null) ? 0 : hoaDon.hashCode());
		result = prime * result + ((sanPham == null) ? 0 : sanPham.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CT_HoaDonPK other = (CT_HoaDonPK) obj;
		if (hoaDon == null) {
			if (other.hoaDon != null)
				return false;
		} else if (!hoaDon.equals(other.hoaDon))
			return false;
		if (sanPham == null) {
			if (other.sanPham != null)
				return false;
		} else if (!sanPham.equals(other.sanPham))
			return false;
		return true;
	}
	
}
