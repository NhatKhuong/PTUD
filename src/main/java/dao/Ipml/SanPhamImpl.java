package dao.Ipml;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.SanPhamDao;
import entity.SanPham;
import util.HibernateUtil;

public class SanPhamImpl implements SanPhamDao{
	
	private SessionFactory sessionFactory;
	public SanPhamImpl() {
		// TODO Auto-generated constructor stub
		sessionFactory = HibernateUtil.getIntance().getSessionFactory();
	}

	public List<SanPham> getDanhSachSanPham(int page, int instance, String tenSanPham, String nhanHieu, String maSanPham, String loaiSanPham, String kichThuoc, String chatLieu, boolean trangThai) {
		
		int offset = page*instance;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			
			tr.begin();
//			String sql = "select * from [dbo].[SanPham] join [dbo].[LoaiSanPham] on [dbo].[SanPham].maLoai = [dbo].[LoaiSanPham].maLoai\r\n"
//					+ "  where tenSP like N'%"+tenSanPham+"%'and nhanHieu like N'%"+nhanHieu+"%' and tenLoai like N'%"+loaiSanPham+"%' and maSP like '%"+maSanPham+"%'\r\n"
//					+ "  order by [dbo].[SanPham].tenSP\r\n"
//					+ "  offset "+offset+"\r\n"
//					+ "  rows fetch next 3 rows only";
			
			String sql = "select * from [dbo].[SanPham] join [dbo].[LoaiSanPham] on [dbo].[SanPham].maLoai = [dbo].[LoaiSanPham].maLoai "
					+ "where tenSP like N'%"+tenSanPham+"%'"
					+ "and nhanHieu like N'%"+nhanHieu+"%' "
					+ "and tenLoai like N'%"+loaiSanPham+"%' "
					+ "and maSP like '%"+maSanPham+"%' "
					+ "and kichThuoc like N'"+kichThuoc+"%' "
					+ "and chatLieu like N'%"+chatLieu+"%'"
					+ "and trangThaiKD = '"+trangThai+"' "
					+ "order by [dbo].[SanPham].maSP offset "+offset+" rows fetch next "+instance+" rows only";
			
			List<SanPham> sanPhams = session.createNativeQuery(sql,SanPham.class)
					.getResultList();
			
			tr.commit();
			return sanPhams;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}	
		session.close();
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getDanhSachNhanHieu() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			
			tr.begin();
			String sql="select distinct nhanHieu from [dbo].[SanPham]";
			List<String> list = session.createNativeQuery(sql).getResultList();
			
			tr.commit();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
			e.printStackTrace();
		}
		session.close();
		return null;
	}
	@Override
	public SanPham getSanPhamById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			
			tr.begin();
			SanPham sanPham = session.find(SanPham.class, id);
			tr.commit();
			return sanPham;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		session.close();
		return null;
	}

//String sql = "select COUNT(*) from KhachHang where tenKhachHang like N'%"+txtSearch+"%'  and gioiTinh like '%" + ttlv +"%'";
	@Override
	public int tongSoHang(String tenSanPham, String nhanHieu, String maSanPham, String loaiSanPham, String kichThuoc, String chatLieu, boolean trangThai) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
