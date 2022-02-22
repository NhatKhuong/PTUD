package gui;

import static javax.swing.JFileChooser.APPROVE_OPTION;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import dao.LoaiSanPhamDao;
import dao.SanPhamDao;
import dao.Ipml.LoaiSanPhamImpl;
import dao.Ipml.SanPhamImpl;
import entity.SanPham;
import format.Format;

public class CapNhatSanPhamPnGUI extends JPanel implements ActionListener, MouseListener, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4467874837816618032L;
	private JTextField txtTimMa;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtNhanHieu;
	private JTextField txtChatLieu;
	private JTextField txtGia;
	private JTable table;
	private JTextField txtTimTen;
	private JComboBox<String> cbTimTrangThai;
	private JButton btnLamMoi;
	private JButton btnCapNhat;
	private JComboBox<String> cbLoai;
	private JComboBox<String> cbTrangThai;
	private JButton btnChonAnh;
	private DefaultTableModel modelTable;
	
	private SanPhamDao sanPhamDao;
	private LoaiSanPhamDao loaiSanPhamDao;
	
	private JButton btnBackEnd;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnNextEnd;
	private JLabel lblPageCurrent;
	private JLabel lblPageTotal;
	private JComboBox<String> cbKichThuoc;
	private JButton btnKhoiPhuc;
	private JLabel lblHinhAnh;
	private File f;
	private JTextField txtMau;

	/**
	 * Create the panel.
	 */
	public CapNhatSanPhamPnGUI() {
		loaiSanPhamDao = new LoaiSanPhamImpl();
		sanPhamDao = new SanPhamImpl();
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setBounds(0, 0, 1364, 621);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CẬP NHẬT SẢN PHẨM");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(0, 0, 1364, 49);
		add(lblNewLabel_1);
		
		btnChonAnh = new JButton("Chọn ảnh");
		btnChonAnh.setIcon(new ImageIcon(CapNhatSanPhamPnGUI.class.getResource("/img/open-folder.png")));
		btnChonAnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChonAnh.setBounds(133, 265, 132, 35);
		add(btnChonAnh);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã sản phẩm");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(401, 70, 109, 27);
		add(lblNewLabel_1_1);
		
		txtMa = new JTextField();
		txtMa.setText((String) null);
		txtMa.setForeground(Color.RED);
		txtMa.setFont(new Font("Tahoma", Font.ITALIC, 16));
		txtMa.setEnabled(false);
		txtMa.setColumns(10);
		txtMa.setBounds(533, 70, 300, 35);
		add(txtMa);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tên sản phẩm");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(944, 70, 109, 27);
		add(lblNewLabel_1_1_1);
		
		txtTen = new JTextField();
		txtTen.setText((String) null);
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTen.setColumns(10);
		txtTen.setBounds(1054, 70, 300, 35);
		add(txtTen);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nhãn hiệu");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(401, 123, 72, 27);
		add(lblNewLabel_1_3);
		
		txtNhanHieu = new JTextField();
		txtNhanHieu.setText((String) null);
		txtNhanHieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNhanHieu.setColumns(10);
		txtNhanHieu.setBounds(533, 123, 300, 35);
		add(txtNhanHieu);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Chất liệu");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3_2.setBounds(944, 123, 81, 27);
		add(lblNewLabel_1_3_2);
		
		txtChatLieu = new JTextField();
		txtChatLieu.setText((String) null);
		txtChatLieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtChatLieu.setColumns(10);
		txtChatLieu.setBounds(1054, 123, 300, 35);
		add(txtChatLieu);
		
		JLabel lblNewLabel_1_2 = new JLabel("Loại sản phẩm");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(401, 177, 109, 27);
		add(lblNewLabel_1_2);
		
		cbLoai = new JComboBox<String>();
		cbLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbLoai.setBounds(533, 177, 300, 35);
		add(cbLoai);
		
		JLabel lblNewLabel_1_4 = new JLabel("Kích thước");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(944, 177, 81, 27);
		add(lblNewLabel_1_4);
		
		cbKichThuoc = new JComboBox<String>();
		cbKichThuoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbKichThuoc.setBounds(1054, 177, 92, 35);
		add(cbKichThuoc);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Trạng thái KD");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(401, 232, 109, 27);
		add(lblNewLabel_1_2_1);
		
		cbTrangThai = new JComboBox<String>();
		cbTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbTrangThai.setBounds(533, 232, 300, 35);
		add(cbTrangThai);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Giá");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3_1.setBounds(944, 232, 31, 27);
		add(lblNewLabel_1_3_1);
		
		txtGia = new JTextField();
		txtGia.setForeground(Color.RED);
		txtGia.setFont(new Font("Tahoma", Font.ITALIC, 16));
		txtGia.setColumns(10);
		txtGia.setBounds(1054, 232, 300, 35);
		add(txtGia);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 319, 1344, 66);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblMSnPhm = new JLabel("Mã sản phẩm:");
		lblMSnPhm.setBounds(21, 20, 120, 35);
		panel.add(lblMSnPhm);
		lblMSnPhm.setFont(new Font("Arial", Font.BOLD, 16));
		
		txtTimMa = new JTextField();
		txtTimMa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimMa.setBounds(151, 17, 195, 35);
		panel.add(txtTimMa);
		txtTimMa.setColumns(10);
		
		JLabel lblNhpSt_1_4 = new JLabel("Trạng thái kinh doanh");
		lblNhpSt_1_4.setBounds(750, 20, 181, 35);
		panel.add(lblNhpSt_1_4);
		lblNhpSt_1_4.setFont(new Font("Arial", Font.BOLD, 16));
		
		cbTimTrangThai = new JComboBox<String>();
		cbTimTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbTimTrangThai.setBounds(941, 17, 173, 35);
		panel.add(cbTimTrangThai);
		cbTimTrangThai.setBackground(Color.WHITE);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBounds(1209, 15, 125, 35);
		panel.add(btnLamMoi);
		btnLamMoi.setIcon(new ImageIcon(CapNhatSanPhamPnGUI.class.getResource("/img/lam_moi.png")));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblTnSnPhm = new JLabel("Tên sản phẩm:");
		lblTnSnPhm.setFont(new Font("Arial", Font.BOLD, 16));
		lblTnSnPhm.setBounds(393, 20, 120, 35);
		panel.add(lblTnSnPhm);
		
		txtTimTen = new JTextField();
		txtTimTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimTen.setColumns(10);
		txtTimTen.setBounds(523, 17, 195, 35);
		panel.add(txtTimTen);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 395, 1344, 180);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(modelTable = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Lo\u1EA1i s\u1EA3n ph\u1EA9n", "Nh\u00E3n hi\u1EC7u", "K\u00EDch th\u01B0\u1EDBc", "Ch\u1EA5t li\u1EC7u", "Tr\u1EA1ng th\u00E1i kinh doanh", "Gi\u00E1"
			}
		));
		scrollPane.setViewportView(table);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setIcon(new ImageIcon(CapNhatSanPhamPnGUI.class.getResource("/img/update.png")));
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCapNhat.setBounds(1218, 277, 125, 35);
		add(btnCapNhat);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(75, 29, 251, 226);
		add(panel_1);
		panel_1.setLayout(null);
		
		lblHinhAnh = new JLabel("");
		lblHinhAnh.setBounds(0, 0, 251, 226);
		panel_1.add(lblHinhAnh);
		
		btnKhoiPhuc = new JButton("Khôi phục");
		btnKhoiPhuc.setIcon(new ImageIcon(CapNhatSanPhamPnGUI.class.getResource("/img/back.png")));
		btnKhoiPhuc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhoiPhuc.setBounds(1054, 277, 125, 35);
		add(btnKhoiPhuc);
		
		table.setRowHeight(30);
		
		btnBackEnd = new JButton("");
		btnBackEnd.setIcon(new ImageIcon(CapNhatSanPhamPnGUI.class.getResource("/img/previousEnd.png")));
		btnBackEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBackEnd.setBounds(401, 582, 92, 29);
		add(btnBackEnd);
		
		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(CapNhatSanPhamPnGUI.class.getResource("/img/rewind-button.png")));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(503, 582, 92, 29);
		add(btnBack);
		
		lblPageCurrent = new JLabel("1");
		lblPageCurrent.setHorizontalAlignment(SwingConstants.CENTER);
		lblPageCurrent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPageCurrent.setBounds(605, 581, 36, 30);
		add(lblPageCurrent);
		
		lblPageTotal = new JLabel("/0");
		lblPageTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPageTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPageTotal.setBounds(651, 581, 36, 30);
		add(lblPageTotal);
		
		btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon(CapNhatSanPhamPnGUI.class.getResource("/img/forward-button.png")));
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNext.setBounds(708, 582, 92, 29);
		add(btnNext);
		
		btnNextEnd = new JButton("");
		btnNextEnd.setIcon(new ImageIcon(CapNhatSanPhamPnGUI.class.getResource("/img/next.png")));
		btnNextEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNextEnd.setBounds(810, 582, 92, 29);
		add(btnNextEnd);
		
		cbTimTrangThai.addItem("Kinh doanh");
		cbTimTrangThai.addItem("Ngừng kinh doanh");
		
		cbTrangThai.addItem("Kinh doanh");
		cbTrangThai.addItem("Ngừng kinh doanh");
		loadComBoBox(cbLoai, loaiSanPhamDao.getDanhSachLoai());
