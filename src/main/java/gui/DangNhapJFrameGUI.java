package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import dao.NhanVienDao;
import dao.Ipml.NhanVienImpl;
import entity.NhanVien;

public class DangNhapJFrameGUI extends JFrame implements ActionListener,ItemListener,MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2505345578584431973L;
	private JPanel contentPane;
	private JTextField txtMaNhanVien;
	private JLabel lblHinhAnh;
	private JLabel lblQuenMK;
	private JButton btnThoat;
	private JButton btnDangNhap;
	private JCheckBox cbHienMatKhau;
	private NhanVienDao nhanVienDao;
	private JPasswordField txtMatKhau;
	private static  Date timeDangNhap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					DangNhapJFrameGUI frame = new DangNhapJFrameGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhapJFrameGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DangNhapJFrameGUI.class.getResource("/img/security-icon.png")));
		nhanVienDao = new NhanVienImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(462, 722);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setFont(new Font("Arial", Font.PLAIN, 16));
		txtMaNhanVien.setBounds(59, 315, 326, 37);
		contentPane.add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);
		
		btnDangNhap = new JButton("ĐĂNG NHẬP");
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDangNhap.setBackground(new Color(0, 0, 204));
		btnDangNhap.setBounds(59, 529, 326, 41);
		contentPane.add(btnDangNhap);
		
		btnThoat = new JButton("THOÁT");
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThoat.setBackground(new Color(204, 51, 51));
		btnThoat.setBounds(59, 586, 326, 41);
		contentPane.add(btnThoat);
		
		JLabel lblNewLabel_2 = new JLabel("Tên đăng nhập");
		lblNewLabel_2.setForeground(UIManager.getColor("Button.darkShadow"));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(59, 273, 151, 41);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mật khẩu");
		lblNewLabel_2_1.setForeground(UIManager.getColor("Button.darkShadow"));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(59, 366, 100, 41);
		contentPane.add(lblNewLabel_2_1);
		
		cbHienMatKhau = new JCheckBox("Hiển thị mật khẩu");
		cbHienMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbHienMatKhau.setBackground(Color.WHITE);
		cbHienMatKhau.setBounds(59, 461, 224, 21);
		contentPane.add(cbHienMatKhau);
		
		lblHinhAnh = new JLabel("");
		lblHinhAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinhAnh.setIcon(new ImageIcon(DangNhapJFrameGUI.class.getResource("/img/login.png")));
		lblHinhAnh.setBounds(10, 99, 426, 149);
		contentPane.add(lblHinhAnh);
		
		lblQuenMK = new JLabel("Quên mật khẩu");
		lblQuenMK.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuenMK.setForeground(new Color(0, 153, 255));
		lblQuenMK.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuenMK.setBounds(95, 498, 261, 21);
		contentPane.add(lblQuenMK);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(new Font("Arial", Font.PLAIN, 16));
		txtMatKhau.setBounds(59, 404, 326, 37);
		contentPane.add(txtMatKhau);
		
		txtMaNhanVien.setText("NV000003");
		txtMatKhau.setText("11111129");
		txtMaNhanVien.selectAll();
		txtMaNhanVien.requestFocus();
		txtMatKhau.setEchoChar('*');
		
		btnDangNhap.addActionListener(this);
		btnThoat.addActionListener(this);
		cbHienMatKhau.addItemListener(this);
		lblQuenMK.addMouseListener(this);
		
	}
	
///////////////////////////////////////////////////////////////////

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (cbHienMatKhau.isSelected()) {
			txtMatKhau.setEchoChar((char)0);
		}
		else
		{
			txtMatKhau.setEchoChar('*');
		}
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {	
		Object o = e.getSource();
		if (o == btnThoat) {
			System.exit(0);
		}
		if (o == btnDangNhap) {
			String ma = txtMaNhanVien.getText().trim();
			String matKhau = txtMatKhau.getText().trim();
			NhanVien nhanVien = nhanVienDao.getNhanVien(ma, matKhau);
			if (nhanVien!=null) {
				this.dispose();
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						timeDangNhap = Calendar.getInstance().getTime();
						TrangChinhJFrameGUI trangChinhJFrameGUI = new TrangChinhJFrameGUI(nhanVien);
						trangChinhJFrameGUI.setVisible(true);
						
					}
				});
				
			}
			else JOptionPane.showMessageDialog(this,"Mã nhân viên hoặc mật khẩu không chính xác!");
		}
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (txtMaNhanVien.getText().trim()!="" && nhanVienDao.getNhanVientheoMa(txtMaNhanVien.getText().trim()) != null) {
			NhanVien nhanVien = nhanVienDao.getNhanVientheoMa(txtMaNhanVien.getText().trim());
			QuenMatKhauJFrameGUI  quenMatKhauJFrameGUI = new QuenMatKhauJFrameGUI(nhanVien);
			quenMatKhauJFrameGUI.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(this,"Tên đăng nhập không tồn tại trong hệ thống!");
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
	
	public static Date getTimeDangNhap() {
		return timeDangNhap;
	}
}
