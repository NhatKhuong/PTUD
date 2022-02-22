package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.DiaChiDao;
import dao.KhachHangDao;
import dao.Ipml.DiaChiImpl;
import dao.Ipml.KhachHangImpl;
import entity.KhachHang;

public class TraCuuKhachHangPnGUI extends JPanel implements ActionListener, ItemListener, MouseListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 647901219869506492L;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private List<String> listTinhTP = new ArrayList<String>();
	private List<String> listQuanHuyen = new ArrayList<String>();
	private List<String> listPhuongXa = new ArrayList<String>();
	private DiaChiDao diaChiDao = new DiaChiImpl();
	private JComboBox<String> cbTinhTP;
	private JComboBox<String> cbQuanHuyen;
	private JComboBox<String> cbXa;
	private JButton btnLamMoi;
	private JComboBox<String> cbGioiTinh;
	private JButton btnBackEnd;
	private JButton btnBack;
	private JLabel lblSoTrangTable;
	private JButton btnNext;
	private JButton btnNextEnd;
	private KhachHangDao khachHangDao = new KhachHangImpl();
	private JLabel lblTongTrang;

	public TraCuuKhachHangPnGUI() {
		setBackground(Color.WHITE);
		setBounds(0, 50, 1364, 621);
		setLayout(null);

		JLabel lblTmKimKhch = new JLabel("TRA CỨU KHÁCH HÀNG");
		lblTmKimKhch.setHorizontalAlignment(SwingConstants.CENTER);
		lblTmKimKhch.setForeground(Color.BLACK);
		lblTmKimKhch.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTmKimKhch.setBounds(10, 11, 1328, 35);
		add(lblTmKimKhch);

		JLabel lblmaKH = new JLabel("Mã khách hàng:");
		lblmaKH.setFont(new Font("Arial", Font.BOLD, 16));
		lblmaKH.setBounds(47, 57, 130, 35);
		add(lblmaKH);

		txtMaKH = new JTextField();
		txtMaKH.setFont(new Font("Arial", Font.PLAIN, 16));
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(187, 57, 312, 35);
		add(txtMaKH);

		JLabel lblTenKH = new JLabel("Tên khách hàng   :");
		lblTenKH.setFont(new Font("Arial", Font.BOLD, 16));
		lblTenKH.setBounds(568, 57, 141, 35);
		add(lblTenKH);

		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(748, 57, 260, 35);
		add(txtTenKH);

		JLabel lblSDT = new JLabel("Số điện thoại    :");
		lblSDT.setFont(new Font("Arial", Font.BOLD, 16));
		lblSDT.setBounds(47, 103, 130, 35);
		add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Arial", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBounds(187, 103, 312, 35);
		add(txtSDT);

		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
		cbGioiTinh.setBounds(1178, 57, 155, 35);
		add(cbGioiTinh);

		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("Nữ");

		JLabel lblGioiTinh = new JLabel("Giới tính  :");
		lblGioiTinh.setFont(new Font("Arial", Font.BOLD, 16));
		lblGioiTinh.setBounds(1059, 57, 96, 35);
		add(lblGioiTinh);

		JLabel lblDiaChi = new JLabel("Địa chỉ                     :");
		lblDiaChi.setFont(new Font("Arial", Font.BOLD, 16));
		lblDiaChi.setBounds(568, 103, 155, 35);
		add(lblDiaChi);

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon(TraCuuKhachHangPnGUI.class.getResource("/img/lam_moi.png")));
		btnLamMoi.setFont(new Font("Arial", Font.PLAIN, 16));
		btnLamMoi.setBounds(1178, 149, 126, 35);
		add(btnLamMoi);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 207, 1303, 361);
		add(scrollPane);

		table = new JTable();
		String[] colHeader = { "Mã khách hàng", "Tên khách hàng", "Giới tính", "Số điện thoại", "Địa chỉ" };
		model = new DefaultTableModel(colHeader, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		table = new JTable(model);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		table.setRowHeight(35);
		scrollPane.setViewportView(table);

		btnBackEnd = new JButton("");
		btnBackEnd.setIcon(new ImageIcon(TraCuuKhachHangPnGUI.class.getResource("/img/previousEnd.png")));
		btnBackEnd.setBounds(456, 580, 80, 30);
		add(btnBackEnd);

		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(TraCuuKhachHangPnGUI.class.getResource("/img/rewind-button.png")));
		btnBack.setBounds(546, 580, 80, 30);
		add(btnBack);

		lblSoTrangTable = new JLabel("1");
		lblSoTrangTable.setFont(new Font("Arial", Font.BOLD, 16));
		lblSoTrangTable.setBounds(648, 575, 46, 35);
		add(lblSoTrangTable);

		btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon(TraCuuKhachHangPnGUI.class.getResource("/img/nextbutton.png")));
		btnNext.setBounds(733, 579, 80, 30);
		add(btnNext);

		btnNextEnd = new JButton("");
		btnNextEnd.setIcon(new ImageIcon(TraCuuKhachHangPnGUI.class.getResource("/img/nextEnd.png")));
		btnNextEnd.setBounds(823, 579, 80, 30);
		add(btnNextEnd);

		cbXa = new JComboBox<String>();
		cbXa.setFont(new Font("Arial", Font.PLAIN, 16));
		cbXa.setBounds(1178, 103, 155, 35);
		add(cbXa);

		cbQuanHuyen = new JComboBox<String>();
		cbQuanHuyen.setFont(new Font("Arial", Font.PLAIN, 16));
		cbQuanHuyen.setBounds(965, 103, 155, 35);
		add(cbQuanHuyen);

		cbTinhTP = new JComboBox<String>();
		cbTinhTP.setFont(new Font("Arial", Font.PLAIN, 16));
		cbTinhTP.setBounds(748, 103, 155, 35);
		add(cbTinhTP);

		cbTinhTP.addItem("Tỉnh/Thành Phố");
		listTinhTP = diaChiDao.getAllTinhTP();
		for (String a : listTinhTP) {
			cbTinhTP.addItem(a);
		}
		cbQuanHuyen.addItem("Quận/Huyện");
		cbXa.addItem("Xã/Phường");
		cbQuanHuyen.setEnabled(false);
		cbXa.setEnabled(false);
		List<KhachHang> khachhang = khachHangDao.getKhachHangTheoPage(0, "", "", "", "", "", "", 1);
		loadTable(khachhang);
		cbTinhTP.addItemListener(this);
		cbQuanHuyen.addItemListener(this);
		cbXa.addItemListener(this);
		cbGioiTinh.addItemListener(this);
		btnNext.addActionListener(this);
		btnBack.addActionListener(this);
		btnBackEnd.addActionListener(this);
		btnNextEnd.addActionListener(this);
		btnLamMoi.addActionListener(this);
		txtMaKH.addKeyListener(this);
		txtTenKH.addKeyListener(this);
		txtSDT.addKeyListener(this);
		
		lblTongTrang = new JLabel("/  1");
		lblTongTrang.setFont(new Font("Arial", Font.BOLD, 16));
		lblTongTrang.setBounds(677, 575, 46, 35);
		add(lblTongTrang);

		int tongPage = TongTrang();
		lblTongTrang.setText("/" + tongPage);
		
	}
	private int TongTrang() {
		int tongPage = 1;
		String maKH = txtMaKH.getText();
		String tenKH = txtTenKH.getText();
		String sdt = txtSDT.getText();
		String xa = cbXa.getSelectedIndex() > 0 ? cbXa.getSelectedItem().toString() : "";
		String huyen = cbQuanHuyen.getSelectedIndex() > 0 ? cbQuanHuyen.getSelectedItem().toString() : "";
		String tinh = cbTinhTP.getSelectedIndex() > 0 ? cbTinhTP.getSelectedItem().toString() : "";
		int gioiTinh = 1;
		if(cbGioiTinh.getSelectedItem().toString().equalsIgnoreCase("Nữ")) {
			gioiTinh = 0;
		}
		int tongKH = khachHangDao.TongKhachHang(maKH, tenKH, sdt, xa, huyen, tinh, gioiTinh);
		tongPage = tongKH % 10 == 0 ? tongKH / 10 : (tongKH / 10) + 1;
		return tongPage;
	}
	private void Clear() {
		table.clearSelection();
		txtMaKH.setText("");
		txtSDT.setText("");
		txtTenKH.setText("");
		cbGioiTinh.setSelectedIndex(0);
		cbTinhTP.setSelectedIndex(0);
		lblSoTrangTable.setText("1");
	}



	public void XoasachModelKH() {
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		table.clearSelection();
		int tongPage = TongTrang();
		lblTongTrang.setText("/" + tongPage);
	}

	public void loadTable(List<KhachHang> listKH) {
		for (KhachHang kh : listKH) {
			String gioiTinh = "Nữ";
			if (kh.isGioiTinh()) {
				gioiTinh = "Nam";
			}
			model.addRow(new Object[] { kh.getMaKH(), kh.getHoTen(), gioiTinh, kh.getSdt(),
					kh.getDiaChi().getPhuongXa().trim() + "-" + kh.getDiaChi().getQuanHuyen().trim() + "-"
							+ kh.getDiaChi().getTinhTP().trim() });
		}
		
//"Mã khách hàng" ,"Tên khách hàng","Giới tính","Số điện thoại", "Địa chỉ" 
	}
	public void AddIntable() {
		int page  = Integer.parseInt(lblSoTrangTable.getText().toString());
		page--;
		String maKH = txtMaKH.getText().toLowerCase();
		String tenKH = txtTenKH.getText().toLowerCase();
		String sdt = txtSDT.getText().toLowerCase();
		String xa = cbXa.getSelectedIndex() > 0 ? cbXa.getSelectedItem().toString().toLowerCase() : "";
		String huyen = cbQuanHuyen.getSelectedIndex() > 0 ? cbQuanHuyen.getSelectedItem().toString().toLowerCase() : "";
		String tinh = cbTinhTP.getSelectedIndex() > 0 ? cbTinhTP.getSelectedItem().toString().toLowerCase() : "";
		int gioiTinh = 1;
		if(cbGioiTinh.getSelectedItem().toString().equalsIgnoreCase("Nữ")) {
			gioiTinh = 0;
		}
		
		List<KhachHang> list = khachHangDao.getKhachHangTheoPage(page, maKH, tenKH, sdt, xa, huyen, tinh, gioiTinh);
		loadTable(list);
		int tongPage = TongTrang();
		lblTongTrang.setText("/" + tongPage);
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
		Object o = e.getSource();
		if(o.equals(txtMaKH)||o.equals(txtTenKH)|| o.equals(txtSDT)) {
			XoasachModelKH();
			AddIntable();
			lblSoTrangTable.setText("1");
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
		Object o = e.getSource();
		if (e.getStateChange() == ItemEvent.SELECTED)
			return;
		if (o.equals(cbTinhTP)) {
			cbQuanHuyen.removeAllItems();
			cbQuanHuyen.addItem("Quận/Huyện");
			cbQuanHuyen.setEnabled(true);
			if (cbTinhTP.getSelectedIndex() > 0) {
				String tinh = cbTinhTP.getSelectedItem().toString();
				listQuanHuyen = diaChiDao.getAllHuyenTrongTinhTP(tinh);
				for (String b : listQuanHuyen) {
					cbQuanHuyen.addItem(b);
				}
			}
			else {
				cbQuanHuyen.setEnabled(false);
			}
			XoasachModelKH();
			AddIntable();
			lblSoTrangTable.setText("1");
			
		}
		if (o.equals(cbQuanHuyen)) {
			cbXa.removeAllItems();
			cbXa.addItem("Xã/Phường");
			cbXa.setEnabled(true);
			if (cbQuanHuyen.getSelectedIndex() > 0) {
				String tinh = cbTinhTP.getSelectedItem().toString();
				String huyen = cbQuanHuyen.getSelectedItem().toString();
				listPhuongXa = diaChiDao.getAllPhuongXa(tinh, huyen);
				for (String c : listPhuongXa) {
					cbXa.addItem(c);
				}
			}
			else {
				cbXa.setEnabled(false);
			}
			XoasachModelKH();
			AddIntable();
			lblSoTrangTable.setText("1");
		}
		if(o.equals(cbGioiTinh)||o.equals(cbXa)) {
			XoasachModelKH();
			AddIntable();
			lblSoTrangTable.setText("1");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		int tongPage = 1;
		String maKH = txtMaKH.getText();
		String tenKH = txtTenKH.getText();
		String sdt = txtSDT.getText();
		String xa = cbXa.getSelectedIndex() > 0 ? cbXa.getSelectedItem().toString() : "";
		String huyen = cbQuanHuyen.getSelectedIndex() > 0 ? cbQuanHuyen.getSelectedItem().toString() : "";
		String tinh = cbTinhTP.getSelectedIndex() > 0 ? cbTinhTP.getSelectedItem().toString() : "";
		int gioiTinh = 1;
		if(cbGioiTinh.getSelectedItem().toString().equalsIgnoreCase("Nữ")) {
			gioiTinh = 0;
		}
		int tongKH = khachHangDao.TongKhachHang(maKH, tenKH, sdt, xa, huyen, tinh, gioiTinh);
		tongPage = tongKH % 10 == 0 ? tongKH / 10 : (tongKH / 10) + 1;
		
		if (src.equals(btnLamMoi)) {
			Clear();
			XoasachModelKH();
			List<KhachHang> khachhang = khachHangDao.getKhachHangTheoPage(0, "", "", "", "", "", "", 1);
			loadTable(khachhang);
		}
		if (src.equals(btnBack)) {
			int page = Integer.parseInt(lblSoTrangTable.getText());
			if (page > 1) {
				page--;
				lblSoTrangTable.setText(Integer.toString(page));
				
				XoasachModelKH();
				table.clearSelection();
				AddIntable();
			}
		}
		if (src.equals(btnBackEnd)) {
			int page = Integer.parseInt(lblSoTrangTable.getText());
			lblTongTrang.setText("/" + tongPage);
			if (page != 1) {
				lblSoTrangTable.setText(Integer.toString(1));
				XoasachModelKH();
				table.clearSelection();
				AddIntable();
			}
		}
		if (src.equals(btnNext)) {
			int page = Integer.parseInt(lblSoTrangTable.getText());
			if (page < tongPage) {
				page += 1;
				lblSoTrangTable.setText(Integer.toString(page));
				XoasachModelKH();
				table.clearSelection();
				AddIntable();

			} else {
				JOptionPane.showMessageDialog(this, "Danh sách nhân viên đã hết");
			}

		}
		if (src.equals(btnNextEnd)) {
			int page = Integer.parseInt(lblSoTrangTable.getText());
			lblTongTrang.setText("/" + tongPage);
			if (page != tongPage) {
				lblSoTrangTable.setText(Integer.toString(tongPage));
				XoasachModelKH();
				table.clearSelection();
				AddIntable();
			}
		}
	}
}
