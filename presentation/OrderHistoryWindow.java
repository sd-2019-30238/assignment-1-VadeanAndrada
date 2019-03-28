package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businessLogic.OrderLogic;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class OrderHistoryWindow extends JFrame{
	private JTable table;
	private JFrame frame;

	private JTable table_1;
	public OrderHistoryWindow() {frame=new JFrame();

	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Staff");

	getContentPane().setPreferredSize(new Dimension(400,450));

	getContentPane().setLayout(null);

	JLabel lblComenziInCurs = new JLabel("Comenzi in curs de livrare:");
	lblComenziInCurs.setBounds(32, 42, 200, 14);
	getContentPane().add(lblComenziInCurs);

	JLabel lblComenziLivrate = new JLabel("Comenzi livrate:");
	lblComenziLivrate.setBounds(32, 187, 157, 14);
	getContentPane().add(lblComenziLivrate);

	table = new JTable();
	table.setBounds(42, 171, 190, 103);
	getContentPane().add(table);

	table_1 = new JTable();
	table_1.setBounds(42, 326, 190, 103);
	getContentPane().add(table_1);

	JButton btnBack = new JButton("BACK");
	btnBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UserWindow u= new UserWindow();
			u.setVisible(true);
			frame.setVisible(false);
		}
	});
	btnBack.setBounds(10, 11, 120, 23);
	getContentPane().add(btnBack);

	JButton btnAfisare = new JButton("Afisare");
	btnAfisare.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			OrderLogic order=new OrderLogic();
			ArrayList<String[]> rows=new ArrayList<String[]>();
			try {
				rows=order.getDeliveredUserOrders();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			DefaultTableModel tableModel= new DefaultTableModel();
			String[] col= {"NumeClient", "PretTotalComanda"};

			for(String s: col) {
				tableModel.addColumn(s);

			}
			tableModel.addRow(col);
			for(String[] r: rows) {
				tableModel.addRow(r);
			}

			table.setModel(tableModel);	
		}
	});
	btnAfisare.setBounds(165, 38, 89, 23);
	getContentPane().add(btnAfisare);

	JButton btnAfisareLivrat = new JButton("Afisare");
	btnAfisareLivrat.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			OrderLogic order=new OrderLogic();
			ArrayList<String[]> rows=new ArrayList<String[]>();
			try {
				rows=order.getDeliveredUserOrders();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}

			DefaultTableModel tableModel= new DefaultTableModel();
			String[] col= {"NumeClient", "PretTotalComanda"};

			for(String s: col) {
				tableModel.addColumn(s);

			}
			tableModel.addRow(col);
			for(String[] r: rows) {
				tableModel.addRow(r);
			}

			table_1.setModel(tableModel);	
		}
	});
	btnAfisareLivrat.setBounds(165, 183, 89, 23);
	getContentPane().add(btnAfisareLivrat);

	JButton btnFeedBack = new JButton("FEEDBACK");
	btnFeedBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btnFeedBack.setBounds(155, 11, 145, 23);
	getContentPane().add(btnFeedBack);

	frame.setContentPane(getContentPane());
	frame.pack();
	frame.setVisible(true);
	}

}
