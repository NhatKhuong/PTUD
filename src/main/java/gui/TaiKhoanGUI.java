package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import entity.NhanVien;

public class TaiKhoanGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1671259494403698008L;
	private JLabel lblMa;
	private JLabel lblTen;
	private JLabel lblSDT;
	private JLabel lblCMND;
	private JLabel lblDiaChi;
	private JLabel lblGioiTinh;
	private JLabel lblNgaySinh;
	private JLabel lblHinhAnh;
	private JLabel lblNhpSt_1_1_2_2;
	private JLabel lblTimeLamViec;
	private JLabel lblTimeDangNhap;
	private JLabel lblNhpSt_1_1_2_3;
	private Date timeDangNhap;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public TaiKhoanGUI(NhanVien nhanVien) {
		this.timeDangNhap = DangNhapJFrameGUI.getTimeDangNhap();
		
		
		getContentPane().setForeground(new Color(0, 0, 0));
		getContentPane().setBackground(new Color(255, 255, 255));
		
		setBackground(new Color(153, 153, 255));
		setSize(735, 502);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		lblMa = new JLabel("NV000021");
		lblMa.setForeground(new Color(0, 0, 0));
		lblMa.setFont(new Font("Arial", Font.ITALIC, 16));
		lblMa.setBounds(502, 121, 128, 35);
		getContentPane().add(lblMa);
		
		JLabel lblNhpSt_1_1_2 = new JLabel("Số điện thoại   :");
		lblNhpSt_1_1_2.setForeground(new Color(0, 0, 0));
		lblNhpSt_1_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_2.setBounds(377, 321, 125, 35);
		getContentPane().add(lblNhpSt_1_1_2);
		
		JLabel lblNhpSt_1_1_2_1 = new JLabel("CMND                :");
		lblNhpSt_1_1_2_1.setForeground(new Color(0, 0, 0));
		lblNhpSt_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_2_1.setBounds(377, 221, 132, 35);
		getContentPane().add(lblNhpSt_1_1_2_1);
		
		JLabel lblNhpSt_1_1_3 = new JLabel("Địa chỉ                 :");
		lblNhpSt_1_1_3.setForeground(new Color(0, 0, 0));
		lblNhpSt_1_1_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_3.setBounds(82, 406, 132, 35);
		getContentPane().add(lblNhpSt_1_1_3);
		
		JLabel lblThngTinNhn = new JLabel("THÔNG TIN TÀI KHOẢN");
		lblThngTinNhn.setBackground(new Color(255, 255, 255));
		lblThngTinNhn.setForeground(new Color(0, 0, 0));
		lblThngTinNhn.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinNhn.setFont(new Font("Arial", Font.BOLD, 22));
		lblThngTinNhn.setBounds(0, 0, 719, 35);
		getContentPane().add(lblThngTinNhn);
		
		lblTen = new JLabel("NV000021");
		lblTen.setForeground(new Color(0, 0, 0));
		lblTen.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTen.setBounds(217, 367, 223, 35);
		getContentPane().add(lblTen);
		
		lblSDT = new JLabel("NV000021");
		lblSDT.setForeground(new Color(0, 0, 0));
		lblSDT.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSDT.setBounds(505, 321, 125, 35);
		getContentPane().add(lblSDT);
		
		lblCMND = new JLabel("NV000021");
		lblCMND.setForeground(new Color(0, 0, 0));
		lblCMND.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCMND.setBounds(502, 221, 128, 35);
		getContentPane().add(lblCMND);
		
		lblDiaChi = new JLabel("NV000021");
		lblDiaChi.setForeground(new Color(0, 0, 0));
		lblDiaChi.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDiaChi.setBounds(217, 406, 380, 35);
		getContentPane().add(lblDiaChi);
		
		lblMa.setText(nhanVien.getMaNV());
		lblTen.setText(nhanVien.getHoTen());
		lblCMND.setText(nhanVien.getcmnd());
		lblSDT.setText(nhanVien.getSdt());
		lblDiaChi.setText(nhanVien.getDiaChi().getPhuongXa()+"-"+nhanVien.getDiaChi().getQuanHuyen()+"-"+nhanVien.getDiaChi().getTinhTP());
		
		lblHinhAnh = new JLabel();
		lblHinhAnh.setForeground(new Color(255, 255, 255));
		lblHinhAnh.setBounds(82, 128, 201, 219);
		getContentPane().add(lblHinhAnh);
		lblHinhAnh.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel lblNhpSt_1_1_4 = new JLabel("Giới tính            :");
		lblNhpSt_1_1_4.setForeground(new Color(0, 0, 0));
		lblNhpSt_1_1_4.setBounds(377, 171, 125, 35);
		getContentPane().add(lblNhpSt_1_1_4);
		lblNhpSt_1_1_4.setFont(new Font("Arial", Font.BOLD, 16));
		String gioiTinh = "Nữ";
		if(nhanVien.isGioiTinh()) {
			gioiTinh = "Nam";
		}
		lblGioiTinh = new JLabel();
		lblGioiTinh.setBounds(505, 171, 125, 35);
		getContentPane().add(lblGioiTinh);
		lblGioiTinh.setForeground(new Color(0, 0, 0));
		lblGioiTinh.setFont(new Font("Arial", Font.PLAIN, 16));
		lblGioiTinh.setText(gioiTinh);
		
		JLabel lblNhpSt_1_1_4_1 = new JLabel("Ngày sinh         :");
		lblNhpSt_1_1_4_1.setForeground(new Color(0, 0, 0));
		lblNhpSt_1_1_4_1.setBounds(377, 271, 125, 35);
		getContentPane().add(lblNhpSt_1_1_4_1);
		lblNhpSt_1_1_4_1.setFont(new Font("Arial", Font.BOLD, 16));
		
		lblNgaySinh = new JLabel("NV000021");
		lblNgaySinh.setBounds(505, 271, 125, 35);
		getContentPane().add(lblNgaySinh);
		lblNgaySinh.setForeground(new Color(0, 0, 0));
		lblNgaySinh.setFont(new Font("Arial", Font.PLAIN, 16));
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		lblNgaySinh.setText(dateFormat.format(nhanVien.getNgaySinh()));
		
		lblTimeLamViec = new JLabel("a");
		lblTimeLamViec.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTimeLamViec.setForeground(new Color(255, 0, 0));
		lblTimeLamViec.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTimeLamViec.setBounds(624, 71, 74, 25);
		getContentPane().add(lblTimeLamViec);
		
		lblNhpSt_1_1_2_2 = new JLabel("Mã Nhân Viên  :");
		lblNhpSt_1_1_2_2.setForeground(Color.BLACK);
		lblNhpSt_1_1_2_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_2_2.setBounds(374, 121, 128, 35);
		getContentPane().add(lblNhpSt_1_1_2_2);
		
		lblTimeDangNhap = new JLabel("a");
		lblTimeDangNhap.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTimeDangNhap.setForeground(Color.RED);
		lblTimeDangNhap.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTimeDangNhap.setBounds(624, 46, 74, 25);
		getContentPane().add(lblTimeDangNhap);
		
		JLabel lblNhpSt_1_1_2_2_1 = new JLabel("Tên Nhân Viên  :");
		lblNhpSt_1_1_2_2_1.setForeground(Color.BLACK);
		lblNhpSt_1_1_2_2_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_2_2_1.setBounds(82, 367, 143, 35);
		getContentPane().add(lblNhpSt_1_1_2_2_1);
		
		lblNhpSt_1_1_2_3 = new JLabel("Thời gian làm việc      :");
		lblNhpSt_1_1_2_3.setForeground(Color.BLACK);
		lblNhpSt_1_1_2_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_2_3.setBounds(454, 71, 176, 25);
		getContentPane().add(lblNhpSt_1_1_2_3);
		
		JLabel lblNhpSt_1_1_2_3_1 = new JLabel("Thời gian đăng nhập :");
		lblNhpSt_1_1_2_3_1.setForeground(Color.BLACK);
		lblNhpSt_1_1_2_3_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhpSt_1_1_2_3_1.setBounds(454, 46, 176, 25);
		getContentPane().add(lblNhpSt_1_1_2_3_1);
		if (nhanVien.getHinhAnh()!=null) {
			BufferedImage bImg = scaleImage(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), "imgNhanVien//" + nhanVien.getHinhAnh().trim());
			ImageIcon icon = new ImageIcon(bImg);
			lblHinhAnh.setIcon(icon);
		}
		else {
			lblHinhAnh.setIcon(null);
		}
		
		lblTimeDangNhap.setText(String.format("%02d:%02d:%02d",timeDangNhap.getHours(),timeDangNhap.getMinutes(),timeDangNhap.getSeconds()) );
		new Thread(()->{
			while (true) {
				Date now = Calendar.getInstance().getTime();
				long time = now.getTime() - timeDangNhap.getTime();
				 
				long seconds = time / 1000 % 60;
				long minutes = time / (60 * 1000) % 60;
				long hours = minutes/60;
				
				lblTimeLamViec.setText(String.format("%02d:%02d:%02d",hours,minutes,seconds));
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		

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

	
}
