package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import dao.NhanVienDao;
import dao.Ipml.NhanVienImpl;
import entity.NhanVien;

public class ChiTietNhanVienJFrameGUI extends JFrame implements ActionListener, ItemListener, MouseListener, KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7990635091973745212L;
	private JLabel lblMatKhau;
	private JLabel lblDiaChi;
	private JLabel lblCMND;
	private JLabel lblNgaySinh;
	private JLabel lblSDT;
	private JLabel lblGioiTinh;
	private JLabel lblTen;
	private JLabel lblMa;
	private JLabel lbltrangThai;
	private JLabel lblPic;
	private JButton btnThoat;
	private NhanVienDao nhanVienDao = new NhanVienImpl();

	@SuppressWarnings("unused")
	public ChiTietNhanVienJFrameGUI(String maNV) {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 884, 596);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(49, 74, 87));
		panel.setBounds(0, 0, 870, 49);
		getContentPane().add(panel);

		JLabel lblChiTitNhn = new JLabel("CHI TIẾT NHÂN VIÊN");
		lblChiTitNhn.setForeground(Color.WHITE);
		lblChiTitNhn.setFont(new Font("Arial", Font.BOLD, 20));
		lblChiTitNhn.setBounds(364, 10, 208, 25);
		panel.add(lblChiTitNhn);

		JLabel lblNhpSt_1_1_1_4_2 = new JLabel("Trạng thái làm việc :");
		lblNhpSt_1_1_1_4_2.setForeground(Color.RED);
		lblNhpSt_1_1_1_4_2.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNhpSt_1_1_1_4_2.setBounds(575, 50, 151, 35);
		getContentPane().add(lblNhpSt_1_1_1_4_2);

		lbltrangThai = new JLabel("");
		lbltrangThai.setForeground(Color.RED);
		lbltrangThai.setFont(new Font("Arial", Font.ITALIC, 16));
		lbltrangThai.setBounds(724, 50, 134, 35);
		getContentPane().add(lbltrangThai);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 140, 462, 2);
		getContentPane().add(separator);

		JLabel lblNhpSt_1_1_1 = new JLabel("Mã Nhân Viên   :");
		lblNhpSt_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1.setBounds(10, 95, 141, 35);
		getContentPane().add(lblNhpSt_1_1_1);

		lblMa = new JLabel((String) null);
		lblMa.setForeground(Color.RED);
		lblMa.setFont(new Font("Arial", Font.ITALIC, 16));
		lblMa.setBounds(148, 95, 315, 35);
		getContentPane().add(lblMa);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 200, 462, 2);
		getContentPane().add(separator_1);

		JLabel lblNhpSt_1_1_1_1 = new JLabel("Tên Nhân Viên :");
		lblNhpSt_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1_1.setBounds(10, 160, 141, 35);
		getContentPane().add(lblNhpSt_1_1_1_1);

		lblTen = new JLabel((String) null);
		lblTen.setForeground(Color.BLACK);
		lblTen.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTen.setBounds(148, 154, 315, 35);
		getContentPane().add(lblTen);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 260, 462, 2);
		getContentPane().add(separator_1_1);

		JLabel lblNhpSt_1_1_1_1_1 = new JLabel("Giới Tính            :");
		lblNhpSt_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1_1_1.setBounds(10, 220, 141, 35);
		getContentPane().add(lblNhpSt_1_1_1_1_1);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(10, 320, 462, 2);
		getContentPane().add(separator_1_1_1);

		JLabel lblNhpSt_1_1_1_1_1_1 = new JLabel("Số điện thoại    :");
		lblNhpSt_1_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1_1_1_1.setBounds(10, 280, 141, 35);
		getContentPane().add(lblNhpSt_1_1_1_1_1_1);

		JLabel lblNhpSt_1_1_1_1_1_1_1 = new JLabel("Ngày Sinh         :");
		lblNhpSt_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1_1_1_1_1.setBounds(10, 340, 141, 35);
		getContentPane().add(lblNhpSt_1_1_1_1_1_1_1);

		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setBounds(10, 380, 462, 2);
		getContentPane().add(separator_1_1_1_1);

		JSeparator separator_1_1_1_1_1 = new JSeparator();
		separator_1_1_1_1_1.setBounds(10, 440, 462, 2);
		getContentPane().add(separator_1_1_1_1_1);

		JLabel lblNhpSt_1_1_1_1_1_1_1_1 = new JLabel("CMND                 :");
		lblNhpSt_1_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1_1_1_1_1_1.setBounds(10, 400, 141, 35);
		getContentPane().add(lblNhpSt_1_1_1_1_1_1_1_1);

		JLabel lblNhpSt_1_1_1_1_1_1_1_1_1 = new JLabel("Địa Chỉ                :");
		lblNhpSt_1_1_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1_1_1_1_1_1_1.setBounds(10, 460, 141, 35);
		getContentPane().add(lblNhpSt_1_1_1_1_1_1_1_1_1);

		JSeparator separator_1_1_1_1_1_1 = new JSeparator();
		separator_1_1_1_1_1_1.setBounds(10, 500, 462, 2);
		getContentPane().add(separator_1_1_1_1_1_1);

		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(ChiTietNhanVienJFrameGUI.class.getResource("/img/logout.png")));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThoat.setBounds(686, 500, 150, 35);
		getContentPane().add(btnThoat);

		lblPic = new JLabel("");

		JSeparator separator_1_1_1_1_1_1_1 = new JSeparator();
		separator_1_1_1_1_1_1_1.setBounds(10, 560, 462, 2);
		getContentPane().add(separator_1_1_1_1_1_1_1);

		JLabel lblNhpSt_1_1_1_1_1_1_1_1_1_1 = new JLabel("Mật Khẩu            :");
		lblNhpSt_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_1_1_1_1_1_1_1_1.setBounds(10, 514, 141, 35);
		getContentPane().add(lblNhpSt_1_1_1_1_1_1_1_1_1_1);

		lblGioiTinh = new JLabel((String) null);
		lblGioiTinh.setForeground(Color.RED);
		lblGioiTinh.setFont(new Font("Arial", Font.ITALIC, 16));
		lblGioiTinh.setBounds(148, 214, 315, 35);
		getContentPane().add(lblGioiTinh);

		lblSDT = new JLabel((String) null);
		lblSDT.setForeground(Color.RED);
		lblSDT.setFont(new Font("Arial", Font.ITALIC, 16));
		lblSDT.setBounds(148, 274, 315, 35);
		getContentPane().add(lblSDT);

		lblNgaySinh = new JLabel((String) null);
		lblNgaySinh.setForeground(Color.RED);
		lblNgaySinh.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNgaySinh.setBounds(148, 333, 315, 35);
		getContentPane().add(lblNgaySinh);

		lblCMND = new JLabel((String) null);
		lblCMND.setForeground(Color.RED);
		lblCMND.setFont(new Font("Arial", Font.ITALIC, 16));
		lblCMND.setBounds(148, 394, 315, 35);
		getContentPane().add(lblCMND);

		lblDiaChi = new JLabel((String) null);
		lblDiaChi.setForeground(Color.RED);
		lblDiaChi.setFont(new Font("Arial", Font.ITALIC, 16));
		lblDiaChi.setBounds(148, 453, 315, 35);
		getContentPane().add(lblDiaChi);

		lblMatKhau = new JLabel((String) null);
		lblMatKhau.setForeground(Color.RED);
		lblMatKhau.setFont(new Font("Arial", Font.ITALIC, 16));
		lblMatKhau.setBounds(148, 514, 315, 35);
		getContentPane().add(lblMatKhau);

		NhanVien nv = nhanVienDao.getNhanVientheoMa(maNV);
		lblMa.setText(nv.getMaNV());
		lblTen.setText(nv.getHoTen());
		lblSDT.setText(nv.getSdt());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String date = simpleDateFormat.format(nv.getNgaySinh());
		lblNgaySinh.setText(date);
		lblSDT.setText(nv.getSdt());
		lblCMND.setText(nv.getcmnd());
		lblDiaChi.setText(
				nv.getDiaChi().getPhuongXa() + "-" + nv.getDiaChi().getQuanHuyen() + "-" + nv.getDiaChi().getTinhTP());
		String trangThai = "Đã nghỉ việc";
		if (nv.isTrangThai()) {
			trangThai = "Còn Làm việc";
		}
		lbltrangThai.setText(trangThai);
		String gioiTinh = "Nữ";
		if (nv.isGioiTinh()) {
			gioiTinh = "Nam";
		}
		lblGioiTinh.setText(gioiTinh);
		lblPic.setBounds(508, 140, 350, 350);
		getContentPane().add(lblPic);
		lblMatKhau.setText(nv.getMatKhau());
		String chucVu = "Nhân Viên";
		if (nv.isChucVu()) {
			chucVu = "Quản lý";
		}

		btnThoat.addActionListener(this);
		
		String picName = nv.getHinhAnh();
		String picPath = "imgNhanVien/"+picName+"";
		BufferedImage bImage = scaleImage(lblPic.getWidth(),lblPic.getHeight(), picPath);
		ImageIcon icon = new ImageIcon(bImage);
		lblPic.setIcon(icon);
		lblPic.updateUI();
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
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThoat)) {
			dispose();
		}

	}
	
}
