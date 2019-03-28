package dataAccess;

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
				System.out.println(result.getString(1)+" "+result.getString(2)+ " "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5));
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
	}
	public void addUser(User u) {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement =null;
		try {
			String query="Insert into user (nameUser, email, phoneUser, password, address, isOnline) values (?,?,?,?,?,?)";
			statement=con.prepareStatement(query);
			statement.setString(1, u.getNameUser());
			statement.setString(2, u.getEmail());
			statement.setString(3, u.getPhoneUser());
			statement.setString(4, u.getPassword());
			statement.setString(5, u.getAddress());
			statement.setInt(6,0);
			statement.executeUpdate();
		}catch (Exception e) {
			System.out.println("cannot add into database!=> "+e);
		}
		
	}
	
	public int searchUserByName(User user){
		Connection con=ConnectionDB.getConnection();
		Statement statement=null;
		ResultSet result=null;
		try {
			String query="Select count(nameUser) AS total from user where nameUser='"+user.getNameUser()+"'";
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
	
	public int getIsOnline(){
		Connection con=ConnectionDB.getConnection();
		Statement statement=null;
		ResultSet result=null;
		try {
			String query="Select count(isOnline) AS total from user where isOnline=1";
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
	
	public User getIsOnlineUserName(){
		Connection con=ConnectionDB.getConnection();
		User user= new User();
		Statement statement=null;
		ResultSet result=null;
		try {
			String query="Select nameUser from user where isOnline=1";
			statement=con.createStatement();
			result=statement.executeQuery(query);
			result.next();
			String username=result.getString(1);
			user.setNameUser(username);
			return user;
		}catch (Exception e) {
			System.out.println("can't find the user "+e);
		}
		return user;
	}
	
	
	public User getIsOnlineUserId(){
		Connection con=ConnectionDB.getConnection();
		User user= new User();
		Statement statement=null;
		ResultSet result=null;
		try {
			String query="Select idUser from user where isOnline=1";
			statement=con.createStatement();
			result=statement.executeQuery(query);
			result.next();
			int id=Integer.parseInt(result.getString(1));
			user.setIdUser(id);
			return user;
		}catch (Exception e) {
			System.out.println("can't find the user "+e);
		}
		return user;
	}
	
	
	public User getIsOnlineUserId(User u){
		Connection con=ConnectionDB.getConnection();
		User user= new User();
		Statement statement=null;
		ResultSet result=null;
		try {
			String query="Select idUser from user where nameUser= '"+u.getNameUser()+"'";
			statement=con.createStatement();
			result=statement.executeQuery(query);
			result.next();
			int id=Integer.parseInt(result.getString(1));
			user.setIdUser(id);
			return user;
		}catch (Exception e) {
			System.out.println("can't find the user "+e);
		}
		return user;
	}
	
	
	
	public void setIsOnlineUser(User user){
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement=null;
		User aux=new User();
		aux=getIsOnlineUserId(user);
		int idUser=aux.getIdUser();
		user.setIdUser(idUser);
		int result=0;
		try {
			String query="UPDATE user SET isOnline = 1 WHERE idUser = "+idUser;
			statement=con.prepareStatement(query);
			statement.executeUpdate();
			result=statement.executeUpdate();	
		}catch (Exception e) {
			System.out.println("can't find the user "+e);
		}

	}
	
	public void setIsOffline(){
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement=null;
		int result=0;
		try {
			String query="UPDATE user SET isOnline = 0";
			statement=con.prepareStatement(query);
			statement.executeUpdate();
			result=statement.executeUpdate();	
		}catch (Exception e) {
			System.out.println("can't find the user "+e);
		}

	}
	
	public void setIsOfflineUser(){
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement=null;
		User user=new User();
		user=getIsOnlineUserId();			
		int result=0;
		try {
			String query="UPDATE user SET isOnline = 0 WHERE idUser = "+user.getIdUser()
			;
			statement=con.prepareStatement(query);
			statement.executeUpdate();
			result=statement.executeUpdate();	
		}catch (Exception e) {
			System.out.println("can't find the user "+e);
		}
	}
	
	
	
	public int searchUserByNamePassword(User user){
		Connection con=ConnectionDB.getConnection();
		Statement statement=null;
		ResultSet result=null;
		try {
			String query="Select count(nameUser) AS total from user where nameUser='"+user.getNameUser()+"' and password='"+user.getPassword()+"'";
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


