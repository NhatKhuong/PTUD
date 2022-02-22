package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import entity.CT_HoaDon;
import entity.DiaChi;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiSanPham;
import entity.NhanVien;
import entity.SanPham;

public class HibernateUtil {
	private SessionFactory sessionFactory;
	private static HibernateUtil instance = null;

	public HibernateUtil() {

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
												.configure()
												.build();
		Metadata meta = new MetadataSources(serviceRegistry)
							.addAnnotatedClass(DiaChi.class)
							.addAnnotatedClass(NhanVien.class)
							.addAnnotatedClass(KhachHang.class)
							.addAnnotatedClass(LoaiSanPham.class)
							.addAnnotatedClass(SanPham.class)
							.addAnnotatedClass(HoaDon.class)
							.addAnnotatedClass(CT_HoaDon.class)
							.getMetadataBuilder()
							.build();
		sessionFactory = meta.getSessionFactoryBuilder()
								.build();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static synchronized HibernateUtil getIntance() {
		if(instance == null) {
			instance = new HibernateUtil();
		}
		return instance;
	}
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
