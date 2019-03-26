package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import businessLogic.FurnitureLogic;
import businessLogic.UserLogic;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UserWindow extends JFrame{
	private JTable table;
	private JFrame frame;
	public UserWindow() {
		
		frame=new JFrame();	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("User");
		getContentPane().setPreferredSize(new Dimension(615,330));
		getContentPane().setLayout(null);
		
		JLabel lblCosulTau = new JLabel("Cosul tau:");
		lblCosulTau.setBounds(444, 11, 108, 14);
		getContentPane().add(lblCosulTau);
		
		JButton btnCart = new JButton("Cos");
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCart.setBounds(498, 7, 89, 23);
		getContentPane().add(btnCart);
		
	
		JButton btnAddCart = new JButton("Adauga in cos");
		btnAddCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddCart.setBounds(451, 58, 118, 23);
		getContentPane().add(btnAddCart);
		
		JButton btnDeleteCart = new JButton("Sterge din cos");
		btnDeleteCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteCart.setBounds(451, 92, 118, 23);
		getContentPane().add(btnDeleteCart);
		
		JLabel lblSelecteazaProdusulPe = new JLabel("Selecteaza produsul pe care il doresti si apasa pe butonul \"Adauga in cos\".");
		lblSelecteazaProdusulPe.setBounds(28, 23, 373, 14);
		getContentPane().add(lblSelecteazaProdusulPe);
		
		JButton btnHistorical = new JButton("Istoric comenzi");
		btnHistorical.setBounds(451, 239, 118, 23);
		getContentPane().add(btnHistorical);
		
		JLabel lblSorteaza = new JLabel("Sorteaza:");
		lblSorteaza.setBounds(28, 48, 82, 14);
		getContentPane().add(lblSorteaza);
		
		JComboBox comboBoxFilter = new JComboBox();
		comboBoxFilter.setModel(new DefaultComboBoxModel(new String[] {"tip", "nume", "pret"}));
		comboBoxFilter.setToolTipText("");
		comboBoxFilter.setBounds(92, 48, 89, 20);
		getContentPane().add(comboBoxFilter);
		
		JButton btnClickHere = new JButton("Click here!");
		btnClickHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClickHere.setBounds(191, 48, 89, 23);
		getContentPane().add(btnClickHere);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogic user=new UserLogic();
				user.logOutUser();
				LogInUser logIn= new LogInUser();
				logIn.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(0, 0, 89, 23);
		getContentPane().add(btnBack);
		
		JButton btnAfiseazaProduse = new JButton("Afiseaza produse");
		btnAfiseazaProduse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FurnitureLogic furniture=new FurnitureLogic();
				ArrayList<String[]> rows=new ArrayList<String[]>();
				try {
					rows=furniture.seeFurniture("orderedByName");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				DefaultTableModel tableModel= new DefaultTableModel();
				String[] col= {"nume", "pret","discount","tip"};
			
				for(String s: col) {
						tableModel.addColumn(s);
				}
				for(String[] r: rows) {
					tableModel.addRow(r);
				}
				
				table.setModel(tableModel);	
				
				
			}
		});
		table = new JTable();
		table.setLayout(null);
		table.setBounds(30, 78, 343, 211);
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		getContentPane().add(table);
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseCicked(java.awt.event.MouseEvent evt) {
				int row=table.rowAtPoint(evt.getPoint());
				String name=table.getValueAt(row, 0).toString();
				String pret=table.getValueAt(row, 1).toString();
				String discount=table.getValueAt(row, 2).toString();
				String tip=table.getValueAt(row, 3).toString();
				
				
			}
		});
	
		btnAfiseazaProduse.setBounds(451, 126, 118, 23);
		getContentPane().add(btnAfiseazaProduse);
		
		
		
		frame.setContentPane(getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
}
