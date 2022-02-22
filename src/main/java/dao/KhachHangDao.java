package dao;

import java.util.List;

import entity.KhachHang;

public interface KhachHangDao {
	public String getKhachHangCuoiCung();
	public boolean themKhachHang(KhachHang kh);
	public KhachHang getKhachHangById(String id);
	public KhachHang getKhachHangByStd(String sdt);
	public List<KhachHang> getKhachHangTheoPage(int page,String ma, String ten, String sdt, String xa, String huyen, String tinh, int gioiTinh);
	public List<KhachHang> findKhachHang(String ma, String ten, String sdt, String xa, String huyen, String tinh, int gioiTinh);
	public int TongKhachHang(String ma, String ten, String sdt, String xa, String huyen, String tinh, int gioiTinh);
	public List<KhachHang> getKhachHangTheoPage_instance(int page, int instance,String ma, String ten);
	public int tongHangTimKiem(String ma, String ten);
	public boolean update(KhachHang khachHang);
}
