package dataAcces;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
