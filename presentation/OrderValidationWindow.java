package presentation;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businessLogic.FurnitureLogic;
import businessLogic.OrderLogic;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class OrderValidationWindow extends JFrame{
	private JTable table;
	private JFrame frame;
	private String name;
	private JButton btnValidareComanda;

	public OrderValidationWindow() {
		frame=new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Staff");

		getContentPane().setPreferredSize(new Dimension(300,350));
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 80, 324, 186);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row=table.rowAtPoint(evt.getPoint());
				name=table.getValueAt(row, 0).toString();
				btnValidareComanda.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						OrderLogic order=new OrderLogic();
						order.changeStatusOrder(name);
					}
				});


			}
		});
		getContentPane().add(table);
		
		JLabel lblComenzileCareTrebuie = new JLabel("Comenzile care trebuie validate:");
		lblComenzileCareTrebuie.setBounds(24, 23, 203, 14);
		getContentPane().add(lblComenzileCareTrebuie);
		
		JButton btnVeziComenzi = new JButton("Vezi Comenzi");
		btnVeziComenzi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderLogic order=new OrderLogic();
				ArrayList<String[]> rows=new ArrayList<String[]>();
				try {
					rows=order.getAllOrders();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}

				DefaultTableModel tableModel= new DefaultTableModel();
				String[] col= {"NumeClient", "PretTotalComanda","Status"};

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
		btnVeziComenzi.setBounds(299, 51, 125, 23);
		getContentPane().add(btnVeziComenzi);
		
		btnValidareComanda = new JButton("Validare comanda");

		btnValidareComanda.setBounds(299, 85, 125, 23);
		getContentPane().add(btnValidareComanda);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffWindow staff=new StaffWindow();
				staff.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(0, 0, 89, 23);
		getContentPane().add(btnBack);
		
		frame.setContentPane(getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
}
