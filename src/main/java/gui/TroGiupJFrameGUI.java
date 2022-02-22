package gui;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class TroGiupJFrameGUI extends JPanel implements ActionListener, ItemListener, MouseListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5319222167918230907L;
	private JButton btnSanPham;
	private JButton btnTraCuuSP;
	private JButton btnCapNhatSP;
	private JButton btnThongKeSP;
	private JButton btnKhachHang;
	private JButton btnThemKH;
	private JButton btnTraCuuKH;
	private JButton btnCapNhatKH;
	private JButton btnHoaDon;
	private JButton btnThemHD;
	private JButton btnTraCuuHD;
	private JButton btnThongKeHD;
	private JButton btnNhanVien;
	private JButton btnThemNV;
	private JButton btnTraCuuNV;
	private JButton btnCapNhatNV;
	private JPanel panelSanPham;
	private JPanel panelMenu;
	private JPanel panelKH;
	private JPanel panelHD;
	private JPanel panelNV;
	private JPanel panelXuLi;
	private JScrollPane scrollPane;
	private JEditorPane editorPane;

	public TroGiupJFrameGUI() {
		setBounds(0, 0, 1364, 621);
		setLayout(null);
		panelMenu = new JPanel();
		panelMenu.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelMenu.setBorder(new LineBorder(UIManager.getColor("CheckBox.focus")));
		panelMenu.setBounds(10, 11, 280, 599);
		add(panelMenu);
		panelMenu.setLayout(null);

		btnSanPham = new JButton("Sản phẩm");
		btnSanPham.setBounds(0, 43, 280, 35);
		btnSanPham.setFont(new Font("Arial", Font.BOLD, 16));
		btnSanPham.setBackground(SystemColor.textHighlight);
		panelMenu.add(btnSanPham);

		btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.setBounds(0, 79, 280, 35);
		btnKhachHang.setFont(new Font("Arial", Font.BOLD, 16));
		btnKhachHang.setBackground(SystemColor.textHighlight);
		panelMenu.add(btnKhachHang);

		btnHoaDon = new JButton("Hóa đơn");
//		btnHoaDon.setBounds(0, 322, 280, 35);
		btnHoaDon.setBounds(0, 114, 280, 35);
		btnHoaDon.setFont(new Font("Arial", Font.BOLD, 16));
		btnHoaDon.setBackground(SystemColor.textHighlight);
		panelMenu.add(btnHoaDon);

		btnNhanVien = new JButton("Nhân viên");
//		btnNhanVien.setBounds(0, 459, 280, 35);
		btnNhanVien.setBounds(0, 149, 280, 35);
		btnNhanVien.setFont(new Font("Arial", Font.BOLD, 16));
		btnNhanVien.setBackground(SystemColor.textHighlight);
		panelMenu.add(btnNhanVien);

		JLabel lblIconShop = new JLabel("");
		lblIconShop.setBounds(0, 0, 280, 44);
		lblIconShop.setIcon(new ImageIcon(TroGiupJFrameGUI.class.getResource("/img/logotrogiup.png")));
		lblIconShop.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenu.add(lblIconShop);

		panelSanPham = new JPanel();
		panelSanPham.setBounds(0, 77, 280, 108);
		panelSanPham.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelMenu.add(panelSanPham);
		panelSanPham.setLayout(null);

		btnTraCuuSP = new JButton("Tra cứu sản phẩm");
		btnTraCuuSP.setBounds(0, 0, 280, 35);
		panelSanPham.add(btnTraCuuSP);
		btnTraCuuSP.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTraCuuSP.setBackground(SystemColor.activeCaption);

		btnCapNhatSP = new JButton("Cập nhật sản phẩm");
		btnCapNhatSP.setBounds(0, 34, 280, 35);
		panelSanPham.add(btnCapNhatSP);
		btnCapNhatSP.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCapNhatSP.setBackground(SystemColor.activeCaption);

		btnThongKeSP = new JButton("Thống kê sản phẩm sắp hết ");
		btnThongKeSP.setBounds(0, 70, 280, 35);
		panelSanPham.add(btnThongKeSP);
		btnThongKeSP.setFont(new Font("Arial", Font.PLAIN, 14));
		btnThongKeSP.setBackground(SystemColor.activeCaption);

		panelKH = new JPanel();
		panelKH.setBounds(0, 218, 280, 108);
		panelKH.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelMenu.add(panelKH);
		panelKH.setLayout(null);

		btnThemKH = new JButton("Thêm khách hàng");
		btnThemKH.setBounds(0, 0, 280, 35);
		panelKH.add(btnThemKH);
		btnThemKH.setFont(new Font("Arial", Font.PLAIN, 14));
		btnThemKH.setBackground(SystemColor.activeCaption);

		btnTraCuuKH = new JButton("Tra cứu khách hàng");
		btnTraCuuKH.setBounds(0, 35, 280, 35);
		panelKH.add(btnTraCuuKH);
		btnTraCuuKH.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTraCuuKH.setBackground(SystemColor.activeCaption);

		btnCapNhatKH = new JButton("Cập nhật khách hàng");
		btnCapNhatKH.setBounds(0, 70, 280, 35);
		panelKH.add(btnCapNhatKH);
		btnCapNhatKH.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCapNhatKH.setBackground(SystemColor.activeCaption);

		panelHD = new JPanel();
		panelHD.setBounds(0, 355, 280, 108);
		panelHD.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelMenu.add(panelHD);
		panelHD.setLayout(null);

		btnThemHD = new JButton("Thêm hóa đơn");
		btnThemHD.setBounds(0, 0, 280, 35);
		panelHD.add(btnThemHD);
		btnThemHD.setFont(new Font("Arial", Font.PLAIN, 14));
		btnThemHD.setBackground(SystemColor.activeCaption);

		btnTraCuuHD = new JButton("Tra cứu hóa đơn");
		btnTraCuuHD.setBounds(0, 34, 280, 35);
		panelHD.add(btnTraCuuHD);
		btnTraCuuHD.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTraCuuHD.setBackground(SystemColor.activeCaption);

		btnThongKeHD = new JButton("Thống kê hóa đơn");
		btnThongKeHD.setBounds(0, 69, 280, 35);
		panelHD.add(btnThongKeHD);
		btnThongKeHD.setFont(new Font("Arial", Font.PLAIN, 14));
		btnThongKeHD.setBackground(SystemColor.activeCaption);

		panelNV = new JPanel();
		panelNV.setBounds(0, 494, 280, 105);
		panelNV.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		panelMenu.add(panelNV);
		panelNV.setLayout(null);

		btnThemNV = new JButton("Thêm nhân viên");
		btnThemNV.setBounds(0, 0, 280, 35);
		panelNV.add(btnThemNV);
		btnThemNV.setFont(new Font("Arial", Font.PLAIN, 14));
		btnThemNV.setBackground(SystemColor.activeCaption);

		btnTraCuuNV = new JButton("Tra cứu nhân viên");
		btnTraCuuNV.setBounds(0, 35, 280, 35);
		panelNV.add(btnTraCuuNV);
		btnTraCuuNV.setFont(new Font("Arial", Font.PLAIN, 14));
		btnTraCuuNV.setBackground(SystemColor.activeCaption);

		btnCapNhatNV = new JButton("Cập nhật trạng thái nhân viên ");
		btnCapNhatNV.setBounds(0, 71, 280, 35);
		panelNV.add(btnCapNhatNV);
		btnCapNhatNV.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCapNhatNV.setBackground(SystemColor.activeCaption);
		panelKH.setVisible(false);
		panelHD.setVisible(false);
		panelNV.setVisible(false);

		panelSanPham.setVisible(false);
		btnNhanVien.addMouseListener(this);
		btnKhachHang.addMouseListener(this);
		btnHoaDon.addMouseListener(this);
		btnSanPham.addMouseListener(this);
		btnCapNhatNV.addMouseListener(this);
		btnThemNV.addMouseListener(this);
		btnTraCuuNV.addMouseListener(this);
		btnCapNhatSP.addMouseListener(this);
		btnThongKeSP.addMouseListener(this);
		btnTraCuuSP.addMouseListener(this);
		btnCapNhatKH.addMouseListener(this);
		btnThemKH.addMouseListener(this);
		btnTraCuuKH.addMouseListener(this);
		btnThemHD.addMouseListener(this);
		btnThongKeHD.addMouseListener(this);
		btnTraCuuHD.addMouseListener(this);
		
		panelXuLi = new JPanel();
		panelXuLi.setBounds(300, 11, 1054, 599);
		add(panelXuLi);
		panelXuLi.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1054, 599);
		panelXuLi.add(scrollPane);
		
		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		scrollPane.setViewportView(editorPane);
		editorPane.setContentType("text/html");
	}

	public void hideMenu() {
		if (panelHD.isVisible() == true) {
			panelHD.setVisible(false);
		}
		if (panelKH.isVisible() == true) {
			panelKH.setVisible(false);
		}
		if (panelNV.isVisible() == true) {
			panelNV.setVisible(false);
		}
		if (panelSanPham.isVisible() == true) {
			panelSanPham.setVisible(false);
		}
	}

	public void showMenu(JPanel subMenu) {
		if (subMenu.isVisible() == false) {
			hideMenu();
			subMenu.setVisible(true);
		} else {
			if (subMenu.equals(panelSanPham)) {
				btnKhachHang.setBounds(0, 79, 280, 35);
				btnHoaDon.setBounds(0, 114, 280, 35);
				btnNhanVien.setBounds(0, 149, 280, 35);
			}
			if (subMenu.equals(panelKH)) {
				btnKhachHang.setBounds(0, 79, 280, 35);
				btnHoaDon.setBounds(0, 114, 280, 35);
				btnNhanVien.setBounds(0, 149, 280, 35);
			}
			if (subMenu.equals(panelHD)) {
				btnKhachHang.setBounds(0, 79, 280, 35);
				btnHoaDon.setBounds(0, 114, 280, 35);
				btnNhanVien.setBounds(0, 149, 280, 35);
			}
			subMenu.setVisible(false);
		}
	}

	public void format() {
		btnKhachHang.setBounds(0, 79, 280, 35);
		btnHoaDon.setBounds(0, 114, 280, 35);
		btnNhanVien.setBounds(0, 149, 280, 35);
		hideMenu();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnSanPham)) {
			btnKhachHang.setBounds(0, 183, 280, 35);
			btnHoaDon.setBounds(0, 218, 280, 35);
			btnNhanVien.setBounds(0, 253, 280, 35);
			editorPane.setText("");
			showMenu(panelSanPham);
		}
		// Xử lí sản phẩm
		if (o.equals(btnCapNhatSP)) { 
			format();
			editorPane.setText("<html>\r\n" + 
					"	<head>\r\n" + 
					"		<title></title>\r\n" + 
					"		<style type=\"text/css\">\r\n" + 
					"			div{\r\n" + 
					"				margin-left: 20px;\r\n" + 
					"			}\r\n" + 
					"			h2{\r\n" + 
					"				padding: 10px;\r\n" + 
					"				font-size: 15px;\r\n" + 
					"			}\r\n" + 
					"			h1{\r\n" + 
					"				text-align: center;\r\n" + 
					"				color : blue;\r\n" + 
					"				font-size: 20px;\r\n" + 
					"			}\r\n" + 
					"		</style>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<div>\r\n" + 
					"			<h1>CẬP NHẬT SẢN PHẨM</h1>"+
					"			<h2>Bước 1: Chọn sản phẩm cần cập nhật</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/capnhatsanphambuoc1.png")+"\">\r\n" + 
					"			<h2>Bước 2: Nhập/ chọn các thông tin cập nhật tại các TextFied và Combobox</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/capnhatsanphambuoc2.png")+"\">\r\n" + 
					"			<h2>Bước 3: Nhấn cập nhận để cập nhật</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/capnhatsanphambuoc3.png")+"\">\r\n" + 
					"			<h2>Bước 4: Xác nhận</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/capnhatsanphambuoc4.png")+"\">\r\n" + 
					"		</div>\r\n" + 
					"	</body>\r\n" + 
					"</html>"
					);
		}
		// Xử lí sản phẩm
		if (o.equals(btnThongKeSP)) {
			format();
			editorPane.setText("<html>\r\n" + 
					"	<head>\r\n" + 
					"		<title></title>\r\n" + 
					"		<style type=\"text/css\">\r\n" + 
					"			div{\r\n" + 
					"				margin-left: 20px;\r\n" + 
					"			}\r\n" + 
					"			h2{\r\n" + 
					"				padding: 10px;\r\n" + 
					"				font-size: 15px;\r\n" + 
					"			}\r\n" + 
					"			h1{\r\n" + 
					"				text-align: center;\r\n" + 
					"				color : blue;\r\n" + 
					"				font-size: 20px;\r\n" + 
					"			}\r\n" + 
					"		</style>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<div>\r\n" + 
					"			<h1>THỐNG KÊ SẢN PHẨM SẮP HẾT SỐ LƯỢNG</h1>"+
					"			<h2>Dùng để xem những sản phẩm nào sắp hết số lượng </h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkesanphambuoc1.png")+"\">\r\n" + 
					"			<h2>2.Ngoài ra còn có thể xuất file Excel bằng cách nhấn vào Button xuất file Excel</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkesanphambuoc2.png")+"\">\r\n" + 
					"		</div>\r\n" + 
					"	</body>\r\n" + 
					"</html>"
					);
		}
		// Xử lí sản phẩm
		if (o.equals(btnTraCuuSP)) {
			format();
			editorPane.setText("<html>\r\n" + 
					"	<head>\r\n" + 
					"		<title></title>\r\n" + 
					"		<style type=\"text/css\">\r\n" + 
					"			div{\r\n" + 
					"				margin-left: 20px;\r\n" + 
					"			}\r\n" + 
					"			h2{\r\n" + 
					"				padding: 10px;\r\n" + 
					"				font-size: 15px;\r\n" + 
					"			}\r\n" + 
					"			h1{\r\n" + 
					"				text-align: center;\r\n" + 
					"				color : blue;\r\n" + 
					"				font-size: 20px;\r\n" + 
					"			}\r\n" + 
					"		</style>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<div>\r\n" + 
					"			<h1>TRA CỨU SẢN PHẨM</h1>"+
					"			<h2>Bước 1: Nhập thông tin hoặc chọn các Combobox để tìm kiếm sản phẩm theo các tiêu chí tương ứng</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/tracuusanphambuoc1.png")+"\">\r\n" + 
					"			<h2>Bước 2: Chọn sản phẩm cần xem chi tiết</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/tracuusanphambuoc2.png")+"\">\r\n" + 
					"			<h2>Bước 3: Nhấn xem  chi tiết để xem chi tiết sản phẩm</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/tracuusanphambuoc3.png")+"\">\r\n" + 
					"		</div>\r\n" + 
					"	</body>\r\n" + 
					"</html>"
					);
		}
		if (o.equals(btnKhachHang)) {
			btnKhachHang.setBounds(0, 79, 280, 35);
			panelKH.setBounds(0, 114, 280, 108);
			btnHoaDon.setBounds(0, 222, 280, 35);
			btnNhanVien.setBounds(0, 257, 280, 35);
			editorPane.setText("");
			showMenu(panelKH);
		}
		// Xử lí khách hàng
		if (o.equals(btnCapNhatKH)) {
			format();
			editorPane.setText("<html>\r\n" + 
					"	<head>\r\n" + 
					"		<title></title>\r\n" + 
					"		<style type=\"text/css\">\r\n" + 
					"			div{\r\n" + 
					"				margin-left: 20px;\r\n" + 
					"			}\r\n" + 
					"			h2{\r\n" + 
					"				padding: 10px;\r\n" + 
					"				font-size: 15px;\r\n" + 
					"			}\r\n" + 
					"			h1{\r\n" + 
					"				text-align: center;\r\n" + 
					"				color : blue;\r\n" + 
					"				font-size: 20px;\r\n" + 
					"			}\r\n" + 
					"		</style>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<div>\r\n" + 
					"			<h1>CẬP NHẬT KHÁCH HÀNG</h1>"+
					"			<h2>Bước 1: Chọn khách hàng cần cập nhật</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/capnhatkhachhangbuoc1.png")+"\">\r\n" + 
					"			<h2>Bước 2: Nhập/ chọn các thông tin cập nhật tại các TextFied và Combobox</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/capnhatkhachhangbuoc2.png")+"\">\r\n" + 
					"			<h2>Bước 3: Nhấn cập nhận để cập nhật</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/capnhatkhachhangbuoc3.png")+"\">\r\n" + 
					"			<h2>Bước 4: Xác nhận</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/capnhatkhachhangbuoc4.png")+"\">\r\n" + 
					"		</div>\r\n" + 
					"	</body>\r\n" + 
					"</html>"
					);
		}
		// Xử lí khách hàng
		if (o.equals(btnThemKH)) {
			format();
			editorPane.setText("<html>\r\n" + 
					"	<head>\r\n" + 
					"		<title></title>\r\n" + 
					"		<style type=\"text/css\">\r\n" + 
					"			div{\r\n" + 
					"				margin-left: 20px;\r\n" + 
					"			}\r\n" + 
					"			h2{\r\n" + 
					"				padding: 10px;\r\n" + 
					"				font-size: 15px;\r\n" + 
					"			}\r\n" + 
					"			h1{\r\n" + 
					"				text-align: center;\r\n" + 
					"				color : blue;\r\n" + 
					"				font-size: 20px;\r\n" + 
					"			}\r\n" + 
					"		</style>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<div>\r\n" + 
					"			<h1>THÊM KHÁCH HÀNG</h1>"+
					"			<h2>Bước 1 : Nhập thông tin và các TextField và chọn Combobox .</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/themkhachhangbuoc1.png")+"\">\r\n" + 
					"			<h2>Bước 2 : Nhấn Thêm để thêm khách hàng và hệ thống sẽ hiện thông báo.</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/themkhachhangbuoc2.png")+"\">\r\n" + 
					"		</div>\r\n" + 
					"	</body>\r\n" + 
					"</html>"
					);
		}
		// Xử lí khách hàng
		if (o.equals(btnTraCuuKH)) {
			format();
			editorPane.setText("<html>\r\n" + 
					"	<head>\r\n" + 
					"		<title></title>\r\n" + 
					"		<style type=\"text/css\">\r\n" + 
					"			div{\r\n" + 
					"				margin-left: 20px;\r\n" + 
					"			}\r\n" + 
					"			h2{\r\n" + 
					"				padding: 10px;\r\n" + 
					"				font-size: 15px;\r\n" + 
					"			}\r\n" + 
					"			h1{\r\n" + 
					"				text-align: center;\r\n" + 
					"				color : blue;\r\n" + 
					"				font-size: 20px;\r\n" + 
					"			}\r\n" + 
					"		</style>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<div>\r\n" + 
					"			<h1>TRA CỨU KHÁCH HÀNG</h1>"+
					"			<h2>Bước 1: Nhập thông tin hoặc chọn các Combobox để tìm kiếm sản phẩm theo các tiêu chí tương ứng	</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/tracuukhachhangbuoc1.png")+"\">\r\n" + 
					"		</div>\r\n" + 
					"	</body>\r\n" + 
					"</html>"
					);
		}
		if (o.equals(btnHoaDon)) {
			btnHoaDon.setBounds(0, 114, 280, 35);
			panelHD.setBounds(0, 149, 280, 108);
			btnNhanVien.setBounds(0, 257, 280, 35);
			editorPane.setText("");
			showMenu(panelHD);
		}
		// Xử lí hóa đơn
		if (o.equals(btnThemHD)) {
			format();
			editorPane.setText("<html>\r\n" + 
					"	<head>\r\n" + 
					"		<title></title>\r\n" + 
					"		<style type=\"text/css\">\r\n" + 
					"			div{\r\n" + 
					"				margin-left: 20px;\r\n" + 
					"			}\r\n" + 
					"			h2{\r\n" + 
					"				padding: 10px;\r\n" + 
					"				font-size: 15px;\r\n" + 
					"			}\r\n" + 
					"			h1{\r\n" + 
					"				text-align: center;\r\n" + 
					"				color : blue;\r\n" + 
					"				font-size: 20px;\r\n" + 
					"			}\r\n" + 
					"		</style>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<div>\r\n" + 
					"			<h1>THÊM HÓA ĐƠN</h1>"+
					"			<h2>Bước 1: Tìm kiếm sản phẩm cần lập hóa đơn</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/themhoadonbuoc1.png")+"\">\r\n" + 
					"			<h2>Bước 2: Nhập số lượng cần thêm vào hóa đơn và nhấn button mũi tên để thêm sản phẩm vào hóa đơn</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/themhoadonbuoc2.png")+"\">\r\n" + 
					"			<h2>Bước 3.1 : Nếu là khách hàng cũ thì nhập số điện thoại khách hàng và tìm kiếm khách hàng</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/themhoadonbuoc3.1.png")+"\">\r\n" + 
					"			<h2>Bước 3.2 : Nếu là khách hàng mới thì nhấn Thêm KH</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/themhoadonbuoc3.2.png")+"\">\r\n" + 
					"			<h2>Bước 4: Nhập tiền nhận từ khách hàng</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/themhoadonbuoc4.png")+"\">\r\n" + 
					"			<h2>Bước 5: Nhấn thanh toán</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/themhoadonbuoc5.png")+"\">\r\n" + 
					"			<h2>Bước 6 : Xác nhận</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/themhoadonbuoc6.png")+"\">\r\n" + 
					"		</div>\r\n" + 
					"	</body>\r\n" + 
					"</html>"
					);
		}
		// Xử lí hóa đơn
		if (o.equals(btnThongKeHD)) {
			format();
			editorPane.setText("<html>\r\n" + 
					"	<head>\r\n" + 
					"		<title></title>\r\n" + 
					"		<style type=\"text/css\">\r\n" + 
					"			div{\r\n" + 
					"				margin-left: 20px;\r\n" + 
					"			}\r\n" + 
					"			h2{\r\n" + 
					"				padding: 10px;\r\n" + 
					"				font-size: 15px;\r\n" + 
					"			}\r\n" + 
					"			h1{\r\n" + 
					"				text-align: center;\r\n" + 
					"				color : blue;\r\n" + 
					"				font-size: 20px;\r\n" + 
					"			}\r\n" + 
					"		</style>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<div>\r\n" + 
					"			<h1>THỐNG KÊ HÓA ĐƠN</h1>"+
					"			<h2>Dùng để thống kê doanh thu bán được theo ngày hoặc theo tháng hoặc theo năm </h2>\r\n" + 
					"			<h2>I.Thống kê theo ngày </h2>\r\n" + 
					"			<h2>a.Thống kê theo nhân viên </h2>\r\n" + 
					"			<h2>Bước 1: Chọn thống kê theo ngày</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheongaynvbuoc1.png")+"\">\r\n" + 
					"			<h2>Bước 2: Chọn ngày cần thống kê</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheongaynvbuoc2.png")+"\">\r\n" + 
					"			<h2>Bước 3: Nhấn xuất file excel nếu muốn thống kê ra file excel</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheongaynvbuoc3.png")+"\">\r\n" + 
					"			<h2>b.Thống kê theo từng nhân viên </h2>\r\n" + 
					"			<h2>Bước 1: Chọn thống kê theo ngày</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheongaytnvbuoc1.png")+"\">\r\n" + 
					"			<h2>Bước 2: Chọn ngày cần thống kê</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheongaytnvbuoc2.png")+"\">\r\n" + 
					"			<h2>Bước 3: Chọn combobox thống kê theo nhân nhân viên</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheongaytnvbuoc3.png")+"\">\r\n" + 
					"			<h2>Bước 4: Click chọn nhân viên cần xem thống kê</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheongaytnvbuoc4.png")+"\">\r\n" + 
					"			<h2>Bước 5: Nhấn xuất file excel nếu muốn thống kê ra file excel</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheongaytnvbuoc5.png")+"\">\r\n" + 	
					"			<h2>II.Thống kê theo tháng </h2>\r\n" + 
					"			<h2>a.Thống kê theo nhân viên </h2>\r\n" + 
					"			<h2>Bước 1: Chọn thống kê theo tháng</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheothangnvbuoc1.png")+"\">\r\n" + 
					"			<h2>Bước 2: Chọn bombobox tháng, năm cần thống kê</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheothangnvbuoc2.png")+"\">\r\n" + 
					"			<h2>Bước 3: Nhấn xuất file excel nếu muốn thống kê ra file excel</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheothangnvbuoc3.png")+"\">\r\n" + 
					"			<h2>b.Thống kê theo từng nhân viên </h2>\r\n" + 
					"			<h2>Bước 1: Chọn thống kê theo tháng</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheothangtnvbuoc1.png")+"\">\r\n" + 
					"			<h2>Bước 2: Chọn bombobox tháng, năm cần thống kê</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheothangtnvbuoc2.png")+"\">\r\n" + 
					"			<h2>Bước 3: Chọn thống kê theo nhân viên</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheothangtnvbuoc3.png")+"\">\r\n" + 
					"			<h2>Bước 4: Click chọn nhân viên cần xem thống kê</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheothangtnvbuoc4.png")+"\">\r\n" + 
					"			<h2>Bước 5: Nhấn xuất file excel nếu muốn thống kê ra file excel</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheothangtnvbuoc5.png")+"\">\r\n" + 	
					"			<h2>III.Thống kê theo năm </h2>\r\n" + 
					"			<h2>a.Thống kê theo nhân viên </h2>\r\n" + 
					"			<h2>Bước 1: Chọn thống kê theo năm</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheonamnvbuoc1.png")+"\">\r\n" + 
					"			<h2>Bước 2 : Chọn combobox năm cần thống kê</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheonamnvbuoc2.png")+"\">\r\n" + 
					"			<h2>Bước 3: Nhấn xuất file excel nếu muốn thống kê ra file excel</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheonamnvbuoc3.png")+"\">\r\n" + 
					"			<h2>b.Thống kê theo từng nhân viên </h2>\r\n" + 
					"			<h2>Bước 1: Chọn thống kê theo năm</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheonamtnvbuoc1.png")+"\">\r\n" + 
					"			<h2>Bước 2 : Chọn combobox năm cần thống kê</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheonamtnvbuoc2.png")+"\">\r\n" + 
					"			<h2>Bước 3: Chọn combobox thống kê theo nhân viên</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheonamtnvbuoc3.png")+"\">\r\n" + 
					"			<h2>Bước 4: Click chọn nhân viên cần xem thống kê</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheonamtnvbuoc4.png")+"\">\r\n" + 
					"			<h2>Bước 5: Nhấn xuất file excel nếu muốn thống kê ra file excel</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/thongkehoadontheonamtnvbuoc5.png")+"\">\r\n" + 	
					"		</div>\r\n" + 
					"	</body>\r\n" + 
					"</html>"
					);
		}
		// Xử lí hóa đơn
		if (o.equals(btnTraCuuHD)) {
			format();
			editorPane.setText("<html>\r\n" + 
					"	<head>\r\n" + 
					"		<title></title>\r\n" + 
					"		<style type=\"text/css\">\r\n" + 
					"			div{\r\n" + 
					"				margin-left: 20px;\r\n" + 
					"			}\r\n" + 
					"			h2{\r\n" + 
					"				padding: 10px;\r\n" + 
					"				font-size: 15px;\r\n" + 
					"			}\r\n" + 
					"			h1{\r\n" + 
					"				text-align: center;\r\n" + 
					"				color : blue;\r\n" + 
					"				font-size: 20px;\r\n" + 
					"			}\r\n" + 
					"		</style>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<div>\r\n" + 
					"			<h1>TRA CỨU HÓA ĐƠN</h1>"+
					"			<h2>Bước 1: Nhập thông tin hoặc chọn các Combobox để tìm kiếm sản phẩm theo các tiêu chí tương ứng</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/tracuuhoadonbuoc1.png")+"\">\r\n" + 
					"			<h2>Bước 2: Chọn sản phẩm cần xem chi tiết</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/tracuuhoadonbuoc2.png")+"\">\r\n" + 
					"			<h2>Bước 3: Nhấn xem  chi tiết để xem chi tiết sản phẩm</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/tracuuhoadonbuoc3.png")+"\">\r\n" + 
					"		</div>\r\n" + 
					"	</body>\r\n" + 
					"</html>"
					);
		}
		if (o.equals(btnNhanVien)) {
			btnNhanVien.setBounds(0, 149, 280, 35);
			panelNV.setBounds(0, 184, 280, 108);
			editorPane.setText("");
			showMenu(panelNV);
		}
		// Xử lí nhân viên
		if (o.equals(btnCapNhatNV)) {
			format();
			editorPane.setText("<html>\r\n" + 
					"	<head>\r\n" + 
					"		<title></title>\r\n" + 
					"		<style type=\"text/css\">\r\n" + 
					"			div{\r\n" + 
					"				margin-left: 20px;\r\n" + 
					"			}\r\n" + 
					"			h2{\r\n" + 
					"				padding: 10px;\r\n" + 
					"				font-size: 15px;\r\n" + 
					"			}\r\n" + 
					"			h1{\r\n" + 
					"				text-align: center;\r\n" + 
					"				color : blue;\r\n" + 
					"				font-size: 20px;\r\n" + 
					"			}\r\n" + 
					"		</style>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<div>\r\n" + 
					"			<h1>CẬP NHẬT NHÂN VIÊN</h1>"+
					"			<h2>Bước 1: Nhập thông tin hoặc chọn combobox để tìm kiếm nhân viên cần cập nhật thông tin</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/capnhatnhanvienbuoc1.png")+"\">\r\n" + 
					"			<h2>Bước 2: Chọn nhân viên và nhấn cập nhật</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/capnhatnhanvienbuoc2.png")+"\">\r\n" + 
					"			<h2>Bước 3: Nhập thông tin nhân viên cần cập nhật</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/capnhatnhanvienbuoc3.png")+"\">\r\n" + 
					"			<h2>Bước 4: Chọn ảnh nhân viên cần cập nhật</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/capnhatnhanvienbuoc4.png")+"\">\r\n" + 
					"			<h2>Bước 5: Nhấn cập nhật để cập nhật thông tin nhân viên</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/capnhatnhanvienbuoc5.png")+"\">\r\n" + 
					"			<h2>Bước 6 : Chọn Yes để xác nhận cập nhật</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/capnhatnhanvienbuoc6.png")+"\">\r\n" + 
					"		</div>\r\n" + 
					"	</body>\r\n" + 
					"</html>"
					);
		}
		// Xử lí nhân viên
		if (o.equals(btnThemNV)) {
			format();
			editorPane.setText("<html>\r\n" + 
					"	<head>\r\n" + 
					"		<title></title>\r\n" + 
					"		<style type=\"text/css\">\r\n" + 
					"			div{\r\n" + 
					"				margin-left: 20px;\r\n" + 
					"			}\r\n" + 
					"			h2{\r\n" + 
					"				padding: 10px;\r\n" + 
					"				font-size: 15px;\r\n" + 
					"			}\r\n" + 
					"			h1{\r\n" + 
					"				text-align: center;\r\n" + 
					"				color : blue;\r\n" + 
					"				font-size: 20px;\r\n" + 
					"			}\r\n" + 
					"		</style>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<div>\r\n" + 
					"			<h1>THÊM NHÂN VIÊN</h1>"+
					"			<h2>Bước 1: Nhập thông tin nhân viên cần thêm</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/themnhanvienbuoc1.png")+"\">\r\n" +
					"			<h2>Bước 2: Chọn ảnh nhân viên</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/themnhanvienbuoc2.png")+"\">\r\n" + 
					"			<h2>Bước 3:  Nhấn thêm để thêm nhân viên</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/themnhanvienbuoc3.png")+"\">\r\n" + 
					"		</div>\r\n" + 
					"	</body>\r\n" + 
					"</html>"
					);
		}
		// Xử lí nhân viên
		if (o.equals(btnTraCuuNV)) {
			format();
			editorPane.setText("<html>\r\n" + 
					"	<head>\r\n" + 
					"		<title></title>\r\n" + 
					"		<style type=\"text/css\">\r\n" + 
					"			div{\r\n" + 
					"				margin-left: 20px;\r\n" + 
					"			}\r\n" + 
					"			h2{\r\n" + 
					"				padding: 10px;\r\n" + 
					"				font-size: 15px;\r\n" + 
					"			}\r\n" + 
					"			h1{\r\n" + 
					"				text-align: center;\r\n" + 
					"				color : blue;\r\n" + 
					"				font-size: 20px;\r\n" + 
					"			}\r\n" + 
					"		</style>\r\n" + 
					"	</head>\r\n" + 
					"	<body>\r\n" + 
					"		<div>\r\n" + 
					"			<h1>TRA CỨU NHÂN VIÊN</h1>"+
					"			<h2>Bước 1: Nhập thông tin nhân viên hoặc chọn các combobox để tìm nhân viên theo các tiêu chí mong muốn</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/tracuunhanvienbuoc1.png")+"\">\r\n" + 
					"			<h2>Bước 2: Chọn nhân viên cần xem chi tiết và nhấn xem chi tiết</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/tracuunhanvienbuoc2.png")+"\">\r\n" + 
					"			<h2>Bước 3: Nhấn thoát để quay lại</h2>\r\n" + 
					"			<img src=\""+TroGiupJFrameGUI.class.getResource("/imgTroGiup/tracuunhanvienbuoc2.png")+"\">\r\n" + 
					"		</div>\r\n" + 
					"	</body>\r\n" + 
					"</html>"
					);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
