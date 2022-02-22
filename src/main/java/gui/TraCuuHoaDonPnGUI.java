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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.HoaDonDao;
import dao.Ipml.HoaDonImpl;
import entity.HoaDon;
import entity.NhanVien;
import format.Format;

public class TraCuuHoaDonPnGUI extends JPanel
		implements ActionListener, KeyListener, ChangeListener, ItemListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6418853613991234332L;
	private JTextField txtSDTNV;
	private JTextField txtSDTKH;
	private JTextField txtMaHD;
	private JTextField txtTenKH;
	private JTable table;
	private JScrollPane scrollPane;
	private JDateChooser dateNgayLapHD;
	private JButton btnChiTiet;
	private JButton btnLamMoi;
	private JTextField txtTenNV;
	private DefaultTableModel model;
	private HoaDonDao hoaDonDao = new HoaDonImpl();
	private JLabel lblSoTrangTable;
	private JLabel lblTongTrang;
	private JButton btnBack;
	private JButton btnBackEnd;
	private JButton btnNext;
	private JButton btnNextEnd;
	private NhanVien nhanVien;

	public TraCuuHoaDonPnGUI(NhanVien nhanVien) {
		setBackground(Color.WHITE);
		this.nhanVien = nhanVien;
		setBounds(0, 50, 1364, 621);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("TRA CỨU HÓA ĐƠN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1344, 24);
		add(lblNewLabel);

		JLabel lblNgayLapHoaDon = new JLabel(" Ngày Lập HĐ   :");
		lblNgayLapHoaDon.setFont(new Font("Arial", Font.BOLD, 16));
		lblNgayLapHoaDon.setBounds(812, 105, 123, 35);
		add(lblNgayLapHoaDon);

		txtSDTNV = new JTextField();
		txtSDTNV.setFont(new Font("Arial", Font.PLAIN, 16));
		txtSDTNV.setColumns(10);
		txtSDTNV.setBounds(609, 105, 180, 35);
		add(txtSDTNV);

		txtSDTKH = new JTextField();
		txtSDTKH.setFont(new Font("Arial", Font.PLAIN, 16));
		txtSDTKH.setColumns(10);
		txtSDTKH.setBounds(609, 56, 180, 35);
		add(txtSDTKH);

		JLabel lblSDTKhachHang = new JLabel("SĐT Khách Hàng :");
		lblSDTKhachHang.setFont(new Font("Arial", Font.BOLD, 16));
		lblSDTKhachHang.setBounds(460, 56, 148, 35);
		add(lblSDTKhachHang);

		JLabel lblSDTNhanVien = new JLabel("SĐT Nhân Viên     :");
		lblSDTNhanVien.setFont(new Font("Arial", Font.BOLD, 16));
		lblSDTNhanVien.setBounds(460, 105, 148, 35);
		add(lblSDTNhanVien);

		JLabel lblMaHoaDon = new JLabel("Mã Hóa Đơn        :");
		lblMaHoaDon.setFont(new Font("Arial", Font.BOLD, 16));
		lblMaHoaDon.setBounds(39, 105, 148, 35);
		add(lblMaHoaDon);

		txtMaHD = new JTextField();
		txtMaHD.setFont(new Font("Arial", Font.PLAIN, 16));
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(181, 105, 265, 35);
		add(txtMaHD);

		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(181, 56, 265, 35);
		add(txtTenKH);

		JLabel lblTenKhachHang = new JLabel("Tên Khách Hàng:");
		lblTenKhachHang.setFont(new Font("Arial", Font.BOLD, 16));
		lblTenKhachHang.setBounds(39, 56, 148, 35);
		add(lblTenKhachHang);

		btnChiTiet = new JButton("Xem Chi Tiết");
		btnChiTiet.setIcon(new ImageIcon(TraCuuHoaDonPnGUI.class.getResource("/img/view-details.png")));
		btnChiTiet.setFont(new Font("Arial", Font.PLAIN, 16));
		btnChiTiet.setBounds(1190, 105, 143, 35);
		add(btnChiTiet);

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon(TraCuuHoaDonPnGUI.class.getResource("/img/lam_moi.png")));
		btnLamMoi.setFont(new Font("Arial", Font.PLAIN, 16));
		btnLamMoi.setBounds(1190, 56, 143, 35);
		add(btnLamMoi);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 172, 1344, 381);
		add(scrollPane);

		table = new JTable();
		String[] colHeader = { "Mã hóa đơn", "Mã khách hàng", "Ngày lập HĐ", "Tên Khách Hàng", "Số điện thoại KH",
				"Nhân viên lập", "Số điện thoại NV", "Tổng tiền" };
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
		table.setSelectionMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(15);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		btnNextEnd = new JButton("");
		btnNextEnd.setIcon(new ImageIcon(TraCuuHoaDonPnGUI.class.getResource("/img/nextEnd.png")));
		btnNextEnd.setBounds(844, 575, 80, 30);
		add(btnNextEnd);

		btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon(TraCuuHoaDonPnGUI.class.getResource("/img/forward-button.png")));
		btnNext.setBounds(744, 575, 80, 30);
		add(btnNext);

		lblSoTrangTable = new JLabel("1");
		lblSoTrangTable.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoTrangTable.setFont(new Font("Arial", Font.BOLD, 16));
		lblSoTrangTable.setBounds(623, 575, 81, 35);
		add(lblSoTrangTable);

		btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(TraCuuHoaDonPnGUI.class.getResource("/img/rewind-button.png")));
		btnBack.setBounds(552, 575, 80, 30);
		add(btnBack);

		btnBackEnd = new JButton("");
		btnBackEnd.setIcon(new ImageIcon(TraCuuHoaDonPnGUI.class.getResource("/img/previousEnd.png")));
		btnBackEnd.setBounds(460, 575, 80, 30);
		add(btnBackEnd);

		dateNgayLapHD = new JDateChooser();
		dateNgayLapHD.setBounds(945, 102, 208, 38);
		add(dateNgayLapHD);

		lblTongTrang = new JLabel("/ 0 ");
		lblTongTrang.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongTrang.setFont(new Font("Arial", Font.BOLD, 16));
		lblTongTrang.setBounds(653, 575, 81, 35);
		add(lblTongTrang);

		JLabel lblTenNV = new JLabel("Tên Nhân Viên :");
		lblTenNV.setFont(new Font("Arial", Font.BOLD, 16));
		lblTenNV.setBounds(812, 56, 130, 35);
		add(lblTenNV);

		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(945, 56, 208, 35);
		add(txtTenNV);

		dateNgayLapHD.setDateFormatString("dd/MM/yyyy");
		List<HoaDon> hoaDon;
		if (nhanVien.isChucVu()) {
			hoaDon = hoaDonDao.getAllHoaDonTheoPage(0, "", 0, 0, 0, "", "", "", "");
		} else {
			hoaDon = hoaDonDao.getAllHoaDonTheoPage(0, "", 0, 0, 0, "", "", "", nhanVien.getSdt());
		}
		loadTable(hoaDon);
		int tongHD = hoaDonDao.getTongSoHD("", 0, 0, 0, "", "", "", "");
		int tongPage = tongHD % 10 == 0 ? tongHD / 10 : (tongHD / 10) + 1;

		lblTongTrang.setText("/" + tongPage);

		btnLamMoi.addActionListener(this);
		btnChiTiet.addActionListener(this);
		btnBackEnd.addActionListener(this);
		btnBack.addActionListener(this);
		btnNext.addActionListener(this);
		btnNextEnd.addActionListener(this);
		txtMaHD.addKeyListener(this);
		txtSDTKH.addKeyListener(this);
		txtSDTNV.addKeyListener(this);
		txtTenKH.addKeyListener(this);
		txtTenNV.addKeyListener(this);

		if (!nhanVien.isChucVu()) {
			txtTenNV.setText(nhanVien.getHoTen().trim());
			txtTenNV.setEditable(false);
			txtSDTNV.setText(nhanVien.getSdt().trim());
			txtSDTNV.setEditable(false);
		}

		dateNgayLapHD.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent e) {
				XoaModelHD();
				AddIntable();
				lblSoTrangTable.setText("1");
			}
		});
	}

	public int TongPage() {
		int tongPage = 1;
		String tenKH = txtTenKH.getText();
		String maHD = txtMaHD.getText();
		String sdtKH = txtSDTKH.getText();
		String sdtNV = txtSDTNV.getText();
		String tenNV = txtTenNV.getText();
		int ngay = 0, thang = 0, nam = 0;
		if (dateNgayLapHD.getDate() != null) {
			Date date = dateNgayLapHD.getDate();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String ngayLap = simpleDateFormat.format(date);
			String[] ngayLapHD = ngayLap.split("-");
			ngay = Integer.parseInt(ngayLapHD[0]);
			thang = Integer.parseInt(ngayLapHD[1]);
			nam = Integer.parseInt(ngayLapHD[2]);
		}
		int tongHD = hoaDonDao.getTongSoHD(maHD, ngay, thang, nam, tenKH, sdtKH, tenNV, sdtNV);
		tongPage = tongHD % 10 == 0 ? tongHD / 10 : (tongHD / 10) + 1;
		return tongPage;
	}

	public void loadTable(List<HoaDon> listHD) {
		for (HoaDon hd : listHD) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String date = simpleDateFormat.format(hd.getNgayLapHD());

//			"Mã hóa đơn", "Mã khách hàng", "Ngày lập HĐ", "Tên Khách Hàng", "Số điện thoại KH", "Nhân viên lập", "Số điện thoại NV", "Tổng tiền"
			model.addRow(new Object[] { hd.getMaHD(), hd.getKhachHang().getMaKH(), date, hd.getKhachHang().getHoTen(),
					hd.getKhachHang().getSdt(), hd.getNhanVien().getHoTen(), hd.getNhanVien().getSdt(),
					Format.chuyenDoiTienTe(hd.tinhTongTien_VAT()) });
		}
	}

	public void AddIntable() {
		int page = Integer.parseInt(lblSoTrangTable.getText());
		page--;
		String tenKH = txtTenKH.getText().toUpperCase();
		String maHD = txtMaHD.getText().toUpperCase();
		String sdtKH = txtSDTKH.getText().toUpperCase();
		String sdtNV = txtSDTNV.getText().toUpperCase();
		String tenNV = txtTenNV.getText().toUpperCase();
		int ngay = 0, thang = 0, nam = 0;
		List<HoaDon> listHoaDon;
		if (dateNgayLapHD.getDate() != null) {
			Date date = dateNgayLapHD.getDate();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			String ngayLap = simpleDateFormat.format(date);
			String[] ngayLapHD = ngayLap.split("-");
			ngay = Integer.parseInt(ngayLapHD[0]);
			thang = Integer.parseInt(ngayLapHD[1]);
			nam = Integer.parseInt(ngayLapHD[2]);
			listHoaDon = hoaDonDao.getAllHoaDons(page, maHD, ngay, thang, nam, tenKH, sdtKH, tenNV, sdtNV);

		} else {
			listHoaDon = hoaDonDao.getAllHoaDonTheoPage(page, maHD, ngay, thang, nam, tenKH, sdtKH, tenNV, sdtNV);
		}
		loadTable(listHoaDon);
		int tongPage = TongPage();
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
		if (o.equals(txtMaHD) || o.equals(txtSDTKH) || o.equals(txtSDTNV) || o.equals(txtTenKH) || o.equals(txtTenNV)) {
			XoaModelHD();
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

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		int tongPage = TongPage();
		if (o.equals(btnLamMoi)) {
			Clear();
			XoaModelHD();
			List<HoaDon> hoaDon = hoaDonDao.getAllHoaDonTheoPage(0, "", 0, 0, 0, "", "", "", nhanVien.getSdt().trim());
			loadTable(hoaDon);
		}
		if (o.equals(btnChiTiet)) {
			int n = table.getSelectedRow();
			if (n == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn bạn muốn coi");
				return;
			}
			String maHD = table.getValueAt(n, 0).toString();
			ChiTietHoaDonJFrameGUI ctHoaDonJFrame = new ChiTietHoaDonJFrameGUI(maHD);
			ctHoaDonJFrame.setVisible(true);
		}
		if (o.equals(btnBack)) {
			int page = Integer.parseInt(lblSoTrangTable.getText());
			if (page > 1) {
				page--;
				lblSoTrangTable.setText(Integer.toString(page));
				lblTongTrang.setText("/" + tongPage);
				XoaModelHD();
				table.clearSelection();
				AddIntable();
			}
		}
		if (o.equals(btnBackEnd)) {
			int page = Integer.parseInt(lblSoTrangTable.getText());
			if (page != 1) {
				lblSoTrangTable.setText(Integer.toString(1));
				XoaModelHD();
				table.clearSelection();
				AddIntable();
			}
		}
		if (o.equals(btnNext)) {
			int page = Integer.parseInt(lblSoTrangTable.getText());
			if (page < tongPage) {
				page += 1;
				lblSoTrangTable.setText(Integer.toString(page));
				XoaModelHD();
				table.clearSelection();
				AddIntable();

			} else {
				JOptionPane.showMessageDialog(this, "Danh sách hóa đơn đã hết");
			}

		}
		if (o.equals(btnNextEnd)) {
			int page = Integer.parseInt(lblSoTrangTable.getText());
			if (page != tongPage) {
				lblSoTrangTable.setText(Integer.toString(tongPage));
				XoaModelHD();
				table.clearSelection();
				AddIntable();
			}
		}
	}

	public void XoaModelHD() {
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		table.clearSelection();
		int tongPage = TongPage();
		lblTongTrang.setText("/" + tongPage);
	}

	private void Clear() {
		table.clearSelection();
		txtMaHD.setText("");
		txtSDTKH.setText("");
		txtTenKH.setText("");
		if (nhanVien.isChucVu()) {
			txtSDTNV.setText("");
			txtTenNV.setText("");
		}
		dateNgayLapHD.setDate(null);
		lblSoTrangTable.setText("1");
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(dateNgayLapHD)) {
			XoaModelHD();
			AddIntable();
			lblSoTrangTable.setText("1");
		}
	}
}
