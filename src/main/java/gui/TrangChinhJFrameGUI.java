package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import dao.Ipml.NhanVienImpl;
import entity.NhanVien;
import util.HibernateUtil;

public class TrangChinhJFrameGUI extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7517101561472047735L;
	private JPanel contentPane;
	private JMenu mnHeThong;
	private JMenuItem mntmHeThong_TaiKhoan;
	private JMenu mnSanPham;
	private JMenu mnKhachHang;
	private JMenu mnHoaDon;
	private JMenu mnNhanVien;
	private JMenuItem mntmKhachHang_Them;
	private JMenuItem mntmSanPham_TraCuu;
	private JMenuItem mntmSanPham_CapNhat;
	private JMenuItem mntmSanPham_ThongKeHetSoLuong;
	private JMenuItem mntmKhachHang_TraCuu;
	private JMenuItem mntmKhachHang_CapNhat;
	private JMenuItem mntmHoaDon_ThongKe;
	private JMenuItem mntmHoaDon_TraCuu;
	private JMenuItem mntmNhanVien_Them;
	private JMenuItem mntmNhanVien_TraCuu;
	private JPanel panelBody;
	private JMenuItem mntmNhanVien_CapNhat;
	private JButton btnToolbarQuayLai;
	private JButton btnToolbarThemKhachHang;
	private JButton btnToolbarLapHocDon;
	private JMenuItem mntmHoaDon_Them;
	public NhanVien nhanVien;
	private JMenuItem mntmHethong_DangXuat;
	private JMenuItem mntmHeThong_TroGiup;
	private JMenu mnSanPham_Them;
	private JMenuItem mntmSanPham_ThemMot;
	private JMenuItem mntmSanPham_ThemNhieu;
	private JMenuItem mntmSanPham_ThongKeBanChay;
	private JMenu mnNewMenu;
	
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TrangChinhJFrameGUI(NhanVien nhanVien) {
		setBackground(Color.WHITE);
		new NhanVienImpl();
		HibernateUtil.getIntance();
		this.nhanVien = nhanVien;
		
		setTitle("NPK FASHION");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TrangChinhJFrameGUI.class.getResource("/img/shops.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(-5,0, 1380, 735);
		setLocationRelativeTo(null);
		setResizable(false);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(Color.WHITE);
		menuBar.setFont(new Font("Arial", Font.PLAIN, 16));
		setJMenuBar(menuBar);
		
		mnHeThong = new JMenu("Hệ thống    ");
		mnHeThong.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/setting24px.png")));
		mnHeThong.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnHeThong);
		
		mntmHeThong_TaiKhoan = new JMenuItem("T\u00E0i kho\u1EA3n");
		mntmHeThong_TaiKhoan.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/account.png")));
		mntmHeThong_TaiKhoan.setFont(new Font("Arial", Font.PLAIN, 16));
		mnHeThong.add(mntmHeThong_TaiKhoan);
		
		mntmHeThong_TroGiup = new JMenuItem("Tr\u1EE3 gi\u00FAp");
		mntmHeThong_TroGiup.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/Help.png")));
		mntmHeThong_TroGiup.setFont(new Font("Arial", Font.PLAIN, 16));
		mnHeThong.add(mntmHeThong_TroGiup);
		
		JSeparator separator = new JSeparator();
		mnHeThong.add(separator);
		
		mntmHethong_DangXuat = new JMenuItem("\u0110\u0103ng xu\u1EA5t");
		mntmHethong_DangXuat.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/dangxuat.png")));
		mntmHethong_DangXuat.setFont(new Font("Arial", Font.PLAIN, 16));
		mnHeThong.add(mntmHethong_DangXuat);
		
		mnSanPham = new JMenu("Sản phẩm    ");
		mnSanPham.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/sanpham24px.png")));
		mnSanPham.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnSanPham);
		
		mntmSanPham_TraCuu = new JMenuItem("Tra cứu");
		mntmSanPham_TraCuu.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/Search.png")));
		mntmSanPham_TraCuu.setFont(new Font("Arial", Font.PLAIN, 16));
		mnSanPham.add(mntmSanPham_TraCuu);
		
		mntmSanPham_CapNhat = new JMenuItem("C\u1EADp nh\u1EADt");
		mntmSanPham_CapNhat.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/update.png")));
		mntmSanPham_CapNhat.setFont(new Font("Arial", Font.PLAIN, 16));
		mnSanPham.add(mntmSanPham_CapNhat);
		
		mnSanPham_Them = new JMenu("Thêm");
		mnSanPham_Them.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/them.png")));
		mnSanPham_Them.setFont(new Font("Arial", Font.PLAIN, 16));
		mnSanPham.add(mnSanPham_Them);
		
		mntmSanPham_ThemMot = new JMenuItem("Một sản phẩm");
		mntmSanPham_ThemMot.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/Add-one-icon.png")));
		mntmSanPham_ThemMot.setFont(new Font("Arial", Font.PLAIN, 16));
		mnSanPham_Them.add(mntmSanPham_ThemMot);
		
		mntmSanPham_ThemNhieu = new JMenuItem("Nhiều sản phẩm");
		mntmSanPham_ThemNhieu.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/Folder-Add-icon.png")));
		mntmSanPham_ThemNhieu.setFont(new Font("Arial", Font.PLAIN, 16));
		mnSanPham_Them.add(mntmSanPham_ThemNhieu);
		
		mnNewMenu = new JMenu("Thống kê");
		mnNewMenu.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/thongke.png")));
		mnNewMenu.setFont(new Font("Arial", Font.PLAIN, 16));
		mnSanPham.add(mnNewMenu);
		
		mntmSanPham_ThongKeHetSoLuong = new JMenuItem("Sản phẩm sắp hết ");
		mnNewMenu.add(mntmSanPham_ThongKeHetSoLuong);
		mntmSanPham_ThongKeHetSoLuong.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/icons8-out-of-stock-24.png")));
		mntmSanPham_ThongKeHetSoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
		
		mntmSanPham_ThongKeBanChay = new JMenuItem("Sản phẩm bán chạy");
		mntmSanPham_ThongKeBanChay.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/hot.png")));
		mntmSanPham_ThongKeBanChay.setFont(new Font("Arial", Font.PLAIN, 16));
		mnNewMenu.add(mntmSanPham_ThongKeBanChay);
		mntmSanPham_ThongKeHetSoLuong.addActionListener(this);
		
		mnKhachHang = new JMenu("Khách hàng    ");
		mnKhachHang.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/customer24px.png")));
		mnKhachHang.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnKhachHang);
		
		mntmKhachHang_Them = new JMenuItem("Th\u00EAm");
		mntmKhachHang_Them.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/them.png")));
		mntmKhachHang_Them.setFont(new Font("Arial", Font.PLAIN, 16));
		mnKhachHang.add(mntmKhachHang_Them);
		
		mntmKhachHang_TraCuu = new JMenuItem("Tra cứu");
		mntmKhachHang_TraCuu.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/Search.png")));
		mntmKhachHang_TraCuu.setFont(new Font("Arial", Font.PLAIN, 16));
		mnKhachHang.add(mntmKhachHang_TraCuu);
		
		mntmKhachHang_CapNhat = new JMenuItem("C\u1EADp nh\u1EADt");
		mntmKhachHang_CapNhat.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/update.png")));
		mntmKhachHang_CapNhat.setFont(new Font("Arial", Font.PLAIN, 16));
		mnKhachHang.add(mntmKhachHang_CapNhat);
		
		mnHoaDon = new JMenu("Hóa đơn    ");
		mnHoaDon.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/bill24px.png")));
		mnHoaDon.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnHoaDon);
		
		mntmHoaDon_Them = new JMenuItem("Th\u00EAm");
		mntmHoaDon_Them.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/them.png")));
		mntmHoaDon_Them.setFont(new Font("Arial", Font.PLAIN, 16));
		mnHoaDon.add(mntmHoaDon_Them);
		
		mntmHoaDon_TraCuu = new JMenuItem("Tra cứu");
		mntmHoaDon_TraCuu.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/Search.png")));
		mntmHoaDon_TraCuu.setFont(new Font("Arial", Font.PLAIN, 16));
		mnHoaDon.add(mntmHoaDon_TraCuu);
		
		mntmHoaDon_ThongKe = new JMenuItem("Th\u1ED1ng k\u00EA");
		mntmHoaDon_ThongKe.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/thongke.png")));
		mntmHoaDon_ThongKe.setFont(new Font("Arial", Font.PLAIN, 16));
		mnHoaDon.add(mntmHoaDon_ThongKe);
		
		mnNhanVien = new JMenu("Nhân viên   ");
		mnNhanVien.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/staff24px.png")));
		mnNhanVien.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnNhanVien);
		
		mntmNhanVien_Them = new JMenuItem("Th\u00EAm");
		mntmNhanVien_Them.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/them.png")));
		mntmNhanVien_Them.setFont(new Font("Arial", Font.PLAIN, 16));
		mnNhanVien.add(mntmNhanVien_Them);
		
		mntmNhanVien_TraCuu = new JMenuItem("Tra cứu");
		mntmNhanVien_TraCuu.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/Search.png")));
		mntmNhanVien_TraCuu.setFont(new Font("Arial", Font.PLAIN, 16));
		mnNhanVien.add(mntmNhanVien_TraCuu);
		
		mntmNhanVien_CapNhat = new JMenuItem("C\u1EADp nh\u1EADt");
		mntmNhanVien_CapNhat.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/update.png")));
		mntmNhanVien_CapNhat.setFont(new Font("Arial", Font.PLAIN, 16));
		mnNhanVien.add(mntmNhanVien_CapNhat);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.RED, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(new LineBorder(Color.GRAY));
		toolBar.setBounds(0, 0, 1364, 50);
		contentPane.add(toolBar);
		
		btnToolbarQuayLai = new JButton("Quay lại (F1)");
		btnToolbarQuayLai.setFont(new Font("Arial", Font.BOLD, 12));
		btnToolbarQuayLai.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/back.png")));
		btnToolbarQuayLai.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnToolbarQuayLai.setHorizontalTextPosition(SwingConstants.CENTER);
		clickOnKey(btnToolbarQuayLai, "Quay lại",KeyEvent.VK_F1);
		toolBar.add(btnToolbarQuayLai);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setMaximumSize(new Dimension(4, 4));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_1);
		
		btnToolbarThemKhachHang = new JButton("Thêm khách hàng (F2)");
		btnToolbarThemKhachHang.setFont(new Font("Arial", Font.BOLD, 12));
		btnToolbarThemKhachHang.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/addCustomer.png")));
		btnToolbarThemKhachHang.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnToolbarThemKhachHang.setHorizontalTextPosition(SwingConstants.CENTER);
		clickOnKey(btnToolbarThemKhachHang,"Thêm khách hàng", KeyEvent.VK_F2);
		toolBar.add(btnToolbarThemKhachHang);
		
		btnToolbarLapHocDon = new JButton("Lập hóa đơn (F3)");
		btnToolbarLapHocDon.setFont(new Font("Arial", Font.BOLD, 12));
		btnToolbarLapHocDon.setIcon(new ImageIcon(TrangChinhJFrameGUI.class.getResource("/img/addBill.png")));
		btnToolbarLapHocDon.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnToolbarLapHocDon.setHorizontalTextPosition(SwingConstants.CENTER);
		clickOnKey(btnToolbarLapHocDon,"Lập hóa đơn", KeyEvent.VK_F3);
		toolBar.add(btnToolbarLapHocDon);
		
		panelBody = new JPanel();
		panelBody.setBounds(0, 50, 1364, 621);
		panelBody.setLayout(null);
		contentPane.add(panelBody);
		mntmNhanVien_Them.addActionListener(this);
		mntmNhanVien_CapNhat.addActionListener(this);
		mntmNhanVien_TraCuu.addActionListener(this);
		btnToolbarQuayLai.addActionListener(this);
		mntmHoaDon_ThongKe.addActionListener(this);
		mntmHoaDon_TraCuu.addActionListener(this);
		mntmKhachHang_TraCuu.addActionListener(this);
		mntmKhachHang_Them.addActionListener(this);
		btnToolbarLapHocDon.addActionListener(this);
		btnToolbarThemKhachHang.addActionListener(this);
		
		mntmHoaDon_Them.addActionListener(this);
		mntmSanPham_TraCuu.addActionListener(this);
		mntmSanPham_CapNhat.addActionListener(this);
		mntmKhachHang_CapNhat.addActionListener(this);
		
		mntmHethong_DangXuat.addActionListener(this);
		mntmHeThong_TaiKhoan.addActionListener(this);
		mntmHeThong_TroGiup.addActionListener(this);
		mntmSanPham_ThemMot.addActionListener(this);
		mntmSanPham_ThemNhieu.addActionListener(this);
		mntmSanPham_ThongKeBanChay.addActionListener(this);
		mntmSanPham_ThongKeHetSoLuong.addActionListener(this);
		

		TrangChuPnGUI trangChuPn = new TrangChuPnGUI(nhanVien);
		trangChuPn.setBounds(0, 0, 1364, 621);
		panelBody.add(trangChuPn);
		
		if (!nhanVien.isChucVu()) {
			mnNhanVien.setVisible(false);
			mntmSanPham_ThongKeBanChay.setVisible(false);
		}
	}
	
	public static void clickOnKey(final AbstractButton button, String actionName, int key) {
		button.getInputMap(JButton.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key, 0), actionName);
		button.getActionMap().put(actionName, new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				button.doClick();
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		
		Object o =  e.getSource();
		
		if (o ==  btnToolbarQuayLai) {
			TrangChuPnGUI trangChuPn = new TrangChuPnGUI(nhanVien);
			trangChuPn.setBounds(0, 0, 1364, 621);
			panelBody.removeAll();
			panelBody.add(trangChuPn);
			panelBody.updateUI();
		}
		
		if (o == btnToolbarLapHocDon) {
			LapHoaDonPnGUI lapHoaDonPnGUI = new LapHoaDonPnGUI(nhanVien);
			lapHoaDonPnGUI.setBounds(0,0, 1364, 621);
			panelBody.removeAll();
			panelBody.add(lapHoaDonPnGUI);
			panelBody.updateUI();
		}
		
		if (o == mntmNhanVien_Them) {
			ThemNhanVienPnGUI themNhanVienPn =  new ThemNhanVienPnGUI();
			themNhanVienPn.setBounds(0,0, 1364, 621);
			panelBody.removeAll();
			panelBody.add(themNhanVienPn);
			panelBody.updateUI();
		}
		
		if (o == mntmNhanVien_CapNhat) {
			CapNhatNhanVienPnGUI capNhatNhanVienPn = new CapNhatNhanVienPnGUI();
			capNhatNhanVienPn.setBounds(0,0, 1364, 621);
			panelBody.removeAll();
			panelBody.add(capNhatNhanVienPn);
			panelBody.updateUI();
		}
		
		if (o == mntmNhanVien_TraCuu) {
			TraCuuNhanVienPnGUI traCuuNhanVienPn = new TraCuuNhanVienPnGUI();
			traCuuNhanVienPn.setBounds(0,0, 1364, 621);
			panelBody.removeAll();
			panelBody.add(traCuuNhanVienPn);
			panelBody.updateUI();
		}
		
		if (o == mntmHoaDon_ThongKe) {
			if(nhanVien.isChucVu()) {
				ThongKeHoaDonPnGUI thongKeHoaDonPnGUI = new ThongKeHoaDonPnGUI();
				thongKeHoaDonPnGUI.setBounds(0,0, 1364, 621);
				panelBody.removeAll();
				panelBody.add(thongKeHoaDonPnGUI);
				panelBody.updateUI();
			} else {
				ThongKeHoaDonNhanVienPnGUI thongKeHoaDonNhanVienPnGUI = new ThongKeHoaDonNhanVienPnGUI(nhanVien);
				thongKeHoaDonNhanVienPnGUI.setBounds(0,0, 1364, 621);
				panelBody.removeAll();
				panelBody.add(thongKeHoaDonNhanVienPnGUI);
				panelBody.updateUI();
			}
			
			
		}
		
		if (o == mntmHoaDon_TraCuu) {
			TraCuuHoaDonPnGUI traCuuHoaDonPn = new TraCuuHoaDonPnGUI(nhanVien);
			traCuuHoaDonPn.setBounds(0,0, 1364, 621);
			panelBody.removeAll();
			panelBody.add(traCuuHoaDonPn);
			panelBody.updateUI();
		}
		
		if (o == mntmKhachHang_TraCuu) {
			TraCuuKhachHangPnGUI traCuuKhachHangPn = new TraCuuKhachHangPnGUI();
			traCuuKhachHangPn.setBounds(0,0, 1364, 621);
			panelBody.removeAll();
			panelBody.add(traCuuKhachHangPn);
			panelBody.updateUI();
		}
		
		if (o == mntmSanPham_ThemMot) {
			ThemMotSanPhamPnGUI themMotSanPhamPnGUI = new ThemMotSanPhamPnGUI();
			themMotSanPhamPnGUI.setBounds(0,0, 1364, 621);
			panelBody.removeAll();
			panelBody.add(themMotSanPhamPnGUI);
			panelBody.updateUI();
		}
		
		if (o == mntmSanPham_ThemNhieu) {
			ThemNhieuSanPhamPnGUI themNhieuSanPhamPnGUI  = new ThemNhieuSanPhamPnGUI();
			themNhieuSanPhamPnGUI.setBounds(0,0, 1364, 621);
			panelBody.removeAll();
			panelBody.add(themNhieuSanPhamPnGUI);
			panelBody.updateUI();
		}
		
		if (o == mntmSanPham_CapNhat) {
			CapNhatSanPhamPnGUI capNhatSanPhamPnGUI = new CapNhatSanPhamPnGUI();
			capNhatSanPhamPnGUI.setBounds(0,0, 1364, 621);
			panelBody.removeAll();
			panelBody.add(capNhatSanPhamPnGUI);
			panelBody.updateUI();
		}
		
		if (o == mntmSanPham_TraCuu) {
			TraCuuSanPhamPnGUI timKiemSanPhamPnGUI = new TraCuuSanPhamPnGUI();
			timKiemSanPhamPnGUI.setBounds(0,0, 1364, 621);
			panelBody.removeAll();
			panelBody.add(timKiemSanPhamPnGUI);
			panelBody.updateUI();
		}
		
		if (o == mntmSanPham_ThongKeHetSoLuong) {
			ThongKeSanPhamSapHetSoLuongPnGUI capNhatSanPhamPnGUI = new ThongKeSanPhamSapHetSoLuongPnGUI();
			capNhatSanPhamPnGUI.setBounds(0,0, 1364, 621);
			panelBody.removeAll();
			panelBody.add(capNhatSanPhamPnGUI);
			panelBody.updateUI();
		}
		
		if (o == mntmSanPham_ThongKeBanChay) {
			ThongKeSanPhamBanChayPnGUI thongKeSanPhamBanChayPnGUI = new ThongKeSanPhamBanChayPnGUI();
			thongKeSanPhamBanChayPnGUI.setBounds(0,0, 1364, 621);
			panelBody.removeAll();
			panelBody.add(thongKeSanPhamBanChayPnGUI);
			panelBody.updateUI();
		}
		
		if (o == mntmHoaDon_Them) {
			LapHoaDonPnGUI lapHoaDonPnGUI = new LapHoaDonPnGUI(nhanVien);
			lapHoaDonPnGUI.setBounds(0,0, 1364, 621);
			panelBody.removeAll();
			panelBody.add(lapHoaDonPnGUI);
			panelBody.updateUI();
		}
		
		if (o == mntmKhachHang_CapNhat) {
			CapNhatKhachHangPnGUI capNhatKhachHangPnGUI = new CapNhatKhachHangPnGUI();
			capNhatKhachHangPnGUI.setBounds(0,0, 1364, 621);
			panelBody.removeAll();
			panelBody.add(capNhatKhachHangPnGUI);
			panelBody.updateUI();
		}
		
		if (o == mntmKhachHang_Them || o == btnToolbarThemKhachHang) {
			new ThemKhachHangJFrameGUI("").setVisible(true);
		}
		
		if (o == mntmHethong_DangXuat) {
			int opt = JOptionPane.showConfirmDialog(this,"Bạn muốn đăng xuất khỏi hệ thống?", "Cảnh báo",JOptionPane.YES_NO_OPTION);
			if (opt == JOptionPane.YES_OPTION) {
				dispose();
				DangNhapJFrameGUI dangNhapJFrameGUI = new DangNhapJFrameGUI();
				dangNhapJFrameGUI.setVisible(true);
			}
		}
		
		if(o == mntmHeThong_TaiKhoan) {
			TaiKhoanGUI taiKhoanGUI= new TaiKhoanGUI(nhanVien);
			taiKhoanGUI.setVisible(true);

		}
		
		if(o == mntmHeThong_TroGiup) {
			TroGiupJFrameGUI troGiupJFrameGUI= new TroGiupJFrameGUI();
			troGiupJFrameGUI.setBounds(0,0, 1364, 621);
			panelBody.removeAll();
			panelBody.add(troGiupJFrameGUI);
			panelBody.updateUI();

		}
	}
}
