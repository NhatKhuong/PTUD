package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.HoaDonDao;
import dao.Ipml.HoaDonImpl;
import entity.HoaDon;
import entity.NhanVien;

public class XemChiTietTheoThangJFrameGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6031860239720197209L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private static JLabel lblTongDT;
	private JLabel lblTenNV;
	private JLabel lbTitle;
	private JLabel lblTongSoHD;

	public XemChiTietTheoThangJFrameGUI(LocalDate date, NhanVien nv) {
		setBounds(100, 100, 1001, 574);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbTitle = new JLabel("BẢNG THỐNG KÊ DOANH THU CHI TIẾT NGÀY 10 THÁNG 0 NĂM 9999");
		lbTitle.setFont(new Font("Arial", Font.BOLD, 16));
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setBounds(10, 0, 965, 40);
		contentPane.add(lbTitle);

		JPanel panel = new JPanel();
		panel.setBounds(5, 60, 974, 409);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		model = new DefaultTableModel(
				new String[] { "Mã hóa đơn", "SĐT khách hàng", "Tên khách hàng", "Mã nhân viên", "Tên nhân viên","Tổng tiền"}, 0) {
			/**
					 * 
					 */
					private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};
		table.setModel(model);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		scrollPane.getViewport().setBackground(Color.WHITE);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnThoat.setIcon(new ImageIcon(XemChiTietTheoThangJFrameGUI.class.getResource("/img/Close.png")));
		btnThoat.setFont(new Font("Arial", Font.PLAIN, 16));
		btnThoat.setBounds(862, 493, 113, 35);
		contentPane.add(btnThoat);

		JButton btnXuat = new JButton("Xuất excel");
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnXuat.setIcon(new ImageIcon(XemChiTietTheoThangJFrameGUI.class.getResource("/img/excel.png")));
		btnXuat.setFont(new Font("Arial", Font.PLAIN, 16));
		btnXuat.setBounds(625, 493, 140, 35);
		contentPane.add(btnXuat);

		JLabel lblNewLabel = new JLabel("Tổng tiền các hóa đơn: ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(200, 469, 190, 35);
		contentPane.add(lblNewLabel);

		lblTongDT = new JLabel("1000,000,000 VND");
		lblTongDT.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTongDT.setBounds(384, 469, 227, 35);
		contentPane.add(lblTongDT);

		lblTenNV = new JLabel("Nhân viên: Đỗ Trung Ngọc");
		lblTenNV.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTenNV.setBounds(704, 27, 271, 30);
		contentPane.add(lblTenNV);
		
		JLabel lblTSHD = new JLabel("Tổng số hóa đơn: ");
		lblTSHD.setFont(new Font("Arial", Font.BOLD, 16));
		lblTSHD.setBounds(10, 469, 151, 35);
		contentPane.add(lblTSHD);
		
		lblTongSoHD = new JLabel("0 VND");
		lblTongSoHD.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTongSoHD.setBounds(155, 469, 35, 35);
		contentPane.add(lblTongSoHD);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.setRowHeight(30);

		loadData(date, nv);

	}

	private void loadData(LocalDate date, NhanVien nv) {
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		table.clearSelection();
		HoaDonDao hoaDonDao = new HoaDonImpl();
		 List<HoaDon> list = hoaDonDao.getDoanhThuTheoNgay(date, nv.getMaNV());
		AtomicReference<Double> tong = new AtomicReference<Double>(0.0);
		DecimalFormat format = new DecimalFormat("###,###,###,###.### VND");
		list.forEach(l->{
			tong.set(tong.get() + l.tinhTongTien_VAT());
			model.addRow(new Object[] { l.getMaHD(),l.getKhachHang().getSdt(), l.getKhachHang().getHoTen(),
					l.getNhanVien().getMaNV(),l.getNhanVien().getHoTen(), format.format(l.tinhTongTien_VAT()) });
		});
		lblTongDT.setText(format.format(tong.get()));
		String title = "BẢNG THỐNG KÊ HÓA ĐƠN NGÀY " + date.getDayOfMonth() + " THÁNG " + date.getMonthValue() + " NĂM "
				+ date.getYear();
		lbTitle.setText(title);
		lblTongSoHD.setText(list.size() + "");
		if (nv.getMaNV().trim() == "") {
			lblTenNV.setText("");
		} else {
			lblTenNV.setText("Nhân viên: " + nv.getHoTen().trim());
		}

	}
}
