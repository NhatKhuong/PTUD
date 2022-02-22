package gui;

import static javax.swing.JFileChooser.APPROVE_OPTION;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.io.FileUtils;

import dao.SanPhamDao;
import dao.Ipml.SanPhamImpl;
import entity.SanPham;
import format.Format;
import util.ReadExcel;

public class ThemNhieuSanPhamPnGUI extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5151249746592641511L;
	private JTable table;
	private JButton btnExcel;
	private JLabel lblTongSanPham;
	private DefaultTableModel model;
	private JButton btnChonHinhAnh;
	private JButton btnThemDatabase;
	private JButton btnLamMoi;
	private List<SanPham> sanPhams;
	private JLabel lblTongHinhAnh;
	private SanPhamDao sanPhamDao;
	private File folderImg;

	/**
	 * Create the panel.
	 */
	public ThemNhieuSanPhamPnGUI() {
		setBackground(Color.WHITE);
		sanPhams = new ArrayList<>();
		sanPhamDao = new SanPhamImpl();
		
		setBorder(new LineBorder(Color.BLACK));
		setBounds(0, 0, 1364, 621);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÊM NHIỀU SẢN PHẨM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 1344, 29);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 1344, 414);
		add(scrollPane);
		
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Tên sản phẩm", "Kích thước", "Chất liệu", "Loại sản phẩm", "Nhãn hiệu", "Số lượng", "Giá bán"
				}
			);
		table = new JTable();
		table.setModel(model);
		table.setRowHeight(30);
		table.setSelectionMode(0);
		scrollPane.setViewportView(table);
		
		btnExcel = new JButton("Chọn file excel");
		btnExcel.setIcon(new ImageIcon(ThemNhieuSanPhamPnGUI.class.getResource("/img/excel.png")));
		btnExcel.setFont(new Font("Arial", Font.PLAIN, 16));
		btnExcel.setBounds(153, 75, 172, 35);
		add(btnExcel);
		
		btnChonHinhAnh = new JButton("Chọn folder hình ảnh");
		btnChonHinhAnh.setIcon(new ImageIcon(ThemNhieuSanPhamPnGUI.class.getResource("/img/file.png")));
		btnChonHinhAnh.setFont(new Font("Arial", Font.PLAIN, 16));
		btnChonHinhAnh.setBounds(839, 75, 202, 35);
		add(btnChonHinhAnh);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng số sản phẩm:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(372, 75, 139, 35);
		add(lblNewLabel_1);
		
		lblTongSanPham = new JLabel("0");
		lblTongSanPham.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTongSanPham.setBounds(518, 75, 54, 35);
		add(lblTongSanPham);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tổng số hình ảnh:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(1085, 75, 128, 35);
		add(lblNewLabel_1_1);
		
		lblTongHinhAnh = new JLabel("0");
		lblTongHinhAnh.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTongHinhAnh.setBounds(1219, 75, 54, 35);
		add(lblTongHinhAnh);
		
		btnThemDatabase = new JButton("Thêm vào Database ");
		btnThemDatabase.setIcon(new ImageIcon(ThemNhieuSanPhamPnGUI.class.getResource("/img/database.png")));
		btnThemDatabase.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThemDatabase.setBounds(1140, 564, 214, 33);
		add(btnThemDatabase);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(ThemNhieuSanPhamPnGUI.class.getResource("/img/lam_moi.png")));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLamMoi.setBounds(941, 564, 162, 33);
		add(btnLamMoi);
		
		btnExcel.addActionListener(this);
		btnChonHinhAnh.addActionListener(this);
		btnThemDatabase.addActionListener(this);
		btnLamMoi.addActionListener(this);
		
	}
	
	////////////////////////////////////////////////////////////////////////////////

	@Override
	public void actionPerformed(ActionEvent e) {
		Object  o = e.getSource();
		
		if (o == btnExcel) {
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("File excel","xlsx");
			fileChooser.setFileFilter(extensionFilter);
			fileChooser.setMultiSelectionEnabled(false);
			int x = fileChooser.showDialog(this, "Chọn file");
			if(x == APPROVE_OPTION) {
				File f = fileChooser.getSelectedFile();
				if(f != null) {
					try {
						List<SanPham> listSanPham = ReadExcel.readExcel(f.getAbsolutePath());
						sanPhams.addAll(listSanPham);
						loadTable(listSanPham);
						lblTongSanPham.setText(sanPhams.size() + "");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		
		if (o == btnChonHinhAnh) {
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Folder","Folder");
			fileChooser.setFileFilter(extensionFilter);
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setAcceptAllFileFilterUsed(false);
			int x = fileChooser.showDialog(this,"Chọn folder hình ảnh");
			if (x == APPROVE_OPTION) {
				folderImg = fileChooser.getSelectedFile();
				lblTongHinhAnh.setText(folderImg.listFiles().length + "");
			}
		}
		
		if (o == btnThemDatabase) {
			if (kiemTraTruocThemDatabase()) {
				Boolean check;
				for (int i = 0; i<sanPhams.size(); i++) {
					check =  sanPhamDao.them(sanPhams.get(i));
					if(!check) {
						JOptionPane.showMessageDialog(this,"Thêm vào Database không thành công! Kiểm tra lại tập dữ liệu");
						for (int j=0; j<i; j++) {
							sanPhamDao.deleteSanPham(sanPhams.get(j));
						}
						return;
					}
				}
				try {
					FileUtils.copyDirectory(folderImg,new File("imgSanPham"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(this,"Bạn đã thêm thành công "+this.sanPhams.size()+" sản phẩm và "+this.folderImg.listFiles().length+" ảnh vào Database");
				lamMoi();
			}
		}
		
		if (o == btnLamMoi) {
			lamMoi();
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////
	
	public void loadTable(List<SanPham> sanPhams) {
		for (SanPham sanPham : sanPhams) {
			model.addRow(new Object[] {sanPham.getTenSP(), sanPham.getKichThuoc(), sanPham.getChatLieu(), sanPham.getLoaiSanPham().getTenLoai(), sanPham.getNhanHieu(), sanPham.getSoLuong(), Format.chuyenDoiTienTe(sanPham.getDonGia())});			
		}
	}
	
	private void lamMoi() {
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		table.clearSelection();
		lblTongHinhAnh.setText("0");
		lblTongSanPham.setText("0");
		sanPhams = new ArrayList<SanPham>();
		folderImg = null;
	}
	
	private boolean kiemTraTruocThemDatabase() {
		if (sanPhams.size() == 0) {
			JOptionPane.showMessageDialog(this,"Chưa có sản phẩm để thêm!");
			return false;
		}
		if (lblTongHinhAnh.getText().trim().equals("0")) {
			JOptionPane.showMessageDialog(this,"Vui lòng chọn hình ảnh cho sản phẩm!");
			return false;
		};
		return true;
	}
	
}
