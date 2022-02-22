package gui;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.HoaDonDao;
import dao.Ipml.HoaDonImpl;
import entity.CT_HoaDon;
import entity.HoaDon;
import format.Format;

public class XuatHoaDonJFrameGUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2869309240349577987L;
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
	private JLabel lblSetTienDua;
	private JLabel lblSetTienThua;
	private JLabel lblSetTongTien;
	private JLabel lblSetTongCong;
	private JLabel lblLogo;
	private HoaDonDao hoaDonDao = new HoaDonImpl();
	private JLabel lblTenKH;
	private JLabel lblSetTienVAT;
	private DefaultTableModel model;
	private JTable table;
	

	public XuatHoaDonJFrameGUI(String ma) {
		
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
		setSize(905, 682);
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
		
		lblMaHD = new JLabel("Mã hóa đơn         :");
		lblMaHD.setFont(new Font("Arial", Font.BOLD, 16));
		lblMaHD.setBounds(10, 108, 138, 35);
		getContentPane().add(lblMaHD);
		
		lblHd = new JLabel("HD00001");
		lblHd.setForeground(Color.RED);
		lblHd.setFont(new Font("Arial", Font.ITALIC, 16));
		lblHd.setBounds(158, 108, 109, 35);
		getContentPane().add(lblHd);
		
		lblNewLabel = new JLabel("H\u00D3A \u0110\u01A0N B\u00C1N H\u00C0NG");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 62, 880, 45);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTenNhanVien = new JLabel("Tên nhân viên    :");
		lblTenNhanVien.setFont(new Font("Arial", Font.BOLD, 16));
		lblTenNhanVien.setBounds(10, 142, 138, 35);
		getContentPane().add(lblTenNhanVien);
		
		lblTenNV = new JLabel("Nguy\u1EC5n V\u0103n A");
		lblTenNV.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTenNV.setBounds(158, 142, 467, 35);
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
		lblTenKH.setBounds(158, 176, 467, 35);
		getContentPane().add(lblTenKH);
		
		JLabel lblTienDua = new JLabel("Ti\u1EC1n kh\u00E1ch \u0111\u01B0a :");
		lblTienDua.setFont(new Font("Arial", Font.BOLD, 16));
		lblTienDua.setBounds(10, 526, 133, 35);
		getContentPane().add(lblTienDua);
		
		lblSetTienDua = new JLabel("200,000 VN\u0110");
		lblSetTienDua.setForeground(Color.RED);
		lblSetTienDua.setFont(new Font("Arial", Font.BOLD, 16));
		lblSetTienDua.setBounds(148, 526, 209, 35);
		getContentPane().add(lblSetTienDua);
		
		JLabel lblTienThua = new JLabel("Tiền thừa             :");
		lblTienThua.setFont(new Font("Arial", Font.BOLD, 16));
		lblTienThua.setBounds(10, 560, 147, 35);
		getContentPane().add(lblTienThua);
		
		lblSetTienThua = new JLabel("90,000 VN\u0110");
		lblSetTienThua.setForeground(Color.RED);
		lblSetTienThua.setFont(new Font("Arial", Font.BOLD, 16));
		lblSetTienThua.setBounds(148, 560, 219, 35);
		getContentPane().add(lblSetTienThua);
		
		JLabel lblTongTien = new JLabel("T\u1ED5ng th\u00E0nh ti\u1EC1n :");
		lblTongTien.setFont(new Font("Arial", Font.BOLD, 16));
		lblTongTien.setBounds(531, 526, 147, 35);
		getContentPane().add(lblTongTien);
		
		lblSetTongTien = new JLabel("100,000 VN\u0110");
		lblSetTongTien.setForeground(Color.RED);
		lblSetTongTien.setFont(new Font("Arial", Font.BOLD, 16));
		lblSetTongTien.setBounds(688, 526, 183, 35);
		getContentPane().add(lblSetTongTien);
		
		JLabel lblTienThue = new JLabel("Thuế VAT            :");
		lblTienThue.setFont(new Font("Arial", Font.BOLD, 16));
		lblTienThue.setBounds(531, 560, 147, 35);
		getContentPane().add(lblTienThue);
		
		lblSetTienVAT = new JLabel("10,000 VN\u0110");
		lblSetTienVAT.setForeground(Color.RED);
		lblSetTienVAT.setFont(new Font("Arial", Font.BOLD, 16));
		lblSetTienVAT.setBounds(688, 560, 183, 35);
		getContentPane().add(lblSetTienVAT);
		
		JLabel lblTongCong = new JLabel("Tổng  cộng          :");
		lblTongCong.setFont(new Font("Arial", Font.BOLD, 16));
		lblTongCong.setBounds(531, 600, 147, 35);
		getContentPane().add(lblTongCong);
		
		lblSetTongCong = new JLabel("");
		lblSetTongCong.setForeground(Color.RED);
		lblSetTongCong.setFont(new Font("Arial", Font.BOLD, 16));
		lblSetTongCong.setBounds(688, 600, 183, 35);
		getContentPane().add(lblSetTongCong);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 213, 869, 302);
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
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(XuatHoaDonJFrameGUI.class.getResource("/img/logonpk.png")));
		lblLogo.setFont(new Font("Arial", Font.BOLD, 16));
		lblLogo.setBounds(771, 0, 119, 35);
		getContentPane().add(lblLogo);
		lblHd.setText(ma);
		
		HoaDon hoaDon = hoaDonDao.getHoaDonTheoMa(ma);
		String lblVAT = String.format("Thuế VAT(%.0f %%) :",hoaDon.getThueVAT()*100);
		lblTienThue.setText(lblVAT);
		
		lblTenNV.setText(hoaDon.getNhanVien().getHoTen());
		lblTenKH.setText(hoaDon.getKhachHang().getHoTen());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String ngayLap = simpleDateFormat.format(hoaDon.getNgayLapHD());
		lblNgayLapHD.setText(ngayLap);
		lblSetTienVAT.setText(Format.chuyenDoiTienTe(hoaDon.tinhTongTien()*hoaDon.getThueVAT()));
		lblSetTienDua.setText(Format.chuyenDoiTienTe(hoaDon.getTienNhan()));
		lblSetTongTien.setText(Format.chuyenDoiTienTe(hoaDon.tinhTongTien()));
		double tienThua = (hoaDon.getTienNhan() - hoaDon.tinhTongTien_VAT());
		lblSetTienThua.setText(Format.chuyenDoiTienTe(tienThua));
		lblSetTongCong.setText(Format.chuyenDoiTienTe(hoaDon.tinhTongTien_VAT()));
		List<CT_HoaDon> listCT_HD = hoaDonDao.getDanhSachChiTietHoaDon(ma);
		int i = 0;
		for(CT_HoaDon cthd : listCT_HD) {
			i++;
			double thanhtien = cthd.getSoLuong() * cthd.getGia();
			model.addRow(new Object[] {
					i,cthd.getSanPham().getTenSP(),cthd.getSoLuong(),Format.chuyenDoiTienTe(cthd.getGia()),Format.chuyenDoiTienTe(thanhtien)
			});
		}
		
		table.setRowHeight(30);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);	
		table.getColumnModel().getColumn(2).setPreferredWidth(5);	
		table.getColumnModel().getColumn(1).setPreferredWidth(350);
		if (listCT_HD.size()>8) {
			int height = (listCT_HD.size()-9) * 30;
			
			this.setSize(905, 682+height);
			scrollPane.setBounds(10, 213, 869, 302 + height);
			
			lblTienDua.setBounds(10, 526+ height, 133, 35);
			lblSetTienDua.setBounds(148, 526+ height, 209, 35);
			lblTienThua.setBounds(10, 560+ height, 147, 35);
			lblSetTienThua.setBounds(148, 560+ height, 219, 35);
			lblTongTien.setBounds(531, 526+ height, 147, 35);
			lblSetTongTien.setBounds(688, 526+ height, 183, 35);
			lblTienThue.setBounds(531, 560+ height, 147, 35);
			lblSetTienVAT.setBounds(688, 560+ height, 183, 35);
			lblTongCong.setBounds(531, 600+ height, 147, 35);
			lblSetTongCong.setBounds(688, 600+ height, 183, 35);
			
			((JPanel) getContentPane()).updateUI();		
		}
	}

	
}
