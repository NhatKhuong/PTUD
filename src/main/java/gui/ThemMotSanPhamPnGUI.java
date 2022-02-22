package gui;

import static javax.swing.JFileChooser.APPROVE_OPTION;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.LoaiSanPhamDao;
import dao.SanPhamDao;
import dao.Ipml.LoaiSanPhamImpl;
import dao.Ipml.SanPhamImpl;
import entity.LoaiSanPham;
import entity.SanPham;

public class ThemMotSanPhamPnGUI extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4387048235436388625L;
	private JTextField txtNhanHieu;
	private JTextField txtTen;
	private JTextField txtChatLieu;
	private JTextField txtGia;
	private JTextField txtSoLuong;
	private JLabel lblNewLabel_1_3_3;
	private JButton btnLamMoi;
	private JButton btnThem;
	private LoaiSanPhamDao loaiSanPhamDao;
	private SanPhamDao sanPhamDao;
	private JComboBox<String> cbLoai;
	private JComboBox<String> cbKichThuoc;
	private JButton btnChonAnh;
	private File file;
	private JLabel lblHinhAnh;
	private JLabel lblMa;
	private JLabel lblNewLabel_1_3_4;
	private JTextField txtMau;

	/**
	 * Create the panel.
	 */
	public ThemMotSanPhamPnGUI() {
		loaiSanPhamDao = new LoaiSanPhamImpl();
		sanPhamDao = new SanPhamImpl();
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		setBounds(0, 0, 1364, 621);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("THÊM SẢN PHẨM");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(0, 11, 1364, 49);
		add(lblNewLabel_1);
		
		btnChonAnh = new JButton("Chọn ảnh");
		btnChonAnh.setIcon(new ImageIcon(ThemMotSanPhamPnGUI.class.getResource("/img/open-folder.png")));
		btnChonAnh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnChonAnh.setBounds(108, 430, 132, 35);
		add(btnChonAnh);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã sản phẩm");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(404, 145, 109, 27);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nhãn hiệu");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(404, 215, 72, 27);
		add(lblNewLabel_1_3);
		
		txtNhanHieu = new JTextField();
		txtNhanHieu.setText((String) null);
		txtNhanHieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNhanHieu.setColumns(10);
		txtNhanHieu.setBounds(536, 215, 300, 35);
		add(txtNhanHieu);
		
		JLabel lblNewLabel_1_2 = new JLabel("Loại sản phẩm");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(404, 290, 109, 27);
		add(lblNewLabel_1_2);
		
		cbLoai = new JComboBox<String>();
		cbLoai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbLoai.setBounds(536, 290, 300, 35);
		add(cbLoai);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tên sản phẩm");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(894, 145, 109, 27);
		add(lblNewLabel_1_1_1);
		
		txtTen = new JTextField();
		txtTen.setText((String) null);
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTen.setColumns(10);
		txtTen.setBounds(1004, 145, 300, 35);
		add(txtTen);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Chất liệu");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3_2.setBounds(894, 215, 81, 27);
		add(lblNewLabel_1_3_2);
		
		txtChatLieu = new JTextField();
		txtChatLieu.setText((String) null);
		txtChatLieu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtChatLieu.setColumns(10);
		txtChatLieu.setBounds(1004, 215, 300, 35);
		add(txtChatLieu);
		
		JLabel lblNewLabel_1_4 = new JLabel("Kích thước");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(894, 290, 81, 27);
		add(lblNewLabel_1_4);
		
		cbKichThuoc = new JComboBox<String>();
		cbKichThuoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cbKichThuoc.setBounds(1004, 290, 300, 35);
		add(cbKichThuoc);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Giá");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3_1.setBounds(894, 370, 31, 27);
		add(lblNewLabel_1_3_1);
		
		txtGia = new JTextField();
		txtGia.setForeground(Color.RED);
		txtGia.setFont(new Font("Tahoma", Font.ITALIC, 16));
		txtGia.setColumns(10);
		txtGia.setBounds(1004, 370, 300, 35);
		add(txtGia);
		
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(ThemMotSanPhamPnGUI.class.getResource("/img/lam_moi.png")));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLamMoi.setBounds(1004, 450, 125, 35);
		add(btnLamMoi);
		
		btnThem = new JButton("Thêm");
		btnThem.setIcon(new ImageIcon(ThemMotSanPhamPnGUI.class.getResource("/img/them.png")));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThem.setBounds(1179, 450, 125, 35);
		add(btnThem);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(27, 132, 300, 288);
		add(panel_1);
		
		lblHinhAnh = new JLabel("");
		lblHinhAnh.setBounds(0, 0, 300, 288);
		panel_1.add(lblHinhAnh);
		
		lblNewLabel_1_3_3 = new JLabel("Số lượng");
		lblNewLabel_1_3_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3_3.setBounds(404, 370, 72, 27);
		add(lblNewLabel_1_3_3);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setText((String) null);
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(536, 370, 300, 35);
		add(txtSoLuong);
		
		lblMa = new JLabel("");
		lblMa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMa.setBounds(536, 143, 300, 35);
		add(lblMa);
		
		cbLoai.addItem("Chọn loại");
		loadCombobox(cbLoai, loaiSanPhamDao.getDanhSachLoai());
		cbKichThuoc.addItem("Chọn kích thước");
		loadCombobox(cbKichThuoc, Arrays.asList("S","M","L","X","XL","XXL","XXXL"));
		
