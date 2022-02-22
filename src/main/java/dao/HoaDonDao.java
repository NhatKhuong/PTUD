package dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import entity.CT_HoaDon;
import entity.HoaDon;

public interface HoaDonDao {
	public List<CT_HoaDon> getDanhSachChiTietHoaDon(String maHD);
	public String getHoaDonCuoi();
	public boolean them(HoaDon hoaDon);
	public LocalDate getNgayLapHoaDonDauTien();

	public Map<Integer, Double> getDoanhThuTheoNam(int nam,String maNV);
	public List<HoaDon> getDoanhThuTheoNgay(LocalDate date,String maNV);
	public Map<Integer,Double> getDoanhThuTheoThang(int thang,int nam,String maNV);
	public int getTongHoaDonTheoNam(int nam,String maNV);
	public int getTongHoaDonTheoNgay(LocalDate date,String maNV);
	public int getTongHoaDonTheoThang(int thang,int nam,String maNV);
	
	public List<HoaDon>getAllHoaDonTheoPage(int page,String maHD,int ngay,int thang,int nam, String tenKH,String sdtKH,String tenNV, String sdtNV);
	public int getTongSoHD(String maHD,int ngay,int thang,int nam, String tenKH,String sdtKH,String tenNV, String sdtNV);
	public HoaDon getHoaDonTheoMa(String maHD);
	
	public List<HoaDon> getAllHoaDons(int page, String maHD, int ngay, int thang, int nam, String tenKH, String sdtKH,
			String tenNV, String sdtNV);

}
