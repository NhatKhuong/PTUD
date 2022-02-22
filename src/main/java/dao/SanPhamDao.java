package dao;

import java.util.List;
import java.util.Map;

import entity.SanPham;

public interface SanPhamDao{
	public List<SanPham> getDanhSachSanPham(int page,int instance, String tenSanPham, String nhanHieu, String maSanPham, String loaiSanPham, String kichThuoc, String chatLieu, boolean trangThai);
	public List<String> getDanhSachNhanHieu();
	public List<String> getKichThuoc();
	public SanPham getSanPhamById(String id);
	public int tongSoHang(String tenSanPham, String nhanHieu, String maSanPham, String loaiSanPham, String kichThuoc, String chatLieu, boolean trangThai);
	public boolean update(SanPham sanPham);
	public boolean capNhatTrangThaiKD(String id, boolean trangThai);
	public List<SanPham> danhSachSanPhamBanChay(int page, int instance);
	public boolean capNhatSoLuong(String maSP, int soLuongThem);
	public List<String> getDanhSachChatLieu();
	public List<SanPham> getAllSanPham(String tenSanPham, String nhanHieu, String maSanPham, String loaiSanPham, String kichThuoc, String chatLieu);
	public List<SanPham> getAllSanPhamCoTrangThai(String tenSanPham, String nhanHieu, String maSanPham, String loaiSanPham, String kichThuoc, String chatLieu, boolean trangThai);
	public List<SanPham> getSanPhamSapHetSoLuong();
	public int tinhTongHangBanChay();
	public boolean them(SanPham sanPham);
	public String getMaSanPhamCuoi();
	public boolean deleteSanPham(SanPham sanPham);
	public Map<SanPham,Integer> getSanPhamBanChay(int ngay, int thang, int nam, int top);
}
