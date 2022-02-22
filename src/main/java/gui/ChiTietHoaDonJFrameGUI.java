package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import dao.HoaDonDao;
import dao.Ipml.HoaDonImpl;
import entity.CT_HoaDon;
import entity.HoaDon;
import format.Format;

public class ChiTietHoaDonJFrameGUI extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6370928653941619030L;
	private JLabel lblTenCuaHang;
	private JLabel lblNpkFashsion;
	private JLabel lblDiaChi;
	private JLabel lblSNguyn;
	private JLabel lblNewLabel;
	private JLabel lblHd;
	private JLabel lblMaHD;
	private JLabel lblTenNV;
	private JLabel lblNgayLap;
	private JLabel lblNgayLapHD;
	private JLabel lblTienKhachDua;
	private JLabel lblTienThua;
	private JLabel lblTienTongThanhTien;
	private JLabel lblTongTien;
	private JTable table;
	private JLabel lblLogo;
	private HoaDonDao hoaDonDao = new HoaDonImpl();
	private JLabel lblTenKH;
	private JLabel lblTienVAT;
	private DefaultTableModel model;
	private JButton btnXuatFile;
	private String maHoaDon;
	private JButton btnThoat;
	
	public ChiTietHoaDonJFrameGUI(String ma) {
		this.maHoaDon = ma;
		
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setSize(905, 754);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		lblTenCuaHang = new JLabel("T\u00EAn c\u1EEDa h\u00E0ng :");
		lblTenCuaHang.setFont(new Font("Arial", Font.BOLD, 16));
		lblTenCuaHang.setBounds(10, 0, 128, 35);
		getContentPane().add(lblTenCuaHang);
		
		setLocationRelativeTo(null);
		
		lblNpkFashsion = new JLabel("NPK Fashsion");
		lblNpkFashsion.setFont(new Font("Arial", Font.BOLD, 16));
		lblNpkFashsion.setBounds(148, 0, 119, 35);
		getContentPane().add(lblNpkFashsion);
		
		lblDiaChi = new JLabel("Địa chỉ              :");
		lblDiaChi.setFont(new Font("Arial", Font.BOLD, 16));
		lblDiaChi.setBounds(10, 29, 133, 35);
		getContentPane().add(lblDiaChi);
		
		lblSNguyn = new JLabel("S\u1ED1 12 Nguy\u1EC5n V\u0103n B\u1EA3o, Ph\u01B0\u1EDDng 4, Qu\u1EADn G\u00F2 V\u1EA5p , Th\u00E0nh Ph\u1ED1 H\u1ED3 Ch\u00ED Minh");
		lblSNguyn.setFont(new Font("Arial", Font.ITALIC, 16));
		lblSNguyn.setBounds(148, 29, 585, 35);
		getContentPane().add(lblSNguyn);
		
		lblMaHD = new JLabel("Mã hóa đơn        :");
		lblMaHD.setFont(new Font("Arial", Font.BOLD, 16));
		lblMaHD.setBounds(10, 111, 128, 35);
		getContentPane().add(lblMaHD);
		
		lblHd = new JLabel("HD00001");
		lblHd.setForeground(Color.RED);
		lblHd.setFont(new Font("Arial", Font.ITALIC, 16));
		lblHd.setBounds(148, 111, 109, 35);
		getContentPane().add(lblHd);
		
		lblNewLabel = new JLabel("H\u00D3A \u0110\u01A0N B\u00C1N H\u00C0NG");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 62, 880, 45);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTenNhanVien = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn    :");
		lblTenNhanVien.setFont(new Font("Arial", Font.BOLD, 16));
		lblTenNhanVien.setBounds(10, 142, 133, 35);
		getContentPane().add(lblTenNhanVien);
		
		lblTenNV = new JLabel("Nguy\u1EC5n V\u0103n A");
		lblTenNV.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTenNV.setBounds(148, 142, 467, 35);
		getContentPane().add(lblTenNV);
		
		lblNgayLap = new JLabel("Ng\u00E0y l\u1EADp :");
		lblNgayLap.setFont(new Font("Arial", Font.BOLD, 16));
		lblNgayLap.setBounds(650, 142, 83, 35);
		getContentPane().add(lblNgayLap);
		
		lblNgayLapHD = new JLabel("01-01-2022");
		lblNgayLapHD.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNgayLapHD.setBounds(743, 142, 147, 35);
		getContentPane().add(lblNgayLapHD);
		
		JLabel lblTenKhachHang = new JLabel("T\u00EAn kh\u00E1ch h\u00E0ng :");
		lblTenKhachHang.setFont(new Font("Arial", Font.BOLD, 16));
		lblTenKhachHang.setBounds(10, 176, 133, 35);
		getContentPane().add(lblTenKhachHang);
		
		lblTenKH = new JLabel("Nguy\u1EC5n V\u0103n A");
		lblTenKH.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTenKH.setBounds(148, 176, 467, 35);
		getContentPane().add(lblTenKH);
		
		JLabel lblKhachDua = new JLabel("Ti\u1EC1n kh\u00E1ch \u0111\u01B0a :");
		lblKhachDua.setFont(new Font("Arial", Font.BOLD, 16));
		lblKhachDua.setBounds(10, 526, 133, 35);
		getContentPane().add(lblKhachDua);
		
		lblTienKhachDua = new JLabel("200,000 VN\u0110");
		lblTienKhachDua.setForeground(Color.RED);
		lblTienKhachDua.setFont(new Font("Arial", Font.BOLD, 16));
		lblTienKhachDua.setBounds(148, 526, 209, 35);
		getContentPane().add(lblTienKhachDua);
		
		JLabel lblTienThuaKhachDua = new JLabel("Tiền thừa             :");
		lblTienThuaKhachDua.setFont(new Font("Arial", Font.BOLD, 16));
		lblTienThuaKhachDua.setBounds(10, 560, 147, 35);
		getContentPane().add(lblTienThuaKhachDua);
		
		lblTienThua = new JLabel("90,000 VN\u0110");
		lblTienThua.setForeground(Color.RED);
		lblTienThua.setFont(new Font("Arial", Font.BOLD, 16));
		lblTienThua.setBounds(148, 560, 219, 35);
		getContentPane().add(lblTienThua);
		
		JLabel lblTongThanhTien = new JLabel("T\u1ED5ng th\u00E0nh ti\u1EC1n :");
		lblTongThanhTien.setFont(new Font("Arial", Font.BOLD, 16));
		lblTongThanhTien.setBounds(531, 526, 147, 35);
		getContentPane().add(lblTongThanhTien);
		
		lblTienTongThanhTien = new JLabel("100,000 VN\u0110");
		lblTienTongThanhTien.setForeground(Color.RED);
		lblTienTongThanhTien.setFont(new Font("Arial", Font.BOLD, 16));
		lblTienTongThanhTien.setBounds(688, 526, 183, 35);
		getContentPane().add(lblTienTongThanhTien);
		
		JLabel lblThueVAT = new JLabel("Thuế VAT            :");
		lblThueVAT.setFont(new Font("Arial", Font.BOLD, 16));
		lblThueVAT.setBounds(531, 560, 147, 35);
		getContentPane().add(lblThueVAT);
		
		lblTienVAT = new JLabel("10,000 VN\u0110");
		lblTienVAT.setForeground(Color.RED);
		lblTienVAT.setFont(new Font("Arial", Font.BOLD, 16));
		lblTienVAT.setBounds(688, 560, 183, 35);
		getContentPane().add(lblTienVAT);
		
		JLabel lblTong = new JLabel("Tổng  cộng          :");
		lblTong.setFont(new Font("Arial", Font.BOLD, 16));
		lblTong.setBounds(531, 600, 147, 35);
		getContentPane().add(lblTong);
		
		lblTongTien = new JLabel("");
		lblTongTien.setForeground(Color.RED);
		lblTongTien.setFont(new Font("Arial", Font.BOLD, 16));
		lblTongTien.setBounds(688, 600, 183, 35);
		getContentPane().add(lblTongTien);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 211, 869, 304);
		getContentPane().add(scrollPane);
		
		String[] colHeader = { "STT", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
				};
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
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setRowHeight(35);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);	
		table.getColumnModel().getColumn(2).setPreferredWidth(5);	
		table.getColumnModel().getColumn(1).setPreferredWidth(350);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(ChiTietHoaDonJFrameGUI.class.getResource("/img/logonpk.png")));
		lblLogo.setFont(new Font("Arial", Font.BOLD, 16));
		lblLogo.setBounds(771, 0, 119, 35);
		getContentPane().add(lblLogo);
		lblHd.setText(ma);
		
		HoaDon hoaDon = hoaDonDao.getHoaDonTheoMa(ma);
		String lblVAT = String.format("Thuế VAT(%.0f %%) :",hoaDon.getThueVAT()*100);
		lblThueVAT.setText(lblVAT);
		
		lblTenNV.setText(hoaDon.getNhanVien().getHoTen());
		lblTenKH.setText(hoaDon.getKhachHang().getHoTen());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String ngayLap = simpleDateFormat.format(hoaDon.getNgayLapHD());
		lblNgayLapHD.setText(ngayLap);
		lblTienVAT.setText(Format.chuyenDoiTienTe(hoaDon.tinhTongTien()*hoaDon.getThueVAT()));
		lblTienKhachDua.setText(Format.chuyenDoiTienTe(hoaDon.getTienNhan()));
		lblTienTongThanhTien.setText(Format.chuyenDoiTienTe(hoaDon.tinhTongTien()));
		double tienThua = (hoaDon.getTienNhan() - hoaDon.tinhTongTien_VAT());
		lblTienThua.setText(Format.chuyenDoiTienTe(tienThua));
		lblTongTien.setText(Format.chuyenDoiTienTe(hoaDon.tinhTongTien_VAT()));
		
		btnXuatFile = new JButton("Xuất hóa đơn");
		btnXuatFile.setIcon(new ImageIcon(ChiTietHoaDonJFrameGUI.class.getResource("/img/file.png")));
		btnXuatFile.setFont(new Font("Arial", Font.PLAIN, 16));
		btnXuatFile.setBounds(533, 658, 157, 35);
		getContentPane().add(btnXuatFile);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(ChiTietHoaDonJFrameGUI.class.getResource("/img/Thoat.png")));
		btnThoat.setFont(new Font("Arial", Font.PLAIN, 16));
		btnThoat.setBounds(762, 658, 109, 35);
		getContentPane().add(btnThoat);
		List<CT_HoaDon> listCT_HD = hoaDonDao.getDanhSachChiTietHoaDon(ma);
		int i = 0;
		for(CT_HoaDon cthd : listCT_HD) {
			i++;
			double thanhtien = cthd.getSoLuong() * cthd.getGia();
			model.addRow(new Object[] {
					i,cthd.getSanPham().getTenSP(),cthd.getSoLuong(),Format.chuyenDoiTienTe(cthd.getGia()),Format.chuyenDoiTienTe(thanhtien)
			});
		}
		
		btnXuatFile.addActionListener(this);
		btnThoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if (o == btnThoat) {
			dispose();
		}
		
		if (o == btnXuatFile) {
			
			JFileChooser fChooser = new JFileChooser();
			
			fChooser.setCurrentDirectory(new File("C:\\Users\\Trung Ngoc\\Downloads"));
			fChooser.addChoosableFileFilter(new FileFilter() {

				@Override
				public String getDescription() {
					// TODO Auto-generated method stub
					return "Excel file (*.pdf)";
				}

				@Override
				public boolean accept(File f) {
					// TODO Auto-generated method stub
					if (f.isDirectory()) {
						return true;
					} else {
						return f.getName().toLowerCase().endsWith(".pdf");
//								|| f.getName().toLowerCase().endsWith(".jpg");
					}
				}
			});

			int i = fChooser.showSaveDialog(this);
			if (i == 0) {
				String path = fChooser.getSelectedFile().getAbsolutePath();
				
//				if (!path.matches("(.)+(\\.png|\\.jpg)$")) {
//					path += ".png";
//				}
				if (!path.matches("(.)+(\\.pdf)$")) {
					path += ".pdf";
				}
				int xacNhan = JOptionPane.showConfirmDialog(this, "Bạn có muốn xuất file", "Thông báo",
						JOptionPane.YES_NO_OPTION);
				if (xacNhan == JOptionPane.YES_OPTION) {
					
					JFrame xuatHD = new XuatHoaDonJFrameGUI(maHoaDon);
					xuatHD.setVisible(true);
					Container content = xuatHD.getContentPane();
					xuatHD.setVisible(false);
					int height = content.getHeight();
					int width = content.getHeight();
		            BufferedImage img = new BufferedImage(content.getWidth(), content.getHeight(), BufferedImage.TYPE_INT_RGB);
		            Graphics2D g2d = img.createGraphics();
		            content.printAll(g2d);
		            g2d.dispose();

		            try {

		            	Document d = new Document();
		    	        PdfWriter writer = PdfWriter.getInstance(d, new FileOutputStream(path));
		    	        d.open();
		    	        
		    	        PdfContentByte contentByte = writer.getDirectContent();
		    	        Image image = Image.getInstance(contentByte,scaleImage(595,height, img), 1);
		    	        
		    	        PdfTemplate template = contentByte.createTemplate(width, height);
		    	        image.setAbsolutePosition(0,0);
		    	        template.addImage(image);
		    	        contentByte.addTemplate(template,0,100);
		    	        d.close();
		                
		                xacNhan = JOptionPane.showConfirmDialog(this, "Bạn có muốn xem file", "Thông báo", JOptionPane.YES_NO_OPTION);
						if(xacNhan==JOptionPane.YES_OPTION)
							try {
								Desktop.getDesktop().open(new File(path));
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
		            } catch (IOException | DocumentException ex) {
		            	ex.printStackTrace();
		            	JOptionPane.showMessageDialog(this, "Không thành công");
		            }
						
				}
			}
		}
		
	}
	
	public BufferedImage scaleImage(int WIDTH, int HEIGHT,BufferedImage img ) {
	    BufferedImage bi = null;
	    try {
	        ImageIcon ii = new ImageIcon(img);
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
	
}
