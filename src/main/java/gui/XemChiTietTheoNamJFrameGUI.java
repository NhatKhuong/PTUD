package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Map;
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
import entity.NhanVien;

public class XemChiTietTheoNamJFrameGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5027957268059491239L;
	private JPanel contentPane;
	private JLabel lblNhanVien;
	private JTable table;
	private JLabel lblTongDT;
	private DefaultTableModel model;
	private JLabel lblTitle;
	private JLabel lblTongSoHD;

	public XemChiTietTheoNamJFrameGUI(int thang, int nam, NhanVien nv) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 519, 641);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitle = new JLabel("BẢNG THỐNG KÊ  DOANH THU CHI TIẾT NĂM 9999");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitle.setBounds(10, 9, 483, 30);
		contentPane.add(lblTitle);

		lblNhanVien = new JLabel("Nhân viên: Đỗ Trung Ngọc");
		lblNhanVien.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNhanVien.setBounds(245, 34, 248, 30);
		contentPane.add(lblNhanVien);

		JPanel panel = new JPanel();
		panel.setBounds(5, 64, 493, 432);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		model = new DefaultTableModel(new String[] { "Ngày", "Tổng số hóa đơn","Tổng tiền các hóa đơn" }, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = -4938044335521820055L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};
		table.setModel(model);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		scrollPane.getViewport().setBackground(Color.WHITE);

		JLabel lblNewLabel = new JLabel("Tổng tiền các hóa đơn: ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(33, 524, 185, 30);
		contentPane.add(lblNewLabel);

		lblTongDT = new JLabel("0 VND");
		lblTongDT.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTongDT.setBounds(224, 524, 237, 30);
		contentPane.add(lblTongDT);

		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.setIcon(new ImageIcon(XemChiTietTheoNamJFrameGUI.class.getResource("/img/Thoat.png")));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton.setBounds(393, 558, 100, 35);
		contentPane.add(btnNewButton);

		JButton btnXuat = new JButton("Xuất excel");
		btnXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnXuat.setIcon(new ImageIcon(XemChiTietTheoNamJFrameGUI.class.getResource("/img/excel.png")));
		btnXuat.setFont(new Font("Arial", Font.PLAIN, 16));
		btnXuat.setBounds(203, 558, 148, 35);
		contentPane.add(btnXuat);
		
		JLabel lblTngSHa = new JLabel("Tổng số hóa đơn          : ");
		lblTngSHa.setFont(new Font("Arial", Font.BOLD, 16));
		lblTngSHa.setBounds(33, 500, 185, 30);
		contentPane.add(lblTngSHa);
		
		lblTongSoHD = new JLabel("0");
		lblTongSoHD.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTongSoHD.setBounds(224, 500, 237, 30);
		contentPane.add(lblTongSoHD);

		loadData(thang, nam, nv);
	}

	private void loadData(int thang, int nam, NhanVien nv) {
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		table.clearSelection();
		HoaDonDao hoaDonDao = new HoaDonImpl();
		Map<Integer, Double> map = hoaDonDao.getDoanhThuTheoThang(thang, nam, nv.getMaNV());
		AtomicReference<Double> tongDT = new AtomicReference<Double>(0.0);
		AtomicReference<Integer> tongHD = new AtomicReference<Integer>(0);
		DecimalFormat format = new DecimalFormat("###,###,###,###.### VND");
		map.entrySet().forEach(en -> {
			if (en.getValue() != 0) {
				tongDT.set(tongDT.get() + en.getValue());
				LocalDate date = LocalDate.of(nam, thang, en.getKey());
				int tongSoHD = hoaDonDao.getTongHoaDonTheoNgay(date, nv.getMaNV());
				tongHD.set(tongHD.get() + tongSoHD);
				model.addRow(new Object[] { en.getKey(),tongSoHD,format.format(en.getValue()) });
			}
		});
		
		lblTongDT.setText(format.format(tongDT.get()));
		String title = "BẢNG THỐNG KÊ HÓA ĐƠN THÁNG " + thang + " NĂM " + nam;
		lblTitle.setText(title);
		lblTongSoHD.setText(tongHD.get() + "");
		if (nv.getMaNV().trim() == "") {
			lblNhanVien.setText("");
		} else {
			lblNhanVien.setText("Nhân viên: " + nv.getHoTen().trim());
		}
	}
}
