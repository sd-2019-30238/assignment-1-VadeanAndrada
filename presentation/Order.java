package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import businessLogic.ShoppingCartLogic;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class Order extends JFrame {
	private JTable table;
	private JFrame frame;
	private JTextField filedTotalPrice;
	public Order() {
		frame=new JFrame();	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("User");
		getContentPane().setPreferredSize(new Dimension(615,330));
	
		getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("Buna ziua! Mai jos veti gasi produsele selectate de dumneavoastra. ");
		lbl1.setBounds(22, 32, 385, 14);
		getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("Pentru a finaliza comanda apasati \"Finalizare comanda\".");
		lbl2.setBounds(23, 46, 336, 14);
		getContentPane().add(lbl2);
		
		JButton btnDeleteProduct = new JButton("Sterge produs");
		btnDeleteProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteProduct.setBounds(296, 178, 128, 23);
		getContentPane().add(btnDeleteProduct);
		
		JButton btnShowProducts = new JButton("Afisare produse");
		btnShowProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartLogic cart=new ShoppingCartLogic();
				ArrayList<String[]> rows=new ArrayList<String[]>();
				rows=cart.getShoppingCart();
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
		btnShowProducts.setBounds(23, 71, 122, 23);
		getContentPane().add(btnShowProducts);
		
		JButton btnFinalizareComanda = new JButton("Finalizare Comanda");
		btnFinalizareComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFinalizareComanda.setBounds(296, 212, 128, 23);
		getContentPane().add(btnFinalizareComanda);
		
		table = new JTable();
		table.setBounds(23, 105, 261, 130);
		getContentPane().add(table);
		
		JButton btnContinuaCumparaturile = new JButton("Continua Cumparaturile");
		btnContinuaCumparaturile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserWindow userWindow=new UserWindow();
				userWindow.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnContinuaCumparaturile.setBounds(0, 0, 145, 23);
		getContentPane().add(btnContinuaCumparaturile);
		
		filedTotalPrice = new JTextField();
		filedTotalPrice.setBounds(296, 132, 128, 20);
		getContentPane().add(filedTotalPrice);
		filedTotalPrice.setColumns(10);
		
		JLabel lblPretTotal = new JLabel("Pret total:");
		lblPretTotal.setBounds(296, 105, 95, 14);
		getContentPane().add(lblPretTotal);
		
		frame.setContentPane(getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
}
