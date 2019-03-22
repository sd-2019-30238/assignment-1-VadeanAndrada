package dataAcces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManageStaff {
	public void showStaff() {
		Connection con= ConnectionDB.getConnection();
		try {
			String query="Select * from staff";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				System.out.println(result.getString(1)+" "+result.getString(2));
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
	}
	public void addStaff(Staff s) {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement =null;
		try {
			String query="Insert into staff (nameStaff, rol) values (?,?)";
			statement=con.prepareStatement(query);
			statement.setString(1, s.getNameStaff());
			statement.setString(2, s.getRole());
			statement.executeUpdate();
		}catch (Exception e) {
			System.out.println("cannot add into database!=> "+e);
		}
		
	}
	
	public int searchStaffByNamePassword(String nameStaff, String password){
		Connection con=ConnectionDB.getConnection();
		Statement statement=null;
		ResultSet result=null;
		try {
			String query="Select count(nameStaff) AS total from staff where nameStaff='"+nameStaff+"' and pasword='"+password+"'";
			statement=con.createStatement();
			result=statement.executeQuery(query);
			result.next();
			int noUser=result.getInt("total");
		//	System.out.println("am gasit jnumele si paroloa"+noUser);
			return noUser;
		}catch (Exception e) {
			System.out.println("can't find the user, maybe you don't have an account "+e);
		}
		return 0;
	}
	
	public int searchStaff(String nameStaff){
		Connection con=ConnectionDB.getConnection();
		Statement statement=null;
		ResultSet result=null;
		try {
			String query="Select count(nameStaff) AS total from staff where nameUser='"+nameStaff+"'";
			statement=con.createStatement();
			result=statement.executeQuery(query);
			result.next();
			int noUser=result.getInt("total");
			return noUser;
		}catch (Exception e) {
			System.out.println("can't find the user "+e);
		}
		return 0;
	}
	
	public void deleteStaff(Staff s)throws SQLException{
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement=null;
		try {
			String query="Delete from staff where nameStaff="+"'"+s.getNameStaff()+"'";
			statement=con.prepareStatement(query);
			statement.executeUpdate();

		}catch (Exception e) {
			System.out.println("no database "+e);
		}
	}
	
	
}
