package dao;

import java.time.LocalDate;
import java.util.List;

import entity.NhanVien;

public interface NhanVienDao {
	public List<NhanVien> getAllNhanVien();
	public List<NhanVien> findNhanVien(String maNV, String tenNV, String sdt);
	public boolean themNhanVien(NhanVien nv);
	public boolean suaNVTT(NhanVien nv);
	public NhanVien getNhanVien(String maNV, String tenNV, String sdt);
	public String getNhanVienCuoiCung();
	public NhanVien getNhanVientheoMa(String maNV);
	public List<NhanVien> getAllNhanVienTheoGTvaTT(boolean gioiTinh, boolean trangThai);
	
	public List<NhanVien> getNhanVienTheoPage(int page,String maNV, String tenNV, String sdt, String xa, String huyen, String tinh,
			int trangThai,int gioiTinh,String cmnd);
	public int TongNhanVien(String maNV, String tenNV, String sdt, String xa, String huyen, String tinh,
			int trangThai,int gioiTinh,String cmnd);
	
	public boolean capNhatNhanVien(NhanVien nv);
	public boolean kiemTraSoDienThoai(String sdt);
	public boolean kiemTraChungMinhNhanDan(String cmnd);
	public int getTongSoHang(String ma, String ten, boolean trangThai);
	public List<NhanVien> timKiemNhanVien(String ma, String ten, boolean trangThai,int page);
	
	public NhanVien getNhanVien(String maNV, String matKhau);
	
	public List<NhanVien> timKiemNhanVienDaLapHoaDonTheoNgay(String ten, String ma, LocalDate date);
	public List<NhanVien> timKiemNhanVienDaLapHoaDonTheoThang(String ten, String ma, int thang, int nam);
	public List<NhanVien> timKiemNhanVienDaLapHoaDonTheoNam(String ten, String ma, int nam);
	
}
