package presentation;

import javax.swing.JFrame;
import javax.swing.JTextField;

import businessLogic.UserLogic;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInUser extends JFrame {
	private JFrame frame;
	private JTextField fieldUsername;
	private JLabel lblLogin;
	private JPasswordField passwordField;
	private JButton btnBack;
	private JButton btnCreaateAccount;
	public LogInUser() {
		frame=new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("User");
		
		getContentPane().setPreferredSize(new Dimension(300,400));
		getContentPane().setLayout(null);
		fieldUsername = new JTextField();
		fieldUsername.setBounds(129, 115, 140, 20);
		getContentPane().add(fieldUsername);
		fieldUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(40, 118, 90, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblPssword = new JLabel("Password:");
		lblPssword.setBounds(40, 163, 79, 14);
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
				UserLogic user=new UserLogic();
				String username=fieldUsername.getText();
				String password = new String(passwordField.getPassword());

				int isOK=user.logInUser(username, password);
				System.out.println(password+" "+isOK);
				if(isOK==0)
					JOptionPane.showMessageDialog(frame,
							"Username-ul sau parola sunt gresite! Incearca cu mai multa atentie!");
				if(isOK==1) {
					UserWindow userWindow=new UserWindow();
					userWindow.setVisible(true);
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
		
		btnCreaateAccount = new JButton("CreateAccount");
		btnCreaateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateAccountUser create= new CreateAccountUser();
				create.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnCreaateAccount.setBounds(118, 271, 120, 23);
		getContentPane().add(btnCreaateAccount);
	
		frame.setContentPane(getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
}
