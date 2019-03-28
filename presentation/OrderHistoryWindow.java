package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;

public class OrderHistoryWindow extends JFrame{
	private JTable table;
	private JTable table_1;
	public OrderHistoryWindow() {
		getContentPane().setLayout(null);
		
		JLabel lblComenziInCurs = new JLabel("Comenzi in curs de livrare:");
		lblComenziInCurs.setBounds(32, 42, 200, 14);
		getContentPane().add(lblComenziInCurs);
		
		JLabel lblComenziLivrate = new JLabel("Comenzi livrate:");
		lblComenziLivrate.setBounds(32, 187, 157, 14);
		getContentPane().add(lblComenziLivrate);
		
		table = new JTable();
		table.setBounds(42, 171, 190, -103);
		getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setBounds(42, 326, 190, -103);
		getContentPane().add(table_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBounds(10, 11, 120, 23);
		getContentPane().add(btnBack);
		
		JButton btnAfisare = new JButton("Afisare");
		btnAfisare.setBounds(165, 38, 89, 23);
		getContentPane().add(btnAfisare);
		
		JButton btnAfisareLivrat = new JButton("Afisare");
		btnAfisareLivrat.setBounds(165, 183, 89, 23);
		getContentPane().add(btnAfisareLivrat);
		
		JButton btnFeedBack = new JButton("FEEDBACK");
		btnFeedBack.setBounds(155, 11, 145, 23);
		getContentPane().add(btnFeedBack);
	}

}
