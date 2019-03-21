package dataAcces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ManageUser {
	public void showAllUserrs() {
		Connection con= ConnectionDB.getConnection();
		try {
			String query="Select * from user";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				System.out.println(result.getString(1)+" "+result.getString(2)+ " "+result.getString(3)+" "+result.getString(4));
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
	}
	public void addUser(User u) {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement =null;
		try {
			String query="Insert into user (nameUser, email, phoneUser, pasword) values (?,?,?,?)";
			statement=con.prepareStatement(query);
			statement.setString(1, u.getNameUser());
			statement.setString(2, u.getEmail());
			statement.setString(3, u.getPhoneUser());
			statement.setString(4, u.getPasword());
			statement.executeUpdate();
		}catch (Exception e) {
			System.out.println("cannot add into database!=> "+e);
		}
		
	}
	
	public int searchUserByName(String nameUser){
		Connection con=ConnectionDB.getConnection();
		Statement statement=null;
		ResultSet result=null;
		try {
			String query="Select count(nameUser) AS total from user where nameUser='"+nameUser+"'";
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
	
	public int searchUserByNamePasword(String nameUser, String pasword){
		Connection con=ConnectionDB.getConnection();
		Statement statement=null;
		ResultSet result=null;
		try {
			String query="Select count(nameUser) AS total from user where nameUser='"+nameUser+"' and pasword='"+pasword+"'";
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
	
	public void deleteUser(User u)throws SQLException{
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement=null;
		try {
			String query="Delete from user where nameUser="+"'"+u.getNameUser()+"'";
			statement=con.prepareStatement(query);
			statement.executeUpdate();

		}catch (Exception e) {
			System.out.println("no database "+e);
		}
	}
}


