package dao;

import java.util.List;

import entity.LoaiSanPham;

public interface LoaiSanPhamDao {
	public LoaiSanPham getLoaiSanPhamById(String id);
	public LoaiSanPham getLoaiSanPhamByName(String name);
	public List<String> getDanhSachLoai();

}
