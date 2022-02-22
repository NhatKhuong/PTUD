package gui;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.SanPhamDao;
import dao.Ipml.SanPhamImpl;
import entity.SanPham;

public class ThongKeSanPhamSapHetSoLuongPnGUI extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7262463616864319188L;
	private JTable tbHetSoLuong;
	private JButton btnXuatFile;
	private DefaultTableModel model;
	private SanPhamDao sanPhamDao;
	
	public ThongKeSanPhamSapHetSoLuongPnGUI() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		setBounds(0, 0, 1364, 621);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 60, 1364, 506);
		add(scrollPane);
		
		model = new DefaultTableModel(new String[] { "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Nhãn hiệu","Màu sắc","Kích thước","Số lượng","Giá bán"},0){
			/**
			 * 
			 */
			private static final long serialVersionUID = 8798493760278188131L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};

		tbHetSoLuong = new JTable();
		tbHetSoLuong.setFont(new Font("Arial", Font.PLAIN, 16));
		tbHetSoLuong.setModel(model);
		scrollPane.setViewportView(tbHetSoLuong);
		tbHetSoLuong.setRowHeight(30);
		tbHetSoLuong.getColumnModel().getColumn(1).setPreferredWidth(200);
		tbHetSoLuong.getColumnModel().getColumn(0).setPreferredWidth(20);
		tbHetSoLuong.getColumnModel().getColumn(2).setPreferredWidth(20);
		tbHetSoLuong.getColumnModel().getColumn(4).setPreferredWidth(20);
		tbHetSoLuong.getColumnModel().getColumn(5).setPreferredWidth(20);
		tbHetSoLuong.getColumnModel().getColumn(6).setPreferredWidth(20);

		btnXuatFile = new JButton("Xuất file excel");
		btnXuatFile.setIcon(new ImageIcon(ThongKeSanPhamSapHetSoLuongPnGUI.class.getResource("/img/excel.png")));
		btnXuatFile.setFont(new Font("Arial", Font.PLAIN, 16));
		btnXuatFile.setBounds(1183, 576, 171, 35);
		add(btnXuatFile);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH SẢN PHẨM SẮP HẾT SỐ LƯỢNG");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1364, 50);
		add(lblNewLabel);
		
		loadData();
	}
	
	private void loadData() {
		sanPhamDao = new SanPhamImpl();
		
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		tbHetSoLuong.clearSelection();
		
		DecimalFormat format = new DecimalFormat("###,###,###,###.### VND");
		
		List<SanPham> list = sanPhamDao.getSanPhamSapHetSoLuong();
		list.forEach(sp -> {
			model.addRow(new Object[] {sp.getMaSP(),sp.getTenSP(),sp.getLoaiSanPham().getTenLoai(),sp.getNhanHieu(),sp.getMauSac(),sp.getKichThuoc(),sp.getSoLuong(),format.format(sp.getDonGia())});
		});
		
	}
}
