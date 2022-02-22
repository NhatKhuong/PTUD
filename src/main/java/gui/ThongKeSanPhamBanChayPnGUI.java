package gui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.toedter.calendar.JDateChooser;

import dao.HoaDonDao;
import dao.SanPhamDao;
import dao.Ipml.HoaDonImpl;
import dao.Ipml.SanPhamImpl;
import entity.SanPham;
import format.Format;

public class ThongKeSanPhamBanChayPnGUI extends JPanel implements ItemListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JComboBox<String> cbThoiGian;
	private JDateChooser dateChooser;
	private JPanel pnThoiGian;
	private JComboBox<Integer> cbThang_Thang;
	private JComboBox<Integer> cbThang_Nam;
	private JComboBox<String> cbTop;
	private JLabel lblThang_Thang;
	private JLabel lblThang_Nam;
	private JLabel lblNam;
	private JComboBox<Integer> cbNam;
	private HoaDonDao hoaDonDao;
	private SanPhamDao sanPhamDao;
	private LocalDate ngayLapHDDauTien;
	private LocalDate dateNow;
	private DefaultTableModel model;
	private Map<SanPham, Integer> map;
	private JButton btnXuatFile;
	private int nam;
	private int ngay;
	private int thang;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("deprecation")
	public ThongKeSanPhamBanChayPnGUI() {
		hoaDonDao = new HoaDonImpl();
		sanPhamDao = new SanPhamImpl();
		ngayLapHDDauTien = hoaDonDao.getNgayLapHoaDonDauTien();
		dateNow = LocalDate.now();

		setBackground(Color.WHITE);
		setBorder(new LineBorder(Color.BLUE));
		setSize(1364, 621);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("THỐNG KÊ SẢN PHẨM  BÁN CHẠY");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 1344, 30);
		add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 1344, 433);
		add(scrollPane);

		model = new DefaultTableModel(new String[] { "STT", "Mã sản phẩm", "Tên sản phẩm", "Nhãn hiệu", "Kích thước",
				"Màu sắc", "Chất liệu", "Đơn giá", "Số lượng bán" }, 0) {
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
		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setModel(model);
		scrollPane.setViewportView(table);
		table.setRowHeight(30);

		JLabel lblNewLabel_1 = new JLabel("Thời gian thống kê: ");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(60, 79, 170, 35);
		add(lblNewLabel_1);

		cbThoiGian = new JComboBox<String>();
		cbThoiGian.setFont(new Font("Arial", Font.PLAIN, 16));
		cbThoiGian.setBounds(223, 77, 95, 35);
		add(cbThoiGian);
		cbThoiGian.addItem("Ngày");
		cbThoiGian.addItem("Tháng");
		cbThoiGian.addItem("Năm");

		pnThoiGian = new JPanel();
		pnThoiGian.setBackground(Color.WHITE);
		pnThoiGian.setBounds(368, 64, 406, 52);
		add(pnThoiGian);
		pnThoiGian.setLayout(null);

		lblNam = new JLabel("Năm : ");
		lblNam.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNam.setBounds(10, 11, 46, 35);

		cbNam = new JComboBox<Integer>();
		cbNam.setBounds(66, 13, 86, 35);
		cbNam.setFont(new Font("Arial", Font.PLAIN, 16));

		dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 11, 160, 35);
		dateChooser.setFont(new Font("Arial", Font.PLAIN, 16));
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setDate(Calendar.getInstance().getTime());
		dateChooser.setMinSelectableDate(new Date(ngayLapHDDauTien.getYear() - 1900,
				ngayLapHDDauTien.getMonthValue() - 1, ngayLapHDDauTien.getDayOfMonth()));
		dateChooser.setMaxSelectableDate(Calendar.getInstance().getTime());

		lblThang_Thang = new JLabel("Tháng : ");
		lblThang_Thang.setBounds(10, 11, 69, 35);
		lblThang_Thang.setFont(new Font("Arial", Font.BOLD, 16));

		cbThang_Thang = new JComboBox<Integer>();
		cbThang_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		cbThang_Thang.setBounds(77, 11, 89, 35);

		lblThang_Nam = new JLabel("Năm : ");
		lblThang_Nam.setFont(new Font("Arial", Font.BOLD, 16));
		lblThang_Nam.setBounds(219, 11, 58, 35);

		cbThang_Nam = new JComboBox<Integer>();
		cbThang_Nam.setBounds(274, 11, 87, 35);
		cbThang_Nam.setFont(new Font("Arial", Font.PLAIN, 16));

		JLabel lblNewLabel_1_2 = new JLabel("Thống kê theo top :");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(881, 77, 161, 35);
		add(lblNewLabel_1_2);

		pnThoiGian.add(dateChooser);

		cbTop = new JComboBox<String>();
		cbTop.setFont(new Font("Arial", Font.PLAIN, 16));
		cbTop.setBounds(1040, 77, 88, 35);
		add(cbTop);
		cbTop.addItem("10");
		cbTop.addItem("50");
		cbTop.addItem("100");
		cbTop.addItem("Tất cả");

		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);

		btnXuatFile = new JButton("Xuất file");
		btnXuatFile.setIcon(new ImageIcon(ThongKeSanPhamBanChayPnGUI.class.getResource("/img/excel.png")));
		btnXuatFile.setFont(new Font("Arial", Font.PLAIN, 16));
		btnXuatFile.setBounds(1175, 571, 118, 35);
		add(btnXuatFile);

		for (int i = dateNow.getYear(); i >= ngayLapHDDauTien.getYear(); i--) {
			cbNam.addItem(i);
			cbThang_Nam.addItem(i);
		}

		for (int i = dateNow.getMonthValue(); i >= 1; i--) {
			cbThang_Thang.addItem(i);
		}

		cbThoiGian.addItemListener(this);
		cbTop.addItemListener(this);
		cbNam.addItemListener(this);
		cbThang_Thang.addItemListener(this);
		cbThang_Nam.addItemListener(this);
		btnXuatFile.addActionListener(this);

		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent e) {
				clearData();
				loadData();
			}
		});
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////	

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED)
			return;
		Object o = e.getSource();

		if (o == cbThoiGian) {
			if (cbThoiGian.getSelectedIndex() == 0) {
				pnThoiGian.removeAll();
				pnThoiGian.add(dateChooser);
				pnThoiGian.updateUI();
			}

			if (cbThoiGian.getSelectedIndex() == 1) {
				pnThoiGian.removeAll();
				pnThoiGian.add(lblThang_Thang);
				pnThoiGian.add(cbThang_Thang);
				pnThoiGian.add(lblThang_Nam);
				pnThoiGian.add(cbThang_Nam);
				pnThoiGian.updateUI();

			}

			if (cbThoiGian.getSelectedIndex() == 2) {
				pnThoiGian.removeAll();
				pnThoiGian.add(lblNam);
				pnThoiGian.add(cbNam);
				pnThoiGian.updateUI();
			}
			loadData();
		}

		if (o == cbThang_Nam) {
			int soThang = 12;
			if ((int) cbThang_Nam.getSelectedItem() == dateNow.getYear()) {
				soThang = dateNow.getMonthValue();
			}
			cbThang_Thang.removeAllItems();
			for (int i = soThang; i >= 1; i--) {
				cbThang_Thang.addItem(i);
				System.out.println("bbbb");
			}
			cbThang_Thang.setSelectedIndex(0);
			loadData();
		}
		if (o == cbThang_Thang && (cbThang_Thang.getSelectedIndex()!=-1)) {
			loadData();
		}
		if (o == cbNam) {
			loadData();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		if (o == btnXuatFile) {
			if (table.getRowCount() == 0)
				JOptionPane.showMessageDialog(this, "Không có nội dung để xuất!");
			else
				handleXuatFile();
		}

	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////

	private void clearData() {
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		table.clearSelection();
	}

	@SuppressWarnings("deprecation")
	private void loadData() {
		clearData();

		int top = -1;
		if (cbTop.getSelectedIndex() == 0)
			top = 10;
		if (cbTop.getSelectedIndex() == 1)
			top = 50;
		if (cbTop.getSelectedIndex() == 2)
			top = 100;

		ngay = -1;
		thang = -1;
		nam = -1;

		if (cbThoiGian.getSelectedIndex() == 0) {
			Date date = dateChooser.getDate();
			ngay = date.getDate();
			thang = date.getMonth() + 1;
			nam = date.getYear() + 1900;
		}
		if (cbThoiGian.getSelectedIndex() == 1) {
			thang = (int) cbThang_Thang.getSelectedItem();
			nam = (int) cbThang_Nam.getSelectedItem();
		}
		if (cbThoiGian.getSelectedIndex() == 2) {
			nam = (int) cbNam.getSelectedItem();
		}

		map = sanPhamDao.getSanPhamBanChay(ngay, thang, nam, top);

		AtomicInteger i = new AtomicInteger(1);
		map.entrySet().forEach(en -> {
			SanPham sp = en.getKey();
			model.addRow(new Object[] { i.get(), sp.getMaSP(), sp.getTenSP(), sp.getNhanHieu(), sp.getKichThuoc(),
					sp.getMauSac(), sp.getChatLieu(), Format.chuyenDoiTienTe(sp.getDonGia()), en.getValue() });
			i.set(i.get() + 1);
		});

	}

	private void handleXuatFile() {
		JFileChooser fChooser = new JFileChooser();

		fChooser.setCurrentDirectory(new File("C:\\Users\\Trung Ngoc\\Downloads"));
		fChooser.addChoosableFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "Excel file (*.xls, *xlsx)";
			}

			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				if (f.isDirectory()) {
					return true;
				} else {
					return f.getName().toLowerCase().endsWith(".xls") || f.getName().toLowerCase().endsWith(".xlsx");
				}
			}
		});

		int i = fChooser.showSaveDialog(this);
		if (i == 0) {
			String path = fChooser.getSelectedFile().getAbsolutePath();

			if (!path.matches("(.)+(\\.xls|\\.xlsx)$")) {
				path += ".xlsx";
			}
			boolean t = true;
			t = ghiFile(path);
			if (t) {
				int xacNhan = JOptionPane.showConfirmDialog(this, "Bạn có muốn xem file", "Thông báo",
						JOptionPane.YES_NO_OPTION);
				if (xacNhan == JOptionPane.YES_OPTION)
					try {
						Desktop.getDesktop().open(new File(path));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			} else
				JOptionPane.showMessageDialog(this, "Không thành công");

		}
	}

	@SuppressWarnings("resource")
	private boolean ghiFile(String path) {
		Workbook workBook = new XSSFWorkbook();

		Sheet sh = workBook.createSheet("Sheet1");
		String header[] = { "STT", "Mã sản phẩm", "Tên sản phẩm", "Nhãn hiệu", "Kích thước", "Màu sắc", "Chất liệu",
				"Đơn giá", "Số lượng bán" };

		String title = "";
		int thoigian = cbThoiGian.getSelectedIndex();
		if (thoigian == 0)
			title = String.format(
					"                            NPK FASHION - BẢNG THỐNG KÊ SẢN PHẨM BÁN CHẠY NGÀY %d THÁNG %d NĂM %d", ngay,
					thang, nam);
		if (thoigian == 1)
			title = String.format("                            NPK FASHION - BẢNG THỐNG KÊ SẢN PHẨM BÁN CHẠY THÁNG %d NĂM %d",
					thang, nam);
		if (thoigian == 2)
			title = String.format("                                      NPK FASHION - BẢNG THỐNG KÊ SẢN PHẨM BÁN CHẠY NĂM %d", nam);

		sh.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));
		sh.createRow(0).createCell(0).setCellValue(title);

		sh.createRow(1);
		Row rowHeader = sh.createRow(2);
		for (int i = 0; i < header.length; i++) {
			Cell cell = rowHeader.createCell(i);
			cell.setCellValue(header[i]);
		}

		int numRow = 3;
		for (; numRow < table.getRowCount()+3; numRow++) {
			Row row = sh.createRow(numRow);
			row.createCell(0).setCellValue(table.getValueAt(numRow - 3, 0).toString().trim());
			row.createCell(1).setCellValue(table.getValueAt(numRow - 3, 1).toString().trim());
			row.createCell(2).setCellValue(table.getValueAt(numRow - 3, 2).toString().trim());
			row.createCell(3).setCellValue(table.getValueAt(numRow - 3, 3).toString().trim());
			row.createCell(4).setCellValue(table.getValueAt(numRow - 3, 4).toString().trim());
			row.createCell(5).setCellValue(table.getValueAt(numRow - 3, 5).toString().trim());
			row.createCell(6).setCellValue(table.getValueAt(numRow - 3, 6).toString().trim());
			row.createCell(7).setCellValue(table.getValueAt(numRow - 3, 7).toString().trim());
			row.createCell(8).setCellValue(table.getValueAt(numRow - 3, 8).toString().trim());
		}

		for (int i = 0; i < header.length; i++) {
			sh.autoSizeColumn(i);
		}

		try {
			FileOutputStream f = new FileOutputStream(path);
			workBook.write(f);
			f.close();
			workBook.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