//		String spCuoiCung = khachHangDao.getKhachHangCuoiCung().substring(2);
		String spCuoi = sanPhamDao.getMaSanPhamCuoi().substring(2);
		int maSPNum = Integer.parseInt(spCuoi);
		maSPNum++;
		String maSP = String.format("SP%06d",maSPNum);
		lblMa.setText(maSP);
		btnChonAnh.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnThem.addActionListener(this);
		
		lblNewLabel_1_3_4 = new JLabel("Màu sắc");
		lblNewLabel_1_3_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3_4.setBounds(404, 450, 72, 27);
		add(lblNewLabel_1_3_4);
		
		txtMau = new JTextField();
		txtMau.setText((String) null);
		txtMau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMau.setColumns(10);
		txtMau.setBounds(536, 450, 300, 35);
		add(txtMau);
		
		
		
		
		
	}
	
	public void loadCombobox(JComboBox<String> cb, List<String> list) {
		for (String string : list) {
			cb.addItem(string);
		}
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
			FileOutputStream out = new FileOutputStream(new File("imgSanPham//"+name));
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
	
	public void selectAndFocus(JTextField txt) {
		txt.requestFocus();
		txt.selectAll();
	}
	
	public boolean kiemTra() {
		
		if(txtNhanHieu.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Nhãn hiệu không được rỗng");
			selectAndFocus(txtNhanHieu);
			return false;
		}
		
		if(cbLoai.getSelectedItem().equals("Chọn loại")) {
			JOptionPane.showMessageDialog(this,"Vui lòng chọn loại sản phẩm");
			return false;
		}
		
		try {
			Double.parseDouble(txtSoLuong.getText());
			if(Integer.parseInt(txtSoLuong.getText()) <= 0) {
				JOptionPane.showMessageDialog(this,"Số lượng sản phẩm là số nguyên dương");
				selectAndFocus(txtSoLuong);
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Số lượng sản phẩm là số nguyên dương");
			selectAndFocus(txtSoLuong);
			return false;
		}
		
		if(txtMau.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Màu sắc không được rỗng");
			selectAndFocus(txtNhanHieu);
			return false;
		}
		
		if(txtTen.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Tên sản phẩm không được rỗng");
			selectAndFocus(txtTen);
			return false;
		}
		
		if(txtChatLieu.getText().equals("")) {
			JOptionPane.showMessageDialog(this,"Chất liệu không được rỗng");
			selectAndFocus(txtChatLieu);
			return false;
		}
		
		if(cbKichThuoc.getSelectedItem().equals("Chọn kích thước")) {
			JOptionPane.showMessageDialog(this,"Vui lòng chọn kích thước sản phẩm");
			return false;
		}
		
		
		try {
			Double.parseDouble(txtGia.getText());
			if(Double.parseDouble(txtGia.getText()) <= 0) {
				JOptionPane.showMessageDialog(this,"Giá sản phẩm là số dương");
				selectAndFocus(txtGia);
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,"Giá sản phẩm là số dương");
			selectAndFocus(txtGia);
			return false;
		}
		return true;
	}
	
	public void clear() {
		txtChatLieu.setText("");
		txtGia.setText("");
//		lblMa.setText("");
		txtNhanHieu.setText("");
		txtTen.setText("");
		cbKichThuoc.setSelectedIndex(0);
		cbLoai.setSelectedIndex(0);
		lblHinhAnh.setIcon(null);
		txtSoLuong.setText("");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnChonAnh)) {
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("Hinh anh","jpg","png");
			fileChooser.setFileFilter(extensionFilter);
			fileChooser.setMultiSelectionEnabled(false);
			int x = fileChooser.showDialog(this, "Chọn file");
			if(x == APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();
				BufferedImage bImage = scaleImage(lblHinhAnh.getWidth(),lblHinhAnh.getHeight(), file.getAbsolutePath());
				ImageIcon icon = new ImageIcon(bImage);
				lblHinhAnh.setIcon(icon);
			}
		}
		
		if(o.equals(btnThem)) {
			if(kiemTra()){
					String maSp = lblMa.getText();
					String tenSP = txtTen.getText();
					String nhanHieu = txtNhanHieu.getText();
					int soLuong = Integer.parseInt(txtSoLuong.getText());
					double gia = Double.parseDouble(txtGia.getText());
					String loaiSP = cbLoai.getSelectedItem().toString();
					LoaiSanPham loaiSanPham = loaiSanPhamDao.getLoaiSanPhamByName(loaiSP);
					String kichThuoc = cbKichThuoc.getSelectedItem().toString();
					String chatLieu = txtChatLieu.getText();
					String mau = txtMau.getText();
					if(file == null) {
						JOptionPane.showMessageDialog(this,"Vui lòng chọn hình ảnh cho sản phẩm");
						return;
					}
					String picName = getNameByPath(file.getAbsolutePath());
					
					SanPham sanPham = new SanPham(maSp, tenSP, soLuong,mau, chatLieu, kichThuoc, gia, nhanHieu, picName, loaiSanPham, true);
					Boolean kq =  sanPhamDao.them(sanPham);
					if(kq) {
						JOptionPane.showMessageDialog(this,"Thêm thành công");
						coppyImg(picName,file);
						file = null;
						clear();
						String spCuoi = sanPhamDao.getMaSanPhamCuoi().substring(2);
						int maSPNum = Integer.parseInt(spCuoi);
						maSPNum++;
						String maSP = String.format("SP%06d",maSPNum);
						lblMa.setText(maSP);
						
					}else {
						JOptionPane.showMessageDialog(this,"Thêm thất bại công");
					}
			}
		}
		
		if(o.equals(btnLamMoi)) {
			clear();
		}
		
		
	}
}
