package gui;

import java.awt.Color;
import java.awt.Desktop;
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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JDateChooser;

import dao.HoaDonDao;
import dao.NhanVienDao;
import dao.Ipml.HoaDonImpl;
import dao.Ipml.NhanVienImpl;
import entity.HoaDon;
import entity.NhanVien;

public class ThongKeHoaDonPnGUI extends JPanel
		implements ActionListener, KeyListener, ChangeListener, ItemListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTheoNam_TongHD;
	private JTextField txtTheoNam_TongDT;
	private JTable tbTKTheoNam;
	private JTextField txtTheoThang_TongHD;
	private JTextField txtTheoThang_TongDT;
	private JTable tbTKTheoThang;
	private JTextField txtTheoNgay_TongHD;
	private JTextField txtTheoNgay_TongDT;
	private JTable tbTKTheoNgay;
	private JDateChooser dateChooser_Ngay;
	private JButton btnTheoThang_XemCT;
	private JButton btnTheoThang_XuatFile;
	private JButton btnTheoNam_XuatFile;
	private JButton btnTheoNam_XemCT;
	private JPanel pnTheoThang_BieuDo;
	private JButton btnTheoNgay_XuatFile;
	private static JPanel panelTheoNam;
	private DefaultTableModel modelNhanVien_Thang;
	private List<NhanVien> listNhanVien;
	private LocalDate ngayLapHDDauTien;
	private JTabbedPane tabbedPane;
	private DefaultTableModel modelTheoNgay;
	private Map<Integer, Double> mapTheoNam;
	private List<HoaDon> listHoaDonTheoNgay;
	private DefaultTableModel modelTheoNam;
	private DefaultTableModel modelTheoThang;
	private JComboBox<Integer> cbTheoNam_Nam;
	private JPanel pnTheoNam_BieuDo;
	private Map<Integer, Double> mapTheoThang;
	private JComboBox<Integer> cbTheoThang_Thang;
	private JComboBox<Integer> cbTheoThang_Nam;
	private LocalDate dateNow;

	private HoaDonDao hoaDonDao;
	private NhanVienDao nhanVienDao;
	private JPanel panel;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JComboBox<String> cbNhanVien_Ngay;
	private JPanel panel_4;
	private JTextField txtTimTen_Ngay;
	private JTextField txtTimMa_Ngay;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JScrollPane scrollPane;
	private JPanel panel_5;
	private JPanel panel_6;
	private JLabel lblNewLabel_8;
	private JComboBox<String> cbNhanVien_Thang;
	private JPanel panel_7;
	private JTextField txtTimTen_Thang;
	private JTextField txtTimMa_Thang;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JScrollPane scrollPane_4;
	private JPanel panel_8;
	private JPanel panel_9;
	private JLabel lblNewLabel_11;
	private JComboBox<String> cbNhanVien_Nam;
	private JPanel panel_10;
	private JTextField txtTimTen_Nam;
	private JTextField txtTimMa_Nam;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JScrollPane scrollPane_5;
	private JTable tbNhanVien_Ngay;
	private JTable tbNhanVien_Nam;
	private JTable tbNhanVien_Thang;
	private DefaultTableModel modelNhanVien_Ngay;
	private DefaultTableModel modelNhanVien_Nam;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public ThongKeHoaDonPnGUI() {
		hoaDonDao = new HoaDonImpl();
		nhanVienDao = new NhanVienImpl();
		ngayLapHDDauTien = hoaDonDao.getNgayLapHoaDonDauTien();

		setBackground(Color.WHITE);
		setBorder(new LineBorder(Color.BLACK));
		setBounds(0, 0, 1364, 621);
		setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 50, 1363, 571);
		add(panel_1);
		panel_1.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 14));
		tabbedPane.setBounds(10, 0, 1343, 562);
		panel_1.add(tabbedPane);

		JPanel panelTheoNgay = new JPanel();
		panelTheoNgay.setBackground(Color.WHITE);
		tabbedPane.addTab("Theo ngày", null, panelTheoNgay, null);
		panelTheoNgay.setLayout(null);

		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBackground(Color.WHITE);
		panel_3_1_1.setBounds(10, 0, 1318, 60);
		panelTheoNgay.add(panel_3_1_1);

		JLabel lblNewLabel_5_1_1 = new JLabel("Tổng số hóa đơn:");
		lblNewLabel_5_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_5_1_1.setBounds(369, 18, 151, 25);
		panel_3_1_1.add(lblNewLabel_5_1_1);

		JLabel lblNewLabel_6_1_1 = new JLabel("Tổng tiền các HĐ:");
		lblNewLabel_6_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_6_1_1.setBounds(710, 18, 144, 24);
		panel_3_1_1.add(lblNewLabel_6_1_1);

		txtTheoNgay_TongHD = new JTextField();
		txtTheoNgay_TongHD.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTheoNgay_TongHD.setEditable(false);
		txtTheoNgay_TongHD.setColumns(10);
		txtTheoNgay_TongHD.setBounds(515, 17, 100, 30);
		panel_3_1_1.add(txtTheoNgay_TongHD);

		txtTheoNgay_TongDT = new JTextField();
		txtTheoNgay_TongDT.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTheoNgay_TongDT.setEditable(false);
		txtTheoNgay_TongDT.setColumns(10);
		txtTheoNgay_TongDT.setBounds(853, 17, 315, 30);
		panel_3_1_1.add(txtTheoNgay_TongDT);

		JLabel lblNewLabel_7_1 = new JLabel("Ngày thống kê:");
		lblNewLabel_7_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_7_1.setBounds(23, 19, 133, 21);
		panel_3_1_1.add(lblNewLabel_7_1);

		dateChooser_Ngay = new JDateChooser();

		dateChooser_Ngay.setBounds(159, 17, 158, 30);
		dateChooser_Ngay.setDateFormatString("dd/MM/yyyy");
		dateChooser_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		dateChooser_Ngay.setDate(Calendar.getInstance().getTime());
		dateChooser_Ngay.setMinSelectableDate(new Date(ngayLapHDDauTien.getYear() - 1900,
				ngayLapHDDauTien.getMonthValue() - 1, ngayLapHDDauTien.getDayOfMonth()));
		dateChooser_Ngay.setMaxSelectableDate(Calendar.getInstance().getTime());
		panel_3_1_1.add(dateChooser_Ngay);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(380, 61, 954, 413);
		panelTheoNgay.add(scrollPane_3);

		modelTheoNgay = new DefaultTableModel(new String[] { "Mã hóa đơn", "SDT khách hàng", "Tên khách hàng",
				"Mã nhân viên", "Tên nhân viên", "Tổng tiền" }, 0) {
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
		tbTKTheoNgay = new JTable();
		tbTKTheoNgay.setBackground(null);
		tbTKTheoNgay.setFont(new Font("Arial", Font.PLAIN, 15));
		tbTKTheoNgay.setModel(modelTheoNgay);
		tbTKTheoNgay.getColumnModel().getColumn(0).setPreferredWidth(20);
		tbTKTheoNgay.getColumnModel().getColumn(3).setPreferredWidth(20);
		tbTKTheoNgay.setRowHeight(30);
		scrollPane_3.setViewportView(tbTKTheoNgay);
		scrollPane_3.getViewport().setBackground(Color.WHITE);

		btnTheoNgay_XuatFile = new JButton("Xuất file excel");
		btnTheoNgay_XuatFile.setIcon(new ImageIcon(ThongKeHoaDonPnGUI.class.getResource("/img/excel.png")));
		btnTheoNgay_XuatFile.setFont(new Font("Arial", Font.PLAIN, 16));
		btnTheoNgay_XuatFile.setBounds(1161, 485, 167, 35);
		panelTheoNgay.add(btnTheoNgay_XuatFile);

		panelTheoNam = new JPanel();
		panelTheoNam.setBackground(Color.WHITE);

		panelTheoNam.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(380, 11, 363, 99);
		panelTheoNam.add(panel_3);
		panel_3.setLayout(null);
		dateNow = LocalDate.now();

		JLabel lblNewLabel_5 = new JLabel("Tổng số hóa đơn");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(10, 11, 137, 30);
		panel_3.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Tổng tiền các HĐ");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(10, 52, 137, 30);
		panel_3.add(lblNewLabel_6);

		txtTheoNam_TongHD = new JTextField();
		txtTheoNam_TongHD.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTheoNam_TongHD.setEditable(false);
		txtTheoNam_TongHD.setBounds(157, 12, 189, 30);
		panel_3.add(txtTheoNam_TongHD);
		txtTheoNam_TongHD.setColumns(10);

		txtTheoNam_TongDT = new JTextField();
		txtTheoNam_TongDT.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTheoNam_TongDT.setEditable(false);
		txtTheoNam_TongDT.setBounds(157, 54, 189, 30);
		panel_3.add(txtTheoNam_TongDT);
		txtTheoNam_TongDT.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(380, 118, 363, 402);
		panelTheoNam.add(scrollPane_1);

		tbTKTheoNam = new JTable();
		modelTheoNam = new DefaultTableModel(new String[] { "Tháng", "Tổng số các HĐ  ", "Tổng tiền các HĐ" }, 0) {
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
		tbTKTheoNam.setFont(new Font("Arial", Font.PLAIN, 16));
		tbTKTheoNam.setModel(modelTheoNam);
		tbTKTheoNam.getColumnModel().getColumn(2).setPreferredWidth(150);
		tbTKTheoNam.getColumnModel().getColumn(0).setPreferredWidth(20);
		scrollPane_1.setViewportView(tbTKTheoNam);
		scrollPane_1.getViewport().setBackground(Color.WHITE);

		btnTheoNam_XemCT = new JButton("Xem chi tiết");
		btnTheoNam_XemCT.setIcon(new ImageIcon(ThongKeHoaDonPnGUI.class.getResource("/img/view-details.png")));
		btnTheoNam_XemCT.setFont(new Font("Arial", Font.PLAIN, 16));
		btnTheoNam_XemCT.setBounds(876, 485, 157, 35);
		panelTheoNam.add(btnTheoNam_XemCT);

		btnTheoNam_XuatFile = new JButton("Xuất file excel");
		btnTheoNam_XuatFile.setIcon(new ImageIcon(ThongKeHoaDonPnGUI.class.getResource("/img/excel.png")));
		btnTheoNam_XuatFile.setFont(new Font("Arial", Font.PLAIN, 16));
		btnTheoNam_XuatFile.setBounds(1181, 485, 157, 35);
		panelTheoNam.add(btnTheoNam_XuatFile);

		JPanel panelTheoThang = new JPanel();
		panelTheoThang.setBackground(Color.WHITE);
		tabbedPane.addTab("Theo tháng", null, panelTheoThang, null);

		tabbedPane.addTab("Theo năm", null, panelTheoNam, null);

		pnTheoNam_BieuDo = new JPanel();
		pnTheoNam_BieuDo.setBackground(Color.WHITE);
		pnTheoNam_BieuDo.setBorder(new LineBorder(Color.BLUE));
		pnTheoNam_BieuDo.setBounds(763, 65, 575, 406);
		panelTheoNam.add(pnTheoNam_BieuDo);
		pnTheoNam_BieuDo.setLayout(null);

		panelTheoThang.setLayout(null);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(380, 11, 363, 96);
		panelTheoThang.add(panel_3_1);
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(Color.WHITE);

		JLabel lblNewLabel_5_1 = new JLabel("Tổng số hóa đơn");
		lblNewLabel_5_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_5_1.setBounds(10, 11, 137, 30);
		panel_3_1.add(lblNewLabel_5_1);

		JLabel lblNewLabel_6_1 = new JLabel("Tổng tiền các HĐ");
		lblNewLabel_6_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_6_1.setBounds(10, 52, 137, 30);
		panel_3_1.add(lblNewLabel_6_1);

		txtTheoThang_TongHD = new JTextField();
		txtTheoThang_TongHD.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTheoThang_TongHD.setEditable(false);
		txtTheoThang_TongHD.setColumns(10);
		txtTheoThang_TongHD.setBounds(157, 12, 189, 30);
		panel_3_1.add(txtTheoThang_TongHD);

		txtTheoThang_TongDT = new JTextField();
		txtTheoThang_TongDT.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTheoThang_TongDT.setEditable(false);
		txtTheoThang_TongDT.setColumns(10);
		txtTheoThang_TongDT.setBounds(157, 54, 189, 30);
		panel_3_1.add(txtTheoThang_TongDT);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(380, 118, 363, 402);
		scrollPane_2.getViewport().setBackground(Color.white);
		panelTheoThang.add(scrollPane_2);

		tbTKTheoThang = new JTable();
		modelTheoThang = new DefaultTableModel(new String[] { "Ngày", "Tổng số HĐ", "Tổng tiền các HĐ" }, 0) {
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
		tbTKTheoThang.setFont(new Font("Arial", Font.PLAIN, 16));
		tbTKTheoThang.setModel(modelTheoThang);
		tbTKTheoThang.getColumnModel().getColumn(2).setPreferredWidth(150);
		tbTKTheoThang.getColumnModel().getColumn(0).setPreferredWidth(20);
		scrollPane_2.setViewportView(tbTKTheoThang);
		tbTKTheoNgay.setRowHeight(30);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(Color.BLUE));
		panel.setBounds(10, 61, 350, 470);
		panelTheoNgay.add(panel);

		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 11, 330, 195);
		panel.add(panel_2);

		lblNewLabel = new JLabel("Thống kê theo: ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(20, 14, 127, 21);
		panel_2.add(lblNewLabel);

		cbNhanVien_Ngay = new JComboBox();
		cbNhanVien_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		cbNhanVien_Ngay.setBounds(157, 11, 160, 27);
		panel_2.add(cbNhanVien_Ngay);

		panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"T\u00ECm ki\u1EBFm nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(10, 58, 310, 126);
		panel_2.add(panel_4);

		txtTimTen_Ngay = new JTextField();
		txtTimTen_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTimTen_Ngay.setEnabled(false);
		txtTimTen_Ngay.setColumns(10);
		txtTimTen_Ngay.setBounds(84, 73, 216, 30);
		panel_4.add(txtTimTen_Ngay);

		txtTimMa_Ngay = new JTextField();
		txtTimMa_Ngay.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTimMa_Ngay.setEnabled(false);
		txtTimMa_Ngay.setColumns(10);
		txtTimMa_Ngay.setBounds(84, 26, 216, 30);
		panel_4.add(txtTimMa_Ngay);

		lblNewLabel_1 = new JLabel("Mã NV   : ");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 32, 75, 14);
		panel_4.add(lblNewLabel_1);

		lblNewLabel_3 = new JLabel("Tên NV :");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 79, 75, 14);
		panel_4.add(lblNewLabel_3);

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerifyInputWhenFocusTarget(false);
		scrollPane.setBounds(10, 223, 330, 236);
		panel.add(scrollPane);

		tbNhanVien_Ngay = new JTable();
		tbNhanVien_Ngay.setFont(new Font("Arial", Font.PLAIN, 14));
		modelNhanVien_Ngay = new DefaultTableModel(new String[] { "Mã nhân viên", "Tên nhân viên" }, 0) {
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
		tbNhanVien_Ngay.setModel(modelNhanVien_Ngay);
		tbNhanVien_Ngay.setRowHeight(30);
		scrollPane.setViewportView(tbNhanVien_Ngay);
		tbTKTheoThang.setRowHeight(30);
		tbTKTheoNam.setRowHeight(30);

		panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(Color.BLUE));
		panel_8.setBounds(10, 61, 350, 459);
		panelTheoNam.add(panel_8);

		panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(10, 11, 330, 195);
		panel_8.add(panel_9);

		lblNewLabel_11 = new JLabel("Thống kê theo: ");
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_11.setBounds(20, 14, 127, 21);
		panel_9.add(lblNewLabel_11);

		cbNhanVien_Nam = new JComboBox();
		cbNhanVien_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		cbNhanVien_Nam.setBounds(157, 11, 160, 27);
		panel_9.add(cbNhanVien_Nam);

		panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"T\u00ECm ki\u1EBFm nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(10, 58, 310, 126);
		panel_9.add(panel_10);

		txtTimTen_Nam = new JTextField();
		txtTimTen_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTimTen_Nam.setEnabled(false);
		txtTimTen_Nam.setColumns(10);
		txtTimTen_Nam.setBounds(84, 73, 216, 30);
		panel_10.add(txtTimTen_Nam);

		txtTimMa_Nam = new JTextField();
		txtTimMa_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTimMa_Nam.setEnabled(false);
		txtTimMa_Nam.setColumns(10);
		txtTimMa_Nam.setBounds(84, 26, 216, 30);
		panel_10.add(txtTimMa_Nam);

		lblNewLabel_12 = new JLabel("Mã NV   : ");
		lblNewLabel_12.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_12.setBounds(10, 32, 75, 14);
		panel_10.add(lblNewLabel_12);

		lblNewLabel_13 = new JLabel("Tên NV :");
		lblNewLabel_13.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_13.setBounds(10, 79, 75, 14);
		panel_10.add(lblNewLabel_13);

		scrollPane_5 = new JScrollPane();
		scrollPane_5.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_5.setVerifyInputWhenFocusTarget(false);
		scrollPane_5.setBounds(10, 223, 330, 225);
		panel_8.add(scrollPane_5);

		tbNhanVien_Nam = new JTable();
		modelNhanVien_Nam = new DefaultTableModel(new String[] { "Mã nhân viên", "Tên nhân viên" }, 0) {
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
		tbNhanVien_Nam.setModel(modelNhanVien_Nam);
		tbNhanVien_Nam.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane_5.setViewportView(tbNhanVien_Nam);

		JLabel lblNewLabel_4 = new JLabel("Năm thống kê ");
		lblNewLabel_4.setBounds(41, 23, 136, 25);
		panelTheoNam.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 16));

		cbTheoNam_Nam = new JComboBox();
		cbTheoNam_Nam.setBounds(174, 20, 163, 30);
		panelTheoNam.add(cbTheoNam_Nam);
		cbTheoNam_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		cbTheoNam_Nam.addItemListener(this);

		btnTheoThang_XemCT = new JButton("Xem chi tiết");
		btnTheoThang_XemCT.setIcon(new ImageIcon(ThongKeHoaDonPnGUI.class.getResource("/img/view-details.png")));
		btnTheoThang_XemCT.setFont(new Font("Arial", Font.PLAIN, 16));
		btnTheoThang_XemCT.setBounds(876, 485, 157, 35);
		panelTheoThang.add(btnTheoThang_XemCT);

		btnTheoThang_XuatFile = new JButton("Xuất file excel");
		btnTheoThang_XuatFile.setIcon(new ImageIcon(ThongKeHoaDonPnGUI.class.getResource("/img/excel.png")));
		btnTheoThang_XuatFile.setFont(new Font("Arial", Font.PLAIN, 16));
		btnTheoThang_XuatFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTheoThang_XuatFile.setBounds(1171, 485, 157, 35);
		panelTheoThang.add(btnTheoThang_XuatFile);

		pnTheoThang_BieuDo = new JPanel();
		pnTheoThang_BieuDo.setBackground(Color.WHITE);
		pnTheoThang_BieuDo.setBorder(new LineBorder(Color.BLUE));
		pnTheoThang_BieuDo.setBounds(763, 65, 575, 406);
		panelTheoThang.add(pnTheoThang_BieuDo);
		pnTheoThang_BieuDo.setLayout(null);

		JLabel lbTheoThangTenBieuDo = new JLabel("Biểu đồ thống kê doanh thu của tháng 11 năm 2021");
		lbTheoThangTenBieuDo.setFont(new Font("Arial", Font.PLAIN, 16));
		lbTheoThangTenBieuDo.setBounds(95, 11, 355, 19);
		pnTheoThang_BieuDo.add(lbTheoThangTenBieuDo);

		cbTheoThang_Thang = new JComboBox();
		cbTheoThang_Thang.setBounds(87, 19, 84, 30);
		panelTheoThang.add(cbTheoThang_Thang);
		cbTheoThang_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		for (int i = dateNow.getMonthValue(); i >= ngayLapHDDauTien.getMonthValue(); i--) {
			cbTheoThang_Thang.addItem(i);
		}

		JLabel lblNewLabel_7 = new JLabel("Tháng:");
		lblNewLabel_7.setBounds(24, 23, 67, 21);
		panelTheoThang.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 16));

		JLabel lblNewLabel_4_1 = new JLabel("Năm :");
		lblNewLabel_4_1.setBounds(199, 23, 58, 25);
		panelTheoThang.add(lblNewLabel_4_1);
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 16));

		cbTheoThang_Nam = new JComboBox();
		cbTheoThang_Nam.setBounds(254, 19, 106, 30);
		panelTheoThang.add(cbTheoThang_Nam);
		cbTheoThang_Nam.setFont(new Font("Arial", Font.PLAIN, 16));

		panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(Color.BLUE));
		panel_5.setBounds(10, 61, 350, 459);
		panelTheoThang.add(panel_5);

		panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(10, 11, 330, 195);
		panel_5.add(panel_6);

		lblNewLabel_8 = new JLabel("Thống kê theo: ");
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_8.setBounds(20, 14, 127, 21);
		panel_6.add(lblNewLabel_8);

		cbNhanVien_Thang = new JComboBox();
		cbNhanVien_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		cbNhanVien_Thang.setBounds(157, 11, 160, 27);
		panel_6.add(cbNhanVien_Thang);

		panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new TitledBorder(

				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),

				"T\u00ECm ki\u1EBFm nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(10, 58, 310, 126);
		panel_6.add(panel_7);

		txtTimTen_Thang = new JTextField();
		txtTimTen_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTimTen_Thang.setEnabled(false);
		txtTimTen_Thang.setColumns(10);
		txtTimTen_Thang.setBounds(84, 73, 216, 30);
		panel_7.add(txtTimTen_Thang);

		txtTimMa_Thang = new JTextField();
		txtTimMa_Thang.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTimMa_Thang.setEnabled(false);
		txtTimMa_Thang.setColumns(10);
		txtTimMa_Thang.setBounds(84, 26, 216, 30);
		panel_7.add(txtTimMa_Thang);

		lblNewLabel_9 = new JLabel("Mã NV   : ");
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_9.setBounds(10, 32, 75, 14);
		panel_7.add(lblNewLabel_9);

		lblNewLabel_10 = new JLabel("Tên NV :");
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_10.setBounds(10, 79, 75, 14);
		panel_7.add(lblNewLabel_10);

		scrollPane_4 = new JScrollPane();
		scrollPane_4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_4.setVerifyInputWhenFocusTarget(false);
		scrollPane_4.setBounds(10, 223, 330, 227);
		panel_5.add(scrollPane_4);

		tbNhanVien_Thang = new JTable();
		modelNhanVien_Thang = new DefaultTableModel(new String[] { "Mã nhân viên", "Tên nhân viên" }, 0) {
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

		tbNhanVien_Thang.setModel(modelNhanVien_Thang);
		tbNhanVien_Thang.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane_4.setViewportView(tbNhanVien_Thang);

		JLabel lblNewLabel_2 = new JLabel("THỐNG KÊ HÓA ĐƠN");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_2.setBounds(0, 15, 1364, 34);
		add(lblNewLabel_2);
		
		tbNhanVien_Ngay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbNhanVien_Thang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbNhanVien_Nam.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbTKTheoThang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbTKTheoNam.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tbNhanVien_Thang.setRowHeight(30);
		tbNhanVien_Nam.setRowHeight(30);
		tbNhanVien_Ngay.getColumnModel().getColumn(0).setPreferredWidth(20);
		tbNhanVien_Thang.getColumnModel().getColumn(0).setPreferredWidth(20);
		tbNhanVien_Nam.getColumnModel().getColumn(0).setPreferredWidth(20);

		cbNhanVien_Ngay.addItem("Tất cả");
		cbNhanVien_Ngay.addItem("Nhân viên");
		cbNhanVien_Thang.addItem("Tất cả");
		cbNhanVien_Thang.addItem("Nhân viên");
		cbNhanVien_Nam.addItem("Tất cả");
		cbNhanVien_Nam.addItem("Nhân viên");
		

		cbNhanVien_Ngay.addItemListener(this);
		txtTimMa_Ngay.addKeyListener(this);
		txtTimTen_Ngay.addKeyListener(this);
		tbNhanVien_Ngay.addMouseListener(this);
		btnTheoNgay_XuatFile.addActionListener(this);

		cbTheoThang_Nam.addItemListener(this);
		cbTheoThang_Thang.addItemListener(this);
		tabbedPane.addChangeListener(this);
		btnTheoThang_XemCT.addActionListener(this);
		btnTheoNam_XemCT.addActionListener(this);
		txtTimMa_Thang.addKeyListener(this);
		txtTimTen_Thang.addKeyListener(this);
		cbNhanVien_Thang.addItemListener(this);
		tbNhanVien_Thang.addMouseListener(this);
		btnTheoThang_XuatFile.addActionListener(this);
		
		cbNhanVien_Nam.addItemListener(this);
		tbNhanVien_Nam.addMouseListener(this);
		txtTimMa_Nam.addKeyListener(this);
		txtTimTen_Nam.addKeyListener(this);
		btnTheoNam_XuatFile.addActionListener(this);
		
		for (int i = dateNow.getYear(); i >= ngayLapHDDauTien.getYear(); i--) {
			cbTheoNam_Nam.addItem(i);
			cbTheoThang_Nam.addItem(i);
		}

		dateChooser_Ngay.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent e) {
				clearModelNhanVienTheoNgay();
				handleThongKeTheoNgay();
			}
		});


		handleThongKeTheoNgay();

	}

	///////////////////////////////////////////////////////////////////////////
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();

		if (o == tbNhanVien_Ngay) {
			handleThongKeTheoNgay();
		}
		
		if (o == tbNhanVien_Thang) {
			handleThongKeTheoThang();
		}
		
		if (o == tbNhanVien_Nam) {
			handleThongKeTheoNam();
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
		Object o = e.getSource();

		if (e.getStateChange() == ItemEvent.SELECTED)
			return;

		if (o == cbNhanVien_Ngay) {
			if (cbNhanVien_Ngay.getSelectedIndex() == 0) {
				clearModelNhanVienTheoNgay();
				txtTimMa_Ngay.setText("");
				txtTimTen_Ngay.setText("");
				txtTimMa_Ngay.setEnabled(false);
				txtTimTen_Ngay.setEnabled(false);
			} else {
				txtTimMa_Ngay.setEnabled(true);
				txtTimTen_Ngay.setEnabled(true);
			}
			handleThongKeTheoNgay();
		}
		
		if (o == cbNhanVien_Thang) {
			if (cbNhanVien_Thang.getSelectedIndex() == 0) {
				clearModelNhanVienTheoThang();
				txtTimMa_Thang.setText("");
				txtTimTen_Thang.setText("");
				txtTimMa_Thang.setEnabled(false);
				txtTimTen_Thang.setEnabled(false);
			} else {
				txtTimMa_Thang.setEnabled(true);
				txtTimTen_Thang.setEnabled(true);
			}
			handleThongKeTheoThang();
		}
		
		if (o == cbNhanVien_Nam) {
			if (cbNhanVien_Nam.getSelectedIndex() == 0) {
				clearModelNhanVienTheoNam();
				txtTimMa_Nam.setText("");
				txtTimTen_Nam.setText("");
				txtTimMa_Nam.setEnabled(false);
				txtTimTen_Nam.setEnabled(false);
			} else {
				txtTimMa_Nam.setEnabled(true);
				txtTimTen_Nam.setEnabled(true);
			}
			handleThongKeTheoNam();
		}
		
		if (o == cbTheoThang_Nam) {
			int soThang = 12;
			int thangTam  = (int) cbTheoThang_Thang.getSelectedItem();
			if ((int) cbTheoThang_Nam.getSelectedItem() == dateNow.getYear()) {
				soThang = dateNow.getMonthValue();
			}
			cbTheoThang_Thang.removeAllItems();
			for (int i = soThang; i >= 1; i--) {
				cbTheoThang_Thang.addItem(i);
			}
			try {
				cbTheoThang_Thang.setSelectedItem(thangTam);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			cbTheoThang_Nam.getUI().setPopupVisible(cbTheoThang_Nam, false);
			clearModelNhanVienTheoThang();
			handleThongKeTheoThang();
		}

		if (o == cbTheoThang_Thang) {
			cbTheoThang_Thang.getUI().setPopupVisible(cbTheoThang_Thang, false);
			clearModelNhanVienTheoThang();
			handleThongKeTheoThang();
		}

		if (o == cbTheoNam_Nam) {
			cbTheoNam_Nam.getUI().setPopupVisible(cbTheoNam_Nam, false);
			clearModelNhanVienTheoNam();
			handleThongKeTheoNam();
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public void stateChanged(ChangeEvent e) {
		if (tabbedPane.getSelectedIndex() == 0) {
			cbNhanVien_Ngay.setSelectedIndex(0);
			handleThongKeTheoNgay();
		}
		if (tabbedPane.getSelectedIndex() == 1) {
			cbNhanVien_Thang.setSelectedIndex(0);
			cbTheoThang_Thang.setSelectedItem(dateChooser_Ngay.getDate().getMonth() + 1);
			cbTheoThang_Nam.setSelectedItem(dateChooser_Ngay.getDate().getYear() + 1900);
			handleThongKeTheoThang();
		}
		if (tabbedPane.getSelectedIndex() == 2) {
			cbNhanVien_Nam.setSelectedIndex(0);
			cbTheoNam_Nam.setSelectedItem(cbTheoThang_Nam.getSelectedItem());
			handleThongKeTheoNam();
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
		
		if (o == txtTimMa_Ngay || o == txtTimTen_Ngay) {
			String ma = txtTimMa_Ngay.getText().trim();
			String ten = txtTimTen_Ngay.getText().trim();
			Date date = dateChooser_Ngay.getDate();
			@SuppressWarnings("deprecation")
			LocalDate date1 = LocalDate.of(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
			clearThongKeTheoNgay();
			loadDataTableNhanVienTheoNgay(ma, ten, date1);
		}
		
		if (o == txtTimMa_Thang || o == txtTimTen_Thang) {
			String ma = txtTimMa_Thang.getText().trim();
			String ten = txtTimTen_Thang.getText().trim();
			int thang = (int) cbTheoThang_Thang.getSelectedItem();
			int nam = (int) cbTheoThang_Nam.getSelectedItem();
			clearThongKeTheoThang();
			loadDataTableNhanVienTheoThang(ma, ten, thang, nam);
		}
		
		if (o == txtTimMa_Nam || o == txtTimTen_Nam) {
			String ma = txtTimMa_Nam.getText().trim();
			String ten = txtTimTen_Nam.getText().trim();
			int nam = (int) cbTheoNam_Nam.getSelectedItem();
			clearThongKeTheoNam();
			loadDataTableNhanVienTheoNam(ma, ten, nam);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if (o == btnTheoThang_XemCT) {
			if (tbTKTheoThang.getSelectedRow() != -1) {
				NhanVien nv = new NhanVien();
				nv.setMaNV("");
				if (cbNhanVien_Thang.getSelectedIndex() == 1)
					nv = listNhanVien.get(tbNhanVien_Thang.getSelectedRow());
				int nam = (int) cbTheoThang_Nam.getSelectedItem();
				int thang = (int) cbTheoThang_Thang.getSelectedItem();
				int ngay = (int) tbTKTheoThang.getValueAt(tbTKTheoThang.getSelectedRow(), 0);
				LocalDate date = LocalDate.of(nam, thang, ngay);
				new XemChiTietTheoThangJFrameGUI(date, nv).setVisible(true);
	
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày cần xem chi tiết!");
			}
		}

		if (o == btnTheoNam_XemCT) {
			if (tbTKTheoNam.getSelectedRow() != -1) {
				NhanVien nv = new NhanVien();
				nv.setMaNV("");
				if (cbNhanVien_Nam.getSelectedIndex() == 1)
					nv = listNhanVien.get(tbNhanVien_Nam.getSelectedRow());
				int nam = (int) cbTheoNam_Nam.getSelectedItem();
				int thang = (int) tbTKTheoNam.getValueAt(tbTKTheoNam.getSelectedRow(), 0);
				new XemChiTietTheoNamJFrameGUI(thang, nam, nv).setVisible(true);

			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn tháng cần xem chi tiết!");
			}
		}
		
		if (o == btnTheoNgay_XuatFile) {
			if (tbTKTheoNgay.getRowCount() > 0) {
				handleXuatFile("ngay");
			}
			else {
				JOptionPane.showMessageDialog(this,"Không có nội dung để xuất!");
			}
		}
		
		if (o == btnTheoThang_XuatFile) {
			if (tbTKTheoThang.getRowCount() > 0) {
				handleXuatFile("thang");
			}
			else {
				JOptionPane.showMessageDialog(this,"Không có nội dung để xuất!");
			}
		}
		
		if (o == btnTheoNam_XuatFile) {
			if (tbTKTheoNam.getRowCount() > 0) {
				handleXuatFile("nam");
			}
			else {
				JOptionPane.showMessageDialog(this,"Không có nội dung để xuất!");
			}
		}

	}

	///////////////////////////////////////////////////////////////////////////////////

	private void clearThongKeTheoNgay() {
		txtTheoNgay_TongHD.setText("0");
		txtTheoNgay_TongDT.setText("0 VND");
		clearModelTheoNgay();
	}

	@SuppressWarnings("deprecation")
	private void handleThongKeTheoNgay() {
		Date date = dateChooser_Ngay.getDate();
		LocalDate date1 = LocalDate.of(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
		if (cbNhanVien_Ngay.getSelectedIndex() == 0) {
			loadThongKeTheoNgay(date1, "");
		} else {
			int indexNV = tbNhanVien_Ngay.getSelectedRow();
			if (indexNV != -1) {
				loadThongKeTheoNgay(date1, listNhanVien.get(indexNV).getMaNV());
			} else {
				loadDataTableNhanVienTheoNgay("", "", date1);
				clearThongKeTheoNgay();
			}
		}
	}

	private void loadThongKeTheoNgay(LocalDate date, String maNV) {
		clearModelTheoNgay();
		listHoaDonTheoNgay = hoaDonDao.getDoanhThuTheoNgay(date, maNV);
		AtomicReference<Double> tong = new AtomicReference<Double>(0.0);
		DecimalFormat format = new DecimalFormat("###,###,###,###.### VND");
		listHoaDonTheoNgay.forEach(l -> {
			tong.set(tong.get() + l.tinhTongTien_VAT());
			modelTheoNgay.addRow(new Object[] { l.getMaHD(), l.getKhachHang().getSdt(), l.getKhachHang().getHoTen(),
					l.getNhanVien().getMaNV(), l.getNhanVien().getHoTen(), format.format(l.tinhTongTien_VAT()) });
		});

		txtTheoNgay_TongHD.setText(listHoaDonTheoNgay.size() + "");
		txtTheoNgay_TongDT.setText(format.format(tong.get()));
	}

	private void clearThongKeTheoThang() {
		txtTheoThang_TongHD.setText("");
		txtTheoThang_TongDT.setText("0 VND");
		modelTheoThang.getDataVector().removeAllElements();
		modelTheoThang.fireTableDataChanged();
		tbTKTheoThang.clearSelection();
		pnTheoThang_BieuDo.removeAll();
		pnTheoThang_BieuDo.updateUI();
	}

	private void handleThongKeTheoThang() {
		if (cbTheoThang_Thang.getSelectedItem() != null) {
			int thang = (int) cbTheoThang_Thang.getSelectedItem();
			int nam = (int) cbTheoThang_Nam.getSelectedItem();
			if (cbNhanVien_Thang.getSelectedIndex() == 0) {
				loadThongKeTheoThang(thang, nam, "");
			} else {
				int indexNV = tbNhanVien_Thang.getSelectedRow();
				if (indexNV != -1) {
					loadThongKeTheoThang(thang, nam, listNhanVien.get(indexNV).getMaNV());
				} else {
					loadDataTableNhanVienTheoThang("","", thang, nam);
					clearThongKeTheoThang();
				}
			}
		}
	}

	private void loadThongKeTheoThang(int thang, int nam, String maNV) {
		clearModelTheoThang();
		mapTheoThang = hoaDonDao.getDoanhThuTheoThang(thang, nam, maNV);
		AtomicReference<Double> tong = new AtomicReference<Double>(0.0);
		DecimalFormat format = new DecimalFormat("###,###,###,###.### VND");
		mapTheoThang.entrySet().forEach(en -> {
			if (en.getValue() != 0) {
				tong.set(tong.get() + en.getValue());
				int ngay = en.getKey();
				LocalDate date = LocalDate.of(nam, thang, ngay);
				int tongSoHD = hoaDonDao.getTongHoaDonTheoNgay(date, maNV);
				modelTheoThang.addRow(new Object[] { en.getKey(), tongSoHD, format.format(en.getValue()) });
			}
		});
		txtTheoThang_TongHD.setText(hoaDonDao.getTongHoaDonTheoThang(thang, nam, maNV) + "");
		txtTheoThang_TongDT.setText(format.format(tong.get()));
		taoBieuDoTheoThang(thang, nam);
	}

	private void clearThongKeTheoNam() {
		txtTheoNam_TongHD.setText("");
		txtTheoNam_TongDT.setText("0 VND");
		modelTheoNam.getDataVector().removeAllElements();
		modelTheoNam.fireTableDataChanged();
		tbTKTheoNam.clearSelection();
		pnTheoNam_BieuDo.removeAll();
		pnTheoNam_BieuDo.updateUI();
	}

	private void handleThongKeTheoNam() {
		int nam = (int) cbTheoNam_Nam.getSelectedItem();
		if (cbNhanVien_Nam.getSelectedIndex() == 0) {
			loadThongKeTheoNam(nam, "");
		} else {
			int indexNV = tbNhanVien_Nam.getSelectedRow();
			if (indexNV != -1) {
				loadThongKeTheoNam(nam, listNhanVien.get(indexNV).getMaNV());
			} else {
				loadDataTableNhanVienTheoNam("","", nam);
				clearThongKeTheoNam();
			}
		}
	}

	private void loadThongKeTheoNam(int nam, String maNV) {
		clearModelTheoNam();
		mapTheoNam = hoaDonDao.getDoanhThuTheoNam(nam, maNV);
		AtomicReference<Double> tong = new AtomicReference<Double>(0.0);
		DecimalFormat format = new DecimalFormat("###,###,###,###.### VND");
		mapTheoNam.entrySet().forEach(en -> {
			if (en.getValue() != 0) {
				tong.set(tong.get() + en.getValue());
				int thang = en.getKey();
				int tongSoHD = hoaDonDao.getTongHoaDonTheoThang(thang, nam, maNV);
				modelTheoNam.addRow(new Object[] { en.getKey(), tongSoHD, format.format(en.getValue()) });
			}
		});
		txtTheoNam_TongHD.setText(hoaDonDao.getTongHoaDonTheoNam(nam, maNV) + "");
		txtTheoNam_TongDT.setText(format.format(tong.get()));
		taoBieuDoTheoNam(nam);
	}

	private void loadDataTableNhanVienTheoNgay(String ma, String ten, LocalDate date) {
		clearModelNhanVienTheoNgay();
		listNhanVien = nhanVienDao.timKiemNhanVienDaLapHoaDonTheoNgay(ten, ma, date);
		listNhanVien.forEach(nv -> {
			modelNhanVien_Ngay.addRow(new Object[] { nv.getMaNV(), nv.getHoTen() });
		});
	}
	private void loadDataTableNhanVienTheoThang(String ma, String ten, int thang, int nam) {
		clearModelNhanVienTheoThang();
		listNhanVien = nhanVienDao.timKiemNhanVienDaLapHoaDonTheoThang(ten, ma, thang, nam);
		listNhanVien.forEach(nv -> {
			modelNhanVien_Thang.addRow(new Object[] { nv.getMaNV(), nv.getHoTen() });
		});
	}
	private void loadDataTableNhanVienTheoNam(String ma, String ten, int nam) {
		clearModelNhanVienTheoNam();
		listNhanVien = nhanVienDao.timKiemNhanVienDaLapHoaDonTheoNam(ten, ma, nam);
		listNhanVien.forEach(nv -> {
			modelNhanVien_Nam.addRow(new Object[] { nv.getMaNV(), nv.getHoTen() });
		});
	}

	private void clearModelTheoNgay() {
		modelTheoNgay.getDataVector().removeAllElements();
		modelTheoNgay.fireTableDataChanged();
		tbTKTheoNgay.clearSelection();
	}

	private void clearModelTheoThang() {
		modelTheoThang.getDataVector().removeAllElements();
		modelTheoThang.fireTableDataChanged();
		tbTKTheoThang.clearSelection();
	}

	private void clearModelTheoNam() {
		modelTheoNam.getDataVector().removeAllElements();
		modelTheoNam.fireTableDataChanged();
		tbTKTheoNam.clearSelection();
	}

	private void clearModelNhanVienTheoNgay() {
		modelNhanVien_Ngay.getDataVector().removeAllElements();
		modelNhanVien_Ngay.fireTableDataChanged();
		tbNhanVien_Ngay.clearSelection();
	}

	private void clearModelNhanVienTheoThang() {
		modelNhanVien_Thang.getDataVector().removeAllElements();
		modelNhanVien_Thang.fireTableDataChanged();
		tbNhanVien_Thang.clearSelection();
	}

	private void clearModelNhanVienTheoNam() {
		modelNhanVien_Nam.getDataVector().removeAllElements();
		modelNhanVien_Nam.fireTableDataChanged();
		tbNhanVien_Nam.clearSelection();
	}

	private void taoBieuDoTheoThang(int thang, int nam) {
		CategoryDataset dataSet = getDataset(mapTheoThang);
		String title = "  BIỂU ĐỒ THỐNG KÊ DOANH THU THÁNG " + thang + " NĂM " + nam;
		JFreeChart barChart = getChart1(dataSet, title, "Ngày", "Doanh thu");
		barChart.getPlot().setBackgroundPaint(Color.WHITE);
		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setBounds(0, 0, 575, 406);
		pnTheoThang_BieuDo.removeAll();
		pnTheoThang_BieuDo.add(chartPanel);
		pnTheoThang_BieuDo.updateUI();

	}

	private void taoBieuDoTheoNam(int nam) {
		CategoryDataset dataSet = getDataset(mapTheoNam);
		String title = "            BIỂU ĐỒ THỐNG KÊ DOANH THU NĂM " + nam;
		JFreeChart barChart = getChart(dataSet, title, "Tháng", "Doanh thu");
		barChart.getPlot().setBackgroundPaint(Color.WHITE);
		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setBounds(0, 0, 575, 406);
		
		pnTheoNam_BieuDo.removeAll();
		pnTheoNam_BieuDo.add(chartPanel);
		pnTheoNam_BieuDo.updateUI();

	}

	private static JFreeChart getChart1(CategoryDataset dataSet, String title, String titleX, String titleY) {
		JFreeChart barChart = ChartFactory.createBarChart(title, titleX, titleY, dataSet, PlotOrientation.VERTICAL,
				false, false, false);
		CategoryAxis axis = barChart.getCategoryPlot().getDomainAxis();
		axis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
		return barChart;
	}

	private static JFreeChart getChart(CategoryDataset dataSet, String title, String titleX, String titleY) {
		JFreeChart barChart = ChartFactory.createBarChart(title, titleX, titleY, dataSet, PlotOrientation.VERTICAL,
				false, false, false);
		return barChart;
	}

	private static CategoryDataset getDataset(Map<Integer, Double> map) {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		map.entrySet().forEach(en -> {
			dataset.addValue(en.getValue(), "Doanh thu", en.getKey().toString());
		});
		return dataset;
	}
	
	private void handleXuatFile(String loaiThongKe) {
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
					return f.getName().toLowerCase().endsWith(".xls")
							|| f.getName().toLowerCase().endsWith(".xlsx");
				}
			}
		});

		int i = fChooser.showSaveDialog(this);
		if (i == 0) {
			String path = fChooser.getSelectedFile().getAbsolutePath();
			
			if (!path.matches("(.)+(\\.xls|\\.xlsx)$")) {
				path += ".xlsx";
			}
			int xacNhan = JOptionPane.showConfirmDialog(this, "Bạn có muốn xuất file", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (xacNhan == JOptionPane.YES_OPTION) {
				boolean ghiFile = true;
				if (loaiThongKe.equals("ngay")) {
					ghiFile = ghiFileTheoNgay(path);
				}
				if (loaiThongKe.equals("thang")) {
					ghiFile = ghiFileTheoThang(path);
				}
				if (loaiThongKe.equals("nam")) {
					ghiFile = ghiFileTheoNam(path);
				}
				
				if (ghiFile) {
					xacNhan = JOptionPane.showConfirmDialog(this, "Bạn có muốn xem file", "Thông báo", JOptionPane.YES_NO_OPTION);
					if(xacNhan==JOptionPane.YES_OPTION)
						try {
							Desktop.getDesktop().open(new File(path));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
				else
					JOptionPane.showMessageDialog(this, "Không thành công");
			}
		}
	}
	
	private boolean ghiFileTheoNgay(String path) {
		Workbook workBook = new XSSFWorkbook();
		Sheet sheet = workBook.createSheet("Sheet1");
		
		Date date = dateChooser_Ngay.getDate();
		@SuppressWarnings("deprecation")
		String title = String.format("                          NPK FASHION - BẢNG THỐNG KÊ HÓA ĐƠN NGÀY %d THÁNG %d NĂM %d",
				date.getDate(), (date.getMonth()+1), (date.getYear()+1900));
		sheet.addMergedRegion(new CellRangeAddress(0,0, 0, 5));
		sheet.createRow(0).createCell(0).setCellValue(title);
		
		Row rowNhanVien = sheet.createRow(1);
		if (cbNhanVien_Ngay.getSelectedIndex() == 1) {
			String tenNV = listNhanVien.get(tbNhanVien_Ngay.getSelectedRow()).getHoTen();
			rowNhanVien.createCell(3).setCellValue("Nhân viên: ");
			rowNhanVien.createCell(4).setCellValue(tenNV);
		}
		
		sheet.createRow(2);
		
		String header[] = { "Mã hoá đơn", "SĐT khách hàng", "Tên khách hàng", "Mã nhân viên", "Tên nhân viên",
		"Tổng tiền" };
		Row rowHeader = sheet.createRow(3);
		for (int i = 0; i < header.length; i++) {
			Cell cell = rowHeader.createCell(i);
			cell.setCellValue(header[i]);
		}

		int numRow = 4;
		for (int i=0; i<tbTKTheoNgay.getRowCount(); i++) {
			Row row = sheet.createRow(numRow);
			row.createCell(0).setCellValue(tbTKTheoNgay.getValueAt(i,0).toString().trim());
			row.createCell(1).setCellValue(tbTKTheoNgay.getValueAt(i,1).toString().trim());
			row.createCell(2).setCellValue(tbTKTheoNgay.getValueAt(i,2).toString().trim());
			row.createCell(3).setCellValue(tbTKTheoNgay.getValueAt(i,3).toString().trim());
			row.createCell(4).setCellValue(tbTKTheoNgay.getValueAt(i,4).toString().trim());
			row.createCell(5).setCellValue(tbTKTheoNgay.getValueAt(i,5).toString().trim());
			numRow++;
		}
		
		Row row = sheet.createRow(++numRow);
		row.createCell(0).setCellValue("Tổng số hóa đơn: ");
		row.createCell(1).setCellValue(txtTheoNgay_TongHD.getText().trim());
		row.createCell(2).setCellValue("");
		row.createCell(3).setCellValue("");
		row.createCell(4).setCellValue("Tổng cộng: ");
		row.createCell(5).setCellValue(txtTheoNgay_TongDT.getText().trim());
		
		for (int i = 0; i < header.length; i++) {
			sheet.autoSizeColumn(i);
		}
			

		try {
			FileOutputStream out = new FileOutputStream(path);
			workBook.write(out);
			out.close();
			workBook.close();
		} catch (Exception e) {
			return false;
		}
		return true;

	}
	
	private boolean ghiFileTheoThang(String path) {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Sheet1");
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		String title = String.format("NPK FASHION - BẢNG THỐNG KÊ HÓA ĐƠN THÁNG %d NĂM %d",cbTheoThang_Thang.getSelectedItem(),cbTheoNam_Nam.getSelectedItem());
		sheet.createRow(0).createCell(0).setCellValue(title);
		
		Row rowNhanVien = sheet.createRow(1);
		if (cbNhanVien_Thang.getSelectedIndex() == 1) {
			String tenNV = listNhanVien.get(tbNhanVien_Thang.getSelectedRow()).getHoTen();
			rowNhanVien.createCell(1).setCellValue("Nhân viên: ");
			rowNhanVien.createCell(2).setCellValue(tenNV);
		}
		
		sheet.createRow(2);
		
		Row rowHeader = sheet.createRow(3);
		String[] header = {"Ngày","Tổng số hóa đơn","Tổng tiền các hóa đơn"};
		for (int i=0; i<header.length; i++) {
			rowHeader.createCell(i).setCellValue(header[i]);
		}
		
		int numRow = 4;
		for (int i=0; i<tbTKTheoThang.getRowCount(); i++) {
			Row row = sheet.createRow(numRow);
			row.createCell(0).setCellValue(tbTKTheoThang.getValueAt(i,0).toString().trim());
			row.createCell(1).setCellValue(tbTKTheoThang.getValueAt(i,1).toString().trim());
			row.createCell(2).setCellValue(tbTKTheoThang.getValueAt(i,2).toString().trim());
			numRow++;
		}
		
		Row row = sheet.createRow(++numRow);
		row.createCell(0).setCellValue("Tổng cộng: ");
		row.createCell(1).setCellValue(txtTheoThang_TongHD.getText().trim());
		row.createCell(2).setCellValue(txtTheoThang_TongDT.getText().trim());
		
		for (int i=0; i<header.length; i++) {
			sheet.autoSizeColumn(i);
		}
		
		try {
			FileOutputStream out = new FileOutputStream(path);
			workbook.write(out);
			workbook.close();
			out.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean ghiFileTheoNam(String path) {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Sheet1");
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
		String title = String.format("NPK FASHION - BẢNG THỐNG KÊ HÓA ĐƠN NĂM %d",cbTheoNam_Nam.getSelectedItem());
		sheet.createRow(0).createCell(0).setCellValue(title);
		
		Row rowNhanVien = sheet.createRow(1);
		if (cbNhanVien_Nam.getSelectedIndex() == 1) {
			String tenNV = listNhanVien.get(tbNhanVien_Nam.getSelectedRow()).getHoTen();
			rowNhanVien.createCell(1).setCellValue("Nhân viên: ");
			rowNhanVien.createCell(2).setCellValue(tenNV);
		}
		
		sheet.createRow(2);
		
		Row rowHeader = sheet.createRow(3);
		String[] header = {"Tháng","Tổng số hóa đơn","Tổng tiền các hóa đơn"};
		for (int i=0; i<header.length; i++) {
			rowHeader.createCell(i).setCellValue(header[i]);
		}
		
		int numRow = 4;
		for (int i=0; i<tbTKTheoNam.getRowCount(); i++) {
			Row row = sheet.createRow(numRow);
			row.createCell(0).setCellValue(tbTKTheoNam.getValueAt(i,0).toString().trim());
			row.createCell(1).setCellValue(tbTKTheoNam.getValueAt(i,1).toString().trim());
			row.createCell(2).setCellValue(tbTKTheoNam.getValueAt(i,2).toString().trim());
			numRow++;
		}
		
		Row row = sheet.createRow(++numRow);
		row.createCell(0).setCellValue("Tổng cộng: ");
		row.createCell(1).setCellValue(txtTheoNam_TongHD.getText().trim());
		row.createCell(2).setCellValue(txtTheoNam_TongDT.getText().trim());
		
		for (int i=0; i<header.length; i++) {
			sheet.autoSizeColumn(i);
		}
		
		try {
			FileOutputStream out = new FileOutputStream(path);
			workbook.write(out);
			workbook.close();
			out.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
