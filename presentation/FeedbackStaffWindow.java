package presentation;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FeedbackStaffWindow extends JFrame {
	public FeedbackStaffWindow() {
		getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setBounds(24, 11, 89, 23);
		getContentPane().add(btnBack);
		
		JButton btnStergeTot = new JButton("STERGE TOT");
		btnStergeTot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStergeTot.setBounds(123, 11, 136, 23);
		getContentPane().add(btnStergeTot);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(259, 61, -229, 136);
		getContentPane().add(textPane);
	}

}
