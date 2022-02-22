package dao;

import java.util.List;

import entity.CT_HoaDon;

public interface CT_HoaDonDao {
	public List<CT_HoaDon> getDanhSachChiTietHoaDon(String maHD);
	public boolean them(CT_HoaDon ct_HoaDon);

}
