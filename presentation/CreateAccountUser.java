package presentation;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import businessLogic.UserLogic;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPasswordField;

public class CreateAccountUser extends JFrame{
	private JTextField fieldName;
	private JFrame frame;
	private JTextField fieldAddress;
	private JTextField fieldPhone;
	private JTextField fieldEmail;
	private JPasswordField pwdPassword;
	public CreateAccountUser() {
		frame=new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("User");
		
		getContentPane().setPreferredSize(new Dimension(500,500));
		getContentPane().setLayout(null);
		
		fieldName = new JTextField();
		fieldName.setBounds(145, 63, 137, 20);
		getContentPane().add(fieldName);
		fieldName.setColumns(10);
		
		fieldAddress = new JTextField();
		fieldAddress.setBounds(145, 125, 137, 20);
		getContentPane().add(fieldAddress);
		fieldAddress.setColumns(10);
		
		fieldPhone = new JTextField();
		fieldPhone.setBounds(145, 156, 137, 20);
		getContentPane().add(fieldPhone);
		fieldPhone.setColumns(10);
		
		fieldEmail = new JTextField();
		fieldEmail.setBounds(145, 187, 137, 20);
		getContentPane().add(fieldEmail);
		fieldEmail.setColumns(10);
		
		JButton btnCreateAccount = new JButton("CreateAccount");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogic user=new UserLogic();
				String name=fieldName.getText();
				String password = new String(pwdPassword.getPassword());
				String address=fieldAddress.getText();
				String phone=fieldPhone.getText();
				String email=fieldEmail.getText();
				int isOK=user.addUser(name, email, phone, password, address);
				if(isOK==1)
					JOptionPane.showMessageDialog(frame,
							"Contul dumneavoastra a fost creat cu succes!");
				if(isOK==2)
					JOptionPane.showMessageDialog(frame,
							"Acest USERNAME este atribuit altcuiva, va rugam sa alegeti altul!");
				if(isOK==0)
					JOptionPane.showMessageDialog(frame,
							"Completati campurile cu mai multa grija!");
				
			}
		});
		btnCreateAccount.setHorizontalAlignment(SwingConstants.RIGHT);
		btnCreateAccount.setBounds(126, 248, 120, 23);
		getContentPane().add(btnCreateAccount);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setFont(new Font("Papyrus", Font.BOLD, 16));
		lblCreateAccount.setBounds(106, 23, 145, 29);
		getContentPane().add(lblCreateAccount);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInUser logIn= new LogInUser();
				logIn.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(7, 11, 89, 23);
		getContentPane().add(btnBack);
		
		JLabel lblUsername = new JLabel("UserName:");
		lblUsername.setBounds(53, 66, 89, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(53, 97, 75, 14);
		getContentPane().add(lblPassword);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(53, 128, 55, 14);
		getContentPane().add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(53, 159, 46, 14);
		getContentPane().add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(53, 190, 69, 14);
		getContentPane().add(lblEmail);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(145, 94, 137, 20);
		getContentPane().add(pwdPassword);
		
		frame.setContentPane(getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
}
