package dao.Ipml;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.NhanVienDao;
import entity.NhanVien;
import util.HibernateUtil;

public class NhanVienImpl implements NhanVienDao {
	private SessionFactory sessionFactory;

	public NhanVienImpl() {
		// TODO Auto-generated constructor stub
		super();
		this.sessionFactory = HibernateUtil.getIntance().getSessionFactory();
	}

	public List<NhanVien> getAllNhanVien(){
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		List<NhanVien> listNhanVien;
		String sql = "select * from NhanVien";
		try {
			tr.begin();
			listNhanVien = session.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			return listNhanVien;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return null;
		}
	}

	public List<NhanVien> findNhanVien(String maNV, String tenNV, String sdt) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		List<NhanVien> listNhanVien;
		String sql = "select * from NhanVien where maNV like N'%" + maNV + "%' and hoTen like N'%" + tenNV
				+ "%' and sdt like N'%" + sdt + "%'";
		try {
			tr.begin();
			listNhanVien = session.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			return listNhanVien;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return null;
		}
	}

	public NhanVien getNhanVien(String maNV, String tenNV, String sdt) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		NhanVien nv = new NhanVien();
		String sql = "select * from NhanVien where maNV like N'%" + maNV + "%' and hoTen like N'%" + tenNV
				+ "%' and sdt like N'%" + sdt + "%'";
		try {
			tr.begin();
			nv = session.createNativeQuery(sql, NhanVien.class).getSingleResult();
			tr.commit();
			return nv;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return null;
		}
	}

	public boolean themNhanVien(NhanVien nv) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(nv);
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			// TODO: handle exception
		}
		return false;
	}

	public boolean suaNVTT(NhanVien nv) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			session.update(nv);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
			return false;
		}
	}

	@Override
	public String getNhanVienCuoiCung() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		String manv;
		String sql = "select top 1 maNV from NhanVien order by maNV desc";
		try {
			tr.begin();
			manv = (String) session.createNativeQuery(sql).getSingleResult();
			tr.commit();
			return manv;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public NhanVien getNhanVientheoMa(String maNV) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
//		NhanVien nv = new NhanVien();
//		String sql = "select * from NhanVien where maNV like N'%" + maNV + "%'";
		try {
			tr.begin();
//			nv = session.createNativeQuery(sql, NhanVien.class).getSingleResult();
			NhanVien nv = session.find(NhanVien.class, maNV);
			tr.commit();
			return nv;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<NhanVien> getAllNhanVienTheoGTvaTT(boolean gioiTinh, boolean trangThai) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		List<NhanVien> listNhanVien;
		String sql = "select * from NhanVien where gioiTinh = "+ gioiTinh + "and trangThai = "+ trangThai;
		try {
			tr.begin();
			listNhanVien = session.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			return listNhanVien;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return null;
		}
	}
	
	
	@Override
	public int TongNhanVien(String maNV, String tenNV, String sdt, String xa, String huyen, String tinh,
			int trangThai,int gioiTinh,String cmnd) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		int soNV;
		String sql = "SELECT COUNT(*) FROM NhanVien  JOIN [dbo].[DiaChi] ON [dbo].[NhanVien].maDiaChi = [dbo].[DiaChi].maDiaChi WHERE maNV like N'%" + maNV + "%'and hoTen like N'%" + tenNV + "%' and sdt like N'%" + sdt + "%' and phuongXa like N'%" + xa 
				+ "%' and quanHuyen like N'%" + huyen + "%' and tinhTP like N'%"+ tinh + "%' and trangThai =" + trangThai 
				+ " and gioiTinh =" + gioiTinh +" and cmnd like N'%"+cmnd+"%'";
		try {
			tr.begin();
			String tongNV = session.createNativeQuery(sql).uniqueResult().toString();
			soNV = Integer.parseInt(tongNV);
			tr.commit();
			return soNV;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return 0;
	}


	
	@Override
	public List<NhanVien> getNhanVienTheoPage(int page,String maNV, String tenNV, String sdt, String xa, String huyen, String tinh,
			int trangThai,int gioiTinh,String cmnd) {
		// TODO Auto-generated method stub
		int offset = page * 8;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		String sql = "SELECT * FROM [dbo].[NhanVien] JOIN [dbo].[DiaChi] ON [dbo].[NhanVien].maDiaChi = [dbo].[DiaChi].maDiaChi WHERE maNV like N'%" + maNV + "%'and hoTen like N'%" + tenNV + "%' and sdt like N'%" + sdt 
				+ "%' and phuongXa like N'%" + xa + "%' and quanHuyen like N'%" + huyen 
				+ "%' and tinhTP like N'%"+ tinh + "%' and trangThai =" + trangThai + " and gioiTinh =" + gioiTinh
				+" and cmnd like N'%"+cmnd+"%'  ORDER BY maNV desc  offset "+offset+" rows fetch next 8 rows only";
		try {
			tr.begin();
			List<NhanVien> listNV = session.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			return listNV;
			
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return null;
	}
	
	@Override
	public boolean kiemTraSoDienThoai(String sdt) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		String sql = "SELECT sdt from NhanVien\r\n"
					+ "WHERE sdt = '"+sdt+"'";
		try {
			tr.begin();
			Object o = session.createNativeQuery(sql).getSingleResult();
			tr.commit();
			if (o != null)
				return false;
		} catch (Exception e) {
			tr.rollback();
		}
		return true;
	}

	@Override
	public boolean kiemTraChungMinhNhanDan(String cmnd) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		String sql = "SELECT cmnd from NhanVien\r\n"
					+ "WHERE cmnd = '"+cmnd+"'";
		try {
			tr.begin();
			Object o = session.createNativeQuery(sql).getSingleResult();
			tr.commit();
			if (o != null)
				return false;
		} catch (Exception e) {
			tr.rollback();
		}
		return true;
	}



	@Override
	public int getTongSoHang(String ma, String ten, boolean trangThai) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		ten.replace(' ','%');
		String sql = "SELECT COUNT(*) FROM NhanVien\r\n"
					+ "WHERE chucVu = 0 AND  UPPER(maNV) LIKE '"+ma.toUpperCase()+"%' AND  UPPER(hoTen) LIKE N'%"+ten.toUpperCase()+"%' AND trangThai = " + (trangThai==true?1:0);
		try {
			tr.begin();
			String s = session.createNativeQuery(sql).uniqueResult().toString();
			int soHang = Integer.parseInt(s);
			tr.commit();
			return soHang;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return 0;
	}



	@Override
	public List<NhanVien> timKiemNhanVien(String ma, String ten, boolean trangThai,int page) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		ten.replace(' ','%');
		List<NhanVien> listNhanVien;
		String sql = "SELECT * FROM NhanVien\r\n"
					+ "WHERE chucVu = 0 AND  UPPER(maNV) LIKE '"+ma.toUpperCase()+"%' AND  UPPER(hoTen) LIKE N'%"+ten.toUpperCase()+"%' AND trangThai = "+(trangThai==true?1:0)+"\r\n"
					+ "ORDER BY maNV DESC\r\n"
					+ "OFFSET "+ (page-1)*6 +"\r\n"
					+ "ROWS FETCH NEXT 6 ROWS ONLY";
		try {
			tr.begin();
			listNhanVien = session.createNativeQuery(sql,NhanVien.class).getResultList();
			tr.commit();
			return listNhanVien;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean capNhatNhanVien(NhanVien nv) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			session.update(nv);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
			return false;
		}
	}

	@Override
	public NhanVien getNhanVien(String maNV, String matKhau) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		String sql = "select * from NhanVien where maNV = '" + maNV + "' and matKhau = '"+matKhau+"'";
		try {
			tr.begin();
			NhanVien nv = session.createNativeQuery(sql, NhanVien.class).getSingleResult();
			tr.commit();
			return nv;
		} catch (Exception e) {
			tr.rollback();
			return null;
		}
	}

	public List<NhanVien> timKiemNhanVienDaLapHoaDonTheoNgay(String ten, String ma,LocalDate date) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		ten = ten.toUpperCase();
		ma = ma.toUpperCase();
		ten = ten.replace(' ','%');
		String sql = "SELECT * FROM NhanVien N\r\n"
				+ "WHERE EXISTS (SELECT * FROM HoaDon Hd \r\n"
				+ "			  WHERE N.maNV = HD.maNV \r\n"
				+ "					and DAY(Hd.ngayLapHD) =  "+date.getDayOfMonth()+"\r\n"
				+ "					and MONTH(Hd.ngayLapHD) =  "+date.getMonthValue()+"\r\n"
				+ "					and YEAR(Hd.ngayLapHD) =  "+date.getYear()+"\r\n"
				+ "				)\r\n"
				+ "       AND trangThai =1 AND UPPER(hoTen) like N'%" + ten + "%' and UPPER(maNV) like N'" + ma + "%'";
		try {
			tr.begin();
			List<NhanVien> list = session.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return null;
		}
	}
	
	@Override
	public List<NhanVien> timKiemNhanVienDaLapHoaDonTheoThang(String ten, String ma, int thang, int nam) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		ten = ten.toUpperCase();
		ma = ma.toUpperCase();
		ten = ten.replace(' ','%');
		System.out.println(ten);
		String sql = "SELECT * FROM NhanVien N\r\n"
				+ "WHERE EXISTS (SELECT * FROM HoaDon Hd \r\n"
				+ "			  WHERE N.maNV = HD.maNV \r\n"
				+ "					and MONTH(Hd.ngayLapHD) =  "+thang+"\r\n"
				+ "					and YEAR(Hd.ngayLapHD) =  "+nam+"\r\n"
				+ "				)\r\n"
				+ "       AND trangThai =1 AND UPPER(hoTen) like N'%" + ten + "%' and UPPER(maNV) like N'" + ma + "%'";
		try {
			tr.begin();
			List<NhanVien> list = session.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return null;
		}
	}

	@Override
	public List<NhanVien> timKiemNhanVienDaLapHoaDonTheoNam(String ten, String ma, int nam) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		ten = ten.toUpperCase();
		ma = ma.toUpperCase();
		ten = ten.replace(' ','%');
		System.out.println(ten);
		String sql = "SELECT * FROM NhanVien N\r\n"
				+ "WHERE EXISTS (SELECT * FROM HoaDon Hd \r\n"
				+ "			  WHERE N.maNV = HD.maNV \r\n"
				+ "					and YEAR(Hd.ngayLapHD) =  "+nam+"\r\n"
				+ "				)\r\n"
				+ "       AND trangThai =1 AND UPPER(hoTen) like N'%" + ten + "%' and UPPER(maNV) like N'" + ma + "%'";
		try {
			tr.begin();
			List<NhanVien> list = session.createNativeQuery(sql, NhanVien.class).getResultList();
			tr.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
			return null;
		}
	}


}
