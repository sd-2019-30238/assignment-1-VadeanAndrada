package dataAcces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ManageShoppingCart {
	public int addProduct(Furniture f, User u) {
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
			return 1;
		
		}catch(Exception e) {
			System.out.println("Can't add the product: "+e);
		}
		return 0;
	}
	
	public int deleteProduct(Furniture f) {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement st=null;
		int res=0;
		try {
			String query="Delete from shoppingcart where nameProduct="+"'"+f.getNameFurniture()+"'";
			st=con.prepareStatement(query);
			st.executeUpdate();
			res=st.executeUpdate();	
			return 1;
		}catch (Exception e) {
			System.out.println("no database "+e);
		}
		return 0;
	}
	
	public ArrayList<String[]> getShoppingCart(User u){
		ArrayList<String[]> list= new ArrayList<String[]>();
		Connection con= ConnectionDB.getConnection();

		try {
			String query="Select * from furniture where username='"+u.getNameUser()+"'";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
			//	System.out.println(result.getString(1)+" "+result.getString(2)+ " "+result.getString(3)+" "+result.getString(4)+ " "+result.getString(5));
				String[] oneRow= new String[100];
				for(int i=0; i<4;i++) {		
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

}
