package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import dao.SanPhamDao;
import dao.Ipml.SanPhamImpl;
import entity.SanPham;
import format.Format;

public class ChiTietSanPhamJFrameGUI extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4065032011024624823L;
	private JPanel contentPane;
	private JLabel lblNhanHieu;
	private JLabel lblKichThuoc;
	private JLabel lblLoai;
	private JLabel lblTen;
	private JLabel lblMa;
	private JButton btnThoat;
	private JLabel lblGia;

	private SanPhamDao sanPhamDao;
	private JLabel lblTrangThai;
	private JLabel lblChatLieu;
	private JLabel lblMau;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ChiTietSanPhamJFrameGUI(String maSanPham) {
		sanPhamDao = new SanPhamImpl();
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 596);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		JLabel lblNhpSt_1_1_1 = new JLabel("M\u00E3 s\u1EA3n ph\u1EA9m   :");
		lblNhpSt_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1.setBounds(496, 124, 141, 35);
		contentPane.add(lblNhpSt_1_1_1);
		
		JLabel lblNhpSt_1_1_1_1 = new JLabel("T\u00EAn s\u1EA3n ph\u1EA9m  :");
		lblNhpSt_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1_1.setBounds(28, 467, 141, 35);
		contentPane.add(lblNhpSt_1_1_1_1);
		
		JLabel lblNhpSt_1_1_1_2 = new JLabel("Gi\u00E1 ");
		lblNhpSt_1_1_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1_2.setBounds(28, 410, 68, 35);
		contentPane.add(lblNhpSt_1_1_1_2);
		
		JLabel lblNhpSt_1_1_1_3 = new JLabel("K\u00EDch th\u01B0\u1EDBc       :");
		lblNhpSt_1_1_1_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1_3.setBounds(496, 410, 141, 35);
		contentPane.add(lblNhpSt_1_1_1_3);
		
		JLabel lblNhpSt_1_1_1_4 = new JLabel("Nh\u00E3n hi\u1EC7u         :");
		lblNhpSt_1_1_1_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1_4.setBounds(496, 330, 141, 35);
		contentPane.add(lblNhpSt_1_1_1_4);
		
		JLabel lblNhpSt_1_1_1_4_1 = new JLabel("Lo\u1EA1i s\u1EA3n ph\u1EA9m :");
		lblNhpSt_1_1_1_4_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1_4_1.setBounds(496, 265, 141, 35);
		contentPane.add(lblNhpSt_1_1_1_4_1);
		
		JLabel lblNhpSt_1_1_1_4_2 = new JLabel("Tr\u1EA1ng th\u00E1i kinh doanh :");
		lblNhpSt_1_1_1_4_2.setForeground(Color.RED);
		lblNhpSt_1_1_1_4_2.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNhpSt_1_1_1_4_2.setBounds(542, 61, 172, 35);
		contentPane.add(lblNhpSt_1_1_1_4_2);
		
		lblMa = new JLabel("SP000001");
		lblMa.setForeground(Color.RED);
		lblMa.setFont(new Font("Arial", Font.ITALIC, 16));
		lblMa.setBounds(664, 126, 150, 35);
		contentPane.add(lblMa);
		
		lblTen = new JLabel("\u00C1o s\u01A1 mi tr\u1EAFng c\u1ED5 tr\u00F2n");
		lblTen.setForeground(Color.BLACK);
		lblTen.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTen.setBounds(153, 467, 694, 35);
		contentPane.add(lblTen);
		
		lblLoai = new JLabel("\u00C1o s\u01A1 mi");
		lblLoai.setForeground(Color.BLACK);
		lblLoai.setFont(new Font("Arial", Font.PLAIN, 16));
		lblLoai.setBounds(664, 265, 183, 35);
		contentPane.add(lblLoai);
		
		lblNhanHieu = new JLabel("Vi\u00EAtNam");
		lblNhanHieu.setForeground(Color.BLACK);
		lblNhanHieu.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNhanHieu.setBounds(664, 330, 183, 35);
		contentPane.add(lblNhanHieu);
		
		lblKichThuoc = new JLabel("XXL");
		lblKichThuoc.setForeground(Color.BLACK);
		lblKichThuoc.setFont(new Font("Arial", Font.PLAIN, 16));
		lblKichThuoc.setBounds(664, 410, 183, 35);
		contentPane.add(lblKichThuoc);
		
		lblTrangThai = new JLabel("\u0110ang kinh doanh ");
		lblTrangThai.setForeground(Color.RED);
		lblTrangThai.setFont(new Font("Arial", Font.ITALIC, 16));
		lblTrangThai.setBounds(713, 61, 134, 35);
		contentPane.add(lblTrangThai);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 870, 49);
		panel.setBackground(new Color(49, 74, 87));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblChiTitSn = new JLabel("CHI TI\u1EBET S\u1EA2N PH\u1EA8M");
		lblChiTitSn.setBounds(364, 10, 208, 25);
		panel.add(lblChiTitSn);
		lblChiTitSn.setForeground(Color.WHITE);
		lblChiTitSn.setFont(new Font("Arial", Font.BOLD, 20));
		
		lblGia = new JLabel("250000 vn\u0111");
		lblGia.setForeground(Color.RED);
		lblGia.setFont(new Font("Arial", Font.ITALIC, 16));
		lblGia.setBounds(150, 410, 172, 35);
		contentPane.add(lblGia);
		
		btnThoat = new JButton("Tho\u00E1t");
		btnThoat.setIcon(new ImageIcon(ChiTietSanPhamJFrameGUI.class.getResource("/img/logout.png")));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThoat.setBounds(697, 501, 150, 35);
		contentPane.add(btnThoat);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(500, 180, 350, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(500, 244, 350, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(500, 310, 350, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(500, 455, 350, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(500, 380, 350, 2);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(485, 61, 1, 387);
		contentPane.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(485, 105, 2, 345);
		contentPane.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(372, 487, 1, 42);
		contentPane.add(separator_7);
		
		JLabel lblNhpSt_1_1_1_3_1 = new JLabel("Chất liệu");
		lblNhpSt_1_1_1_3_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1_3_1.setBounds(496, 199, 141, 35);
		contentPane.add(lblNhpSt_1_1_1_3_1);
		
		lblChatLieu = new JLabel((String) null);
		lblChatLieu.setForeground(Color.BLACK);
		lblChatLieu.setFont(new Font("Arial", Font.PLAIN, 16));
		lblChatLieu.setBounds(631, 199, 183, 35);
		contentPane.add(lblChatLieu);
		
		JSeparator separator_4_1 = new JSeparator();
		separator_4_1.setBounds(10, 455, 304, 2);
		contentPane.add(separator_4_1);
		
		lblMau = new JLabel("");
		lblMau.setForeground(Color.BLACK);
		lblMau.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMau.setBounds(150, 514, 172, 35);
		contentPane.add(lblMau);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(25, 91, 297, 291);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPic = new JLabel("");
		lblPic.setBounds(10, 10, 276, 271);
		panel_1.add(lblPic);
		lblPic.setIcon(new ImageIcon(ChiTietSanPhamJFrameGUI.class.getResource("/img/AoSoMi.jpg")));
		
		btnThoat.addActionListener(this);
		
		SanPham sanPham = sanPhamDao.getSanPhamById(maSanPham);
		lblMa.setText(sanPham.getMaSP());
		lblTen.setText(sanPham.getTenSP());
		lblLoai.setText(sanPham.getLoaiSanPham().getTenLoai());
		lblNhanHieu.setText(sanPham.getNhanHieu());
		lblGia.setText(Format.chuyenDoiTienTe(sanPham.getDonGia()));
		lblKichThuoc.setText(sanPham.getKichThuoc());
		lblTrangThai.setText(sanPham.isTrangThaiKD() ? "Đang kinh doanh" : "Ngừng kinh doanh");
		lblChatLieu.setText(sanPham.getChatLieu());
		lblMau.setText(sanPham.getMauSac());
		
		
		
		String picName = sanPham.getHinhAnh();
		String picPath = "imgSanPham//"+picName+"";
		
		BufferedImage bImage = scaleImage(lblPic.getWidth(),lblPic.getHeight(), picPath);
		ImageIcon icon = new ImageIcon(bImage);
		lblPic.setIcon(icon);
		
		JLabel lblNhpSt_1_1_1_2_1 = new JLabel("Màu sắc");
		lblNhpSt_1_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1_2_1.setBounds(28, 514, 68, 35);
		contentPane.add(lblNhpSt_1_1_1_2_1);
		
		
		
		JSeparator separator_4_1_1 = new JSeparator();
		separator_4_1_1.setBounds(10, 512, 304, 2);
		contentPane.add(separator_4_1_1);
	 
		
	
		
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
	


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThoat)) {
//			int n = DISPOSE_ON_CLOSE;
			
			dispose();
		}
		
	}
}
