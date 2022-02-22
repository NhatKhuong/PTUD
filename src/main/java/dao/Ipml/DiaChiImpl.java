package dao.Ipml;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.DiaChiDao;
import entity.DiaChi;
import util.HibernateUtil;

public class DiaChiImpl implements DiaChiDao {
	private SessionFactory sessionFactory;
	public DiaChiImpl() {
		super();
		this.sessionFactory = HibernateUtil.getIntance().getSessionFactory();
	}
	
	public List<DiaChi> getAllDC() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		List<DiaChi> listdiaChi;
		String sql = "select * from DiaChi";
		try {
			tr.begin();
			listdiaChi = session.createNativeQuery(sql, DiaChi.class).getResultList();
			tr.commit();
			return listdiaChi;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllTinhTP() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		List<String> tinhTP;
		String sql = "select tinhTP from DiaChi group by tinhTP";
		try {
			tr.begin();
			tinhTP = session.createNativeQuery(sql).getResultList();
			tr.commit();
			return tinhTP;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllHuyenTrongTinhTP(String tinh) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		List<String> huyen;
		String sql = "select quanHuyen from DiaChi where tinhTP like N'%"+tinh+"%' group by quanHuyen";;
		try {
			tr.begin();
			huyen = session.createNativeQuery(sql).getResultList();
			tr.commit();
			return huyen;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllPhuongXa(String tinh, String huyen) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		List<String> xa;
		String sql = "select phuongXa from DiaChi where tinhTP like N'%"+tinh+"%'and quanHuyen like  N'%"+huyen+"%'";
		try {
			tr.begin();
			xa = session.createNativeQuery(sql).getResultList();
			tr.commit();
			return xa;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DiaChi getDiaChi(String xa, String huyen, String tinh) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		DiaChi dc = new DiaChi();
		String sql = "select * from DiaChi where tinhTP like N'%"+tinh+"%'and quanHuyen like  N'%"+huyen+"%' and phuongXa like N'%"+xa+"%'";
		try {
			tr.begin();
			dc = session.createNativeQuery(sql,DiaChi.class).getSingleResult();
			tr.commit();
			return dc;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllPhuongXaTheoHuyen(String huyen) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		List<String> phuongXa;
		String sql = "select phuongXa from DiaChi where quanHuyen like N'%"+huyen+"%' group by phuongXa";;
		try {
			tr.begin();
			phuongXa = session.createNativeQuery(sql).getResultList();
			tr.commit();
			return phuongXa;
		} catch (Exception e) {
			// TODO: handle exception
			tr.rollback();
			e.printStackTrace();
		}
		return null;
	}



}
