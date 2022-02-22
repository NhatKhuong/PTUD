package gui;

import static javax.swing.JFileChooser.APPROVE_OPTION;

import java.awt.Color;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
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

import com.toedter.calendar.JDateChooser;

import dao.DiaChiDao;
import dao.NhanVienDao;
import dao.Ipml.DiaChiImpl;
import dao.Ipml.NhanVienImpl;
import entity.DiaChi;
import entity.NhanVien;

public class CapNhatNhanVienPnGUI extends JPanel implements ActionListener,KeyListener,ItemListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtCMND;
	private JTextField txtMatKhau;
	private JTextField txtTimMa;
	private JTextField txtTimTen;
	private JTable table;
	private JButton btnBackEnd;
	private JButton btnBack;
	private JLabel lblSoTrangTable;
	private JButton btnNext;
	private JButton btnNextEnd;
	private DefaultTableModel model;
	
	private NhanVienDao nhanVienDao;
	private int tongPage;
	private int pageIndex;
	private JComboBox<String> cbTimTrangThai;
	private DiaChiDao diaChiDao;
	private List<String> listTinhTP;
	private List<String> listQuanHuyen;
	private List<String> listPhuongXa;
	private List<NhanVien> list;
	private JLabel lblMa;
	private JDateChooser dateChooserNgaySinh;
	private JComboBox<String> cbGioiTinh;
	private JComboBox<String> cbTrangThai;
	private JComboBox<String> cbHuyen;
	private JComboBox<String> cbXa;
	private JComboBox<String> cbTinh;
	private JButton btnChonAnh;
	private JButton btnLamMoi;
	private JButton btnKhoiPhuc;
	private JButton btnCapNhat;
	private JLabel lblAnh;
	private File file;
	private NhanVien nhanVienEdit;

	/**
	 * Create the panel.
	 */
	public CapNhatNhanVienPnGUI() {
		
		nhanVienDao = new NhanVienImpl();
		diaChiDao = new DiaChiImpl();
		
		setBackground(Color.WHITE);
		setBorder(new LineBorder(Color.BLUE));
		setBounds(0,0, 1364, 621);
		setLayout(null);
		
		JLabel lblCNhnVin = new JLabel("CẬP NHẬT NHÂN VIÊN");
		lblCNhnVin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCNhnVin.setFont(new Font("Arial", Font.BOLD, 20));
		lblCNhnVin.setBounds(0, 11, 1364, 35);
		add(lblCNhnVin);
		
		JLabel lblNhpSt_1_1 = new JLabel("Mã nhân viên  :");
		lblNhpSt_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1.setBounds(308, 59, 141, 35);
		add(lblNhpSt_1_1);
		
		lblMa = new JLabel();
		lblMa.setForeground(Color.RED);
		lblMa.setFont(new Font("Arial", Font.ITALIC, 16));
		lblMa.setBounds(449, 56, 111, 35);
		add(lblMa);
		
		JLabel lblNhpSt_1_1_1 = new JLabel("Tên nhân viên :");
		lblNhpSt_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1.setBounds(308, 105, 141, 35);
		add(lblNhpSt_1_1_1);
		
		JLabel lblNhpSt_1_1_2 = new JLabel("Số điện thoại   :");
		lblNhpSt_1_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_2.setBounds(308, 151, 123, 35);
		add(lblNhpSt_1_1_2);
		
		JLabel lblNhpSt_1_1_2_1 = new JLabel("CMND      :");
		lblNhpSt_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_2_1.setBounds(861, 105, 123, 35);
		add(lblNhpSt_1_1_2_1);
		
		JLabel lblNhpSt_1_1_3 = new JLabel("Địa chỉ               :");
		lblNhpSt_1_1_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_3.setBounds(308, 197, 141, 35);
		add(lblNhpSt_1_1_3);
		
		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
		cbGioiTinh.setBackground(Color.WHITE);
		cbGioiTinh.setBounds(963, 59, 93, 35);
		add(cbGioiTinh);
		
		JLabel lblNhpSt_1_1_4 = new JLabel("Giới tính  :");
		lblNhpSt_1_1_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_4.setBounds(861, 59, 87, 35);
		add(lblNhpSt_1_1_4);
		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("Nữ");
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTen.setColumns(10);
		txtTen.setBounds(449, 103, 368, 35);
		add(txtTen);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Arial", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBounds(449, 149, 368, 35);
		add(txtSDT);
		
		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Arial", Font.PLAIN, 16));
		txtCMND.setColumns(10);
		txtCMND.setBounds(963, 105, 341, 35);
		add(txtCMND);
		
		cbHuyen = new JComboBox<String>();
		cbHuyen.setFont(new Font("Arial", Font.PLAIN, 16));
		cbHuyen.setBackground(Color.WHITE);
		cbHuyen.setBounds(781, 197, 205, 35);
		add(cbHuyen);
		cbHuyen.addItem("Quận/Huyện");
		
		cbXa = new JComboBox<String>();
		cbXa.setFont(new Font("Arial", Font.PLAIN, 16));
		cbXa.setBackground(Color.WHITE);
		cbXa.setBounds(1099, 197, 205, 35);
		add(cbXa);
		cbXa.addItem("Phường/Xã");
		
		cbTinh = new JComboBox<String>();
		cbTinh.setFont(new Font("Arial", Font.PLAIN, 16));
		cbTinh.setBackground(Color.WHITE);
		cbTinh.setBounds(449, 195, 205, 35);
		add(cbTinh);
		cbTinh.addItem("Tỉnh/Thành phố");
		listTinhTP = diaChiDao.getAllTinhTP();
		for(String a : listTinhTP) {
			cbTinh.addItem(a);
		}
		
		txtMatKhau = new JTextField();
		txtMatKhau.setFont(new Font("Arial", Font.PLAIN, 16));
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(963, 151, 341, 35);
		add(txtMatKhau);
		
		JLabel lblNhpSt_1_1_2_1_1 = new JLabel("Mật khẩu :");
		lblNhpSt_1_1_2_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_2_1_1.setBounds(863, 151, 123, 35);
		add(lblNhpSt_1_1_2_1_1);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(CapNhatNhanVienPnGUI.class.getResource("/img/lam_moi.png")));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLamMoi.setBounds(669, 311, 150, 35);
		add(btnLamMoi);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setIcon(new ImageIcon(CapNhatNhanVienPnGUI.class.getResource("/img/update.png")));
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCapNhat.setBounds(1154, 311, 150, 35);
		add(btnCapNhat);
		
		lblAnh = new JLabel();
		lblAnh.setBorder(new LineBorder(Color.BLACK));
		lblAnh.setBounds(57, 57, 231, 244);
		add(lblAnh);
		
		JLabel lblNhpSt_1_1_4_1 = new JLabel("Trạng thái  :");
		lblNhpSt_1_1_4_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_4_1.setBounds(1081, 57, 99, 35);
		add(lblNhpSt_1_1_4_1);
		
		cbTrangThai = new JComboBox<String>();
		cbTrangThai.setFont(new Font("Arial", Font.PLAIN, 16));
		cbTrangThai.setBackground(Color.WHITE);
		cbTrangThai.setBounds(1177, 57, 127, 35);
		add(cbTrangThai);
		
		btnChonAnh = new JButton("Chọn ảnh");
		btnChonAnh.setIcon(new ImageIcon(CapNhatNhanVienPnGUI.class.getResource("/img/file.png")));
		btnChonAnh.setFont(new Font("Arial", Font.PLAIN, 16));
		btnChonAnh.setBounds(113, 305, 123, 35);
		add(btnChonAnh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 357, 1296, 210);
		add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel(new String[] {
				"Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày sinh", "Số điện thoại", "CMND"
			}, 0){
			/**
				 * 
				 */
				private static final long serialVersionUID = -2750624469713725109L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};
		table.setModel(model);
		table.setFont(new Font("Arial", Font.PLAIN, 16));
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		
		JLabel lblNhpSt_1_1_4_2 = new JLabel("Ngày sinh :");
		lblNhpSt_1_1_4_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_4_2.setBounds(572, 57, 87, 35);
		add(lblNhpSt_1_1_4_2);
		
		dateChooserNgaySinh = new JDateChooser();
		dateChooserNgaySinh.setBounds(669, 57, 148, 35);
		dateChooserNgaySinh.setFont(new Font("Arial", Font.PLAIN, 16));
		dateChooserNgaySinh.setDateFormatString("dd/MM/yyyy");
		add(dateChooserNgaySinh);
		
		btnKhoiPhuc = new JButton("Khôi phục");
		btnKhoiPhuc.setIcon(new ImageIcon(CapNhatNhanVienPnGUI.class.getResource("/img/back.png")));
		btnKhoiPhuc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhoiPhuc.setBounds(931, 311, 125, 35);
		add(btnKhoiPhuc);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(308, 240, 996, 61);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNhpSt_1_1_2_2 = new JLabel("Mã nhân viên   :");
		lblNhpSt_1_1_2_2.setBounds(10, 12, 123, 35);
		panel.add(lblNhpSt_1_1_2_2);
		lblNhpSt_1_1_2_2.setFont(new Font("Arial", Font.BOLD, 16));
		
		txtTimMa = new JTextField();
		txtTimMa.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTimMa.setBounds(140, 12, 191, 35);
		panel.add(txtTimMa);
		txtTimMa.setColumns(10);
		
		JLabel lblNhpSt_1_1_2_2_1 = new JLabel("Tên nhân viên :");
		lblNhpSt_1_1_2_2_1.setBounds(375, 12, 123, 35);
		panel.add(lblNhpSt_1_1_2_2_1);
		lblNhpSt_1_1_2_2_1.setFont(new Font("Arial", Font.BOLD, 16));
		
		txtTimTen = new JTextField();
		txtTimTen.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTimTen.setBounds(508, 12, 203, 35);
		panel.add(txtTimTen);
		txtTimTen.setColumns(10);
		
		cbTimTrangThai = new JComboBox<String>();
		cbTimTrangThai.setFont(new Font("Arial", Font.PLAIN, 16));
		cbTimTrangThai.setBounds(859, 12, 127, 35);
		panel.add(cbTimTrangThai);
		cbTimTrangThai.setBackground(Color.WHITE);
		
		JLabel lblNhpSt_1_1_2_2_1_1 = new JLabel("Trạng thái :");
		lblNhpSt_1_1_2_2_1_1.setBounds(756, 12, 100, 35);
		panel.add(lblNhpSt_1_1_2_2_1_1);
		lblNhpSt_1_1_2_2_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		
		btnBackEnd = new JButton("");
		btnBackEnd.setIcon(new ImageIcon(CapNhatNhanVienPnGUI.class.getResource("/img/previousEnd.png")));
		btnBackEnd.setBounds(488, 578, 80, 30);
		add(btnBackEnd);
		
		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(CapNhatNhanVienPnGUI.class.getResource("/img/rewind-button.png")));
		btnBack.setBounds(580, 578, 80, 30);
		add(btnBack);
		
		lblSoTrangTable = new JLabel("1");
		lblSoTrangTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoTrangTable.setFont(new Font("Arial", Font.BOLD, 16));
		lblSoTrangTable.setBounds(648, 578, 81, 35);
		add(lblSoTrangTable);
		
		btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon(CapNhatNhanVienPnGUI.class.getResource("/img/nextbutton.png")));
		btnNext.setBounds(712, 578, 80, 30);
		add(btnNext);
		
		btnNextEnd = new JButton("");
		btnNextEnd.setIcon(new ImageIcon(CapNhatNhanVienPnGUI.class.getResource("/img/next.png")));
		btnNextEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNextEnd.setBounds(812, 578, 80, 30);
		add(btnNextEnd);
		
		btnCapNhat.addActionListener(this);
		btnChonAnh.addActionListener(this);
		btnKhoiPhuc.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnBack.addActionListener(this);
		btnBackEnd.addActionListener(this);
		btnNext.addActionListener(this);
		btnNextEnd.addActionListener(this);
		txtTimMa.addKeyListener(this);
		txtTimTen.addKeyListener(this);
		cbTimTrangThai.addItemListener(this);
		cbTinh.addItemListener(this);
		cbHuyen.addItemListener(this);
		table.addMouseListener(this);
		
		cbTrangThai.addItem("Đang làm");
		cbTrangThai.addItem("Nghỉ việc");
		cbTimTrangThai.addItem("Đang làm");
		cbTimTrangThai.addItem("Đã nghỉ");
		cbHuyen.setEnabled(false);
		cbXa.setEnabled(false);
		
		handleLoadData();
		
		table.setDefaultEditor(Object.class, null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
///////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if (o == btnNext && pageIndex < tongPage) {
			pageIndex ++;
			loadData();
		}
		if (o == btnNextEnd && pageIndex < tongPage) {
			pageIndex = tongPage;
			loadData();
		}
		if (o == btnBack && pageIndex>1) {
			pageIndex--;
			loadData();
		}
		if (o == btnBackEnd && pageIndex>1) {
			pageIndex = 1;
			loadData();
		}
		
		if (o == btnLamMoi) {
			lamMoi();
		}
		
		if (o == btnChonAnh) {
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Hinh anh","jpg","png");
			fileChooser.setFileFilter(extensionFilter);
			fileChooser.setMultiSelectionEnabled(false);
			int x = fileChooser.showDialog(this, "Chọn file");
			if(x == APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();
				BufferedImage bImage = scaleImage(lblAnh.getWidth(),lblAnh.getHeight(), file.getAbsolutePath());
				ImageIcon icon = new ImageIcon(bImage);
				lblAnh.setIcon(icon);
			}
		}
		
		if (o == btnKhoiPhuc) {
			if (nhanVienEdit!=null) {
				lblMa.setText(nhanVienEdit.getMaNV());
				txtTen.setText(nhanVienEdit.getHoTen());
				txtCMND.setText(nhanVienEdit.getcmnd());
				txtMatKhau.setText(nhanVienEdit.getMatKhau());
				txtSDT.setText(nhanVienEdit.getSdt());
				dateChooserNgaySinh.setDate(nhanVienEdit.getNgaySinh());
				cbGioiTinh.setSelectedIndex(nhanVienEdit.isGioiTinh()==true?0:1);
				cbTrangThai.setSelectedIndex(nhanVienEdit.isTrangThai()==true?0:1);
				cbTinh.setSelectedItem(nhanVienEdit.getDiaChi().getTinhTP().trim());
				cbHuyen.setSelectedItem(nhanVienEdit.getDiaChi().getQuanHuyen());
				cbXa.setSelectedItem(nhanVienEdit.getDiaChi().getPhuongXa());
				
				if (nhanVienEdit.getHinhAnh()!=null) {
					BufferedImage bImg = scaleImage(lblAnh.getWidth(), lblAnh.getHeight(), "imgNhanVien//" + nhanVienEdit.getHinhAnh().trim());
					ImageIcon icon = new ImageIcon(bImg);
					lblAnh.setIcon(icon);
				}
				else {
					lblAnh.setIcon(null);
				}
			}
		}
		
		if (o == btnCapNhat) {
			if (!lblMa.getText().trim().equals("")) {
				if (kiemTraDuLieu()) {
					String ma = lblMa.getText().trim();
					String ten = txtTen.getText().trim();
					String sdt = txtSDT.getText().trim();
					String cmnd = txtCMND.getText().trim();
					String matKhau = txtMatKhau.getText().trim();
					Date ngaySinh = dateChooserNgaySinh.getDate();
					String tinh = cbTinh.getSelectedItem().toString();
					String huyen = cbHuyen.getSelectedItem().toString();
					String xa = cbXa.getSelectedItem().toString();
					DiaChi diaChi = diaChiDao.getDiaChi(xa, huyen, tinh);
					String picName = nhanVienEdit.getHinhAnh();
					
					boolean trangThai = cbTrangThai.getSelectedIndex()==0?true:false;
					
					boolean gioiTinh = true;
					if (cbGioiTinh.getSelectedIndex() == 1)
						gioiTinh = false;
					
					
					if (file!=null) {
						picName = getNameByPath(file.getAbsolutePath());
					}
					NhanVien nhanVien = new NhanVien(ma,ten,matKhau,trangThai,sdt,gioiTinh,ngaySinh,false,cmnd,picName,diaChi);
					
					int op = JOptionPane.showConfirmDialog(this,"Bạn muốn cập nhật thông tin nhân viên?","Cảnh báo!",JOptionPane.YES_OPTION);
					if (op == JOptionPane.YES_OPTION) {
						if (nhanVienDao.capNhatNhanVien(nhanVien)) {
							if (file!=null) {
								coppyImg(picName, file);
								file = null;
								if (nhanVienEdit.getHinhAnh()!=null) {
									File imgOld = new File("imgNhanVien//"+nhanVienEdit.getHinhAnh().trim());
									imgOld.delete();
								}
							}
							JOptionPane.showMessageDialog(this,"Cập nhật thông tin nhân viên thành công!");
//							nhanVienEdit = null;
							lblMa.setText("");
							txtTen.setText("");
							txtCMND.setText("");
							txtMatKhau.setText("");
							txtSDT.setText("");
							dateChooserNgaySinh.setDate(Calendar.getInstance().getTime());
							cbGioiTinh.setSelectedIndex(0);
							cbTrangThai.setSelectedIndex(0);
							cbTinh.setSelectedIndex(0);
							lblAnh.setIcon(null);
							if (list.contains(nhanVien)) {
								loadData();
							}
							
						}
						else {
							JOptionPane.showMessageDialog(this,"Cập nhật thông tin nhân viên không thành công!");
						}
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(this,"Vui lòng chọn nhân viên cần cập nhật thông tin!");
			}
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
		handleLoadData();
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object o = e.getSource();
		
		if (e.getStateChange() == ItemEvent.SELECTED)
			return;
		
		if (o == cbTimTrangThai) {
			handleLoadData();
		}
		
		if(o.equals(cbTinh)) {
			cbHuyen.removeAllItems();
			cbHuyen.addItem("Quận/Huyện");
			if(cbTinh.getSelectedIndex() > 0) {
				String tinh = cbTinh.getSelectedItem().toString();
				cbHuyen.setEnabled(true);
				listQuanHuyen = diaChiDao.getAllHuyenTrongTinhTP(tinh);
				for(String b : listQuanHuyen) {
					cbHuyen.addItem(b);
				}
			}
			else {
				cbHuyen.setEnabled(false);
			}
		}
		if(o.equals(cbHuyen)) {
			cbXa.removeAllItems();
			cbXa.addItem("Phường/Xã");
			if(cbHuyen.getSelectedIndex() > 0) {
				String tinh = cbTinh.getSelectedItem().toString();
				String huyen = cbHuyen.getSelectedItem().toString();
				cbXa.setEnabled(true);
				listPhuongXa = diaChiDao.getAllPhuongXa(tinh, huyen);
				for(String c : listPhuongXa) {
					cbXa.addItem(c);
				}
			}
			else{
				cbXa.setEnabled(false);
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int index = table.getSelectedRow();
		NhanVien nv = list.get(index);
		nhanVienEdit = nv;
		
		lblMa.setText(nv.getMaNV());
		txtTen.setText(nv.getHoTen());
		txtCMND.setText(nv.getcmnd());
		txtMatKhau.setText(nv.getMatKhau());
		txtSDT.setText(nv.getSdt());
		dateChooserNgaySinh.setDate(nv.getNgaySinh());
		cbGioiTinh.setSelectedIndex(nv.isGioiTinh()==true?0:1);
		cbTrangThai.setSelectedIndex(nv.isTrangThai()==true?0:1);
		cbTinh.setSelectedItem(nv.getDiaChi().getTinhTP().trim());
		cbHuyen.setSelectedItem(nv.getDiaChi().getQuanHuyen());
		cbXa.setSelectedItem(nv.getDiaChi().getPhuongXa());
		
		if (nv.getHinhAnh()!=null) {
			BufferedImage bImg = scaleImage(lblAnh.getWidth(), lblAnh.getHeight(), "imgNhanVien//" + nv.getHinhAnh().trim());
			ImageIcon icon = new ImageIcon(bImg);
			lblAnh.setIcon(icon);
		}
		else {
			lblAnh.setIcon(null);
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
//////////////////////////////////////////////////////////////////////////////
	
	private void lamMoi() {
		lblMa.setText("");
		txtTen.setText("");
		txtCMND.setText("");
		txtMatKhau.setText("");
		txtSDT.setText("");
		dateChooserNgaySinh.setDate(Calendar.getInstance().getTime());
		cbGioiTinh.setSelectedIndex(0);
		cbTrangThai.setSelectedIndex(0);
		cbTinh.setSelectedIndex(0);
		
		txtTimMa.setText("");
		txtTimTen.setText("");
		cbTimTrangThai.setSelectedIndex(0);
		lblAnh.setIcon(null);
		
		handleLoadData();
	}
	
	private void handleLoadData() {
		int soHang = nhanVienDao.getTongSoHang(txtTimMa.getText().trim(),txtTimTen.getText().trim(),cbTimTrangThai.getSelectedIndex()==0?true:false);
		if (soHang == 0) {
			lblSoTrangTable.setText("1/1");
			xoaDataModel();
			list= null;
			return;
		}
		tongPage = soHang % 6 == 0 ? soHang / 6 : (soHang/6)+1;
		pageIndex = 1;
		loadData();
		
	}
	
	
	private void loadData() {
		xoaDataModel();
		list = nhanVienDao.timKiemNhanVien(txtTimMa.getText().trim(),txtTimTen.getText().trim(),cbTimTrangThai.getSelectedIndex()==0?true:false, pageIndex);
		lblSoTrangTable.setText(pageIndex+"/"+tongPage);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		list.forEach(l->{
			model.addRow(new Object[] {l.getMaNV(),l.getHoTen(),l.isGioiTinh()==true?"Nam":"Nữ",formatter.format( l.getNgaySinh()),l.getSdt(),l.getcmnd()});
		});
	}
	
	private void xoaDataModel() {
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		table.clearSelection();
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
			FileOutputStream out = new FileOutputStream(new File("imgNhanVien//"+name));
			  int length;
	            byte[] buffer = new byte[1024];
	 
	            // copy the file content in bytes
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
	
	@SuppressWarnings("deprecation")
	private boolean kiemTraDuLieu() {
		if (txtTen.getText().trim().equals("")) {
			focus(txtTen, "Vui lòng nhập tên nhân viên!");
			return false;
		}
		if (!txtTen.getText().trim().matches("" + "[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ"
				+ "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu"
				+ "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ]+")) {
			focus(txtTen, "Vui lòng nhập tên nhân viên không chứa kí tự số và ký tự đặc biệt!");
			return false;
		}
		if (txtSDT.getText().trim().equals("")) {
			focus(txtSDT, "Vui lòng nhập số điện thoại!");
			return false;
		}
		if (!txtSDT.getText().trim().matches("^0[1-9][0-9]{8,9}")) {
			focus(txtSDT, "Vui lòng nhập số điện thoại từ 10 đến 11 số!");
			return false;
		}
		if (!txtSDT.getText().trim().equals(nhanVienEdit.getSdt().trim()) && !nhanVienDao.kiemTraSoDienThoai(txtSDT.getText().trim())) {
			focus(txtSDT, "Số điện thoại này đã tồn tại!");
			return false;
		}
		if (dateChooserNgaySinh.getDate() == null) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày sinh!");
			dateChooserNgaySinh.requestFocus();
			return false;
		}
		
		LocalDate ngaySinh  = LocalDate.of(dateChooserNgaySinh.getDate().getYear()+1900,dateChooserNgaySinh.getDate().getMonth()+1,dateChooserNgaySinh.getDate().getDate());
		System.out.println(dateChooserNgaySinh.getDate().getYear());
		if (Period.between(ngaySinh,LocalDate.now()).getYears()<18) {
			JOptionPane.showMessageDialog(this, "Lao động phải từ 18 tuổi trở lên!");
			dateChooserNgaySinh.requestFocus();
			return false;
		}
		if (txtCMND.getText().trim().equals("")) {
			focus(txtCMND, "Vui lòng nhập chứng minh nhân dân!");
			return false;
		}
		if (!txtCMND.getText().trim().matches("^[0-9]{9,}")) {
			focus(txtCMND, "Vui lòng nhập chứng minh nhân dân từ 9 số trở lên!");
			return false;
		}
		if (!txtCMND.getText().trim().equals(nhanVienEdit.getcmnd().trim()) && !nhanVienDao.kiemTraChungMinhNhanDan(txtCMND.getText().trim())) {
			focus(txtCMND, "Chứng minh nhân dân này đã tồn tại!");
			return false;
		}
		if (cbTinh.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn Tỉnh/Thành phố");
			return false;
		}
		if (cbHuyen.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn Quận/huyện");
			return false;
		}
		if (cbXa.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn Phường/xã");
			return false;
		}
		if (txtMatKhau.getText().trim().equals("")){
			focus(txtMatKhau, "Vui lòng nhập mật khẩu!");
			return false;
		}
		if (txtMatKhau.getText().trim().length()<6){
			focus(txtMatKhau, "Vui lòng nhập mật khẩu từ 6 ký tự trở lên!");
			return false;
		}
		return true;
	}
	
	private void focus(JTextField txt,String mess) {
		txt.selectAll();
		txt.requestFocus();
		JOptionPane.showMessageDialog(this,mess);
	}
	
}
