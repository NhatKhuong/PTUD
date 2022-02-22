package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
import javax.swing.border.EmptyBorder;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import dao.NhanVienDao;
import dao.Ipml.NhanVienImpl;
import entity.NhanVien;

public class QuenMatKhauJFrameGUI extends JFrame implements ActionListener,ItemListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7607102766792575913L;
	private JPanel contentPane;
	private JLabel lblMa;
	private JTextField txtSDT;
	private NhanVien nhanVien;
	private JLabel lblSDT;
	private JTextField txtMaXN;
	private JButton btnLayMa;
	private JButton btnXacNhan;
	private JButton btnHoanTat;
	private JButton btnThoat;
	private int maXacNhan;
	private JLabel lblGoiMa;
	public static final String ACCOUNT_SID = "AC20c0574bc4764489a2009f672742e1bb";
    public static final String AUTH_TOKEN = "4565cd46331fd9cb6898c7aee3db8a03";
    private JLabel lblThoiGian;
    private JPasswordField txtMatKhau;
    private JCheckBox chbHienThi;

	public QuenMatKhauJFrameGUI(NhanVien nhanVien) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(QuenMatKhauJFrameGUI.class.getResource("/img/quenmatkhau-icon.png")));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		this.nhanVien = nhanVien;
		
		setBounds(100, 100, 479, 530);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUÊN MẬT KHẨU");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel.setBounds(117, 11, 250, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(41, 65, 111, 30);
		contentPane.add(lblNewLabel_1);
		
		lblMa = new JLabel("Tên đăng nhập: ");
		lblMa.setFont(new Font("Arial", Font.PLAIN, 16));
		lblMa.setBounds(213, 65, 209, 30);
		contentPane.add(lblMa);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(41, 106, 111, 30);
		contentPane.add(lblNewLabel_1_1);
		
		lblSDT = new JLabel("Tên đăng nhập: ");
		lblSDT.setFont(new Font("Arial", Font.PLAIN, 16));
		lblSDT.setBounds(213, 106, 209, 30);
		contentPane.add(lblSDT);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nhập điện thoại");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(41, 148, 111, 30);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Arial", Font.PLAIN, 16));
		txtSDT.setBounds(213, 148, 209, 30);
		contentPane.add(txtSDT);
		txtSDT.setColumns(10);
		
		btnLayMa = new JButton("Lấy mã");
		btnLayMa.setFont(new Font("Arial", Font.PLAIN, 16));
		btnLayMa.setBounds(278, 218, 89, 30);
		contentPane.add(btnLayMa);
		
		lblGoiMa = new JLabel("Gởi mã qua số điện thoại");
		lblGoiMa.setForeground(Color.BLUE);
		lblGoiMa.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGoiMa.setBounds(80, 218, 183, 30);
		contentPane.add(lblGoiMa);
		
		lblMa.setText(nhanVien.getMaNV().trim());
		char[] sdt = nhanVien.getSdt().trim().toCharArray();
		for (int i=2; i<sdt.length-2; i++) {
			sdt[i] = '*';
		}
		
		lblSDT.setText(String.valueOf(sdt));
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Nhập mã xác nhận");
		lblNewLabel_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1_1_2.setBounds(41, 287, 141, 30);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		txtMaXN = new JTextField();
		txtMaXN.setFont(new Font("Arial", Font.PLAIN, 16));
		txtMaXN.setColumns(10);
		txtMaXN.setBounds(192, 288, 111, 30);
		contentPane.add(txtMaXN);
		
		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setFont(new Font("Arial", Font.PLAIN, 16));
		btnXacNhan.setBounds(320, 287, 102, 30);
		contentPane.add(btnXacNhan);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Nhập mật khẩu mới");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1_1_1_2_1.setBounds(41, 347, 154, 30);
		contentPane.add(lblNewLabel_1_1_1_2_1);
		
		btnHoanTat = new JButton("Hoàn tất");
		btnHoanTat.setIcon(new ImageIcon(QuenMatKhauJFrameGUI.class.getResource("/img/true.png")));
		btnHoanTat.setFont(new Font("Arial", Font.PLAIN, 16));
		btnHoanTat.setBounds(152, 432, 111, 35);
		contentPane.add(btnHoanTat);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setIcon(new ImageIcon(QuenMatKhauJFrameGUI.class.getResource("/img/Thoat.png")));
		btnThoat.setFont(new Font("Arial", Font.PLAIN, 16));
		btnThoat.setBounds(320, 432, 102, 35);
		contentPane.add(btnThoat);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(QuenMatKhauJFrameGUI.class.getResource("/img/quenmatkhau.png")));
		lblNewLabel_2.setBounds(91, 0, 41, 44);
		contentPane.add(lblNewLabel_2);
		btnHoanTat.setEnabled(false);
		txtMaXN.setEnabled(false);
		btnXacNhan.setEnabled(false);
		
		lblThoiGian = new JLabel("");
		lblThoiGian.setFont(new Font("Arial", Font.PLAIN, 16));
		lblThoiGian.setBounds(391, 218, 31, 30);
		contentPane.add(lblThoiGian);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(new Font("Arial", Font.PLAIN, 16));
		txtMatKhau.setBounds(192, 348, 230, 30);
		contentPane.add(txtMatKhau);
		
		chbHienThi = new JCheckBox("Hiển thị mật khẩu");
		chbHienThi.setFont(new Font("Arial", Font.PLAIN, 12));
		chbHienThi.setBounds(290, 385, 132, 23);
		contentPane.add(chbHienThi);
		txtMatKhau.setEchoChar('*');
		txtMatKhau.setEnabled(false);
		chbHienThi.setEnabled(false);
		
		btnHoanTat.addActionListener(this);
		btnThoat.addActionListener(this);
		btnLayMa.addActionListener(this);
		btnXacNhan.addActionListener(this);
		chbHienThi.addItemListener(this);
	
	}
	
