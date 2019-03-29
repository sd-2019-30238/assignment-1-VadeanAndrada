package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManageFeedback {
	
	public void addFeedback(Feedback f) throws SQLException {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement =null;
		try {
			String query="Insert into furniture (username, message) values (?,?)";
			statement=con.prepareStatement(query);
			statement.setString(1, f.getUsername());
			statement.setString(2, f.getMessage());
			statement.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("cannot add into database!=> "+e);
		}		
	}
	
	public void deleteFeedbacks()throws SQLException{
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement=null;
		try {
			String query="TRUNCATE TABLE feedback";
			statement=con.prepareStatement(query);
			statement.executeUpdate();
		}catch (Exception e) {
			System.out.println("no database "+e);
		}
	}
	
	//public String[] getAll(){}
		

}
