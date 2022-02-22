package gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import entity.NhanVien;

public class TrangChuPnGUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4428033723920383878L;
	private JLabel lblTime;
	private JLabel lblDate;
	private JLabel lblAnhNhanVien;
	private JLabel lblTenNhanVien;

	/**
	 * Create the panel.
	 */
	public TrangChuPnGUI(NhanVien nhanVien) {
		setBackground(new Color(153, 255, 255));
		setBounds(0, 0, 1364, 621);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TrangChuPnGUI.class.getResource("/img/npk2.png")));
		lblNewLabel.setBounds(0, 0, 991, 621);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Shop NPK Fashion");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.MAGENTA);
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 34));
		lblNewLabel_1.setBounds(1001, 102, 353, 71);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Hotline: 0908070605 - 0294314535");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(1001, 533, 270, 38);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Địa chỉ: Số 1A, phường 1, quận 1, Tp. Hồ Chí Minh");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(1001, 575, 363, 23);
		add(lblNewLabel_3);

		lblAnhNhanVien = new JLabel("");
		lblAnhNhanVien.setIcon(new ImageIcon(TrangChuPnGUI.class.getResource("/img/admin.png")));
		lblAnhNhanVien.setBounds(1124, 239, 110, 110);
		add(lblAnhNhanVien);

		lblTime = new JLabel("New label");
		lblTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTime.setForeground(Color.RED);
		lblTime.setFont(new Font("Arial", Font.BOLD, 16));
		lblTime.setBounds(1124, 34, 219, 23);
		add(lblTime);

		lblDate = new JLabel("New label");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setForeground(Color.RED);
		lblDate.setFont(new Font("Arial", Font.BOLD, 16));
		lblDate.setBounds(1035, 11, 308, 23);
		add(lblDate);

		JLabel lblNewLabel_5 = new JLabel("WELCOME");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(1001, 184, 353, 23);
		add(lblNewLabel_5);

		lblTenNhanVien = new JLabel("Nhân viên: Nguyễn Văn A");
		lblTenNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenNhanVien.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTenNhanVien.setBounds(1001, 360, 353, 31);
		add(lblTenNhanVien);

		clock();
		
		if (nhanVien.isChucVu()) {
			lblTenNhanVien.setText("Chủ cửa hàng: " + nhanVien.getHoTen());
		}
		else {
			lblTenNhanVien.setText("Nhân viên: " + nhanVien.getHoTen());
		}
		try {
			setAnhNhanVien(nhanVien.getHinhAnh());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setAnhNhanVien(String picName) throws IOException {
		BufferedImage master = scaleImage(lblAnhNhanVien.getWidth(), lblAnhNhanVien.getHeight(),"imgNhanVien//"+picName);

		int diameter = Math.min(lblAnhNhanVien.getWidth(), master.getHeight());
		BufferedImage mask = new BufferedImage(master.getWidth(), master.getHeight(), BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = mask.createGraphics();
		applyQualityRenderingHints(g2d);
		g2d.fillOval(0, 0, diameter - 1, diameter - 1);
		g2d.dispose();

		BufferedImage masked = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
		g2d = masked.createGraphics();
		applyQualityRenderingHints(g2d);
		int x = (diameter - master.getWidth()) / 2;
		int y = (diameter - master.getHeight()) / 2;
		g2d.drawImage(master, x, y, null);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
		g2d.drawImage(mask, 0, 0, null);
		g2d.dispose();
		
		lblAnhNhanVien.setIcon(new ImageIcon(masked));
		
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
	
	public static void applyQualityRenderingHints(Graphics2D g2d) {

	    g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
	    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	    g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
	    g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
	    g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
	    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	    g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

	}

	public void clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					while (true) {
						Calendar cal = new GregorianCalendar();
						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR_OF_DAY);
						String thu;
						int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
						if (dayOfWeek == 1) {
							thu = "Chủ nhật";
						} else {
							thu = "Thứ " + Integer.toString(dayOfWeek);
						}
						int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);

						lblTime.setText(String.format("%02d:%02d:%02d",hour,minute,second));
						lblDate.setText(thu + " ngày " + dayOfMonth + " tháng " + (month + 1) + " năm " + year);
						sleep(1000);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}

}
