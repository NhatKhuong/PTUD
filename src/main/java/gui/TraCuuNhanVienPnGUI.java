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
import java.text.SimpleDateFormat;
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
import dao.NhanVienDao;
import dao.Ipml.DiaChiImpl;
import dao.Ipml.NhanVienImpl;
import entity.NhanVien;

public class TraCuuNhanVienPnGUI extends JPanel implements ActionListener, ItemListener, MouseListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1097190155345830396L;
	private JTextField txtMaNV;
	private JTextField txtSDT;
	private JTextField txtTenNV;
	private JTable table;
	private DefaultTableModel modelNhanvien;
	private JTextField txtCMND;
	private NhanVienDao nhanVienDao = new NhanVienImpl();
	private JComboBox<String> cbGioiTinh;
	private JComboBox<String> cbTrangThai;
	private JButton btnLamMoi;
	private JButton btnNextEnd;
	private JButton btnNext;
	private JButton btnBack;
	private JButton btnBackEnd;
	private JLabel lblSoTrangTable;
	private JScrollPane scrollPane;
	private JComboBox<String> cbTinhTP;
	private JComboBox<String> cbQuanHuyen;
	private JComboBox<String> cbXaPhuong;
	private List<String> listTinhTP = new ArrayList<String>();
	private List<String> listQuanHuyen = new ArrayList<String>();
	private List<String> listPhuongXa = new ArrayList<String>();
	private DiaChiDao diaChiDao = new DiaChiImpl();
	private JLabel lblTongTrang;
	private JButton btnXemCT;
	

	public TraCuuNhanVienPnGUI() {
		setBackground(Color.WHITE);
		// TODO Auto-generated constructor stub
		setBounds(0, 50, 1364, 621);
		setLayout(null);

		JLabel lblmaNhanVien = new JLabel("Mã nhân viên :");
		lblmaNhanVien.setFont(new Font("Arial", Font.BOLD, 16));
		lblmaNhanVien.setBounds(20, 57, 130, 35);
		add(lblmaNhanVien);

		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Arial", Font.PLAIN, 16));
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(137, 59, 433, 35);
		add(txtMaNV);

		JLabel lblSDT = new JLabel("Số điện thoại :");
		lblSDT.setFont(new Font("Arial", Font.BOLD, 16));
		lblSDT.setBounds(20, 103, 130, 35);
		add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Arial", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBounds(137, 103, 433, 35);
		add(txtSDT);

		JLabel lblTenNhanVien = new JLabel("Tên nhân viên :");
		lblTenNhanVien.setFont(new Font("Arial", Font.BOLD, 16));
		lblTenNhanVien.setBounds(781, 57, 141, 35);
		add(lblTenNhanVien);

		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(906, 57, 428, 35);
		add(txtTenNV);

		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
		cbGioiTinh.setBounds(906, 103, 136, 35);
		add(cbGioiTinh);
		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("Nữ");
		JLabel lblGioiTinh = new JLabel("Giới tính            :");
		lblGioiTinh.setFont(new Font("Arial", Font.BOLD, 16));
		lblGioiTinh.setBounds(781, 103, 141, 35);
		add(lblGioiTinh);

		JLabel lblTrangThai = new JLabel("Trạng thái   :");
		lblTrangThai.setFont(new Font("Arial", Font.BOLD, 16));
		lblTrangThai.setBounds(1071, 103, 105, 35);
		add(lblTrangThai);

		cbTrangThai = new JComboBox<String>();
		cbTrangThai.setFont(new Font("Arial", Font.PLAIN, 16));
		cbTrangThai.setBounds(1175, 105, 159, 35);
		add(cbTrangThai);
		cbTrangThai.addItem("Đang làm");
		cbTrangThai.addItem("Nghỉ việc");
		
		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon(TraCuuNhanVienPnGUI.class.getResource("/img/lam_moi.png")));
		btnLamMoi.setFont(new Font("Arial", Font.PLAIN, 16));
		btnLamMoi.setBounds(1175, 203, 126, 35);
		add(btnLamMoi);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 262, 1314, 293);
		add(scrollPane);
		table = new JTable();
		String[] colHeaderNhanVien = { "Mã Nhân Viên", "Tên Nhân Viên", "Giới tính", "Ngày Sinh", "CMND", "Mật khẩu",
				"Số Điện Thoại", "Trạng Thái", "Địa Chỉ" };
		modelNhanvien = new DefaultTableModel(colHeaderNhanVien, 0) {
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
		table = new JTable(modelNhanvien);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		table.setRowHeight(35);
		btnNextEnd = new JButton("");
		btnNextEnd.setIcon(new ImageIcon(TraCuuNhanVienPnGUI.class.getResource("/img/nextEnd.png")));
		btnNextEnd.setBounds(837, 580, 80, 30);
		add(btnNextEnd);

		btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon(TraCuuNhanVienPnGUI.class.getResource("/img/forward-button.png")));
		btnNext.setBounds(747, 580, 80, 30);
		add(btnNext);

		lblSoTrangTable = new JLabel("1");
		lblSoTrangTable.setFont(new Font("Arial", Font.BOLD, 16));
		lblSoTrangTable.setBounds(651, 575, 46, 35);
		add(lblSoTrangTable);

		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(TraCuuNhanVienPnGUI.class.getResource("/img/rewind-button.png")));
		btnBack.setBounds(545, 580, 80, 30);
		add(btnBack);

		btnBackEnd = new JButton("");
		btnBackEnd.setIcon(new ImageIcon(TraCuuNhanVienPnGUI.class.getResource("/img/previousEnd.png")));
		btnBackEnd.setBounds(455, 580, 80, 30);
		add(btnBackEnd);

		JLabel lblaCh = new JLabel("Địa Chỉ            : ");
		lblaCh.setFont(new Font("Arial", Font.BOLD, 16));
		lblaCh.setBounds(20, 149, 130, 35);
		add(lblaCh);

		JLabel lblCmnd = new JLabel("CMND               : ");
		lblCmnd.setFont(new Font("Arial", Font.BOLD, 16));
		lblCmnd.setBounds(786, 149, 136, 35);
		add(lblCmnd);

		
		btnXemCT = new JButton("Xem Chi Tiết");
		btnXemCT.setIcon(new ImageIcon(TraCuuNhanVienPnGUI.class.getResource("/img/view-details.png")));
		btnXemCT.setFont(new Font("Arial", Font.PLAIN, 16));
		btnXemCT.setBounds(988, 203, 145, 35);
		add(btnXemCT);
		
		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Arial", Font.PLAIN, 16));
		txtCMND.setColumns(10);
		txtCMND.setBounds(906, 149, 428, 35);
		add(txtCMND);
		JLabel lblNewLabel = new JLabel("TRA CỨU NHÂN VIÊN");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 13, 1344, 35);
		add(lblNewLabel);
		

		
		cbTinhTP = new JComboBox<String>();
		cbTinhTP.setFont(new Font("Arial", Font.PLAIN, 16));
		cbTinhTP.setBounds(137, 149, 141, 35);
		cbTinhTP.addItem("Tỉnh/Thành Phố");
		add(cbTinhTP);
		listTinhTP = diaChiDao.getAllTinhTP();
		for(String a : listTinhTP) {
			cbTinhTP.addItem(a);
		}
		
		cbQuanHuyen = new JComboBox<String>();
		cbQuanHuyen.setFont(new Font("Arial", Font.PLAIN, 16));
		cbQuanHuyen.setBounds(293, 149, 141, 35);
		add(cbQuanHuyen);
		cbQuanHuyen.addItem("Quận/Huyện");
		cbXaPhuong = new JComboBox<String>();
		cbXaPhuong.setFont(new Font("Arial", Font.PLAIN, 16));
		cbXaPhuong.setBounds(444, 149, 126, 35);
		cbQuanHuyen.setEnabled(false);
		cbXaPhuong.setEnabled(false);
		add(cbXaPhuong);
		cbXaPhuong.addItem("Xã/Phường");
		cbTinhTP.addItemListener(this);
		cbQuanHuyen.addItemListener(this);
		btnNext.addActionListener(this);
		btnBack.addActionListener(this);
		btnBackEnd.addActionListener(this);
		btnNextEnd.addActionListener(this);
		btnLamMoi.addActionListener(this);
		cbXaPhuong.addItemListener(this);
		txtMaNV.addKeyListener(this);
		txtTenNV.addKeyListener(this);
		txtSDT.addKeyListener(this);
		txtCMND.addKeyListener(this);
		cbGioiTinh.addItemListener(this);
		cbTrangThai.addItemListener(this);
		btnXemCT.addActionListener(this);
		
		lblTongTrang = new JLabel("/ 1");
		lblTongTrang.setFont(new Font("Arial", Font.BOLD, 16));
		lblTongTrang.setBounds(677, 575, 46, 35);
		add(lblTongTrang);
		List<NhanVien> nhanviens = nhanVienDao.getNhanVienTheoPage(0,"","","","","","", 1, 1,"");
		loadTable(nhanviens);
		
		int tongPage = 1;
		String maNV = txtMaNV.getText();
		String tenNV = txtTenNV.getText();
		String sdt = txtSDT.getText();
		String cmnd = txtCMND.getText();
		String xa = cbXaPhuong.getSelectedIndex() > 0 ? cbXaPhuong.getSelectedItem().toString() : "";
		String huyen = cbQuanHuyen.getSelectedIndex() > 0 ? cbQuanHuyen.getSelectedItem().toString() : "";
		String tinh = cbTinhTP.getSelectedIndex() > 0 ? cbTinhTP.getSelectedItem().toString() : "";
		int trangThai = 1;
		int gioiTinh = 1;
		if(cbTrangThai.getSelectedItem().toString().equalsIgnoreCase("Nghỉ việc")) {
			trangThai = 0;
		}
		if(cbGioiTinh.getSelectedItem().toString().equalsIgnoreCase("Nữ")) {
			gioiTinh = 0;
		}
