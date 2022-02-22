package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SuaSoLuongGUI extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2675386831857737174L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtSua;
	private JLabel lblSoLuongCo;
	private JLabel lblSoLuongLap;
	public static int soLuongSua = -1;
	private JButton btnThoat;
	private JButton btnSua;
	private int soLuongHienCo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public SuaSoLuongGUI(int soLuongHienCo, int soLuongLapHD) {
		this.soLuongHienCo = soLuongHienCo;
		setModal(true);
		setBounds(100, 100, 349, 345);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Sửa số lượng");
		
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Nhập số lượng cần sửa");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(27, 135, 169, 24);
		contentPanel.add(lblNewLabel);
		
		txtSua = new JTextField();
		txtSua.setBounds(27, 169, 280, 35);
		contentPanel.add(txtSua);
		txtSua.setColumns(10);
		
		JLabel lblSLngHin = new JLabel("Số lượng hiện có         :");
		lblSLngHin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSLngHin.setBounds(27, 44, 169, 24);
		contentPanel.add(lblSLngHin);
		
		JLabel lblSLngLp = new JLabel("Số lượng lập hóa đơn  :");
		lblSLngLp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSLngLp.setBounds(27, 90, 169, 24);
		contentPanel.add(lblSLngLp);
		
		lblSoLuongCo = new JLabel("");
		lblSoLuongCo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSoLuongCo.setBounds(203, 44, 104, 21);
		contentPanel.add(lblSoLuongCo);
		
		lblSoLuongLap = new JLabel("");
		lblSoLuongLap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSoLuongLap.setBounds(203, 90, 104, 21);
		contentPanel.add(lblSoLuongLap);

		
		lblSoLuongCo.setText(String.valueOf(soLuongHienCo));
		lblSoLuongLap.setText(String.valueOf(soLuongLapHD));
		
		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThoat.setBounds(27, 225, 131, 35);
		contentPanel.add(btnThoat);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSua.setBounds(176, 225, 131, 35);
		contentPanel.add(btnSua);
		
		btnSua.addActionListener(this);
		btnThoat.addActionListener(this);
		
		
		
	}
	public boolean isNum(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public void focusAndSelect(JTextField txt) {
		txt.requestFocus();
		txt.selectAll();
	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnSua)) {
			if(!isNum(txtSua.getText()) || Integer.parseInt(txtSua.getText()) <0 ) {
				JOptionPane.showMessageDialog(this,"Số lượng phải là số nguyên dương");
				focusAndSelect(txtSua);
				return;
			}
			if(Integer.parseInt(txtSua.getText()) > soLuongHienCo) {
				JOptionPane.showMessageDialog(this,"Số lượng sủa vượt quá số lượng hiện có");
				focusAndSelect(txtSua);
				return;
			}
			this.soLuongSua = Integer.parseInt(txtSua.getText());
			dispose();
		}
		
		if(o.equals(btnThoat)) {
			dispose();
		}
		
	}
}