//			String sql = " select COUNT(*) from [dbo].[SanPham] join [dbo].[LoaiSanPham] on [dbo].[SanPham].maLoai = [dbo].[LoaiSanPham].maLoai where tenSP like N'%"+tenSanPham+"%'and nhanHieu like N'%"+nhanHieu+"%' and tenLoai like N'%"+loaiSanPham+"%' and maSP like N'%"+maSanPham+"%'";
			String sql = "select COUNT(*) from [dbo].[SanPham] join [dbo].[LoaiSanPham] on [dbo].[SanPham].maLoai = [dbo].[LoaiSanPham].maLoai where tenSP like N'%"+tenSanPham+"%'and nhanHieu like N'%"+nhanHieu+"%' and tenLoai like N'%"+loaiSanPham+"%' and maSP like '%"+maSanPham+"%' and kichThuoc like N'"+kichThuoc+"%' and chatLieu like N'%"+chatLieu+"%'and trangThaiKD = '"+trangThai+"'";

			String tongHang = session.createNativeQuery(sql).uniqueResult().toString();
			System.out.println(tongHang);
			int n = Integer.parseInt(tongHang);
			tr.commit();
			return n;
		} catch (Exception e) {
			// TODO: handle exception
		}
		session.close();
		return 0;
	}

	@Override
	public boolean update(SanPham sanPham) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			
			tr.begin();
			session.update(sanPham);			
			tr.commit();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
		
	}

	@Override
	public boolean capNhatTrangThaiKD(String id, boolean trangThai) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			
			tr.begin();
			SanPham sanPham = session.find(SanPham.class, id);
			sanPham.setTrangThaiKD(trangThai);
			session.update(sanPham);
			tr.commit();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getKichThuoc() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			
			tr.begin();
			String sql="select distinct kichThuoc from [dbo].[SanPham]";
			List<String> list = session.createNativeQuery(sql).getResultList();
			
			tr.commit();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
			e.printStackTrace();
		}
		session.close();
		return null;
	}

	@Override
	public List<SanPham> danhSachSanPhamBanChay(int page, int instance) {
		int offset = page*instance;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			
			String sql = "select [dbo].[CT_HoaDon].maSP, count([dbo].[CT_HoaDon].maSP) as soLanLapHD\r\n"
					+ "from [dbo].[SanPham] join [dbo].[CT_HoaDon] on [dbo].[SanPham].maSP = [dbo].[CT_HoaDon].maSP\r\n"
					+ "where [dbo].[SanPham].[trangThaiKD] = 'true'\r\n"
					+ "group by [dbo].[CT_HoaDon].maSP\r\n"
					+ "order by soLanLapHD desc\r\n"
					+ "offset "+offset+" rows fetch next "+instance+" rows only";
			List<?> list = session.createNativeQuery(sql).getResultList();
			List<SanPham> dsSanPham = new ArrayList<SanPham>();
			for (Object object : list) {
				Object [] o = (Object[]) object;
				String maSP = (String) o[0];
				SanPham sanPham = session.find(SanPham.class, maSP);
				System.out.println(sanPham);
				dsSanPham.add(sanPham);
			}
			tr.commit();
			return dsSanPham;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		session.close();
		return null;
	}

	@Override
	public boolean capNhatSoLuong(String maSP, int soLuongThem) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			
			tr.begin();
			SanPham sanPham = session.find(SanPham.class,maSP);
			int soLuongBanDau = sanPham.getSoLuong();
			sanPham.setSoLuong(soLuongBanDau-soLuongThem);
			session.update(sanPham);
			
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getDanhSachChatLieu() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			
			tr.begin();
			String sql="select distinct chatLieu from [dbo].[SanPham]";
			List<String> list = session.createNativeQuery(sql).getResultList();
			
			tr.commit();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
			e.printStackTrace();
		}
		session.close();
		return null;
	}

	@Override
	public List<SanPham> getAllSanPham(String tenSanPham, String nhanHieu, String maSanPham, String loaiSanPham,
			String kichThuoc, String chatLieu) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			String sql = "select * from [dbo].[SanPham] join [dbo].[LoaiSanPham] on [dbo].[SanPham].maLoai = [dbo].[LoaiSanPham].maLoai\r\n"
			+ "  where tenSP like N'%"+tenSanPham+"%'and nhanHieu like N'%"+nhanHieu+"%' and tenLoai like N'%"+loaiSanPham+"%' and maSP like '%"+maSanPham+"%'\r\n"
			+ "  order by [dbo].[SanPham].tenSP\r\n";
			
			List<SanPham> list = session.createNativeQuery(sql, SanPham.class).getResultList();
			
			tr.commit();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
			e.printStackTrace();
		}
		session.close();
		return null;
		
	}

	@Override
	public List<SanPham> getAllSanPhamCoTrangThai(String tenSanPham, String nhanHieu, String maSanPham,
			String loaiSanPham, String kichThuoc, String chatLieu, boolean trangThai) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			String sql = "select * from [dbo].[SanPham] join [dbo].[LoaiSanPham] on [dbo].[SanPham].maLoai = [dbo].[LoaiSanPham].maLoai\r\n"
			+ "  where tenSP like N'%"+tenSanPham+"%'and nhanHieu like N'%"+nhanHieu+"%' and tenLoai like N'%"+loaiSanPham+"%' and trangThaiKD = '"+trangThai+"' and maSP like '%"+maSanPham+"%'\r\n"
			+ "  order by [dbo].[SanPham].tenSP\r\n";
			
			List<SanPham> list = session.createNativeQuery(sql, SanPham.class).getResultList();
			
			tr.commit();
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
			e.printStackTrace();
		}
		session.close();
		return null;
	}

	@Override
	public List<SanPham> getSanPhamSapHetSoLuong() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		List<SanPham> list;
		String sql = "SELECT * FROM SanPham WHERE soLuong<10";
		try {
			tr.begin();
			list = session.createNativeQuery(sql,SanPham.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			tr.rollback();
			return null;
		}
	}

	@Override
	public int tinhTongHangBanChay() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		String sql = "select Count(*) \r\n"
				+ "from [dbo].[SanPham] join [dbo].[CT_HoaDon] on [dbo].[SanPham].maSP = [dbo].[CT_HoaDon].maSP\r\n"
				+ "where [dbo].[SanPham].[trangThaiKD] = 'true'\r\n"
				+ "group by [dbo].[CT_HoaDon].maSP";
		try {
			tr.begin();
			List<?> list = session.createNativeQuery(sql).getResultList();
			tr.commit();
			return list.size();
		} catch (Exception e) {
			tr.rollback();
			return 0;
		}
	}

	@Override
	public boolean them(SanPham sanPham) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(sanPham);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}

	@Override
	public String getMaSanPhamCuoi() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		String maSP;
		String sql = "select top 1 maSP from SanPham order by maSP desc";
		try {
			tr.begin();
			maSP = (String) session.createNativeQuery(sql).getSingleResult();
			tr.commit();
			return maSP;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteSanPham(SanPham sanPham) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.remove(sanPham);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Map<SanPham,Integer> getSanPhamBanChay(int ngay, int thang, int nam, int top) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		String topString = "";
		if (top!=-1)
			topString = " TOP " + top + " ";
		String ngayString = "";
		if (ngay!=-1)
			ngayString = String.format("%02d", ngay);
		String thangString = "";
		if (thang!=-1)
			thangString = String.format("%02d", thang);
		String namString = "";
		System.out.println(nam);
		if (nam!=-1)
			namString = String.format("%04d", nam);
		
		String sql = "SELECT "+topString+" OD.maSP, SUM(OD.soLuong) AS soLuong\r\n"
				+ "FROM CT_HoaDon OD JOIN HoaDon O ON OD.maHD = O.maHD\r\n"
				+ "WHERE DAY(ngayLapHD) like '"+ngayString+"%' AND MONTH(ngayLapHD) like '"+thangString+"%' AND YEAR(ngayLapHD) like '"+namString+"%'\r\n"
				+ "GROUP BY maSP\r\n"
				+ "ORDER BY soLuong desc";
		Map<SanPham, Integer> map = new LinkedHashMap<>();
		try {
			tr.begin();
			List<?> list  = session.createNativeQuery(sql).getResultList();
			list.forEach(l->{
				Object[] o = (Object[]) l;
				int soLuong = (int) o[1];
				String id = (String) o[0];
				SanPham sp = session.find(SanPham.class,id);
				map.put(sp,soLuong);
			});
			tr.commit();
			return map;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return null;
		}
	}



}