//		cbKichThuoc.addItem("Tất cả");
		List<String> kichThuocList = sanPhamDao.getKichThuoc();
		for (String string : kichThuocList) {
			if(!string.equals("")) {
				cbKichThuoc.addItem(string);
			}
		}
		cbKichThuoc.setSelectedItem(null);
		cbLoai.setSelectedItem(null);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		
		btnLamMoi.addActionListener(this);
		btnBack.addActionListener(this);
		btnBackEnd.addActionListener(this);
		btnNext.addActionListener(this);
		btnNextEnd.addActionListener(this);
		txtTimMa.addKeyListener(this);
		txtTimTen.addKeyListener(this);
		cbTimTrangThai.addActionListener(this);
		table.addMouseListener(this);
		btnKhoiPhuc.addActionListener(this);
		btnChonAnh.addActionListener(this);
		btnCapNhat.addActionListener(this);
		
		List<SanPham> sanPhams = sanPhamDao.getDanhSachSanPham(0,5,"","","","","","",true);
		loadTable(sanPhams);
		lblPageTotal.setText(String.valueOf("/"+tinhPage()));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("Màu sắc");
		lblNewLabel_1_3_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3_3.setBounds(1161, 181, 72, 27);
		add(lblNewLabel_1_3_3);
		
		txtMau = new JTextField();
		txtMau.setText((String) null);
		txtMau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMau.setColumns(10);
		txtMau.setBounds(1243, 177, 108, 35);
		add(txtMau);
		table.setDefaultEditor(Object.class, null);
	}
	
	public void clear() {
		txtChatLieu.setText("");
		txtGia.setText("");
		txtMa.setText("");
		txtNhanHieu.setText("");
		txtTen.setText("");
		cbKichThuoc.setSelectedItem(null);
		cbLoai.setSelectedItem(null);
		cbTrangThai.setSelectedItem(null);
		
	}
	
	public void loadTable(List<SanPham> list) {
		System.out.println(list);
		for (SanPham sanPham : list) {
			modelTable.addRow(new Object [] {sanPham.getMaSP() , sanPham.getTenSP(), sanPham.getLoaiSanPham().getTenLoai(), sanPham.getNhanHieu(), sanPham.getKichThuoc(), sanPham.getChatLieu(), sanPham.isTrangThaiKD() ? "Đang kinh doanh" : "Ngừng kinh doanh", Format.chuyenDoiTienTe(sanPham.getDonGia())});
		}
	}
	
	public void xoaToanBoBan() {
		modelTable.getDataVector().removeAllElements();
		modelTable.fireTableDataChanged();
		table.clearSelection();
	}
	
	public void addInToTable() {
		int page = Integer.parseInt(lblPageCurrent.getText());
		String tenSanPham = txtTimTen.getText().trim().replace(' ','%');
		String  maSanPham = txtTimMa.getText();
		boolean trangThai =  cbTimTrangThai.getSelectedIndex() == 0 ? true : false;
		List<SanPham> list = sanPhamDao.getDanhSachSanPham(page-1,5, tenSanPham,"", maSanPham,"","","", trangThai);
		loadTable(list);
	}
	
	public void loadComBoBox(JComboBox<String> cb ,List<String> list) {
		for (String item : list) {
			cb.addItem(item);
		}
	}
	
	public int tinhPage() {
		int tongPage = 1;
		String tenSanPham = txtTimTen.getText().replace(' ','%');
		String  maSanPham = txtTimMa.getText();
		boolean trangThai =  cbTimTrangThai.getSelectedIndex() == 0 ? true : false;
		int tongHang = sanPhamDao.tongSoHang(tenSanPham,"", maSanPham,"","", "", trangThai);
		tongPage = tongHang % 5 == 0 ? tongHang / 5 : (tongHang/5)+1;
		return tongPage;
	}
	
	public void selectAndFocus(JTextField txt) {
		txt.requestFocus();
		txt.selectAll();
	}
	
	public boolean kiemTra() {
		if(table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this,"Vui lòng chọn sản phẩm cần cập nhật");
			return false;
		}
		
		if(txtNhanHieu.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Nhãn hiệu không được rỗng");
			selectAndFocus(txtNhanHieu);
			return false;
		}
		
		if(cbLoai.getSelectedItem().equals(null)) {
			JOptionPane.showMessageDialog(this,"Vui lòng chọn loại sản phẩm");
			return false;
		}
		
		if(txtTen.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Tên sản phẩm không được rỗng");
			selectAndFocus(txtTen);
			return false;
		}
		
		if(txtChatLieu.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Chất liệu không được rỗng");
			selectAndFocus(txtChatLieu);
			return false;
		}
		
		if(cbKichThuoc.getSelectedItem().equals(null)) {
			JOptionPane.showMessageDialog(this,"Vui lòng chọn kích thước sản phẩm");
			return false;
		}
		
		if(txtMau.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Màu sắc không được rỗng");
			selectAndFocus(txtChatLieu);
			return false;
		}
		
		try {
			Double.parseDouble(txtGia.getText());
			if(Double.parseDouble(txtGia.getText()) <= 0) {
				JOptionPane.showMessageDialog(this,"Giá sản phẩm là số dương");
				selectAndFocus(txtGia);
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Giá sản phẩm là số dương");
			selectAndFocus(txtGia);
			return false;
		}
		return true;
	}
	
	
	public void setTextFiled(SanPham sanPham) {
		txtMa.setText(sanPham.getMaSP());
		txtChatLieu.setText(sanPham.getChatLieu());
		txtGia.setText(String.format("%.0f", sanPham.getDonGia()));
		txtNhanHieu.setText(sanPham.getNhanHieu());
		txtTen.setText(sanPham.getTenSP());
		cbLoai.setSelectedItem(sanPham.getLoaiSanPham().getTenLoai());
		cbTrangThai.setSelectedIndex(sanPham.isTrangThaiKD() ? 0 : 1);
		cbKichThuoc.setSelectedItem(sanPham.getKichThuoc());
		txtMau.setText(sanPham.getMauSac());
		
		
		String picName = sanPham.getHinhAnh();
		String picPath = "imgSanPham//"+picName+"";
		
		BufferedImage bImage = scaleImage(lblHinhAnh.getWidth(),lblHinhAnh.getHeight(), picPath);
		ImageIcon icon = new ImageIcon(bImage);
		lblHinhAnh.setIcon(icon);
	}
	
	public BufferedImage scaleImage(int WIDTH, int HEIGHT, String filename) {
	    BufferedImage bi = null;
	    try {
	        ImageIcon ii = new ImageIcon(filename);//path to image
	        bi = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2d = (Graphics2D) bi.createGraphics();
	        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
	        g2d.drawImage(ii.getImage(), 0, 0, WIDTH, HEIGHT, null);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	    return bi;
	}
	
	
	@SuppressWarnings("resource")
	public boolean coppyImg(String name, File img) {
		try {			
			FileInputStream in = new FileInputStream(img);
			FileOutputStream out = new FileOutputStream(new File("imgSanPham//"+name));
			  int length;
	            byte[] buffer = new byte[1024];
	            while ((length = in.read(buffer)) > 0) {
	                out.write(buffer, 0, length);
	            }
			
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public String getNameByPath(String path) {
		int index = path.lastIndexOf("\\");
		String name = path.substring(index+1);	
		return name;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int tongPage = tinhPage();
		Object o = e.getSource();
		
		if(o.equals(btnChonAnh)) {
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Hinh anh","jpg","png");
			fileChooser.setFileFilter(extensionFilter);
			fileChooser.setMultiSelectionEnabled(false);
			int x = fileChooser.showDialog(this, "Chọn file");
			if(x == APPROVE_OPTION) {
				f = fileChooser.getSelectedFile();
				BufferedImage bImage = scaleImage(lblHinhAnh.getWidth(),lblHinhAnh.getHeight(), f.getAbsolutePath());
				ImageIcon icon = new ImageIcon(bImage);
				lblHinhAnh.setIcon(icon);
			}
		}
		
		if(o.equals(btnKhoiPhuc)) {
			SanPham sanPham = sanPhamDao.getSanPhamById(txtMa.getText());
			setTextFiled(sanPham);
		}
		
		if(o.equals(btnCapNhat)) {
			if(kiemTra()){
				int n = JOptionPane.showConfirmDialog(this,"Bạn có muốn cập nhật sản phẩm không","Thông báo",JOptionPane.YES_NO_OPTION);
				if(n == JOptionPane.YES_NO_OPTION) {
					SanPham sanPham = sanPhamDao.getSanPhamById(txtMa.getText());
					String tenSP = txtTen.getText();
					String nhanHieu = txtNhanHieu.getText();
					double gia = Double.parseDouble(txtGia.getText());
					String LoaiSP = cbLoai.getSelectedItem().toString();
					String kichThuoc = cbKichThuoc.getSelectedItem().toString();
					boolean trangThai = cbTrangThai.getSelectedItem().toString().equals("Kinh doanh") ? true : false;
					String chatLieu = txtChatLieu.getText();
					String picName = sanPham.getHinhAnh();
					String mau = txtMau.getText();
					if(f != null) {
						picName = getNameByPath(f.getAbsolutePath());
						coppyImg(picName,f);
						File imgOld = new File("imgSanPham//"+sanPham.getHinhAnh().trim());
						imgOld.delete();
						f = null;
					}
					
					sanPham.setChatLieu(chatLieu);
					sanPham.setDonGia(gia);
					sanPham.setHinhAnh(picName);
					sanPham.setKichThuoc(kichThuoc);
					sanPham.setLoaiSanPham(loaiSanPhamDao.getLoaiSanPhamByName(LoaiSP));
					sanPham.setNhanHieu(nhanHieu);
					sanPham.setTenSP(tenSP);
					sanPham.setTrangThaiKD(trangThai);
					sanPham.setMauSac(mau);
					
					Boolean kq =  sanPhamDao.update(sanPham);
					if(kq) {
						JOptionPane.showMessageDialog(this,"Sửa thành công");
						xoaToanBoBan();
						addInToTable();	
						
					}else {
						JOptionPane.showMessageDialog(this,"Sửa thất bại công");
					}
				}
			}
		}
		
		if (o.equals(btnNext)) {

			int page = Integer.parseInt(lblPageCurrent.getText());

			if (page < tongPage) {
				page+=1;
				lblPageCurrent.setText(Integer.toString(page));
				xoaToanBoBan();
				table.clearSelection();
				addInToTable();
			}

		}
		if (o.equals(btnBack)) {
			int page = Integer.parseInt(lblPageCurrent.getText());
			if (page > 1) {
				page -=1;
				lblPageCurrent.setText(Integer.toString(page));
				xoaToanBoBan();
				table.clearSelection();
				addInToTable();
			}
		}

		if (o.equals(btnNextEnd)) {
			int page = Integer.parseInt(lblPageCurrent.getText());
			if (page != tongPage) {
				lblPageCurrent.setText(Integer.toString(tongPage));
				xoaToanBoBan();
				table.clearSelection();
				addInToTable();
			}
		}

		if (o.equals(btnBackEnd)) {
			int page = Integer.parseInt(lblPageCurrent.getText());
			if (page != 1) {
				lblPageCurrent.setText(Integer.toString(1));
				xoaToanBoBan();
				table.clearSelection();
				addInToTable();
			}
		}
		
		if(o.equals(cbTimTrangThai)) {
			lblPageCurrent.setText("1");
			lblPageTotal.setText(String.valueOf("/"+tinhPage()));
			xoaToanBoBan();
			addInToTable();
				
		}
		
		if(o.equals(btnLamMoi)) {
			xoaToanBoBan();
			txtTimMa.setText("");
			txtTimTen.setText("");
			cbTimTrangThai.setSelectedIndex(0);
			clear();
			lblHinhAnh.setIcon(null);
		}
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
		if(o.equals(txtTimMa) || o.equals(txtTimTen)) {
			lblPageCurrent.setText("1");
			lblPageTotal.setText(String.valueOf("/"+tinhPage()));
			xoaToanBoBan();
			addInToTable();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(table)) {
			int row = table.getSelectedRow();
			SanPham sanPham = sanPhamDao.getSanPhamById(table.getValueAt(row,0).toString());
			setTextFiled(sanPham);
			
			
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
}
