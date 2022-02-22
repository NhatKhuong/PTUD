package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import dao.CT_HoaDonDao;
import dao.HoaDonDao;
import dao.KhachHangDao;
import dao.SanPhamDao;
import dao.Ipml.CT_HoaDonImpl;
import dao.Ipml.HoaDonImpl;
import dao.Ipml.KhachHangImpl;
import dao.Ipml.LoaiSanPhamImpl;
import dao.Ipml.NhanVienImpl;
import dao.Ipml.SanPhamImpl;
import entity.CT_HoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;
import format.Format;

public class LapHoaDonPnGUI extends JPanel implements ActionListener, MouseListener, KeyListener, ItemListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5510480312680485215L;
	private JTextField txtTen;
	private JTextField txtSoLuong;
	private JTable tableCuaHang;
	private JTable tableGioHang;
	private JTextField txtTienNhan;
	private JTextField txtSdt;
	private JButton btnXemChiTiet;
	private JButton btnLamMoi;
	private JButton btnBackEnd;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnNextEnd;
	private JLabel lblPageCurrent;
	private JLabel lblPageTotal;
	private JButton btnThemVaoGioHang;
	private JLabel lblKhachHang;
	private JLabel lblNgayLapHD;
	private JLabel lblMaHoaDon;
	private JLabel lblNhanVien;
	private JLabel lblTongTien;
	private JButton btnHuy;
	private JButton btnThanhToan;
	private JCheckBox chckXuatHoaDon;
	private JLabel lblKiemTraTien;
	private JButton btnThemKH;
	private DefaultTableModel modelCuaHang;
	private DefaultTableModel modelGioHang;
	
	private SanPhamDao sanPhamDao;
	private KhachHangDao khachHangDao;
	private HoaDonDao hoaDonDao;
	private CT_HoaDonDao ct_HoaDonDao;
	private List<SanPham> listGioHang;
	private JLabel lblTienThua;
	private JLabel lblMSnPhm_1;
	private JTextField txtMa;
	private JComboBox<String> cbKichThuoc;
	private JButton btnTim;
	private JLabel lblMSnPhm_2;
	private JLabel lblTongCong;
	private static final float VAT = (float) 0.1;
	private NhanVien nhanVien;
	private JButton btnSuaSoLuong;
	private JButton btnXoa;
	private JButton btnThemVaoHang;
	private JButton btnDSCho;
	
	public Map<String, List<SanPham>> map = new HashMap<String, List<SanPham>>();

	/**
	 * Create the panel.
	 */
	public LapHoaDonPnGUI(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
		listGioHang = new ArrayList<SanPham>();
		sanPhamDao = new SanPhamImpl();
		new LoaiSanPhamImpl();
		khachHangDao = new KhachHangImpl();
		hoaDonDao = new HoaDonImpl();
		ct_HoaDonDao = new CT_HoaDonImpl();
		new NhanVienImpl();
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0, 0, 1364, 621);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("LẬP HÓA ĐƠN");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(0, 0, 1364, 33);
		add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 77, 501, 171);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblMSnPhm = new JLabel("Tên sản phẩm");
		lblMSnPhm.setBounds(10, 73, 120, 35);
		panel.add(lblMSnPhm);
		lblMSnPhm.setFont(new Font("Arial", Font.BOLD, 16));
		
		txtTen = new JTextField();
		txtTen.setBounds(130, 73, 361, 35);
		panel.add(txtTen);
		txtTen.setColumns(10);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(LapHoaDonPnGUI.class.getResource("/img/lam_moi.png")));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLamMoi.setBounds(366, 118, 125, 35);
		panel.add(btnLamMoi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 258, 501, 314);
		add(scrollPane);
		
		tableCuaHang = new JTable();
		tableCuaHang.setRowHeight(35);
		tableCuaHang.setModel(modelCuaHang = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã sản phẩm", "Tên sản phẩm","Màu sắc","Kích thước", "Số lượng"
			}
		));
		scrollPane.setViewportView(tableCuaHang);
		tableCuaHang.getColumnModel().getColumn(0).setPreferredWidth(130);
		
		btnBackEnd = new JButton("");
		btnBackEnd.setIcon(new ImageIcon(LapHoaDonPnGUI.class.getResource("/img/previousEnd.png")));
		btnBackEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBackEnd.setBounds(10, 582, 92, 29);
		add(btnBackEnd);
		
		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(LapHoaDonPnGUI.class.getResource("/img/rewind-button.png")));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(112, 582, 92, 29);
		add(btnBack);
		
		btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon(LapHoaDonPnGUI.class.getResource("/img/forward-button.png")));
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNext.setBounds(317, 582, 92, 29);
		add(btnNext);
		
		btnNextEnd = new JButton("");
		btnNextEnd.setIcon(new ImageIcon(LapHoaDonPnGUI.class.getResource("/img/next.png")));
		btnNextEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNextEnd.setBounds(419, 582, 92, 29);
		add(btnNextEnd);
		
		lblPageCurrent = new JLabel("1");
		lblPageCurrent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPageCurrent.setHorizontalAlignment(SwingConstants.CENTER);
		lblPageCurrent.setBounds(214, 581, 36, 30);
		add(lblPageCurrent);
		
		lblPageTotal = new JLabel("/10");
		lblPageTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPageTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPageTotal.setBounds(260, 581, 36, 30);
		add(lblPageTotal);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(525, 401, 72, 29);
		add(txtSoLuong);
		
		btnHuy = new JButton("Hủy hóa đơn (F8)");
		btnHuy.setIcon(new ImageIcon(LapHoaDonPnGUI.class.getResource("/img/xoa.png")));
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHuy.setBounds(607, 578, 177, 35);
		clickOnKey(btnHuy,"Hủy hóa đơn", KeyEvent.VK_F8);
		add(btnHuy);
		
		chckXuatHoaDon = new JCheckBox("Xuất hóa đơn");
		chckXuatHoaDon.setFont(new Font("Arial", Font.PLAIN, 16));
		chckXuatHoaDon.setBounds(1032, 578, 120, 35);
		add(chckXuatHoaDon);
		
		btnThanhToan = new JButton("Thanh toán (F10)");
		btnThanhToan.setIcon(new ImageIcon(LapHoaDonPnGUI.class.getResource("/img/money-bag.png")));
		btnThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThanhToan.setBounds(1169, 578, 185, 35);
		clickOnKey(btnThanhToan,"Thanh toán", KeyEvent.VK_F10);
		add(btnThanhToan);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin h\u00F3a \u0111\u01A1n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(607, 77, 747, 495);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 177, 727, 224);
		panel_1.add(scrollPane_1);
		
		tableGioHang = new JTable();
		tableGioHang.setRowHeight(35);
		tableGioHang.setModel(modelGioHang = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã sản phẩm", "Tên sản phẩm","Màu sắc", "Kích thước","Giá","Số lượng", "Thành tiền"
			}
		));
		tableGioHang.getColumnModel().getColumn(5).setPreferredWidth(30);
		tableGioHang.getColumnModel().getColumn(4).setPreferredWidth(150);
		scrollPane_1.setViewportView(tableGioHang);
		
		JLabel lblMSnPhm_4 = new JLabel("Tổng tiền:");
		lblMSnPhm_4.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMSnPhm_4.setBounds(10, 408, 75, 35);
		panel_1.add(lblMSnPhm_4);
		
		lblTongTien = new JLabel("");
		lblTongTien.setForeground(Color.RED);
		lblTongTien.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblTongTien.setBounds(105, 408, 188, 35);
		panel_1.add(lblTongTien);
		
		JLabel lblMSnPhm_3 = new JLabel("Tiền nhận:");
		lblMSnPhm_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMSnPhm_3.setBounds(10, 447, 75, 35);
		panel_1.add(lblMSnPhm_3);
		
		txtTienNhan = new JTextField();
		txtTienNhan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTienNhan.setColumns(10);
		txtTienNhan.setBounds(105, 448, 188, 33);
		panel_1.add(txtTienNhan);
		
		lblKiemTraTien = new JLabel("");
		lblKiemTraTien.setBounds(303, 447, 37, 33);
		panel_1.add(lblKiemTraTien);
		
		JLabel lblMSnPhm_5 = new JLabel("Tiền thừa:");
		lblMSnPhm_5.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMSnPhm_5.setBounds(452, 447, 75, 35);
		panel_1.add(lblMSnPhm_5);
		
		lblTienThua = new JLabel("");
		lblTienThua.setForeground(Color.RED);
		lblTienThua.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblTienThua.setBounds(537, 447, 200, 35);
		panel_1.add(lblTienThua);
		
		JLabel lblNhnVin = new JLabel("Nhân viên");
		lblNhnVin.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNhnVin.setBounds(40, 110, 75, 35);
		panel_1.add(lblNhnVin);
		
		JLabel lblKhchHng = new JLabel("Khách hàng");
		lblKhchHng.setFont(new Font("Arial", Font.PLAIN, 16));
		lblKhchHng.setBounds(400, 110, 91, 35);
		panel_1.add(lblKhchHng);
		
		lblNhanVien = new JLabel("");
		lblNhanVien.setForeground(Color.RED);
		lblNhanVien.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNhanVien.setBounds(148, 110, 208, 35);
		panel_1.add(lblNhanVien);
		
		lblKhachHang = new JLabel("");
		lblKhachHang.setForeground(Color.RED);
		lblKhachHang.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblKhachHang.setBounds(508, 110, 187, 35);
		panel_1.add(lblKhachHang);
		
		JLabel lblNgayLap = new JLabel("Ngày lập :");
		lblNgayLap.setForeground(Color.RED);
		lblNgayLap.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNgayLap.setBounds(519, 25, 83, 35);
		panel_1.add(lblNgayLap);
		
		lblNgayLapHD = new JLabel("01-01-2022");
		lblNgayLapHD.setForeground(Color.RED);
		lblNgayLapHD.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNgayLapHD.setBounds(612, 25, 83, 35);
		panel_1.add(lblNgayLapHD);
		
		JLabel lblNpkFashsion = new JLabel("HÓA ĐƠN BÁN LẺ");
		lblNpkFashsion.setFont(new Font("Arial", Font.BOLD, 20));
		lblNpkFashsion.setBounds(282, 9, 174, 35);
		panel_1.add(lblNpkFashsion);
		
		JLabel lblMaHD = new JLabel("Mã hóa đơn   ");
		lblMaHD.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMaHD.setBounds(40, 70, 109, 35);
		panel_1.add(lblMaHD);
		
		lblMaHoaDon = new JLabel("HD00001");
		lblMaHoaDon.setForeground(Color.RED);
		lblMaHoaDon.setFont(new Font("Arial", Font.ITALIC, 16));
		lblMaHoaDon.setBounds(159, 70, 109, 35);
		panel_1.add(lblMaHoaDon);
		
		JLabel lblStKhchHng = new JLabel("SĐT Khách hàng");
		lblStKhchHng.setBounds(357, 70, 132, 35);
		panel_1.add(lblStKhchHng);
		lblStKhchHng.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtSdt = new JTextField();
		txtSdt.setBounds(508, 71, 187, 33);
		panel_1.add(txtSdt);
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSdt.setColumns(10);
		
		btnTim = new JButton("");
		btnTim.setBounds(694, 70, 43, 35);
		panel_1.add(btnTim);
		btnTim.setIcon(new ImageIcon(LapHoaDonPnGUI.class.getResource("/img/Search.png")));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblMSnPhm_2 = new JLabel("Tổng cộng (10% VAT):");
		lblMSnPhm_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMSnPhm_2.setBounds(365, 408, 162, 35);
		panel_1.add(lblMSnPhm_2);
		
		lblTongCong = new JLabel("");
		lblTongCong.setForeground(Color.RED);
		lblTongCong.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblTongCong.setBounds(547, 408, 190, 35);
		panel_1.add(lblTongCong);
		btnTim.addActionListener(this);
		txtSdt.addActionListener(this);
		
		btnThemVaoGioHang = new JButton("");
		btnThemVaoGioHang.setHorizontalTextPosition(SwingConstants.CENTER);
		
		
		btnThemVaoGioHang.setIcon(new ImageIcon(LapHoaDonPnGUI.class.getResource("/img/fast-forwardResize.png")));
		btnThemVaoGioHang.setBounds(525, 353, 72, 41);
		add(btnThemVaoGioHang);
		
		btnThemKH = new JButton("Thêm KH (F5)");
		btnThemKH.setIcon(new ImageIcon(LapHoaDonPnGUI.class.getResource("/img/them.png")));
		btnThemKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemKH.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThemKH.setBounds(1195, 36, 159, 35);
		clickOnKey(btnThemKH,"Thêm khách hàng", KeyEvent.VK_F5);
		add(btnThemKH);
		
		btnThemVaoGioHang.setEnabled(false);
		
		JLabel lblNhpSt_1_5_1 = new JLabel("Kích thước");
		lblNhpSt_1_5_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_5_1.setBounds(15, 118, 87, 35);
		panel.add(lblNhpSt_1_5_1);
		
		cbKichThuoc = new JComboBox<String>();
		cbKichThuoc.setBackground(Color.WHITE);
		cbKichThuoc.setBounds(130, 120, 183, 35);
		panel.add(cbKichThuoc);
		
		lblMSnPhm_1 = new JLabel("Mã sản phẩm");
		lblMSnPhm_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblMSnPhm_1.setBounds(10, 23, 120, 35);
		panel.add(lblMSnPhm_1);
		
		loadComBoBox(cbKichThuoc, sanPhamDao.getKichThuoc());
		
		txtMa = new JTextField();
		txtMa.setColumns(10);
		txtMa.setBounds(130, 23, 361, 35);
		panel.add(txtMa);
		
		btnXemChiTiet = new JButton("Xem chi tiết");
		btnXemChiTiet.setBounds(349, 36, 162, 35);
		add(btnXemChiTiet);
		btnXemChiTiet.setIcon(new ImageIcon(LapHoaDonPnGUI.class.getResource("/img/view-details.png")));
		btnXemChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnSuaSoLuong = new JButton("Sửa số lượng (F6)");
		btnSuaSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSuaSoLuong.setBounds(489, 144, 147, 30);
		clickOnKey(btnSuaSoLuong,"Sửa số lượng", KeyEvent.VK_F6);
		panel_1.add(btnSuaSoLuong);
		
		btnXoa = new JButton("Xóa (F7)");
		btnXoa.setIcon(null);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(646, 144, 91, 30);
		panel_1.add(btnXoa);
		clickOnKey(btnXoa,"Xóa", KeyEvent.VK_F7);
		
		btnThemVaoHang = new JButton("Thêm vào hàng chờ (F9)");
		btnThemVaoHang.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThemVaoHang.setBounds(794, 578, 213, 35);
		clickOnKey(btnThemVaoHang,"Xóa", KeyEvent.VK_F9);
		add(btnThemVaoHang);
		
		btnDSCho = new JButton("Hàng chờ (F4)");
		btnDSCho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDSCho.setBounds(1032, 36, 141, 35);
		clickOnKey(btnDSCho,"Danh sách hàng chờ", KeyEvent.VK_F4);
		add(btnDSCho);
		
		
		
		txtTen.addKeyListener(this);
		btnBack.addActionListener(this);
		btnBackEnd.addActionListener(this);
		btnNext.addActionListener(this);
		btnNextEnd.addActionListener(this);
		txtMa.addKeyListener(this);
		txtMa.addActionListener(this);
		txtMa.addMouseListener(this);
		tableCuaHang.addMouseListener(this);
		tableGioHang.addMouseListener(this);
		btnLamMoi.addActionListener(this);
		btnThemVaoGioHang.addActionListener(this);
		txtSoLuong.addActionListener(this);
		txtTienNhan.addKeyListener(this);
		btnHuy.addActionListener(this);
		cbKichThuoc.addItemListener(this);
		btnThemKH.addActionListener(this);
		btnXemChiTiet.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnSuaSoLuong.addActionListener(this);
		btnXoa.addActionListener(this);
		chckXuatHoaDon.addActionListener(this);
		btnDSCho.addActionListener(this);
		btnThemVaoHang.addActionListener(this);
		
