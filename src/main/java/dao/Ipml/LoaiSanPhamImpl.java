package dao.Ipml;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.LoaiSanPhamDao;
import entity.LoaiSanPham;
import util.HibernateUtil;

public class LoaiSanPhamImpl implements LoaiSanPhamDao{
	private SessionFactory sessionFactory;
	public LoaiSanPhamImpl() {
		// TODO Auto-generated constructor stub
		sessionFactory =  HibernateUtil.getIntance().getSessionFactory();
	}
	@Override
	public LoaiSanPham getLoaiSanPhamById(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
				LoaiSanPham loaiSanPham = session.find(LoaiSanPham.class,id);
			tr.commit();
			return loaiSanPham;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getDanhSachLoai() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		
		try {
			
			tr.begin();
			String sql="select distinct tenLoai from [dbo].[LoaiSanPham]";
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
	public LoaiSanPham getLoaiSanPhamByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String sql="select * from [dbo].[LoaiSanPham] where tenLoai like N'"+name+"'";
			LoaiSanPham loaiSanPham = session.createNativeQuery(sql, LoaiSanPham.class).getSingleResult();
			
			tr.commit();
			return loaiSanPham;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
			e.printStackTrace();
		}
		session.close();
		return null;
	}

	

}
