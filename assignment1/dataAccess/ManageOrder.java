package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ManageOrder {
	public void addOrder(String username, String totalPrice) {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement= null;
		try {
			String query="Insert into orderr (username, totalPrice, delivered) values (?,?,?)";
			statement=con.prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, totalPrice);
			statement.setInt(3, 0);
			statement.executeUpdate();
		
		}catch(Exception e) {
			System.out.println("Can't add the product: "+e);
		}
	}
	
	public void setOrderDelivered(String username) {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement st=null;
		int res=0;
		try { 
			String query="Update orderr set delivered= 1 where username='"+username+"' and delivered = 0";
			st=con.prepareStatement(query);
			st.executeUpdate();
			res=st.executeUpdate();	
		}catch (Exception e) {
			System.out.println("no database "+e);
		}
	}
	
	
	public ArrayList<String[]> showAll() throws SQLException {
		Connection con= ConnectionDB.getConnection();
		ArrayList<String[]> allFurnitures =new ArrayList<String[]>();
		try {
			String query="Select * from orderr where delivered=0";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				String[] oneRow= new String[100];
				for(int i=0; i<3;i++) {		
					oneRow[i]=result.getString(i+2);
					System.out.println(oneRow[i]);
				}
				allFurnitures.add(oneRow);
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
		return allFurnitures;
	}
	
	
	public ArrayList<String[]> getDeliveredUserOrders(User u) throws SQLException {
		Connection con= ConnectionDB.getConnection();
		ArrayList<String[]> allFurnitures =new ArrayList<String[]>();
		try {
			String query="Select * from orderr where username='"+u.getNameUser()+"' and delivered=1";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				String[] oneRow= new String[100];
				for(int i=0; i<2;i++) {		
					oneRow[i]=result.getString(i+2);
					System.out.println(oneRow[i]);
				}
				allFurnitures.add(oneRow);
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
		return allFurnitures;
	}
	
	public ArrayList<String[]> getNotDeliveredUserOrders(User u) throws SQLException {
		Connection con= ConnectionDB.getConnection();
		ArrayList<String[]> allFurnitures =new ArrayList<String[]>();
		try {
			String query="Select * from orderr where username='"+u.getNameUser()+"' and delivered=0";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				String[] oneRow= new String[100];
				for(int i=0; i<2;i++) {		
					oneRow[i]=result.getString(i+2);
					System.out.println(oneRow[i]);
				}
				allFurnitures.add(oneRow);
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
		return allFurnitures;
	}
}