//		loadComBoBox(cbLoaiSanPham,loaiSanPhamDao.getDanhSachLoai());
//		List<SanPham> list = sanPhamDao.getDanhSachSanPham(0,8,"", "", "", "", "", "",true);
		List<SanPham> list = sanPhamDao.danhSachSanPhamBanChay(0,8);
		loadTableCuaHang(list);
		
		lblPageTotal.setText(String.valueOf("/"+tongPage()));
		
		getMaHD();
		
		lblNhanVien.setText(nhanVien.getHoTen());
		
		tableCuaHang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableGioHang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		tableCuaHang.setDefaultEditor(Object.class, null);
		tableGioHang.setDefaultEditor(Object.class, null);
		
//		btnXoa.setMnemonic(KeyEvent.VK_D);
//		btnSuaSoLuong.setMnemonic(KeyEvent.VK_U);
		
		
		
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
	
	public void getMaHD() {
		String maHoaDonCuoi = hoaDonDao.getHoaDonCuoi().substring(2);
		int soMaHoaDon = Integer.parseInt(maHoaDonCuoi);
		soMaHoaDon++;
		String maHD = String.format("HD%06d", soMaHoaDon);
		lblMaHoaDon.setText(maHD);	
		lblNgayLapHD.setText(LocalDate.now().toString());
	}
	
	public void loadComBoBox(JComboBox<String> cb, List<String> list) {
		cb.addItem("Tất cả");
		for (String item : list) {
			if(!item.equals(""))
				cb.addItem(item);
		}
	}
	
	public void loadTableCuaHang(List<SanPham> sanPhams) {
		for (SanPham sanPham : sanPhams) {
			modelCuaHang.addRow(new Object[] {sanPham.getMaSP(), sanPham.getTenSP(),sanPham.getMauSac(),sanPham.getKichThuoc(),sanPham.getSoLuong()});
		}
	}
	
	public void xoaToanBoban() {
		modelCuaHang.getDataVector().removeAllElements();
		modelCuaHang.fireTableDataChanged();
		tableGioHang.clearSelection();
	}
	
	public void addInToTable() {
		int page = Integer.parseInt(lblPageCurrent.getText().toString());
		String  maSanPham = txtMa.getText().trim();
		String tenSanPham = txtTen.getText().trim().replace(' ','%');
		String kichThuoc = cbKichThuoc.getSelectedIndex() > 0 ? cbKichThuoc.getSelectedItem().toString() : "";
		if(!maSanPham.equals("") || !tenSanPham.equals("") || !kichThuoc.equals("")) {
			List<SanPham> list = sanPhamDao.getDanhSachSanPham(page-1,8,tenSanPham,"", maSanPham,"",kichThuoc,"",true);
			loadTableCuaHang(list);
			return;
		}
		List<SanPham> list = sanPhamDao.danhSachSanPhamBanChay(page-1,8);
		loadTableCuaHang(list);

	}
	
	public int tongPage() {
		int tongPage = 1;
		int tongHang = 0;
		String  maSanPham = txtMa.getText();
		String tenSanPham = txtTen.getText().replace(' ','%');
		String kichThuoc = cbKichThuoc.getSelectedIndex() > 0 ? cbKichThuoc.getSelectedItem().toString() : "";
		if(maSanPham.equals("") && tenSanPham.equals("") && cbKichThuoc.getSelectedIndex() == 0) {
			tongHang = sanPhamDao.tinhTongHangBanChay();
		}
		else {
			tongHang = sanPhamDao.tongSoHang(tenSanPham,"", maSanPham,"",kichThuoc,"",true);
		}
		tongPage = tongHang % 8 == 0 ? tongHang / 8 : (tongHang/8)+1;
		return tongPage;
	}
	
	public void updateSoLuong() {
		for(int i=0; i< tableCuaHang.getRowCount(); i++) {
			for (SanPham sanPham : listGioHang) {
				if(sanPham.getMaSP().equals(tableCuaHang.getValueAt(i, 0).toString())) {
					int soLuongTruocUpdate = Integer.parseInt(tableCuaHang.getValueAt(i, 4).toString()); 
					int soLuongUpDate = soLuongTruocUpdate - sanPham.getSoLuong();
					tableCuaHang.setValueAt(soLuongUpDate, i, 4);
				}
			}
		}
		
	}
	
	public List<SanPham> getSanPhamFromMap(){
		List<SanPham> list = new ArrayList<SanPham>();
		map.entrySet()
		.iterator()
		.forEachRemaining(entry->{
			List<SanPham> sanPhams = entry.getValue();
			for (SanPham sanPham : sanPhams) {
				list.add(sanPham);
			}
		});
		return list;
	}
	
	public void updateSoLuongCho() {
		List<SanPham> sanPhamCho = getSanPhamFromMap();
		for(int i=0; i< tableCuaHang.getRowCount(); i++) {
			for (SanPham sanPham : sanPhamCho) {
				if(sanPham.getMaSP().equals(tableCuaHang.getValueAt(i, 0).toString())) {
					int soLuongTruocUpdate = Integer.parseInt(tableCuaHang.getValueAt(i, 4).toString()); 
					int soLuongUpDate = soLuongTruocUpdate - sanPham.getSoLuong();
					tableCuaHang.setValueAt(soLuongUpDate, i, 4);
				}
			}
		}
		
	}
	
	public void clearTextField() {
		txtTen.setText("");
		txtMa.setText("");
		cbKichThuoc.setSelectedIndex(0);
		
	}
	
	public double tinhThanhTien(int soLuong, double donGia) {
		return soLuong * donGia;
	}
	
	public boolean kiemTraThem(int row) {
		int soLuongCon;
		int soLuongThem;
		try {
			soLuongCon = Integer.parseInt(tableCuaHang.getValueAt(row,4).toString());
			soLuongThem = Integer.parseInt(txtSoLuong.getText().trim());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Vui lòng nhập số lượng thuốc phải là số nguyên dương");
			focusAndSelect(txtSoLuong);
			return false;
		}
		if(soLuongThem <=0 ) {
			JOptionPane.showMessageDialog(this,"Số lượng thuốc phải là số nguyên dương");
			focusAndSelect(txtSoLuong);
			return false;
		}
		if(soLuongThem > soLuongCon) {
			JOptionPane.showMessageDialog(this,"Không đủ sản phẩm!\nSố lượng sản phẩm hiện tại là :"+soLuongCon+"");
			focusAndSelect(txtSoLuong);
			return false;
		}
		return true;
	}
	
	public void focusAndSelect(JTextField txt) {
		txt.requestFocus();
		txt.selectAll();
	}
	
	public double tinhTongTien() {
		double tongTien = 0;
		for (SanPham sanPham : listGioHang) {
			double tien = tinhThanhTien(sanPham.getSoLuong(), sanPham.getDonGia());
			tongTien += tien;
		}
		return tongTien;
	}
	
	public boolean kiemTienNhan() {
		double tienNhan;
		double tongCong = Format.chuyenDoiNguocLaiTienTe(lblTongCong.getText());
		try {
			tienNhan = Double.parseDouble(txtTienNhan.getText().trim());
		} catch (Exception e) {
			return false;
		}
		if(tienNhan <= 0 || tienNhan < tongCong) {
			return false;
		}
		return true;
	}
	
	public double tinhTienThua() {
		double tongCong = Format.chuyenDoiNguocLaiTienTe(lblTongCong.getText());
		double tienNhan = Double.parseDouble(txtTienNhan.getText());
		return tienNhan - tongCong;
	}
	
	public void updateTienThua() {
		if(kiemTienNhan()) {
			lblKiemTraTien.setIcon(new ImageIcon(LapHoaDonPnGUI.class.getResource("/img/true.png")));
			lblTienThua.setText(Format.chuyenDoiTienTe(tinhTienThua()));
		}
		if(!kiemTienNhan()) {
			lblKiemTraTien.setIcon(new ImageIcon(LapHoaDonPnGUI.class.getResource("/img/false.png")));
			lblTienThua.setText("");
		}
		if(txtTienNhan.getText().equals("")) {
			lblKiemTraTien.setIcon(new ImageIcon(LapHoaDonPnGUI.class.getResource("/img/white.png")));
			lblTienThua.setText("");
		}
	}
	
	public boolean kiemTraXoa(int row) {
		int soLuongCon;
		int soLuongXoa;
		try {
			soLuongCon = Integer.parseInt(tableGioHang.getValueAt(row,5).toString());
			soLuongXoa = Integer.parseInt(txtSoLuong.getText().trim());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Vui lòng nhập số lượng thuốc phải là số nguyên dương");
			focusAndSelect(txtSoLuong);
			return false;
		}
		if(soLuongXoa <=0 ) {
			JOptionPane.showMessageDialog(this,"Số lượng thuốc phải là số nguyên dương");
			focusAndSelect(txtSoLuong);
			return false;
		}
		if(soLuongXoa > soLuongCon) {
			JOptionPane.showMessageDialog(this,"Số lượng sản phẩm cần xóa vượt quá số lượng hiện có trong giỏ!\nSố lượng sản phẩm hiện tại trong giỏ là :"+soLuongCon+"");
			focusAndSelect(txtSoLuong);
			return false;
		}
		return true;
	}
	
	public void huyHoaDon() {
//		DialogHoaDonTreo.STD = "";
		modelGioHang.getDataVector().removeAllElements();
		modelGioHang.fireTableDataChanged();
		tableGioHang.clearSelection();
//		listGioHang.removeAll(listGioHang);
		listGioHang = new ArrayList<SanPham>();
		xoaToanBoban();
		addInToTable();
		lblKhachHang.setText("");
		txtTienNhan.setText("");
		lblTongTien.setText("");
		lblTongCong.setText("");
		txtSdt.setText("");
//		lblMaHoaDon.setText("");
		updateTienThua();
//		updateSoLuongCho();
	}
	
	public BufferedImage scaleImage(int WIDTH, int HEIGHT,BufferedImage img ) {
	    BufferedImage bi = null;
	    try {
	        ImageIcon ii = new ImageIcon(img);
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
	
	public void loadTableGioHang(List<SanPham> list) {
		for (SanPham sanPham : list) {
			modelGioHang.addRow(new Object[] {sanPham.getMaSP(), sanPham.getTenSP(),sanPham.getKichThuoc(),Format.chuyenDoiTienTe(sanPham.getDonGia()),sanPham.getSoLuong(),Format.chuyenDoiTienTe(sanPham.getDonGia())});
		}
	}
	
	
	public boolean kiemTraSoDienThoai(String sdt) {
		if(sdt.equals("")){
			JOptionPane.showMessageDialog(null,"Vui lòng nhập số điện thoại");
			focusAndSelect(txtSdt);
			return false;
		}
		else if(!sdt.matches("(^(03)[2-9]\\d{7})|(^(07)[06-9]\\d{7})|(^(08)[1-5]\\d{7})|(^(056)\\d{7})|(^(058)\\d{7})|(^(059)\\d{7})|(^(09)[0-46-9]\\d{7})")) {
			focusAndSelect(txtSdt);
			JOptionPane.showMessageDialog(this,"Số điện thoại không đúng địng dạng");
			return false;
		}
		return true;
	}
	
	public boolean isNum(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public boolean kiemTraThanhToan() {
		
		KhachHang khachHang = khachHangDao.getKhachHangByStd(txtSdt.getText());
		if(khachHang != null) {
			lblKhachHang.setText(khachHang.getHoTen());
		}
		
		if(txtSdt.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Vui lòng nhập số điện thoại của khách hàng nếu là khách hàng củ, nếu là khách hàng mới vui lòng thêm khách hàng trước khi lập hóa đơn");
			focusAndSelect(txtSdt);
			return false;
		}
		
		if(khachHang == null) {
			lblKhachHang.setText("");
			JOptionPane.showMessageDialog(this,"Khách hàng chưa có trong hệ thống vui lòng kiểm tra lại số điện thoại khách hàng");
			focusAndSelect(txtSdt);
			return false;
		}
		
		if(listGioHang.size() == 0) {
			JOptionPane.showMessageDialog(this,"Hóa đơn hiện không có sản phẩm, Vui lòng thêm sản phẩm vào hóa đơn");
			return false;
		}
		
		if(txtTienNhan.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Vui lòng nhập tiền nhận từ khách hàng");
			focusAndSelect(txtTienNhan);
			return false;
		}
		
		if(!kiemTienNhan()) {
			JOptionPane.showMessageDialog(this, "Tiền nhận không hợp lệ");
			focusAndSelect(txtTienNhan);
			return false;
		}
		return true;
	}
	
	
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		int tongPage = tongPage();
		Object o = e.getSource();
		
		if (o.equals(btnNext)) {

			int page = Integer.parseInt(lblPageCurrent.getText());

			if (page < tongPage) {
				page+=1;
				lblPageCurrent.setText(Integer.toString(page));
				xoaToanBoban();
				tableCuaHang.clearSelection();
				addInToTable();
//				updateSoLuong();
				if(getSanPhamFromMap() != null && listGioHang == null) {
					updateSoLuongCho();
				}
				else {					
					updateSoLuong();
					updateSoLuongCho();
				}
			}

		}
		if (o.equals(btnBack)) {
			int page = Integer.parseInt(lblPageCurrent.getText());
			if (page > 1) {
				page -=1;
				lblPageCurrent.setText(Integer.toString(page));
				xoaToanBoban();
				tableCuaHang.clearSelection();
				addInToTable();
				if(getSanPhamFromMap() != null && listGioHang == null) {
					updateSoLuongCho();
				}
				else {					
					updateSoLuong();
					updateSoLuongCho();
				}
			}
		}

		if (o.equals(btnNextEnd)) {
			int page = Integer.parseInt(lblPageCurrent.getText());
			if (page != tongPage) {
				lblPageCurrent.setText(Integer.toString(tongPage));
				xoaToanBoban();
				tableCuaHang.clearSelection();
				addInToTable();
//				updateSoLuong();
				if(getSanPhamFromMap() != null && listGioHang == null) {
					updateSoLuongCho();
				}
				else {					
					updateSoLuong();
					updateSoLuongCho();
				}
			}
		}

		if (o.equals(btnBackEnd)) {
			int page = Integer.parseInt(lblPageCurrent.getText());
			if (page != 1) {
				lblPageCurrent.setText(Integer.toString(1));
				xoaToanBoban();
				tableCuaHang.clearSelection();
				addInToTable();
//				updateSoLuong();
				if(getSanPhamFromMap() != null && listGioHang == null) {
					updateSoLuongCho();
				}
				else {					
					updateSoLuong();
					updateSoLuongCho();
				}
				
			}
		}
				
		if(o.equals(btnLamMoi)) {
			xoaToanBoban();
			lblPageCurrent.setText("1");
			lblPageTotal.setText(String.valueOf("/"+tongPage()));
			if(cbKichThuoc.getSelectedIndex() >0) {
				clearTextField();
			} else {
				clearTextField();
				addInToTable();
			}
//			clearTextField();
//			addInToTable();
//			updateSoLuong();
			if(getSanPhamFromMap() != null && listGioHang == null) {
				updateSoLuongCho();
			}
			else {					
				updateSoLuong();
				updateSoLuongCho();
			}
		}
		
		if(o.equals(btnXemChiTiet)) {
			int n = tableCuaHang.getSelectedRow();
			if(n == -1) {
				JOptionPane.showMessageDialog(this,"Vui lòng chọn sản phẩm cần xem chi tiết");
				return;
			}
			String maSp = tableCuaHang.getValueAt(n, 0).toString();
			ChiTietSanPhamJFrameGUI ctPhamJFrame = new ChiTietSanPhamJFrameGUI(maSp);
			ctPhamJFrame.setVisible(true);
		}
		
		if(o.equals(btnThemVaoGioHang)) {
			int row = tableCuaHang.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm và nhập số lượng cần thêm");
				return;
			} 
			if (kiemTraThem(row)){
				int soLuongThem = Integer.parseInt(txtSoLuong.getText().trim());
				int soLuongCon = Integer.parseInt(tableCuaHang.getValueAt(row,4).toString());
				SanPham sanPham = sanPhamDao.getSanPhamById(tableCuaHang.getValueAt(row,0).toString());
				sanPham.setSoLuong(soLuongThem);
				for(int i = 0; i < listGioHang.size(); i++) {
					if(sanPham.getMaSP().equals(listGioHang.get(i).getMaSP())) {
						int soLuongSau = listGioHang.get(i).getSoLuong()+soLuongThem;
						listGioHang.get(i).setSoLuong(soLuongSau);
						modelGioHang.setValueAt(soLuongSau, i, 5);
						modelGioHang.setValueAt(Format.chuyenDoiTienTe(tinhThanhTien(soLuongSau, sanPham.getDonGia())), i, 6);
						tableCuaHang.setValueAt(soLuongCon-soLuongThem, row, 4);
						lblTongTien.setText(Format.chuyenDoiTienTe(tinhTongTien()));
						lblTongCong.setText(Format.chuyenDoiTienTe(tinhTongTien()+(VAT*tinhTongTien())));
						updateTienThua();
						return;
					}
				}
				
				Double thanhTien = tinhThanhTien(sanPham.getSoLuong(), sanPham.getDonGia());
				
				listGioHang.add(sanPham);
				System.out.println("sau khi add ========= " + listGioHang.size());
				
				map.entrySet().forEach(en->{
					System.out.println(en.getValue().size());
				});
				
				modelGioHang.addRow(new Object[] {sanPham.getMaSP(), sanPham.getTenSP(),sanPham.getMauSac(),sanPham.getKichThuoc(),Format.chuyenDoiTienTe(sanPham.getDonGia()),sanPham.getSoLuong(),Format.chuyenDoiTienTe(thanhTien)});
				tableCuaHang.setValueAt(soLuongCon-soLuongThem, row, 4);
				lblTongTien.setText(Format.chuyenDoiTienTe(tinhTongTien()));
				lblTongCong.setText(Format.chuyenDoiTienTe(tinhTongTien()+(VAT*tinhTongTien())));
				updateTienThua();
			}
			focusAndSelect(txtSoLuong);
		}
		
		
		if(o.equals(btnHuy)) {
			huyHoaDon();
			updateSoLuongCho();
		}
		
		if(o.equals(txtSdt) || o.equals(btnTim)) {
			if(kiemTraSoDienThoai(txtSdt.getText())) {
				
				KhachHang khachHang = khachHangDao.getKhachHangByStd(txtSdt.getText());
				if(khachHang == null) {
					int xacNhan = JOptionPane.showConfirmDialog(this,"Khách hàng không có trong hệ thống \n Bạn có muốn thêm khách hàng vào hệ thống không","Thông báo", JOptionPane.YES_NO_OPTION);
					if(xacNhan == JOptionPane.YES_OPTION) {
						String sdt = txtSdt.getText();
						ThemKhachHangJFrameGUI themKHGUI =  new ThemKhachHangJFrameGUI(sdt);
						themKHGUI.setVisible(true);
						lblKhachHang.setText(themKHGUI.khachHang.getHoTen());
						txtSdt.setText(themKHGUI.khachHang.getSdt());
						themKHGUI.khachHang = null;
					} else {
						lblKhachHang.setText("");
					}
				} else {
					lblKhachHang.setText(khachHang.getHoTen());	
				}
			}
		}
		
		if(o.equals(btnThemKH)) {
			ThemKhachHangJFrameGUI themKHGUI =  new ThemKhachHangJFrameGUI("");
			themKHGUI.setVisible(true);
			lblKhachHang.setText(themKHGUI.khachHang.getHoTen());
			txtSdt.setText(themKHGUI.khachHang.getSdt());
			themKHGUI.khachHang = null;
		}
		
		if(o.equals(btnThanhToan)) {
			if(kiemTraThanhToan()) {
				
				HoaDon hoaDon = new HoaDon();
				hoaDon.setKhachHang(khachHangDao.getKhachHangByStd(txtSdt.getText()));
				hoaDon.setMaHD(lblMaHoaDon.getText());
				hoaDon.setNgayLapHD(Calendar.getInstance().getTime());
				hoaDon.setNhanVien(this.nhanVien);
				hoaDon.setThueVAT(Float.parseFloat("0.1"));
				hoaDon.setTienNhan(Double.parseDouble(txtTienNhan.getText()));
				
				boolean checkThemHD =  hoaDonDao.them(hoaDon);
				boolean checkThemCTHD = true;
				for (SanPham sanPham : listGioHang) {
					CT_HoaDon ct_HoaDon = new CT_HoaDon(sanPham.getSoLuong(), sanPham.getDonGia(), hoaDon, sanPham);
					if(!ct_HoaDonDao.them(ct_HoaDon)) {
						checkThemCTHD = false;
						return;
					}
					sanPhamDao.capNhatSoLuong(sanPham.getMaSP(),sanPham.getSoLuong());
					SanPham sanPhamCheckUpdateTrangThai = sanPhamDao.getSanPhamById(sanPham.getMaSP());
					if(sanPhamCheckUpdateTrangThai.getSoLuong() == 0) {
						sanPhamCheckUpdateTrangThai.setTrangThaiKD(false);
						sanPhamDao.update(sanPhamCheckUpdateTrangThai);
					}
				}
				if(!checkThemCTHD || !checkThemHD) {
					JOptionPane.showMessageDialog(this,"Lập hóa đơn thất bại");
				} else {
					JOptionPane.showMessageDialog(this,"Lập hóa đơn thành công");
					huyHoaDon();
					getMaHD();
					map.remove(DialogHoaDonTreoGUI.STD);
					
					if(chckXuatHoaDon.isSelected()) {
						String path = "dataExport\\"+hoaDon.getMaHD()+".pdf";
						JFrame xuatHD = new XuatHoaDonJFrameGUI(hoaDon.getMaHD());
						xuatHD.setVisible(true);
						Container content = xuatHD.getContentPane();
						xuatHD.setVisible(false);
						int height = content.getHeight();
						int width = content.getHeight();
			            BufferedImage img = new BufferedImage(content.getWidth(), content.getHeight(), BufferedImage.TYPE_INT_RGB);
			            Graphics2D g2d = img.createGraphics();
			            content.printAll(g2d);
			            g2d.dispose();

			            try {

			            	Document d = new Document();
			    	        PdfWriter writer = PdfWriter.getInstance(d, new FileOutputStream(path));
			    	        d.open();
			    	        
			    	        PdfContentByte contentByte = writer.getDirectContent();
			    	        Image image = Image.getInstance(contentByte,scaleImage(595,height, img), 1);
			    	        
			    	        PdfTemplate template = contentByte.createTemplate(width, height);
			    	        image.setAbsolutePosition(0,0);
			    	        template.addImage(image);
			    	        contentByte.addTemplate(template,0,100);
			    	        d.close();
			                
			                int xacNhan = JOptionPane.showConfirmDialog(this, "Bạn có muốn xem file", "Thông báo", JOptionPane.YES_NO_OPTION);
							if(xacNhan==JOptionPane.YES_OPTION)
								try {
									Desktop.getDesktop().open(new File(path));
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
			            } catch (IOException | DocumentException ex) {
			            	ex.printStackTrace();
			            	JOptionPane.showMessageDialog(this, "Không thành công");
			            }
					}
					
				}
			}
			
			
		}
		
		if(o.equals(btnSuaSoLuong)) {
			int row = tableGioHang.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this,"Vui lòng chọn sản phẩm cần sửa số lượng");
				return;
			} else {
				SuaSoLuongGUI suaSoLuongGUI = new SuaSoLuongGUI(sanPhamDao.getSanPhamById(tableGioHang.getValueAt(row, 0).toString()).getSoLuong(), Integer.parseInt(tableGioHang.getValueAt(row, 5).toString()));
				suaSoLuongGUI.setVisible(true);
				int soLuongSua = suaSoLuongGUI.soLuongSua;
				if(soLuongSua == -1) {
					return;
				}
				if(soLuongSua == 0) {
					modelGioHang.removeRow(row);
					listGioHang.remove(row);
					lblTongTien.setText(Format.chuyenDoiTienTe(tinhTongTien()));
					lblTongCong.setText(Format.chuyenDoiTienTe(tinhTongTien()+(VAT*tinhTongTien())));
					updateTienThua();
					xoaToanBoban();
					addInToTable();
					updateSoLuong();
					suaSoLuongGUI.soLuongSua =-1;
				} 
				else {
					tableGioHang.setValueAt(soLuongSua, row, 5);
					listGioHang.get(row).setSoLuong(soLuongSua);
					tableGioHang.setValueAt(Format. chuyenDoiTienTe(soLuongSua*listGioHang.get(row).getDonGia()),row,6);
					lblTongTien.setText(Format.chuyenDoiTienTe(tinhTongTien()));
					lblTongCong.setText(Format.chuyenDoiTienTe(tinhTongTien()+(VAT*tinhTongTien())));
					updateTienThua();
					xoaToanBoban();
					addInToTable();
					updateSoLuong();
					suaSoLuongGUI.soLuongSua =-1;
				}
			}
		}
		
		if(o.equals(btnXoa)) {
			int row = tableGioHang.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this,"Vui lòng chọn sản phẩm cần xóa");
				return;
			} else {
				modelGioHang.removeRow(row);
				listGioHang.remove(row);
				lblTongTien.setText(Format.chuyenDoiTienTe(tinhTongTien()));
				lblTongCong.setText(Format.chuyenDoiTienTe(tinhTongTien()+(VAT*tinhTongTien())));
				updateTienThua();
				xoaToanBoban();
				addInToTable();
				updateSoLuong();
			}
		}
		
		if(o.equals(btnDSCho)) {
			boolean trangThaiLap = listGioHang.size()==0 ? false : true;
			DialogHoaDonTreoGUI dialogHoaDonTreo = new DialogHoaDonTreoGUI(map, trangThaiLap);
			dialogHoaDonTreo.setVisible(true);
			map = DialogHoaDonTreoGUI.map;
			String sdt = DialogHoaDonTreoGUI.STD;
			xoaToanBoban();
			addInToTable();
			if(getSanPhamFromMap() != null && listGioHang == null) {
				updateSoLuongCho();
			}
			else {					
				updateSoLuong();
				updateSoLuongCho();
			}
			if(!sdt.equals("")) {
				huyHoaDon();
				updateSoLuongCho();
//				huyHoaDon();
				List<SanPham> listTam = new ArrayList<SanPham>();
				listTam.addAll(map.get(sdt));
				listGioHang.addAll(listTam);
				map.remove(sdt);
				if(listGioHang == null) {
					listGioHang = new ArrayList<SanPham>();
					return;
				}
				loadTableGioHang(listGioHang);
				txtSdt.setText(sdt);
				lblKhachHang.setText(khachHangDao.getKhachHangByStd(sdt).getHoTen());
				lblTongTien.setText(Format.chuyenDoiTienTe(tinhTongTien()));
				lblTongCong.setText(Format.chuyenDoiTienTe(tinhTongTien()+(VAT*tinhTongTien())));
			}
			
			
		}
		
		if(o.equals(btnThemVaoHang)) {
//			map = DialogHoaDonTreo.map;
			if (txtSdt.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(this,"Vui lòng chọn chọn khách hàng trước khi thêm hóa đơn vào hàng chờ!");
				return;
			};
			if (listGioHang.size() == 0) {
				JOptionPane.showMessageDialog(this,"Hoá đơn chưa có sản phẩm!");
				return;
			}
			List<SanPham> listTemp = new ArrayList<SanPham>();
			listTemp.addAll(listGioHang);
			map.put(txtSdt.getText(), listTemp);
			listTemp = null;
			JOptionPane.showMessageDialog(this,"Đã thêm vào hàng chờ");
			huyHoaDon();
			updateSoLuongCho();
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
		Object o = e.getSource();
		if(o.equals(txtTen) || o.equals(txtMa)) {
			lblPageCurrent.setText("1");
			lblPageTotal.setText(String.valueOf("/"+tongPage()));
			xoaToanBoban();
			addInToTable();
//			updateSoLuong();
			if(getSanPhamFromMap() != null && listGioHang == null) {
				updateSoLuongCho();
			}
			else {					
				updateSoLuong();
				updateSoLuongCho();
			}
		}
		
		if(o.equals(txtTienNhan)) {
			updateTienThua();
		}	
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(tableCuaHang)) {
			focusAndSelect(txtSoLuong);
			btnThemVaoGioHang.setEnabled(true);
			tableGioHang.clearSelection();
			txtSoLuong.setText("1");
		}
		
		if(o.equals(tableGioHang)) {
			txtSoLuong.setText("");
			btnThemVaoGioHang.setEnabled(false);
			tableCuaHang.clearSelection();
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
		Object o = e.getSource();
		if(o.equals(cbKichThuoc)) {
		lblPageCurrent.setText("1");
		lblPageTotal.setText(String.valueOf("/"+tongPage()));
		xoaToanBoban();
		addInToTable();
//		updateSoLuong();
		if(getSanPhamFromMap() != null && listGioHang == null) {
			updateSoLuongCho();
		}
		else {					
			updateSoLuong();
			updateSoLuongCho();
		}
		}
			
	}
}


