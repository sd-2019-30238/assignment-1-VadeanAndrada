package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import businessLogic.StaffLogic;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class CreateAccountStaff extends JFrame{
	private JTextField textField;
	private JFrame frame;

	private JPasswordField passwordField;
	public CreateAccountStaff() {
		frame=new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("User");
		
		getContentPane().setPreferredSize(new Dimension(300,300));
		getContentPane().setLayout(null);
		
		JLabel lblCreeazaUnCont = new JLabel("Creeaza un cont nou:");
		lblCreeazaUnCont.setBounds(23, 25, 201, 29);
		getContentPane().add(lblCreeazaUnCont);
		
		textField = new JTextField();
		textField.setBounds(85, 65, 138, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(85, 96, 138, 20);
		getContentPane().add(passwordField);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInStaff logIn= new LogInStaff();
				logIn.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(10, 0, 89, 23);
		getContentPane().add(btnBack);
		
		JButton btnAddAccount = new JButton("Creeaza cont");
		btnAddAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffLogic staff=new StaffLogic();
				String name=textField.getText();
				String password= new String(passwordField.getPassword());
				int isOK=staff.addNewStaff(name, password);
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
		btnAddAccount.setBounds(72, 140, 152, 23);
		getContentPane().add(btnAddAccount);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 65, 89, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 99, 77, 14);
		getContentPane().add(lblPassword);
		
		frame.setContentPane(getContentPane());
		frame.pack();
		frame.setVisible(true);

	}
}
