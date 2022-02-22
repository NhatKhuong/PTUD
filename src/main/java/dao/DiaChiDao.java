package dao;

import java.util.List;

import entity.DiaChi;

public interface DiaChiDao {
	public List<DiaChi> getAllDC();
	public List<String> getAllTinhTP();
	public List<String> getAllHuyenTrongTinhTP(String tinh);
	public List<String> getAllPhuongXa(String tinh, String huyen);
	public List<String> getAllPhuongXaTheoHuyen(String huyen);
	public DiaChi getDiaChi(String xa , String huyen, String tinh);
}
