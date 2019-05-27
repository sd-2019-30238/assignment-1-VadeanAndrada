package presentation;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class FeedbackUserWindow extends JFrame{
	private JFrame frame;
	
	public FeedbackUserWindow() {
frame=new JFrame();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("User");
		
		getContentPane().setPreferredSize(new Dimension(300,300));
		getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(34, 50, 209, 133);
		getContentPane().add(textPane);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserWindow u=new UserWindow();
			}
		});
		btnBack.setBounds(10, 11, 89, 23);
		getContentPane().add(btnBack);
		
		JButton btnTrimite = new JButton("TRIMITE");
		btnTrimite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTrimite.setBounds(260, 165, 89, 23);
		getContentPane().add(btnTrimite);
		
		frame.setContentPane(getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
}
