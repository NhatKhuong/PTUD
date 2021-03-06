package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangDao;
import dao.Ipml.KhachHangImpl;
import entity.KhachHang;
import entity.SanPham;

public class DialogHoaDonTreoGUI extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -297745462421994716L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtSDT;
	private JTable table;
	public static Map<String, List<SanPham>> map = new HashMap<String, List<SanPham>>();
	private DefaultTableModel model;
	private KhachHangDao khachHangDao;
	private List<KhachHang> listKhachHang;
	private JButton btnXoaTatCa;
	private JButton btnXoa;
	private JButton btnThanhToan;
	public static String STD;
	private JButton btnTim;
	private boolean trangThaiLapHoaDon = false;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings("static-access")
	public DialogHoaDonTreoGUI(Map<String, List<SanPham>> map, boolean trangThaiLapHoaDon) {
		this.trangThaiLapHoaDon = trangThaiLapHoaDon;
		STD = "";
		setModal(true);
		khachHangDao = new KhachHangImpl();
		this.map = map;
		setBounds(100, 100, 872, 536);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblDanhSchHa = new JLabel("DANH S??CH KH??CH H??NG CH??? THANH TO??N");
		lblDanhSchHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDanhSchHa.setFont(new Font("Arial", Font.BOLD, 20));
		lblDanhSchHa.setBounds(0, 10, 831, 35);
		contentPanel.add(lblDanhSchHa);
		
		btnThanhToan = new JButton("Thanh to??n");
		btnThanhToan.setIcon(new ImageIcon(DialogHoaDonTreoGUI.class.getResource("/img/money-bag.png")));
		btnThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThanhToan.setBounds(696, 442, 150, 35);
		contentPanel.add(btnThanhToan);
		
		btnXoa = new JButton("X??a");
		btnXoa.setIcon(new ImageIcon(DialogHoaDonTreoGUI.class.getResource("/img/xoa.png")));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoa.setBounds(509, 442, 125, 35);
		contentPanel.add(btnXoa);
		
		btnXoaTatCa = new JButton("X??a t???t c???");
		btnXoaTatCa.setIcon(new ImageIcon(DialogHoaDonTreoGUI.class.getResource("/img/remove-all.png")));
		btnXoaTatCa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnXoaTatCa.setBounds(332, 442, 143, 35);
		contentPanel.add(btnXoaTatCa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 838, 285);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M?? kh??ch h??ng","T??n kh??ch h??ng", "S??? ??i???n tho???i"
			}
		));
		scrollPane.setViewportView(table);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(163, 90, 269, 35);
		contentPanel.add(txtSDT);
		txtSDT.setColumns(10);
		
		btnTim = new JButton("T??m");
		btnTim.setIcon(new ImageIcon(DialogHoaDonTreoGUI.class.getResource("/img/Search.png")));
		btnTim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTim.setBounds(451, 90, 88, 35);
		contentPanel.add(btnTim);
		
		JLabel lblNewLabel = new JLabel("SDT Kh??ch h??ng");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 90, 143, 35);
		contentPanel.add(lblNewLabel);
		table.setRowHeight(35);
		
		btnThanhToan.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTatCa.addActionListener(this);
		
		txtSDT.addActionListener(this);
		
		listKhachHang = getKhachHangFromMap();
		xoaBan();
		loadTable(listKhachHang);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		table.setDefaultEditor(Object.class, null);

	}
	
	public void loadTable(List<KhachHang> list) {
		for (KhachHang khachHang : list) {
			model.addRow(new Object[] {khachHang.getMaKH(), khachHang.getHoTen(), khachHang.getSdt()});
		}
	}
	
	public List<KhachHang> getKhachHangFromMap(){
		listKhachHang = new ArrayList<KhachHang>();
		map.entrySet()
		.iterator()
		.forEachRemaining(entry->{
			KhachHang khachHang = khachHangDao.getKhachHangByStd(entry.getKey());
			listKhachHang.add(khachHang);
		});
		return listKhachHang;
	}
	
	public void xoaBan() {
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThanhToan)) {
			int row = table.getSelectedRow();
			
			if(row == -1) {
				JOptionPane.showMessageDialog(this,"Vui l??ng ch???n kh??ch h??ng");
				return;
			} else {
				if(trangThaiLapHoaDon == true) {
					int xacnhan = JOptionPane.showConfirmDialog(this,"B???n ??ang c?? h??a ????n ??ang l???p vui l??ng ho??n th??nh n??, N???u b???n thanh to??n h??a ????n n??y h??a ????n ??ang l???p s??? b??? m???t, B???n c?? mu???n thanh to??n kh??ng?","Th??ng b??o", JOptionPane.YES_NO_OPTION);
					if(xacnhan == JOptionPane.YES_NO_CANCEL_OPTION) {
						return;
					}
				}
				STD = table.getValueAt(row, 2).toString();
				dispose();
			}
			
		}
		
		if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this,"Vui l??ng ch???n kh??ch h??ng c???n x??a");
				return;
			} else {
				int xacNhan = JOptionPane.showConfirmDialog(this,"X??c nh???n","X??c nh???n", JOptionPane.YES_NO_OPTION);
				if(xacNhan == JOptionPane.YES_OPTION) {					
					String sdt = table.getValueAt(row, 2).toString();
					map.remove(sdt);
					xoaBan();
					loadTable(getKhachHangFromMap());
				}
			}
		}
		
		if(o.equals(btnXoaTatCa)) {
			int xacNhan = JOptionPane.showConfirmDialog(this,"X??c nh???n","X??c nh???n", JOptionPane.YES_NO_OPTION);
			if(xacNhan == JOptionPane.YES_OPTION) {					
				map = new HashMap<String, List<SanPham>>();
				xoaBan();
			}
		}
		
		if(o.equals(btnTim) || o.equals(txtSDT)) {
			String sdt = txtSDT.getText();
			for(int i= 0;i < table.getRowCount(); i++) {
				if(table.getValueAt(i, 2).equals(sdt)) {
					table.setRowSelectionInterval(i, i);
				}
			}
		}
		
	}
}

