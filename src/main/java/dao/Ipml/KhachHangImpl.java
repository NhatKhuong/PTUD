package dao.Ipml;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.KhachHangDao;
import entity.KhachHang;
import util.HibernateUtil;

public class KhachHangImpl implements KhachHangDao {
	private SessionFactory sessionFactory;
	public KhachHangImpl() {
		// TODO Auto-generated constructor stub
		super();
		this.sessionFactory = HibernateUtil.getIntance().getSessionFactory();
	}

	@Override
	public String getKhachHangCuoiCung() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		String maKH;
		String sql = "select top 1 maKH from KhachHang order by maKH desc";
		try {
			tr.begin();
			maKH = (String) session.createNativeQuery(sql).getSingleResult();
			tr.commit();
			return maKH;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean themKhachHang(KhachHang kh) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.save(kh);
			tr.commit();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return false;
	}
	
	@Override
	public KhachHang getKhachHangById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			KhachHang khachHang = session.find(KhachHang.class, id);
			tr.commit();
			return khachHang;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}

	@Override
	public KhachHang getKhachHangByStd(String sdt) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			
			tr.begin();
			String sql = "  select * from [dbo].[KhachHang] where [sdt] like '"+sdt+"'";
			KhachHang khachHang = session.createNativeQuery(sql,KhachHang.class).getSingleResult();
			tr.commit();
			return khachHang;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	
	@Override
	public int TongKhachHang(String ma, String ten, String sdt, String xa, String huyen, String tinh, int gioiTinh) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		int soKH;
		String sql = "SELECT COUNT(*) FROM [dbo].[KhachHang] JOIN [dbo].[DiaChi] ON [dbo].[KhachHang].maDiaChi = [dbo].[DiaChi].maDiaChi WHERE maKH like N'%" + ma +  "%'and hoTen like N'%" + ten +  "%' and sdt like N'%" + sdt +  "%' and phuongXa like N'%" + xa +  "%' and quanHuyen like N'%" + huyen +  "%' and tinhTP like N'%"+ tinh + "%' and gioiTinh = " + gioiTinh;
		try {
			tr.begin();
			String tongKH = session.createNativeQuery(sql).uniqueResult().toString();
			soKH = Integer.parseInt(tongKH);
			tr.commit();
			return soKH;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return 0;
	}


	@Override
	public List<KhachHang> getKhachHangTheoPage(int page,String ma, String ten, String sdt, String xa, String huyen, String tinh, int gioiTinh) {
		// TODO Auto-generated method stub
		int offset = page * 10;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		String sql = "SELECT * FROM [dbo].[KhachHang] JOIN [dbo].[DiaChi] ON [dbo].[KhachHang].maDiaChi = [dbo].[DiaChi].maDiaChi WHERE maKH like N'%"+ma+"%'and hoTen like N'%"+ten 
				+"%' and sdt like N'%"+sdt+"%' and phuongXa like N'%"+xa
				+"%' and quanHuyen like N'%"+ huyen+"%' and tinhTP like N'%"+tinh 
				+"%' and gioiTinh ="+ gioiTinh+"  ORDER BY maKH DESC offset "+offset
				+" rows fetch next 10 rows only";
		try {
			tr.begin();
			List<KhachHang> listKH = session.createNativeQuery(sql, KhachHang.class).getResultList();
			tr.commit();
			return listKH;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		
		return null;
	}


	@Override
	public List<KhachHang> findKhachHang(String ma, String ten, String sdt, String xa, String huyen, String tinh,
			int gioiTinh) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		List<KhachHang> listKH;
		String sql = "SELECT * FROM [dbo].[KhachHang] JOIN [dbo].[DiaChi] ON [dbo].[KhachHang].maDiaChi = [dbo].[DiaChi].maDiaChi "
				+ "WHERE maKH like N'%" + ma + "%'and hoTen like N'%" + ten + "%' and sdt like N'%" + sdt
				+ "%' and phuongXa like N'%"+xa+"%' and quanHuyen like N'%"+huyen+"%' and tinhTP like N'%"
				+tinh+"%' and gioiTinh =" + gioiTinh;
		try {
			tr.begin();
			listKH = session.createNativeQuery(sql, KhachHang.class).getResultList();
			tr.commit();
			return listKH;
		}catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return null;
	}

	@Override
	public List<KhachHang> getKhachHangTheoPage_instance(int page, int instance, String ma, String ten) {
		int offset = page * instance;
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		String sql = "SELECT * FROM [dbo].[KhachHang] WHERE maKH like N'%"+ma+"%'and hoTen like N'%"+ten+"%' ORDER BY maKH DESC offset "+offset+" rows fetch next "+instance+" rows only";
		try {
			tr.begin();
			List<KhachHang> listKH = session.createNativeQuery(sql, KhachHang.class).getResultList();
			tr.commit();
			return listKH;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		
		return null;
	}

	@Override
	public int tongHangTimKiem(String ma, String ten) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		int soKH;
		String sql = "SELECT COUNT(*) FROM [dbo].[KhachHang]  WHERE maKH like N'%"+ma+"%' and hoTen like N'%"+ten+"%'";
		try {
			tr.begin();
			String tongKH = session.createNativeQuery(sql).uniqueResult().toString();
			soKH = Integer.parseInt(tongKH);
			tr.commit();
			return soKH;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
		}
		return 0;
	}

	@Override
	public boolean update(KhachHang khachHang) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.update(khachHang);
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
	}
	
}