//		int tongNV = nhanVienDao.TongNhanVien();
		int tongNV = nhanVienDao.TongNhanVien(maNV, tenNV, sdt, xa, huyen, tinh, trangThai, gioiTinh, cmnd);
		tongPage = tongNV % 8 == 0 ? tongNV / 8 : (tongNV/8) + 1;
		
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
		if(o.equals(txtMaNV)|| o.equals(txtTenNV)|| o.equals(txtSDT)|| o.equals(txtCMND)) {
			XoasachModelNV();
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
		Object o = e.getSource();
		if (e.getStateChange() == ItemEvent.SELECTED)
			return;
		if(o.equals(cbTinhTP)) {
			cbQuanHuyen.removeAllItems();
			cbQuanHuyen.addItem("Quận/Huyện");
			cbQuanHuyen.setEnabled(true);
			if(cbTinhTP.getSelectedIndex() > 0) {
				String tinh = cbTinhTP.getSelectedItem().toString();
				listQuanHuyen = diaChiDao.getAllHuyenTrongTinhTP(tinh);
				for(String b : listQuanHuyen) {
					cbQuanHuyen.addItem(b);
				}
			}
			else {
				cbQuanHuyen.setEnabled(false);
			}
			XoasachModelNV();
			AddIntable();
			lblSoTrangTable.setText("1");
	
		}
		if(o.equals(cbQuanHuyen)) {
			cbXaPhuong.removeAllItems();
			cbXaPhuong.addItem("Xã/Phường");
			cbXaPhuong.setEnabled(true);
			if(cbQuanHuyen.getSelectedIndex() > 0) {
				String tinh = cbTinhTP.getSelectedItem().toString();
				String huyen = cbQuanHuyen.getSelectedItem().toString();
				listPhuongXa = diaChiDao.getAllPhuongXa(tinh, huyen);
				for(String c : listPhuongXa) {
					cbXaPhuong.addItem(c);
				}
			}
			else {
				cbXaPhuong.setEnabled(false);
			}
			XoasachModelNV();
			AddIntable();
			lblSoTrangTable.setText("1");
		}
		if(o.equals(cbXaPhuong)|| o.equals(cbGioiTinh)|| o.equals(cbTrangThai)) {
			XoasachModelNV();
			AddIntable();
			lblSoTrangTable.setText("1");
		}
	}
	public int TongPage() {
		int tongPage = 1;
		String maNV = txtMaNV.getText();
		String tenNV = txtTenNV.getText();
		String sdt = txtSDT.getText();
		String cmnd = txtCMND.getText();
		String xa = cbXaPhuong.getSelectedIndex() > 0 ? cbXaPhuong.getSelectedItem().toString() : "";
		String huyen = cbQuanHuyen.getSelectedIndex() > 0 ? cbQuanHuyen.getSelectedItem().toString() : "";
		String tinh = cbTinhTP.getSelectedIndex() > 0 ? cbTinhTP.getSelectedItem().toString() : "";
		int trangThai = 1;
		int gioiTinh = 1;
		if(cbTrangThai.getSelectedItem().toString().equalsIgnoreCase("Nghỉ việc")) {
			trangThai = 0;
		}
		if(cbGioiTinh.getSelectedItem().toString().equalsIgnoreCase("Nữ")) {
			gioiTinh = 0;
		}
//		int tongNV = nhanVienDao.TongNhanVien();
		int tongNV = nhanVienDao.TongNhanVien(maNV, tenNV, sdt, xa, huyen, tinh, trangThai, gioiTinh, cmnd);
		tongPage = tongNV % 8 == 0 ? tongNV / 8 : (tongNV/8) + 1;
		return tongPage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		int tongPage = 1;
		String maNV = txtMaNV.getText();
		String tenNV = txtTenNV.getText();
		String sdt = txtSDT.getText();
		String cmnd = txtCMND.getText();
		String xa = cbXaPhuong.getSelectedIndex() > 0 ? cbXaPhuong.getSelectedItem().toString() : "";
		String huyen = cbQuanHuyen.getSelectedIndex() > 0 ? cbQuanHuyen.getSelectedItem().toString() : "";
		String tinh = cbTinhTP.getSelectedIndex() > 0 ? cbTinhTP.getSelectedItem().toString() : "";
		int trangThai = 1;
		int gioiTinh = 1;
		if(cbTrangThai.getSelectedItem().toString().equalsIgnoreCase("Nghỉ việc")) {
			trangThai = 0;
		}
		if(cbGioiTinh.getSelectedItem().toString().equalsIgnoreCase("Nữ")) {
			gioiTinh = 0;
		}
//		int tongNV = nhanVienDao.TongNhanVien();
		int tongNV = nhanVienDao.TongNhanVien(maNV, tenNV, sdt, xa, huyen, tinh, trangThai, gioiTinh, cmnd);
		tongPage = tongNV % 8 == 0 ? tongNV / 8 : (tongNV/8) + 1;
		if(src.equals(btnBack)) {
			int page = Integer.parseInt(lblSoTrangTable.getText());
			if(page > 1) {
				page--;
				lblSoTrangTable.setText(Integer.toString(page));
				lblTongTrang.setText("/" + tongPage);
				XoasachModelNV();
				table.clearSelection();
				AddIntable();
			}
		}
		if (src.equals(btnBackEnd)) {
			int page = Integer.parseInt(lblSoTrangTable.getText());
			if(page != 1) {
				lblSoTrangTable.setText(Integer.toString(1));
				XoasachModelNV();
				table.clearSelection();
				AddIntable();
			}
		}
		if (src.equals(btnNext)) {
			int page = Integer.parseInt(lblSoTrangTable.getText());
			if(page < tongPage) {
				page += 1;
				lblSoTrangTable.setText(Integer.toString(page));
				XoasachModelNV();
				table.clearSelection();
				AddIntable();
				
			}
			else {
				JOptionPane.showMessageDialog(this, "Danh sách nhân viên đã hết");
			}
			
		}
		if (src.equals(btnNextEnd)) {
			int page = Integer.parseInt(lblSoTrangTable.getText());
			if(page != tongPage) {
				lblSoTrangTable.setText(Integer.toString(tongPage));
				XoasachModelNV();
				table.clearSelection();
				AddIntable();
			}
		}
		if (src.equals(btnLamMoi)) {
			Clear();
			XoasachModelNV();
			List<NhanVien> nhanviens = nhanVienDao.getNhanVienTheoPage(0,"","","","","","", 1, 1,"");
			loadTable(nhanviens);
		}
		if(src.equals(btnXemCT)) {
			int n = table.getSelectedRow();
			if(n == -1) {
				JOptionPane.showMessageDialog(this,"Vui lòng chọn nhân viên cần muốn xem chi tiết");
				return;
			}
			String maNhanVien = table.getValueAt(n, 0).toString();
			ChiTietNhanVienJFrameGUI ctNhanVienJframe = new ChiTietNhanVienJFrameGUI(maNhanVien);
			ctNhanVienJframe.setVisible(true);
		}
	}

	private void Clear() {
		table.clearSelection();
		txtMaNV.setText("");
		txtSDT.setText("");
		txtTenNV.setText("");
		cbGioiTinh.setSelectedIndex(0);
		cbTrangThai.setSelectedIndex(0);
		cbTinhTP.setSelectedIndex(0);
		txtCMND.setText("");
		lblSoTrangTable.setText("1");
	}
	public void XoasachModelNV() {
		modelNhanvien.getDataVector().removeAllElements();
		modelNhanvien.fireTableDataChanged();
		table.clearSelection();
		int tongPage = TongPage();
		lblTongTrang.setText("/" + tongPage);
	}
	@SuppressWarnings("unused")
	public void loadTable(List<NhanVien> listNV) {
		for (NhanVien nv : listNV) {
			String gioiTinh = "Nữ";
			if(nv.isGioiTinh()) {
				gioiTinh= "Nam";
			}
			String trangThai = "Nghỉ việc";
			if(nv.isTrangThai()) {
				trangThai = "Đang làm";
			}
			String chucVu = "Nhân Viên";
			if(nv.isChucVu()) {
				chucVu = "Quản lý";
			}
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String date = simpleDateFormat.format(nv.getNgaySinh());
			modelNhanvien.addRow(new Object[] {
					nv.getMaNV(),nv.getHoTen(),gioiTinh,date,nv.getcmnd(),nv.getMatKhau(),nv.getSdt(),trangThai,nv.getDiaChi().getPhuongXa().trim()+"-"+nv.getDiaChi().getQuanHuyen().trim()+"-"+nv.getDiaChi().getTinhTP().trim()
			});
		}
	}
	
	public void AddIntable() {
		int page  = Integer.parseInt(lblSoTrangTable.getText().toString());
		page--;
//String maNV, String tenNV, String sdt, String xa, String huyen, String tinh,int trangThai,int gioiTinh,String cmnd	
		String maNV = txtMaNV.getText().toUpperCase();
		String tenNV = txtTenNV.getText().toUpperCase();
		String sdt = txtSDT.getText().toUpperCase();
		String cmnd = txtCMND.getText().toUpperCase();
		String xa = cbXaPhuong.getSelectedIndex() > 0 ? cbXaPhuong.getSelectedItem().toString().toUpperCase() : "";
		String huyen = cbQuanHuyen.getSelectedIndex() > 0 ? cbQuanHuyen.getSelectedItem().toString().toUpperCase() : "";
		String tinh = cbTinhTP.getSelectedIndex() > 0 ? cbTinhTP.getSelectedItem().toString().toUpperCase() : "";
		int trangThai = 1;
		int gioiTinh = 1;
		if(cbTrangThai.getSelectedItem().toString().equalsIgnoreCase("Nghỉ việc")) {
			trangThai = 0;
		}
		if(cbGioiTinh.getSelectedItem().toString().equalsIgnoreCase("Nữ")) {
			gioiTinh = 0;
		}
		List<NhanVien> list = nhanVienDao.getNhanVienTheoPage(page, maNV, tenNV, sdt, xa, huyen, tinh, trangThai, gioiTinh, cmnd);
		loadTable(list);
		int tongPage = TongPage();
		lblTongTrang.setText("/" + tongPage);
	}
}
