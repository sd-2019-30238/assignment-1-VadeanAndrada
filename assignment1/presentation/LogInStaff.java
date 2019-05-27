package presentation;

import javax.swing.JFrame;
import javax.swing.JTextField;

import businessLogic.StaffLogic;
import businessLogic.UserLogic;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInStaff extends JFrame {
	private JTextField fieldUsername;
	private JFrame frame;
	private JLabel lblLogin;
	private JPasswordField passwordField;
	private JButton btnBack;
	private JButton btnCreateaccount;
	public LogInStaff() {
		frame=new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Staff");
		
		getContentPane().setPreferredSize(new Dimension(300,400));
		getContentPane().setLayout(null);
		
		fieldUsername = new JTextField();
		fieldUsername.setBounds(129, 115, 140, 20);
		getContentPane().add(fieldUsername);
		fieldUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(64, 118, 66, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblPssword = new JLabel("Password:");
		lblPssword.setBounds(64, 163, 79, 14);
		getContentPane().add(lblPssword);
		
		lblLogin = new JLabel("LogIn");
		lblLogin.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 24));
		lblLogin.setBounds(129, 43, 127, 45);
		getContentPane().add(lblLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(129, 160, 140, 20);
		getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("LogIn");
		btnLogin.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StaffLogic staff=new StaffLogic();
				String username=fieldUsername.getText();	 
				String password=new String(passwordField.getPassword());
				int isOK=staff.logInStaff(username, password);
				System.out.println(password);
				if(isOK==0)
					JOptionPane.showMessageDialog(frame,
							"Username-ul sau parola sunt gresite! Incearca cu mai multa atentie!");
				else
				{
					StaffWindow newWindow= new StaffWindow();
					newWindow.setVisible(true);
					frame.setVisible(false);
				}
			}
		});
		btnLogin.setBounds(118, 227, 120, 23);
		getContentPane().add(btnLogin);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow main=new MainWindow();
				main.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		getContentPane().add(btnBack);
		
		btnCreateaccount = new JButton("CreateAccount");
		btnCreateaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccountStaff create= new CreateAccountStaff();
				create.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnCreateaccount.setBounds(118, 263, 120, 23);
		getContentPane().add(btnCreateaccount);
		
		frame.setContentPane(getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
}
