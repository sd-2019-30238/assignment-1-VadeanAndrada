package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import businessLogic.ShoppingCartLogic;
import businessLogic.UserLogic;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UserWindow extends JFrame{
	private JTable table;
	private JFrame frame;
	private JButton btnAddCart,btnClickHere;
	private String name;
	private JComboBox comboBoxFilter;
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
				Order order=new Order();
				order.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnCart.setBounds(498, 7, 89, 23);
		getContentPane().add(btnCart);
		
		
		JLabel lblSelecteazaProdusulPe = new JLabel("Selecteaza produsul pe care il doresti si apasa pe butonul \"Adauga in cos\".");
		lblSelecteazaProdusulPe.setBounds(28, 23, 430, 14);
		getContentPane().add(lblSelecteazaProdusulPe);
		
		JButton btnHistorical = new JButton("Istoric comenzi");
		btnHistorical.setBounds(451, 239, 140, 23);
		getContentPane().add(btnHistorical);
		
		JLabel lblSorteaza = new JLabel("Sorteaza:");
		lblSorteaza.setBounds(28, 48, 82, 14);
		getContentPane().add(lblSorteaza);
		
		comboBoxFilter = new JComboBox();
		comboBoxFilter.setModel(new DefaultComboBoxModel(new String[] {"tip", "nume", "pret"}));
		comboBoxFilter.setToolTipText("");
		comboBoxFilter.setBounds(92, 48, 89, 20);
		getContentPane().add(comboBoxFilter);
		
		btnClickHere = new JButton("Click here!");
		btnClickHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FurnitureLogic furniture=new FurnitureLogic();
				ArrayList<String[]> rows=new ArrayList<String[]>();
				try {
					rows=furniture.seeFurniture(comboBoxFilter.getSelectedItem().toString());
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
		btnClickHere.setBounds(191, 48, 100, 23);
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
					rows=furniture.seeFurniture("nume");
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
		
		btnAddCart = new JButton("Adauga in cos");
		btnAddCart.setBounds(451, 58, 140, 23);
		getContentPane().add(btnAddCart);
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row=table.rowAtPoint(evt.getPoint());
			    name=table.getValueAt(row, 0).toString();
				btnAddCart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ShoppingCartLogic cart=new ShoppingCartLogic();
						try {
							Boolean isOk=cart.addShoppingCart(name);
							if(isOk==false) {
								JOptionPane.showMessageDialog(frame,
										"Nu putem adauga acest produs, stocul este indisponibil! Ne pare rau!");
					
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
				
				
			}
		});
	
		btnAfiseazaProduse.setBounds(451, 126, 140, 23);
		getContentPane().add(btnAfiseazaProduse);
		
		
		
		frame.setContentPane(getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
}
