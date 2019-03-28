package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import businessLogic.OrderLogic;
import businessLogic.ShoppingCartLogic;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class Order extends JFrame {
	private JTable table;
	private JFrame frame;
	private String name;
	private JButton  btnDeleteProduct;
	private JTextField filedTotalPrice;
	public Order() {
		frame=new JFrame();	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("User");
		getContentPane().setPreferredSize(new Dimension(615,330));
	
		getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("Buna ziua! Mai jos veti gasi produsele selectate de dumneavoastra. ");
		lbl1.setBounds(22, 32, 450, 14);
		getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("Pentru a finaliza comanda apasati \"Finalizare comanda\".");
		lbl2.setBounds(23, 46, 380, 14);
		getContentPane().add(lbl2);
		
		filedTotalPrice = new JTextField();
		filedTotalPrice.setBounds(296, 132, 128, 20);
		getContentPane().add(filedTotalPrice);
		filedTotalPrice.setColumns(10);
		
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
				float total=0.0f;
				total= cart.getTotal();
				filedTotalPrice.setText(total+"");
			}
		});
		btnShowProducts.setBounds(23, 71, 135, 23);
		getContentPane().add(btnShowProducts);
		
		JButton btnFinalizareComanda = new JButton("Finalizare Comanda");
		btnFinalizareComanda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderLogic newOrder=new OrderLogic();
				ShoppingCartLogic cart=new ShoppingCartLogic();
				String totalPrice=cart.getTotal()+"";
				newOrder.addOrder(totalPrice);
			}
		});
		btnFinalizareComanda.setBounds(296, 212, 150, 23);
		getContentPane().add(btnFinalizareComanda);
		
		table = new JTable();
		table.setBounds(23, 105, 261, 130);
		
		btnDeleteProduct = new JButton("Sterge produs");
	
		btnDeleteProduct.setBounds(296, 178, 150, 23);
		
		
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row=table.rowAtPoint(evt.getPoint());
			    name=table.getValueAt(row, 0).toString();
			    btnDeleteProduct.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ShoppingCartLogic cart=new ShoppingCartLogic();
						try {
							System.out.println(name+"nume produs selectat");
							cart.deleteProduct(name);
					
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
				
				
			}
		});
		getContentPane().add(btnDeleteProduct);
		
		getContentPane().add(table);
		
		JButton btnContinuaCumparaturile = new JButton("Continua Cumparaturile");
		btnContinuaCumparaturile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserWindow userWindow=new UserWindow();
				userWindow.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnContinuaCumparaturile.setBounds(0, 0, 158, 23);
		getContentPane().add(btnContinuaCumparaturile);
		
		
		
		JLabel lblPretTotal = new JLabel("Pret total:");
		lblPretTotal.setBounds(296, 105, 95, 14);
		getContentPane().add(lblPretTotal);
		
		frame.setContentPane(getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
}
