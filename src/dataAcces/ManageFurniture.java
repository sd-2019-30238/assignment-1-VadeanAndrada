package dataAcces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ManageFurniture {
	
	public ArrayList<String[]> showAllFurnitures() {
		Connection con= ConnectionDB.getConnection();
		ArrayList<String[]> allFurnitures =new ArrayList<String[]>();
		try {
			String query="Select * from furniture";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
			//	System.out.println(result.getString(1)+" "+result.getString(2)+ " "+result.getString(3)+" "+result.getString(4)+ " "+result.getString(5));
				String[] oneRow= new String[100];
				for(int i=0; i<4;i++) {		
					oneRow[i]=result.getString(i+1);
					System.out.println(oneRow[i]);
				}
				allFurnitures.add(oneRow);
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
		return allFurnitures;
	}
	
	public ArrayList<String[]> showAllOrderByName() {
		Connection con= ConnectionDB.getConnection();
		ArrayList<String[]> allFurnitures =new ArrayList<String[]>();
		try {
			String query="Select * from furniture ORDER BY nameFurniture";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
			//	System.out.println(result.getString(1)+" "+result.getString(2)+ " "+result.getString(3)+" "+result.getString(4)+ " "+result.getString(5));
				String[] oneRow= new String[100];
				for(int i=0; i<4;i++) {		
					oneRow[i]=result.getString(i+1);
					System.out.println(oneRow[i]);
				}
				allFurnitures.add(oneRow);
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
		return allFurnitures;
	}
	
	public ArrayList<String[]> showAllOrderByType() {
		Connection con= ConnectionDB.getConnection();
		ArrayList<String[]> allFurnitures =new ArrayList<String[]>();
		try {
			String query="Select * from furniture ORDER BY type";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
			//	System.out.println(result.getString(1)+" "+result.getString(2)+ " "+result.getString(3)+" "+result.getString(4)+ " "+result.getString(5));
				String[] oneRow= new String[100];
				for(int i=0; i<4;i++) {		
					oneRow[i]=result.getString(i+1);
					System.out.println(oneRow[i]);
				}
				allFurnitures.add(oneRow);
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
		return allFurnitures;
	}
	
	public ArrayList<String[]> showAllOrderByPrice() {
		Connection con= ConnectionDB.getConnection();
		ArrayList<String[]> allFurnitures =new ArrayList<String[]>();
		try {
			String query="Select * from furniture ORDER BY price";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
			//	System.out.println(result.getString(1)+" "+result.getString(2)+ " "+result.getString(3)+" "+result.getString(4)+ " "+result.getString(5));
				String[] oneRow= new String[100];
				for(int i=0; i<4;i++) {		
					oneRow[i]=result.getString(i+1);
					System.out.println(oneRow[i]);
				}
				allFurnitures.add(oneRow);
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
		return allFurnitures;
	}
	
	public void addFurniture(Furniture f) {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement =null;
		try {
			String query="Insert into furniture (nameFurniture, type, discount, price) values (?,?,?,?)";
			statement=con.prepareStatement(query);
			statement.setString(1, f.getNameFurniture());
			statement.setString(2, f.getType());
			statement.setString(3, f.getDiscount());
			statement.setString(4, f.getPrice());
			statement.executeUpdate();
		}catch (Exception e) {
			System.out.println("cannot add into database!=> "+e);
		}		
	}
	
	public int searchFruniture(String nameUser){
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
