package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ManageShoppingCart {
	public void addProduct(Furniture f, User u) {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement= null;
		try {
			String query="Insert into shoppingcart (nameProduct, priceProduct, quantity, username, delivered) values (?, ?, ?, ?, ?)";
			statement=con.prepareStatement(query);
			statement.setString(1, f.getNameFurniture());
			statement.setString(2, f.getPrice());
			statement.setInt(3, f.getQuantity());
			statement.setString(4, u.getNameUser());
			statement.setInt(5, 0);
			statement.executeUpdate();
		
		}catch(Exception e) {
			System.out.println("Can't add the product: "+e);
		}
	}
	
	public void deleteProduct(Furniture f) {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement st=null;
		int res=0;
		try {
			String query="Delete from shoppingcart where nameProduct='"+f.getNameFurniture()+"' limit 1";
			st=con.prepareStatement(query);
			st.executeUpdate();
			res=st.executeUpdate();	
		}catch (Exception e) {
			System.out.println("no database "+e);
		}
	}
	
	public ArrayList<String[]> getShoppingCart(User u){
		ArrayList<String[]> list= new ArrayList<String[]>();
		Connection con= ConnectionDB.getConnection();
		u.getNameUser();
		try {
			String query="Select * from shoppingcart where username='"+u.getNameUser()+"'";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				String[] oneRow= new String[100];
				for(int i=0; i<3;i++) {		
					oneRow[i]=result.getString(i+2);
					System.out.println(oneRow[i]);
				}
				list.add(oneRow);
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
		return list;
		
	}
	
	public void setCartDone(User u) {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement st=null;
		int res=0;
		try { 
			String query="Update shoppingcart set delivered= 1 where username='"+u.getNameUser()+"' and delivered = 0";
			st=con.prepareStatement(query);
			st.executeUpdate();
			res=st.executeUpdate();	
		}catch (Exception e) {
			System.out.println("no database "+e);
		}
	}
	
	public void setCartDelivered(User u) {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement st=null;
		int res=0;
		try { 
			String query="Update shoppingcart set delivered= 2 where username='"+u.getNameUser()+"' and delivered = 1";
			st=con.prepareStatement(query);
			st.executeUpdate();
			res=st.executeUpdate();	
		}catch (Exception e) {
			System.out.println("no database "+e);
		}
	}
	
	public void deleteShoppingCart(User u) {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement st=null;
		int res=0;
		try {
			String query="Delete from shoppingcart where username="+"'"+u.getNameUser()+"' and delivered= 1 ";
			st=con.prepareStatement(query);
			st.executeUpdate();
			res=st.executeUpdate();	
		}catch (Exception e) {
			System.out.println("no database "+e);
		}
	}
	
	public void updatePrice(Furniture f)throws SQLException{
		Connection con=ConnectionDB.getConnection();
		PreparedStatement st=null;
		int res=0;
		try { 
			String query="Update shoppingcart set priceProduct="+f.getPrice()+" where nameProduct='"+f.getNameFurniture()+"'";
			st=con.prepareStatement(query);
			st.executeUpdate();
			res=st.executeUpdate();	
		}catch (Exception e) {
			System.out.println("no database "+e);
		}
	}
	public void updateQuantity(Furniture f)throws SQLException{
		Connection con=ConnectionDB.getConnection();
		PreparedStatement st=null;
		int res=0;
		try { 
			String query="Update shoppingcart set quantity=2 where nameProduct='"+f.getNameFurniture()+"'";
			st=con.prepareStatement(query);
			st.executeUpdate();
			res=st.executeUpdate();	
		}catch (Exception e) {
			System.out.println("no database "+e);
		}
	}

}
