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
	private JTextField textField;
	private JTextField textField_1;
	private String name;
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
					System.out.println(r);
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
				
			}
		});
		getContentPane().add(table);
		
		JButton btnAdaugaProdus = new JButton("Adauga produs");
		btnAdaugaProdus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdaugaProdus.setBounds(739, 293, 150, 23);
		getContentPane().add(btnAdaugaProdus);
		
		JButton btnStergeProdus = new JButton("Sterge Produs");
		btnStergeProdus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStergeProdus.setBounds(367, 102, 132, 23);
		getContentPane().add(btnStergeProdus);
		
		JButton btnModificaStoc = new JButton("Modifica stoc");
		btnModificaStoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificaStoc.setBounds(367, 148, 132, 23);
		getContentPane().add(btnModificaStoc);
		
		JButton btnSchimbaOferta = new JButton("Schimba oferta");
		btnSchimbaOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSchimbaOferta.setBounds(367, 194, 132, 23);
		getContentPane().add(btnSchimbaOferta);
		
		JButton btnVeziComenzi = new JButton("Vezi comenzi");
		btnVeziComenzi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVeziComenzi.setBounds(155, 11, 110, 23);
		getContentPane().add(btnVeziComenzi);
		
		txtName = new JTextField();
		txtName.setBounds(613, 103, 162, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(613, 138, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(613, 169, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"dormitor", "baie", "bucatarie", "exterior", "copii"}));
		comboBox.setBounds(613, 207, 86, 20);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"fara", "50%", "1+1", "20%"}));
		comboBox_1.setBounds(613, 247, 86, 20);
		getContentPane().add(comboBox_1);
		
		JLabel lblOferta = new JLabel("Oferta:");
		lblOferta.setBounds(529, 250, 46, 14);
		getContentPane().add(lblOferta);
		
		frame.setContentPane(getContentPane());
		frame.pack();
		frame.setVisible(true);
	}

}
