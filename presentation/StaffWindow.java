package presentation;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import businessLogic.FurnitureLogic;
import businessLogic.ShoppingCartLogic;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class StaffWindow extends JFrame {
	private JTable table;
	private JTextField txtName;
	private JFrame frame;
	private JTextField textQuantity;
	private JTextField textPrice;
	private String name;
	private JButton btnSchimbaOferta, btnStergeProdus, btnModificaStoc;
	private JTextField newStoc;
	private JComboBox comboType, comboDeal, changeDeal;
	public StaffWindow() {
		frame=new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Staff");

		getContentPane().setPreferredSize(new Dimension(900,350));
		getContentPane().setLayout(null);

		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogInStaff logIn= new LogInStaff();
				logIn.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(10, 11, 110, 23);
		getContentPane().add(btnBack);

		JButton btnVeziToateProdusele = new JButton("Vezi toate produsele");
		btnVeziToateProdusele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FurnitureLogic furniture=new FurnitureLogic();
				ArrayList<String[]> rows=new ArrayList<String[]>();
				try {
					rows=furniture.seeFurnitureStaff();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}

				DefaultTableModel tableModel= new DefaultTableModel();
				String[] col= {"nume", "pret","discount","tip","cantitate"};

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
		btnVeziToateProdusele.setBounds(10, 56, 162, 23);
		getContentPane().add(btnVeziToateProdusele);

		table = new JTable();
		table.setBounds(10, 80, 324, 186);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row=table.rowAtPoint(evt.getPoint());
				name=table.getValueAt(row, 0).toString();

				btnStergeProdus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FurnitureLogic furnitureLogic=new FurnitureLogic();
						try {
							furnitureLogic.deleteFurniture(name);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}

					}
				});

				btnModificaStoc.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FurnitureLogic furnitureLogic=new FurnitureLogic();
						String stoc=newStoc.getText();
						Boolean ok=false;
						try {
							if(stoc.matches("[0-9]+") && stoc.length() > 0) {
								ok=furnitureLogic.updateStoc(name, stoc);}
							if(ok==false)
								JOptionPane.showMessageDialog(frame,
										"Trebuie sa introduci un numar pozitiv!");

						} catch (SQLException e1) {
							e1.printStackTrace();
						}

					}
				});

				btnSchimbaOferta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						FurnitureLogic furnitureLogic=new FurnitureLogic();
						String deal=changeDeal.getSelectedItem().toString();
						try {
							furnitureLogic.updateDiscount(name, deal);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}

					}
				});

			}
		});
		getContentPane().add(table);


		txtName = new JTextField();
		txtName.setBounds(613, 103, 162, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		textQuantity = new JTextField();
		textQuantity.setBounds(613, 138, 86, 20);
		getContentPane().add(textQuantity);
		textQuantity.setColumns(10);

		textPrice = new JTextField();
		textPrice.setBounds(613, 169, 86, 20);
		getContentPane().add(textPrice);
		textPrice.setColumns(10);

		JButton btnAdaugaProdus = new JButton("Adauga produs");
		btnAdaugaProdus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=txtName.getText();
				String quantity=textQuantity.getText();
				int quant=0;
				if(quantity.matches("[0-9]+") && quantity.length() > 0)
					quant=Integer.parseInt(quantity);
				String price=textPrice.getText();
				String deal= comboDeal.getSelectedItem().toString();
				String type= comboType.getSelectedItem().toString();
				FurnitureLogic furnitureLogic=new FurnitureLogic();
				try {
					if(name.length()>0 && price.length()>0 && quant>0) {
					int ok=furnitureLogic.addNewFurniture(name, type, price,quant, deal);
					if(ok==2)
						JOptionPane.showMessageDialog(frame,
								"Avem deja acest produs! Probabil vrei doar sa modifici stocul.");
					if(ok==0)
						JOptionPane.showMessageDialog(frame,
								"Trebuie sa introduci un numar pozitiv pentru cantitate si pret!");

					}
					else
						JOptionPane.showMessageDialog(frame,
								"Te rugam sa completezi toate campurile!");

						

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnAdaugaProdus.setBounds(739, 293, 150, 23);
		getContentPane().add(btnAdaugaProdus);

		btnStergeProdus = new JButton("Sterge Produs");

		btnStergeProdus.setBounds(367, 102, 132, 23);
		getContentPane().add(btnStergeProdus);

		btnModificaStoc = new JButton("Modifica stoc");

		btnModificaStoc.setBounds(367, 178, 132, 23);
		getContentPane().add(btnModificaStoc);

		btnSchimbaOferta = new JButton("Schimba oferta");

		btnSchimbaOferta.setBounds(367, 243, 132, 23);
		getContentPane().add(btnSchimbaOferta);

		JButton btnVeziComenzi = new JButton("Vezi comenzi");
		btnVeziComenzi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderValidationWindow orders=new OrderValidationWindow();
				orders.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnVeziComenzi.setBounds(155, 11, 110, 23);
		getContentPane().add(btnVeziComenzi);



		JLabel lblAdaugaUnProdus = new JLabel("Adauga un produs nou:");
		lblAdaugaUnProdus.setBounds(529, 60, 197, 14);
		getContentPane().add(lblAdaugaUnProdus);

		JLabel lblNumeProdus = new JLabel("Nume produs:");
		lblNumeProdus.setBounds(529, 106, 85, 14);
		getContentPane().add(lblNumeProdus);

		JLabel lblCantitate = new JLabel("Cantitate:");
		lblCantitate.setBounds(529, 141, 77, 14);
		getContentPane().add(lblCantitate);

		JLabel lblPret = new JLabel("Pret:");
		lblPret.setBounds(529, 172, 74, 14);
		getContentPane().add(lblPret);

		JLabel lblTip = new JLabel("Tip:");
		lblTip.setBounds(529, 210, 46, 14);
		getContentPane().add(lblTip);

		comboType = new JComboBox();
		comboType.setModel(new DefaultComboBoxModel(new String[] {"dormitor", "baie", "bucatarie", "exterior", "copii"}));
		comboType.setBounds(613, 207, 86, 20);
		getContentPane().add(comboType);

		comboDeal = new JComboBox();
		comboDeal.setModel(new DefaultComboBoxModel(new String[] {"fara", "50%", "1+1", "20%"}));
		comboDeal.setBounds(613, 247, 86, 20);
		getContentPane().add(comboDeal);

		JLabel lblOferta = new JLabel("Oferta:");
		lblOferta.setBounds(529, 250, 46, 14);
		getContentPane().add(lblOferta);

		changeDeal = new JComboBox();
		changeDeal.setModel(new DefaultComboBoxModel(new String[] {"fara", "50%", "1+1", "20%"}));
		changeDeal.setBounds(367, 212, 86, 20);
		getContentPane().add(changeDeal);

		newStoc = new JTextField();
		newStoc.setToolTipText("Stocul nou");
		newStoc.setBounds(367, 147, 86, 20);
		getContentPane().add(newStoc);
		newStoc.setColumns(10);

		frame.setContentPane(getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
}
