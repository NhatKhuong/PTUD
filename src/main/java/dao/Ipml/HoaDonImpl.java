package dao.Ipml;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.HoaDonDao;
import entity.CT_HoaDon;
import entity.HoaDon;
import util.HibernateUtil;

public class HoaDonImpl implements HoaDonDao{
	private SessionFactory sessionFactory;
	public HoaDonImpl() {
		// TODO Auto-generated constructor stub
		this.sessionFactory = HibernateUtil.getIntance().getSessionFactory();
	}
	

	@Override
	public List<CT_HoaDon> getDanhSachChiTietHoaDon(String maHD) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		 try {
			 
			 tr.begin();
			 String sql = "select * from [dbo].[CT_HoaDon] where [maHD] = '"+maHD+"'";
			List<CT_HoaDon> list = session.createNativeQuery(sql, CT_HoaDon.class).getResultList();			
			tr.commit();
			
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		 return null;
	}


	@Override
	public String getHoaDonCuoi() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			
			tr.begin();
			String sql = "select top 1 [dbo].[HoaDon].maHD from [dbo].[HoaDon] order by [dbo].[HoaDon].maHD desc";
			String result = (String) session.createNativeQuery(sql).getSingleResult();
			
			tr.commit();
			return result;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return "";
	}


	@Override
	public boolean them(HoaDon hoaDon) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			
			tr.begin();
			session.save(hoaDon);
			tr.commit();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
	public LocalDate getNgayLapHoaDonDauTien() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		String sql = "SELECT TOP 1 ngayLapHD FROM HoaDon\r\n" + "GROUP BY ngayLapHD\r\n" + "ORDER BY ngayLapHD asc";
		try {
			tr.begin();
			Object ob = session.createNativeQuery(sql).getSingleResult();
			tr.commit();
			String[] listString = ob.toString().split("-");
			int nam = Integer.parseInt(listString[0]);
			int thang = Integer.parseInt(listString[1]);
			int ngay = Integer.parseInt(listString[2]);
			LocalDate date = LocalDate.of(nam, thang, ngay);
			return date;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return null;
		}
	}

	public Map<Integer, Double> getDoanhThuTheoNam(int nam, String maNV) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		Map<Integer, Double> mapResult = new HashMap<>();
		String sql = "SELECT MONTH(ngayLapHD), SUM(soLuong*gia+(soLuong*gia*thueVAT)) as doanhThu\r\n"
				+ "FROM CT_HoaDon OD JOIN HoaDon O ON OD.maHD = O.maHD \r\n" + "WHERE YEAR(ngayLapHD) = " + nam
				+ " and maNV like '%" + maNV + "'\r\n" + "GROUP BY MONTH(ngayLapHD)";
		try {
			tr.begin();
			List<?> list = session.createNativeQuery(sql).getResultList();
			Map<Integer, Double> map = new HashMap<Integer, Double>();
			for (Object ob : list) {
				Object[] listO = (Object[]) ob;
				int thang = (int) listO[0];
				double dt = (double) listO[1];
				map.put(thang, dt);
			}
			AtomicInteger i = new AtomicInteger(1);
			AtomicBoolean flag = new AtomicBoolean(false);
			LocalDate date = LocalDate.now();
			int thang = 12;
			if (nam == date.getYear())
				thang = date.getMonthValue();
			while (i.get() <= thang) {
				map.entrySet().forEach(en -> {
					if (en.getKey() == i.get()) {
						mapResult.put(i.get(), en.getValue());
						flag.set(true);
						return;
					}
				});

				if (!flag.get()) {
					mapResult.put(i.get(), 0.0);
				}
				flag.set(false);
				i.set(i.get() + 1);
			}
			tr.commit();
			return mapResult;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return null;
		}
	}
	
		
	public List<HoaDon> getDoanhThuTheoNgay(LocalDate date, String maNV) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		int year = date.getYear() ;
		int month = date.getMonthValue();
		String sql = "SELECT * FROM HoaDon\r\n"
					+ "WHERE YEAR(ngayLapHD) = "+year+" and MONTH(ngayLapHD) = "+month+" and DAY(ngayLapHD) = " + date.getDayOfMonth() +" and maNV like '%"+maNV+"%'";

		try {
			tr.begin();
			List<HoaDon> list  = session.createNativeQuery(sql,HoaDon.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return null;
		}

	}

	
	public Map<Integer, Double> getDoanhThuTheoThang(int thang, int nam, String maNV) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		Map<Integer, Double> mapResult = new HashMap<>();
		String sql = "SELECT DAY(ngayLapHD), SUM(soLuong*gia+(soLuong*gia*thueVAT)) as doanhThu\r\n"
					+ "FROM CT_HoaDon OD JOIN HoaDon O ON OD.maHD = O.maHD \r\n" 
					+ "WHERE YEAR(ngayLapHD) =  " + nam
						+ " and MONTH(ngayLapHD) = " + thang 
						+ " and maNV like '%" + maNV + "'\r\n"
					+ "GROUP BY DAY(ngayLapHD)";
		int month_table[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int leap_month_table[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int soNgay;
		if ((nam % 400 == 0) || (nam % 4 == 0 && nam % 100 != 0)) {
			soNgay = leap_month_table[thang - 1];
		} else {
			soNgay = month_table[thang - 1];
		}
		
		LocalDate date = LocalDate.now();
		
		if (nam == date.getYear() && thang == date.getMonthValue())
			soNgay = date.getDayOfMonth();
		try {
			tr.begin();
			List<?> list = session.createNativeQuery(sql).getResultList();
			Map<Integer, Double> map = new HashMap<Integer, Double>();
			for (Object ob : list) {
				Object[] listO = (Object[]) ob;
				int ngay = (int) listO[0];
				double dt = (double) listO[1];
				map.put(ngay, dt);
			}
			AtomicInteger i = new AtomicInteger(1);
			AtomicBoolean flag = new AtomicBoolean(false);
			while (i.get() <= soNgay) {
				map.entrySet().forEach(en -> {
					if (en.getKey() == i.get()) {
						mapResult.put(i.get(), en.getValue());
						flag.set(true);
						return;
					}
				});

				if (!flag.get()) {
					mapResult.put(i.get(), 0.0);
				}
				flag.set(false);
				i.set(i.get() + 1);
			}
			tr.commit();
			return mapResult;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return null;
		}
	}

	
	public int getTongHoaDonTheoNam(int nam, String maNV) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		String sql = "SELECT  COUNT(*) as Total_Rows\r\n" + "FROM HoaDon\r\n" + "WHERE YEAR(ngayLapHD) = " + nam
				+ " and maNV like '%" + maNV + "'";
		try {
			tr.begin();
			int tong = (int) session.createNativeQuery(sql).getSingleResult();
			tr.commit();
			return tong;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return 0;
		}
	}

	
	public int getTongHoaDonTheoNgay(LocalDate date, String maNV) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		int year = date.getYear() ;
		int month = date.getMonthValue();
		if (month == 0)
			month = 12;
		String sql = "SELECT  COUNT(*) as Total_Rows\r\n" + "FROM HoaDon\r\n" + "WHERE YEAR(ngayLapHD) = " + year
				+ " and MONTH(ngayLapHD) = " + month + " and DAY(ngayLapHD) = " + date.getDayOfMonth() + " and maNV like '%"
				+ maNV + "'";
		try {
			tr.begin();
			int tong = (int) session.createNativeQuery(sql).getSingleResult();
			tr.commit();
			return tong;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return 0;
		}
	}

	
	public int getTongHoaDonTheoThang(int thang, int nam, String maNV) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		String sql = "SELECT  COUNT(*) as Total_Rows\r\n" + "FROM HoaDon\r\n" + "WHERE YEAR(ngayLapHD) = " + nam
				+ " and MONTH(ngayLapHD) = " + thang +  " and maNV like '%"
				+ maNV + "'";
		try {
			tr.begin();
			int tong = (int) session.createNativeQuery(sql).getSingleResult();
			tr.commit();
			return tong;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return 0;
		}
	}


	@Override
	public List<HoaDon> getAllHoaDonTheoPage(int page, String maHD, int ngay, int thang, int nam, String tenKH,
			String sdtKH, String tenNV, String sdtNV) {
		int offset = page * 10;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		String sql = "SELECT        HoaDon.maHD,KhachHang.maKH,NhanVien.maNV,ngayLapHD ,KhachHang.hoTen AS[Họ tên khách hàng],KhachHang.sdt AS [Số điện thoại khách hàng],\r\n"
				+ "			  NhanVien.hoTen AS[Họ tên nhân viên], NhanVien.sdt AS [Số điện thoại nhân viên],SUM(CT_HoaDon.gia * CT_HoaDon.soLuong) AS [Tổng tiền],HoaDon.thueVAT,HoaDon.tienNhan \r\n"
				+ "FROM            HoaDon INNER JOIN\r\n"
				+ "                         CT_HoaDon ON HoaDon.maHD = CT_HoaDon.maHD INNER JOIN\r\n"
				+ "                         KhachHang ON HoaDon.maKH = KhachHang.maKH INNER JOIN\r\n"
				+ "                         NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "WHERE	(HoaDon.maHD like N'%"+maHD+"%' AND KhachHang.hoTen like N'%"+tenKH+"%'\r\n"
				+ "		and KhachHang.sdt like N'%"+sdtKH+"%' and NhanVien.hoTen like N'%"+tenNV+"%' and NhanVien.sdt like N'%"+sdtNV+"%' OR(Day(ngayLapHD) = "+ngay+" and MONTH(ngayLapHD) = "+thang+" and YEAR(ngayLapHD) = "+nam+"))\r\n"
				+ "		OR (HoaDon.maHD like N'%"+maHD+"%' AND KhachHang.hoTen like N'%"+tenKH+"%'\r\n"
				+ "		and KhachHang.sdt like N'%"+sdtKH+"%' and NhanVien.hoTen like N'%"+tenNV+"%' and NhanVien.sdt like N'%"+sdtNV+"%' AND(Day(ngayLapHD) = "+ngay+" and MONTH(ngayLapHD) = "+thang+" and YEAR(ngayLapHD) = "+nam+") )\r\n"
				+ "GROUP BY HoaDon.maHD ,KhachHang.maKH,ngayLapHD,KhachHang.hoTen,NhanVien.hoTen,KhachHang.sdt,NhanVien.sdt,NhanVien.maNV,HoaDon.thueVAT,HoaDon.tienNhan\r\n"
				+ "ORDER BY HoaDon.maHD Desc offset "+offset+" rows fetch next 10 rows only";
		try {
			tr.begin();
			List<HoaDon> listHD = session.createNativeQuery(sql, HoaDon.class).getResultList();
			tr.commit();
			return listHD;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return null;
	}


	@Override
	public int getTongSoHD(String maHD, int ngay, int thang, int nam, String tenKH, String sdtKH, String tenNV,
			String sdtNV) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		String sql = "SELECT        HoaDon.maHD,KhachHang.maKH,NhanVien.maNV,ngayLapHD ,KhachHang.hoTen AS[Họ tên khách hàng],KhachHang.sdt AS [Số điện thoại khách hàng],\r\n"
				+ "			  NhanVien.hoTen AS[Họ tên nhân viên], NhanVien.sdt AS [Số điện thoại nhân viên],SUM(CT_HoaDon.gia * CT_HoaDon.soLuong) AS [Tổng tiền],HoaDon.thueVAT,HoaDon.tienNhan \r\n"
				+ "FROM            HoaDon INNER JOIN\r\n"
				+ "                         CT_HoaDon ON HoaDon.maHD = CT_HoaDon.maHD INNER JOIN\r\n"
				+ "                         KhachHang ON HoaDon.maKH = KhachHang.maKH INNER JOIN\r\n"
				+ "                         NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "WHERE	(HoaDon.maHD like N'%"+maHD+"%'AND KhachHang.hoTen like N'%"+tenKH+"%'\r\n"
				+ "		and KhachHang.sdt like N'%"+sdtKH+"%' and NhanVien.hoTen like N'%"+tenNV+"%' and NhanVien.sdt like N'%"+sdtNV+"%' OR(Day(ngayLapHD) = "+ngay+" and MONTH(ngayLapHD) = "+thang+" and YEAR(ngayLapHD) = "+nam+"))\r\n"
				+ "		OR (HoaDon.maHD like N'%"+maHD+"%' AND KhachHang.hoTen like N'%"+tenKH+"%'\r\n"
				+ "		and KhachHang.sdt like N'%"+sdtKH+"%' and NhanVien.hoTen like N'%"+tenNV+"%' and NhanVien.sdt like N'%"+sdtNV+"%' AND(Day(ngayLapHD) = "+ngay+" and MONTH(ngayLapHD) = "+thang+" and YEAR(ngayLapHD) = "+nam+") )\r\n"
				+ "GROUP BY HoaDon.maHD ,KhachHang.maKH,ngayLapHD,KhachHang.hoTen,NhanVien.hoTen,KhachHang.sdt,NhanVien.sdt,NhanVien.maNV,HoaDon.thueVAT,HoaDon.tienNhan\r\n";
		
		// TODO Auto-generated method stub
		try {
			tr.begin();
			List<HoaDon> listHD = session.createNativeQuery(sql, HoaDon.class).getResultList();
			tr.commit();
			return listHD.size();
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return 0;
	}



	@Override
	public HoaDon getHoaDonTheoMa(String maHD) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		String sql = "Select * from   HoaDon Where HoaDon.maHD like N'%"+maHD+"%'";
		try {
			tr.begin();
			HoaDon hd  = session.createNativeQuery(sql, HoaDon.class).getSingleResult();
			return hd ;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	@Override
	public List<HoaDon> getAllHoaDons(int page, String maHD, int ngay, int thang, int nam, String tenKH, String sdtKH,
			String tenNV, String sdtNV) {
		int offset = page * 10;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		String sql = "SELECT        HoaDon.maHD,KhachHang.maKH,NhanVien.maNV,ngayLapHD ,KhachHang.hoTen AS[Họ tên khách hàng],KhachHang.sdt AS [Số điện thoại khách hàng],\r\n"
				+ "			  NhanVien.hoTen AS[Họ tên nhân viên], NhanVien.sdt AS [Số điện thoại nhân viên],SUM(CT_HoaDon.gia * CT_HoaDon.soLuong) AS [Tổng tiền],HoaDon.thueVAT,HoaDon.tienNhan \r\n"
				+ "FROM            HoaDon INNER JOIN\r\n"
				+ "                         CT_HoaDon ON HoaDon.maHD = CT_HoaDon.maHD INNER JOIN\r\n"
				+ "                         KhachHang ON HoaDon.maKH = KhachHang.maKH INNER JOIN\r\n"
				+ "                         NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "WHERE (HoaDon.maHD like N'%"+maHD+"%' AND KhachHang.hoTen like N'%"+tenKH+"%'\r\n"
				+ "		and KhachHang.sdt like N'%"+sdtKH+"%' and NhanVien.hoTen like N'%"+tenNV+"%' and NhanVien.sdt like N'%"+sdtNV+"%' AND(Day(ngayLapHD) = "+ngay+" and MONTH(ngayLapHD) = "+thang+" and YEAR(ngayLapHD) = "+nam+") )\r\n"
				+ "GROUP BY HoaDon.maHD ,KhachHang.maKH,ngayLapHD,KhachHang.hoTen,NhanVien.hoTen,KhachHang.sdt,NhanVien.sdt,NhanVien.maNV,HoaDon.thueVAT,HoaDon.tienNhan\r\n"
				+ "ORDER BY HoaDon.maHD Desc offset "+offset+" rows fetch next 10 rows only";
		try {
			tr.begin();
			List<HoaDon> listHD = session.createNativeQuery(sql, HoaDon.class).getResultList();
			tr.commit();
			return listHD;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return null;
	}

}
