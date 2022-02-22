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
import javax.swing.ListSelectionModel;
//import dao.LoaiSanPhamDao;
//import dao.SanPhamDao;
//import dao.Ipml.LoaiSanPhamImpl;
//import dao.Ipml.SanPhamImpl;
//import entity.Format;
//import entity.SanPham;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.LoaiSanPhamDao;
import dao.SanPhamDao;
import dao.Ipml.LoaiSanPhamImpl;
import dao.Ipml.SanPhamImpl;
import entity.SanPham;
import format.Format;


public class TraCuuSanPhamPnGUI extends JPanel implements ActionListener, MouseListener, KeyListener, ItemListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3244090351375411392L;
	private JTextField txtMa;
	private JTextField txtTen;
	private JComboBox<String> cbNhanHieu;
	private JComboBox<String> cbLoaiSanPham;
	private JButton btnXemChiTiet;
	private JButton btnLamMoi;
	private JButton btnBackEnd;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnNextEnd;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JLabel lblCurentPage;
	private SanPhamDao sanPhamDao;
	private LoaiSanPhamDao loaiSanPhamDao;
	private JLabel lblNhpSt_1;
	private JComboBox<String> cbKichThuoc;
	private JLabel lblNhpSt_1_3;
	private JComboBox<String> cbTrangThaiKD;
	private JLabel lblNewLabel;
	private JLabel lbltoltalPage;

	/**
	 * Create the panel.
	 */
	public TraCuuSanPhamPnGUI() {
		sanPhamDao = new SanPhamImpl();
		loaiSanPhamDao = new LoaiSanPhamImpl();
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
//		setSize(1364, 621);
		setBounds(0, 0, 1364, 621);
		setLayout(null);
		
		JLabel lblMSnPhm = new JLabel("M\u00E3 s\u1EA3n ph\u1EA9m:");
		lblMSnPhm.setFont(new Font("Arial", Font.BOLD, 16));
		lblMSnPhm.setBounds(772, 43, 120, 35);
		add(lblMSnPhm);
		
		JLabel lblTnSnPhm = new JLabel("Tên sản phẩm:");
		lblTnSnPhm.setFont(new Font("Arial", Font.BOLD, 16));
		lblTnSnPhm.setBounds(10, 43, 120, 35);
		add(lblTnSnPhm);
		
		JLabel lblNhpSt_1_1 = new JLabel("Nh\u00E3n hi\u1EC7u:");
		lblNhpSt_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1.setBounds(10, 90, 87, 35);
		add(lblNhpSt_1_1);
		
		JLabel lblNhpSt_1_2 = new JLabel("Lo\u1EA1i s\u1EA3n ph\u1EA9m:");
		lblNhpSt_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_2.setBounds(337, 90, 120, 35);
		add(lblNhpSt_1_2);
		
		txtMa = new JTextField();
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMa.setColumns(10);
		txtMa.setBounds(917, 43, 437, 35);
		add(txtMa);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTen.setColumns(10);
		txtTen.setBounds(140, 46, 488, 35);
		add(txtTen);
		
		cbNhanHieu = new JComboBox<String>();
		cbNhanHieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbNhanHieu.setBackground(Color.WHITE);
		cbNhanHieu.setBounds(140, 92, 150, 35);
		add(cbNhanHieu);
		
		cbLoaiSanPham = new JComboBox<String>();
		cbLoaiSanPham.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbLoaiSanPham.setBackground(Color.WHITE);
		cbLoaiSanPham.setBounds(478, 92, 150, 35);
		add(cbLoaiSanPham);
		
		btnXemChiTiet = new JButton("Xem chi ti\u1EBFt");
		btnXemChiTiet.setIcon(new ImageIcon(TraCuuSanPhamPnGUI.class.getResource("/img/view-details.png")));
		btnXemChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXemChiTiet.setBounds(917, 137, 150, 35);
		add(btnXemChiTiet);
		
		btnLamMoi = new JButton("L\u00E0m m\u1EDBi");
		btnLamMoi.setIcon(new ImageIcon(TraCuuSanPhamPnGUI.class.getResource("/img/lam_moi.png")));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLamMoi.setBounds(1204, 137, 150, 35);
		add(btnLamMoi);
		
		btnBackEnd = new JButton("");
		btnBackEnd.setIcon(new ImageIcon(TraCuuSanPhamPnGUI.class.getResource("/img/previousEnd.png")));
		btnBackEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBackEnd.setBounds(405, 582, 104, 29);
		add(btnBackEnd);
		
		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(TraCuuSanPhamPnGUI.class.getResource("/img/rewind-button.png")));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(519, 582, 104, 29);
		add(btnBack);
		
		btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon(TraCuuSanPhamPnGUI.class.getResource("/img/nextbutton.png")));
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNext.setBounds(765, 582, 104, 29);
		add(btnNext);
		
		btnNextEnd = new JButton("");
		btnNextEnd.setIcon(new ImageIcon(TraCuuSanPhamPnGUI.class.getResource("/img/next.png")));
		btnNextEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNextEnd.setBounds(879, 582, 104, 29);
		add(btnNextEnd);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 182, 1344, 379);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setRowHeight(35);
		table.setModel(tableModel = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã sản phẩm", "Tên sản phẩm","Kích thước","Chất liệu", "Loại sản phẩm", "Nhãn hiệu", "Số lượng", "Giá bán", "Trạng thái kinh doanh"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		scrollPane.setViewportView(table);
		
		lblCurentPage = new JLabel("1");
		lblCurentPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurentPage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCurentPage.setBounds(648, 583, 36, 28);
		add(lblCurentPage);
		
		lblNhpSt_1 = new JLabel("Kích thước");
		lblNhpSt_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1.setBounds(785, 88, 87, 35);
		add(lblNhpSt_1);
		
		cbKichThuoc = new JComboBox<String>();
		cbKichThuoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbKichThuoc.setBackground(Color.WHITE);
		cbKichThuoc.setBounds(917, 90, 150, 35);
		add(cbKichThuoc);
		
		lblNhpSt_1_3 = new JLabel("Trạng thái KD");
		lblNhpSt_1_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_3.setBounds(1090, 90, 112, 35);
		add(lblNhpSt_1_3);
		
		cbTrangThaiKD = new JComboBox<String>();
		cbTrangThaiKD.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbTrangThaiKD.setBackground(Color.WHITE);
		cbTrangThaiKD.setBounds(1204, 90, 150, 35);
		add(cbTrangThaiKD);
		
		lblNewLabel = new JLabel("TRA CỨU SẢN PHẨM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(0, 0, 1364, 33);
		add(lblNewLabel);
		
		lbltoltalPage = new JLabel("");
		lbltoltalPage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbltoltalPage.setBounds(694, 582, 61, 29);
		add(lbltoltalPage);
		
		List<SanPham> sanPhams = sanPhamDao.getDanhSachSanPham(0,10,"","","","","","",true);
		loadTable(sanPhams);
		cbTrangThaiKD.addItem("Kinh doanh");
		cbTrangThaiKD.addItem("Ngừng bán");
		loadComBoBox(cbLoaiSanPham, loaiSanPhamDao.getDanhSachLoai());
		loadComBoBox(cbNhanHieu, sanPhamDao.getDanhSachNhanHieu());
		cbKichThuoc.addItem("Tất cả");
		List<String> kichThuocList = sanPhamDao.getKichThuoc();
		for (String string : kichThuocList) {
			if(!string.equals("")) {
				cbKichThuoc.addItem(string);
			}
		}
		
		btnBack.addActionListener(this);
		btnBackEnd.addActionListener(this);
		btnNextEnd.addActionListener(this);
		btnNext.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnXemChiTiet.addActionListener(this);
		cbLoaiSanPham.addActionListener(this);
		cbNhanHieu.addActionListener(this);
		cbKichThuoc.addActionListener(this);
		cbTrangThaiKD.addActionListener(this);
		
//		cbKichThuoc.addItemListener(this);
//		cbLoaiSanPham.addItemListener(this);
//		cbNhanHieu.addItemListener(this);
//		cbTrangThaiKD.addItemListener(this);
		
		txtTen.addKeyListener(this);
		txtMa.addKeyListener(this);
		txtMa.addMouseListener(this);
		table.addMouseListener(this);
		
		
		lbltoltalPage.setText(String.valueOf("/"+tinhPage()));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setDefaultEditor(Object.class, null);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(4).setPreferredWidth(30);
		table.getColumnModel().getColumn(6).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
	}

	public void loadTable(List<SanPham> sanPhams) {
		for (SanPham sanPham : sanPhams) {
			tableModel.addRow(new Object[] {sanPham.getMaSP(), sanPham.getTenSP(),sanPham.getKichThuoc(),sanPham.getChatLieu(), sanPham.getLoaiSanPham().getTenLoai(),sanPham.getNhanHieu(), sanPham.getSoLuong(), Format.chuyenDoiTienTe(sanPham.getDonGia()), sanPham.isTrangThaiKD() ? "Đang kinh doanh" : "Ngừng kinh doanh"});
		}
	}
	
	public void loadComBoBox(JComboBox<String> cb ,List<String> list) {
		cb.addItem("Tất cả");
		for (String item : list) {
			cb.addItem(item);
		}
	}
	
	
	public void xoaToanBoban() {
		tableModel.getDataVector().removeAllElements();
		tableModel.fireTableDataChanged();
	}
	
	public void addInToTable() {
		int page = Integer.parseInt(lblCurentPage.getText().toString());
		String tenSanPham = txtTen.getText().trim().replace(' ','%');
		String  maSanPham = txtMa.getText();
		String nhanHieu = cbNhanHieu.getSelectedIndex() > 0 ? cbNhanHieu.getSelectedItem().toString() : "";
		String loaiSanPham = cbLoaiSanPham.getSelectedIndex() > 0 ? cbLoaiSanPham.getSelectedItem().toString() : "";
		String kichThuoc = cbKichThuoc.getSelectedIndex() > 0 ? cbKichThuoc.getSelectedItem().toString() : "";
		boolean trangThai =  cbTrangThaiKD.getSelectedIndex() == 0 ? true : false;
		List<SanPham> list = sanPhamDao.getDanhSachSanPham(page-1,10, tenSanPham, nhanHieu, maSanPham, loaiSanPham, kichThuoc,"", trangThai);
		loadTable(list);
	}
	
	public void clearTextField() {
		txtMa.setText("");
		txtTen.setText("");
		cbLoaiSanPham.setSelectedIndex(0);
		cbNhanHieu.setSelectedIndex(0);
		cbKichThuoc.setSelectedIndex(0);
		cbTrangThaiKD.setSelectedIndex(0);
	}
	
	public int tinhPage() {
		int tongPage = 1;
		String tenSanPham = txtTen.getText().replace(' ','%');
		String  maSanPham = txtMa.getText();
		String nhanHieu = cbNhanHieu.getSelectedIndex() > 0 ? cbNhanHieu.getSelectedItem().toString() : "";
		String loaiSanPham = cbLoaiSanPham.getSelectedIndex() > 0 ? cbLoaiSanPham.getSelectedItem().toString() : "";
		String kichThuoc = cbKichThuoc.getSelectedIndex() > 0 ? cbKichThuoc.getSelectedItem().toString() : "";
		boolean traThai =  cbTrangThaiKD.getSelectedIndex() == 0 ? true : false;
		int tongHang = sanPhamDao.tongSoHang(tenSanPham, nhanHieu, maSanPham, loaiSanPham, kichThuoc, "", traThai);
		tongPage = tongHang % 10 == 0 ? tongHang / 10 : (tongHang/10)+1;
		return tongPage;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int tongPage = tinhPage();
		
		
		Object o = e.getSource();
		if(o.equals(btnXemChiTiet)) {
			int n = table.getSelectedRow();
			if(n == -1) {
				JOptionPane.showMessageDialog(this,"Vui lòng chọn sản phẩm cần xem chi tiết");
				return;
			}
			String maSp = table.getValueAt(n, 0).toString();
			ChiTietSanPhamJFrameGUI ctPhamJFrame = new ChiTietSanPhamJFrameGUI(maSp);
			ctPhamJFrame.setVisible(true);
		}
		
		if (o.equals(btnNext)) {

			int page = Integer.parseInt(lblCurentPage.getText());

			if (page < tongPage) {
				page+=1;
				lblCurentPage.setText(Integer.toString(page));
				xoaToanBoban();
				table.clearSelection();
				addInToTable();
			}

		}
		if (o.equals(btnBack)) {
			int page = Integer.parseInt(lblCurentPage.getText());
			if (page > 1) {
				page -=1;
				lblCurentPage.setText(Integer.toString(page));
				xoaToanBoban();
				table.clearSelection();
				addInToTable();
			}
		}

		if (o.equals(btnNextEnd)) {
			int page = Integer.parseInt(lblCurentPage.getText());
			if (page != tongPage) {
				lblCurentPage.setText(Integer.toString(tongPage));
				xoaToanBoban();
				table.clearSelection();
				addInToTable();
			}
		}

		if (o.equals(btnBackEnd)) {
			int page = Integer.parseInt(lblCurentPage.getText());
			if (page != 1) {
				lblCurentPage.setText(Integer.toString(1));
				xoaToanBoban();
				table.clearSelection();
				addInToTable();
			}
		}
		
		if(o.equals(cbNhanHieu) || o.equals(cbLoaiSanPham) || o.equals(cbKichThuoc) || o.equals(cbTrangThaiKD)) {
			if(cbLoaiSanPham.getSelectedItem().toString().equals("Nón") || cbLoaiSanPham.getSelectedItem().toString().equals("Túi xách")) {
				cbKichThuoc.setSelectedIndex(0);
			}
			
			lblCurentPage.setText("1");
			lbltoltalPage.setText(String.valueOf("/"+tinhPage()));
			xoaToanBoban();
			addInToTable();
		}
		
		
		
		
		
		if(o.equals(btnLamMoi)) {
			xoaToanBoban();
			lblCurentPage.setText("1");
			clearTextField();
//			addInToTable();

		}
		
//		if(o.equals(btnNgungBan)) {
//			int row = table.getSelectedRow();
//			if(row == -1) {
//				JOptionPane.showMessageDialog(this,"Vui lòng chọn sản phẩm cần cập nhật trạng thái");
//				return;
//			} else {
//				int xacNhan = JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật trạng thái kinh doanh không không","Thông báo",JOptionPane.YES_NO_OPTION);
//				if(xacNhan == JOptionPane.YES_OPTION) {					
//					SanPham sanPham = sanPhamDao.getSanPhamById(table.getValueAt(row, 0).toString());
//					boolean trangThai = sanPham.isTrangThaiKD();
//					sanPham.setTrangThaiKD(!trangThai);
//					sanPhamDao.update(sanPham);
//					table.setValueAt(trangThai ? "Ngừng kinh doanh" : "Đang kinh doanh", row, 6);
//				}
//			}
//		}
		
//		if(o.equals(btnSua)) {
//			int row = table.getSelectedRow();
//			if(row == -1) {
//				JOptionPane.showMessageDialog(this,"Vui lòng chọn sản phẩm cần sửa");
//				return;
//			}
//			else {
//				String id = table.getValueAt(row, 0).toString();
//				new SuaSanPhamJFrame(id).setVisible(true);
//			}
//		}
		
		
		
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
		if(o.equals(txtTen) || o.equals(txtMa)) {
			lblCurentPage.setText("1");
			lbltoltalPage.setText(String.valueOf("/"+tinhPage()));
			xoaToanBoban();
			addInToTable();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		btnNgungBan.setIcon(new ImageIcon(SanPhamPn.class.getResource("/img/stopping.png")));
//		Object o = e.getSource();
//		int row = table.getSelectedRow();
//		SanPham sanPham = sanPhamDao.getSanPhamById(table.getValueAt(row, 0).toString());
//		if(sanPham.isTrangThaiKD()) {
//			btnNgungBan.setText("Ngừng KD");
//			btnNgungBan.setIcon(new ImageIcon(TimKiemSanPhamPn.class.getResource("/img/stopping.png")));
//		} else {
//			btnNgungBan.setText("Kinh doanh");
//			btnNgungBan.setIcon(new ImageIcon(TimKiemSanPhamPn.class.getResource("/img/money-bag.png")));
//		}
		
		
		
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
//		Object o = e.getSource();
//		if (e.getStateChange() == ItemEvent.SELECTED)
//			return;
//		if(o.equals(cbNhanHieu) || o.equals(cbLoaiSanPham) || o.equals(cbKichThuoc) || o.equals(cbTrangThaiKD)) {
//			if(cbLoaiSanPham.getSelectedItem().toString().equals("Nón")) {
//				cbKichThuoc.setSelectedIndex(0);
//			}
//			
//			lblCurentPage.setText("1");
//			lbltoltalPage.setText(String.valueOf("/"+tinhPage()));
//			xoaToanBoban();
//			addInToTable();
//		}
		
	}
}
