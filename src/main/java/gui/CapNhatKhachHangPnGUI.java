package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.DiaChiDao;
import dao.KhachHangDao;
import dao.Ipml.DiaChiImpl;
import dao.Ipml.KhachHangImpl;
import entity.DiaChi;
import entity.KhachHang;

public class CapNhatKhachHangPnGUI extends JPanel implements ActionListener, MouseListener, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2854904150057221720L;
	private JTextField txtTen;
	private JTextField txtSDT;
	private JTextField txtTimMa;
	private JTextField txtTimTen;
	private JTable table;
	private JButton btnKhoiPhuc;
	private JComboBox<String> cbGioiTinh;
	private JComboBox<String> cbTinh;
	private JComboBox<String> cbHuyen;
	private JComboBox<String> cbXa;
	private JButton btnBackEnd;
	private JButton btnBack;
	private JButton btnNext;
	private JButton btnNextEnd;
	private JLabel lblPageCurrent;
	private JLabel lblPageTotal;
	private DefaultTableModel modelTable;
	private KhachHangDao khachHangDao;
	private DiaChiDao diaChiDao;
	private JLabel lblMa;
	private JButton btnLamMoi;
	private JButton btnCapNhat;

	/**
	 * Create the panel.
	 */
	public CapNhatKhachHangPnGUI() {
		khachHangDao = new KhachHangImpl();
		diaChiDao = new DiaChiImpl();
		setBackground(Color.WHITE);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(0,0, 1364, 621);
		setLayout(null);
		
		JLabel lblCNhnVin = new JLabel("CẬP NHẬT KHÁCH HÀNG");
		lblCNhnVin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCNhnVin.setFont(new Font("Arial", Font.BOLD, 20));
		lblCNhnVin.setBounds(0, 11, 1364, 35);
		add(lblCNhnVin);
		
		JLabel lblNhpSt_1_1 = new JLabel("Mã khách hàng  :");
		lblNhpSt_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1.setBounds(263, 57, 141, 35);
		add(lblNhpSt_1_1);
		
		lblMa = new JLabel("");
		lblMa.setForeground(Color.RED);
		lblMa.setFont(new Font("Arial", Font.ITALIC, 16));
		lblMa.setBounds(426, 57, 123, 35);
		add(lblMa);
		
		JLabel lblNhpSt_1_1_1 = new JLabel("Tên khách hàng :");
		lblNhpSt_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1.setBounds(263, 103, 141, 35);
		add(lblNhpSt_1_1_1);
		
		JLabel lblNhpSt_1_1_2 = new JLabel("Số điện thoại       :");
		lblNhpSt_1_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_2.setBounds(263, 149, 141, 35);
		add(lblNhpSt_1_1_2);
		
		JLabel lblNhpSt_1_1_3 = new JLabel("Địa chỉ                   :");
		lblNhpSt_1_1_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_3.setBounds(263, 195, 153, 35);
		add(lblNhpSt_1_1_3);
		
		cbGioiTinh = new JComboBox<String>();
		cbGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbGioiTinh.setBackground(Color.WHITE);
		cbGioiTinh.setBounds(960, 59, 123, 35);
		add(cbGioiTinh);
		
		JLabel lblNhpSt_1_1_4 = new JLabel("Giới tính  :");
		lblNhpSt_1_1_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_4.setBounds(863, 57, 87, 35);
		add(lblNhpSt_1_1_4);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTen.setColumns(10);
		txtTen.setBounds(426, 105, 657, 35);
		add(txtTen);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSDT.setColumns(10);
		txtSDT.setBounds(426, 151, 657, 35);
		add(txtSDT);
		
		cbHuyen = new JComboBox<String>();
		cbHuyen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbHuyen.setBackground(Color.WHITE);
		cbHuyen.setBounds(651, 197, 205, 35);
		add(cbHuyen);
		
		cbXa = new JComboBox<String>();
		cbXa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbXa.setBackground(Color.WHITE);
		cbXa.setBounds(877, 197, 205, 35);
		add(cbXa);
		
		cbTinh = new JComboBox<String>();
		cbTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbTinh.setBackground(Color.WHITE);
		cbTinh.setBounds(426, 197, 205, 35);
		add(cbTinh);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setIcon(new ImageIcon(CapNhatKhachHangPnGUI.class.getResource("/img/update.png")));
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCapNhat.setBounds(933, 242, 150, 35);
		add(btnCapNhat);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 357, 1137, 215);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(modelTable =  new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã khách hàng", "Tên khách hàng", "Giới tính", "Số điện thoại", "Địa chỉ"
			}
		));
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		btnKhoiPhuc = new JButton("Khôi phục");
		btnKhoiPhuc.setIcon(new ImageIcon(CapNhatKhachHangPnGUI.class.getResource("/img/back.png")));
		btnKhoiPhuc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKhoiPhuc.setBounds(731, 242, 125, 35);
		add(btnKhoiPhuc);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(114, 287, 1137, 59);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNhpSt_1_1_2_2 = new JLabel("Mã khách hàng   :");
		lblNhpSt_1_1_2_2.setBounds(10, 10, 141, 35);
		panel.add(lblNhpSt_1_1_2_2);
		lblNhpSt_1_1_2_2.setFont(new Font("Arial", Font.BOLD, 16));
		
		txtTimMa = new JTextField();
		txtTimMa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimMa.setBounds(173, 12, 206, 35);
		panel.add(txtTimMa);
		txtTimMa.setColumns(10);
		
		JLabel lblNhpSt_1_1_2_2_1 = new JLabel("Tên khách hàng :");
		lblNhpSt_1_1_2_2_1.setBounds(473, 10, 141, 35);
		panel.add(lblNhpSt_1_1_2_2_1);
		lblNhpSt_1_1_2_2_1.setFont(new Font("Arial", Font.BOLD, 16));
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBounds(977, 12, 150, 35);
		panel.add(btnLamMoi);
		btnLamMoi.setIcon(new ImageIcon(CapNhatKhachHangPnGUI.class.getResource("/img/lam_moi.png")));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		txtTimTen = new JTextField();
		txtTimTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTimTen.setBounds(638, 12, 206, 35);
		panel.add(txtTimTen);
		txtTimTen.setColumns(10);
		
		btnBackEnd = new JButton("");
		btnBackEnd.setIcon(new ImageIcon(CapNhatKhachHangPnGUI.class.getResource("/img/previousEnd.png")));
		btnBackEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBackEnd.setBounds(436, 583, 92, 29);
		add(btnBackEnd);
		
		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(CapNhatKhachHangPnGUI.class.getResource("/img/rewind-button.png")));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(538, 583, 92, 29);
		add(btnBack);
		
		btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon(CapNhatKhachHangPnGUI.class.getResource("/img/forward-button.png")));
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNext.setBounds(743, 583, 92, 29);
		add(btnNext);
		
		btnNextEnd = new JButton("");
		btnNextEnd.setIcon(new ImageIcon(CapNhatKhachHangPnGUI.class.getResource("/img/next.png")));
		btnNextEnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNextEnd.setBounds(845, 583, 92, 29);
		add(btnNextEnd);
		
		lblPageCurrent = new JLabel("1");
		lblPageCurrent.setHorizontalAlignment(SwingConstants.CENTER);
		lblPageCurrent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPageCurrent.setBounds(640, 582, 36, 30);
		add(lblPageCurrent);
		
		lblPageTotal = new JLabel("/0");
		lblPageTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPageTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPageTotal.setBounds(686, 582, 36, 30);
		add(lblPageTotal);
		
		table.setRowHeight(30);
		
		cbGioiTinh.addItem("Nam");
		cbGioiTinh.addItem("Nữ");
		cbTinh.addItem("Tỉnh/Thành phố");
		cbHuyen.addItem("Quận/Huyện");
		cbXa.addItem("Xã/Phường");
		loadCombobox(cbTinh, diaChiDao.getAllTinhTP());
		List<KhachHang> khaHangs = khachHangDao.getKhachHangTheoPage_instance(0, 6,"", "");
		loadTable(khaHangs);
		lblPageTotal.setText("/"+String.valueOf(tongPage()));
		
		cbHuyen.setEnabled(false);
		cbXa.setEnabled(false);
		
		btnCapNhat.addActionListener(this);
		btnKhoiPhuc.addActionListener(this);
		btnLamMoi.addActionListener(this);
		txtTimMa.addKeyListener(this);
		txtTimTen.addKeyListener(this);
		btnBack.addActionListener(this);
		btnBackEnd.addActionListener(this);
		btnNext.addActionListener(this);
		btnNextEnd.addActionListener(this);
		table.addMouseListener(this);
		cbTinh.addActionListener(this);
		cbHuyen.addActionListener(this);
		cbXa.addActionListener(this);
		
		table.setDefaultEditor(Object.class, null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public int tongPage() {
		int tongPage = 1;
		String  maSanPham = txtTimMa.getText();
		String tenSanPham = txtTimTen.getText().replace(' ','%');
		
		int tongHang = khachHangDao.tongHangTimKiem(maSanPham, tenSanPham);
		tongPage = tongHang % 6 == 0 ? tongHang / 6 : (tongHang/6)+1;
		return tongPage;
	}
	
	public void loadTable(List<KhachHang> khachHangs) {
		for (KhachHang khachHang : khachHangs) {
			modelTable.addRow(new Object[] {khachHang.getMaKH(), khachHang.getHoTen(), khachHang.isGioiTinh() ? "Nam" : "Nữ", khachHang.getSdt(), khachHang.getDiaChi().getTinhTP()+"-"+khachHang.getDiaChi().getQuanHuyen()+"-"+khachHang.getDiaChi().getPhuongXa()});
		}
	}
	
	public void loadCombobox(JComboBox<String> cb, List<String> list) {
		for (String string : list) {
			cb.addItem(string);
		}
	}
	
	public void addInToTable() {
		int page = Integer.parseInt(lblPageCurrent.getText().toString());
		String  maSanPham = txtTimMa.getText().trim();
		String tenSanPham = txtTimTen.getText().trim().replace(' ','%');
		List<KhachHang> list = khachHangDao.getKhachHangTheoPage_instance(page-1,6, maSanPham, tenSanPham);
		loadTable(list);

	}
	
	public void xoaToanBoban() {
		modelTable.getDataVector().removeAllElements();
		modelTable.fireTableDataChanged();
		clear();
	}
	
	public void setTextFiled(KhachHang khachHang) {
		lblMa.setText(khachHang.getMaKH());
		txtTen.setText(khachHang.getHoTen());
		txtSDT.setText(khachHang.getSdt());
		cbGioiTinh.setSelectedIndex(khachHang.isGioiTinh() ? 0 : 1);
		cbTinh.setSelectedItem(khachHang.getDiaChi().getTinhTP());
		cbHuyen.removeAllItems();
		cbHuyen.addItem("Quận/Huyện");
		loadCombobox(cbHuyen, diaChiDao.getAllHuyenTrongTinhTP(khachHang.getDiaChi().getTinhTP()));
		cbHuyen.setSelectedItem(khachHang.getDiaChi().getQuanHuyen());
		cbXa.removeAllItems();
		cbXa.addItem("Xã/Phường");
		loadCombobox(cbXa, diaChiDao.getAllPhuongXaTheoHuyen(khachHang.getDiaChi().getQuanHuyen()));
		cbXa.setSelectedItem(khachHang.getDiaChi().getPhuongXa());
	}
	
	public void clear() {
		lblMa.setText("");
		txtTen.setText("");
		cbGioiTinh.setSelectedIndex(0);
		cbTinh.setSelectedIndex(0);
		txtSDT.setText("");
	}
	
	public boolean kiemTra() {
		String sdt = txtSDT.getText();
		String tenKhachHang =  txtTen.getText().toString().trim();
		
		if(tenKhachHang.trim().length() == 0) {
			JOptionPane.showMessageDialog(this, "Tên nhân khách hàng không được rỗng");
			txtTen.selectAll();
			txtTen.requestFocus();
			return false;
		}
		if(!tenKhachHang.matches("[^0-9!@#$%^&*()_+{}:]*")) {
			JOptionPane.showMessageDialog(this, "Tên nhân khách hàng phải là chữ Không được chứa số và kí tự đặc biệt");
			txtTen.selectAll();
			txtTen.requestFocus();
			return false;
		}

		if(sdt.equals("")){
			JOptionPane.showMessageDialog(null,"Vui lòng nhập số điện thoại");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return false;
		}
		
		else if(!sdt.matches("(^(03)[2-9]\\d{7})|(^(07)[06-9]\\d{7})|(^(08)[1-5]\\d{7})|(^(056)\\d{7})|(^(058)\\d{7})|(^(059)\\d{7})|(^(09)[0-46-9]\\d{7})")) {
			txtSDT.selectAll();
			txtSDT.requestFocus();
			JOptionPane.showMessageDialog(this,"Số điện thoại không đúng địng dạng");
			return false;
		}else if(khachHangDao.getKhachHangByStd(sdt) != null && !khachHangDao.getKhachHangByStd(sdt).getMaKH().equals(lblMa.getText())){
			JOptionPane.showMessageDialog(this,"Số điện thoại đã tồn tại ");
			txtSDT.selectAll();
			txtSDT.requestFocus();
			return false;
		}
		
		if(cbTinh.getSelectedIndex() == 0 || cbHuyen.getSelectedIndex() == 0 || cbXa.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Vui lòng kiểm tra lại đại chỉ");
			return false;
		}
		return true;
	}

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
				table.clearSelection();
				addInToTable();
			}

		}
		if (o.equals(btnBack)) {
			int page = Integer.parseInt(lblPageCurrent.getText());
			if (page > 1) {
				page -=1;
				lblPageCurrent.setText(Integer.toString(page));
				xoaToanBoban();
				table.clearSelection();
				addInToTable();

			}
		}

		if (o.equals(btnNextEnd)) {
			int page = Integer.parseInt(lblPageCurrent.getText());
			if (page != tongPage) {
				lblPageCurrent.setText(Integer.toString(tongPage));
				xoaToanBoban();
				table.clearSelection();
				addInToTable();
			}
		}

		if (o.equals(btnBackEnd)) {
			int page = Integer.parseInt(lblPageCurrent.getText());
			if (page != 1) {
				lblPageCurrent.setText(Integer.toString(1));
				xoaToanBoban();
				table.clearSelection();
				addInToTable();
			}
		}
		
		if(o.equals(cbTinh)) {
			cbHuyen.removeAllItems();
			if(cbTinh.getSelectedIndex() > 0) {
				cbHuyen.setEnabled(true);
				cbHuyen.addItem("Quận/Huyện");
//				cbXa.addItem("Xã/Phường");
				String tinh = cbTinh.getSelectedItem().toString();
				
				List<String> listQuanHuyen = diaChiDao.getAllHuyenTrongTinhTP(tinh);
				for(String b : listQuanHuyen) {
					cbHuyen.addItem(b);
				}
			}
			else {
				cbHuyen.setEnabled(false);
				cbHuyen.addItem("Quận/Huyện");
				cbXa.addItem("Xã/Phường");
			}
		}
		if(o.equals(cbHuyen)) {
			cbXa.removeAllItems();
			if(cbHuyen.getSelectedIndex() > 0) {
				String tinh = cbTinh.getSelectedItem().toString();
				String huyen = cbHuyen.getSelectedItem().toString();
				cbXa.setEnabled(true);
				cbXa.addItem("Phường/Xã");
				List<String> listPhuongXa = diaChiDao.getAllPhuongXa(tinh, huyen);
				for(String c : listPhuongXa) {
					cbXa.addItem(c);
				}
			}
			else{
				cbXa.setEnabled(false);
				cbXa.addItem("Phường/Xã");
			}
		}
		

		if(o.equals(btnKhoiPhuc)) {
			KhachHang khachHang = khachHangDao.getKhachHangById(lblMa.getText());
			setTextFiled(khachHang);
		}
		
		if(o.equals(btnLamMoi)) {
			txtTimMa.setText("");
			txtTimTen.setText("");
			lblPageCurrent.setText("1");
			lblPageTotal.setText("/"+tongPage);
			xoaToanBoban();
			addInToTable();
			lblMa.setText("");
			cbGioiTinh.setSelectedIndex(0);
			txtTen.setText("");
			txtSDT.setText("");
		}
		
		if(o.equals(btnCapNhat)) {
			if(table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this,"Vui lòng chọn khách hàng cần cập nhật");
				return;
			}
			if(kiemTra()) {
			int n = JOptionPane.showConfirmDialog(this,"Bạn có muốn cập nhật khách hàng không","Thông báo",JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION) {
					String ten = txtTen.getText();
					@SuppressWarnings("unused")
					boolean gioiTinh = cbGioiTinh.getSelectedIndex() == 0 ? true : false;
					String sdt = txtSDT.getText();
					String tinh = cbTinh.getSelectedItem().toString();
					String huyen = cbHuyen.getSelectedItem().toString();
					String xa = cbXa.getSelectedItem().toString();
					DiaChi diaChi = diaChiDao.getDiaChi(xa, huyen, tinh);
					KhachHang khachHang = new KhachHang(lblMa.getText(), ten, sdt, diaChi);
					if(khachHangDao.update(khachHang)) {
						JOptionPane.showMessageDialog(this, "Cập nhật thành công");
						xoaToanBoban();
						addInToTable();
						clear();
					} else {
						JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
					}
				}
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
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(txtTimMa) || o.equals(txtTimTen)) {
			lblPageCurrent.setText("1");
			lblPageTotal.setText(String.valueOf("/"+tongPage()));
			xoaToanBoban();
			addInToTable();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(table)) {
			int row = table.getSelectedRow();
			KhachHang khachHang = khachHangDao.getKhachHangById(table.getValueAt(row, 0).toString());
			setTextFiled(khachHang);			
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