///////////////////////////////////////////////////////////////////////

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if (o == btnLayMa) {
			if (txtSDT.getText().trim().equals(nhanVien.getSdt())) {
				goiMaXacNhan();
				txtMaXN.setText("");
				txtMaXN.setEnabled(true);
				btnXacNhan.setEnabled(true);
				txtMatKhau.setText("");
				txtMatKhau.setEnabled(false);
				chbHienThi.setSelected(false);
				chbHienThi.setEnabled(false);
				btnHoanTat.setEnabled(false);
				lblGoiMa.setText("Đã gởi mã đến số thoại");
				btnLayMa.setText("Gởi lại");
				btnLayMa.setEnabled(false);
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						int giay = 30;
						while(giay>0) {
							try {
								lblThoiGian.setText(giay + "");
								giay--;
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						lblThoiGian.setText("");
						btnLayMa.setEnabled(true);
					}
				}).start();
			}
			else {
				JOptionPane.showMessageDialog(this,"Số điện thoại không đúng!");
			}
		}
		
		if (o == btnXacNhan) {
			if (txtMaXN.getText().equals(String.valueOf(maXacNhan))) {
				txtMatKhau.setEnabled(true);
				chbHienThi.setEnabled(true);
				btnHoanTat.setEnabled(true);
			}
			else {
				JOptionPane.showMessageDialog(this,"Mã xác nhận không đúng!");
			}
		}
		
		if (o == btnHoanTat) {
			if (txtMatKhau.getText().trim().length()>5) {
				NhanVienDao nhanVienDao = new NhanVienImpl();
				nhanVien.setMatKhau(txtMatKhau.getText().trim());
				nhanVienDao.capNhatNhanVien(nhanVien);
				JOptionPane.showMessageDialog(this,"Đổi mật khẩu thành công!");
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(this,"Mật khẩu phải từ 6 ký tự trỏ lên!");
			}
		}
		
		if (o == btnThoat) {
			dispose();
		}
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (chbHienThi.isSelected()) {
			txtMatKhau.setEchoChar((char)0);
		}
		else
		{
			txtMatKhau.setEchoChar('*');
		}
		
	}
	
//////////////////////////////////////////////////////////////////////////////////////////	

	private void goiMaXacNhan() {
		 maXacNhan = (int) (Math.random() * ((999999 - 100000) + 1) + 100000);
		 String sms = "NPK Fashion - Mã xác nhận là: " + maXacNhan + " . Vui lòng không tiết lộ mã này với bất kỳ ai.";
		 String sdt = "+84" + nhanVien.getSdt().trim();
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
         Message message = Message.creator(
                 new com.twilio.type.PhoneNumber(sdt),
                 new com.twilio.type.PhoneNumber("+18126514351"),
                 sms)
             .create();

         System.out.println(message.getSid());
	}

}
