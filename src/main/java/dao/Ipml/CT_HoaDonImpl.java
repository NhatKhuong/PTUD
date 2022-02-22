package dao.Ipml;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.CT_HoaDonDao;
import entity.CT_HoaDon;
import util.HibernateUtil;

public class CT_HoaDonImpl implements CT_HoaDonDao{
	private SessionFactory sessionFactory;
	public CT_HoaDonImpl() {
		// TODO Auto-generated constructor stub
		this.sessionFactory = HibernateUtil.getIntance().getSessionFactory();
	}
		
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
	public boolean them(CT_HoaDon ct_HoaDon) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		try {
			
			tr.begin();
			session.save(ct_HoaDon);
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
