package dataAcces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ManageFurniture {
	
	public ArrayList<String[]> showAllFurnitures() throws SQLException {
		Connection con= ConnectionDB.getConnection();
		ArrayList<String[]> allFurnitures =new ArrayList<String[]>();
		try {
			String query="Select * from furniture";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
			//	System.out.println(result.getString(1)+" "+result.getString(2)+ " "+result.getString(3)+" "+result.getString(4)+ " "+result.getString(5));
				String[] oneRow= new String[100];
				for(int i=0; i<5;i++) {		
					oneRow[i]=result.getString(i+1);
					System.out.println(oneRow[i]);
				}
				allFurnitures.add(oneRow);
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
	//	con.close();
		return allFurnitures;
	}
	
	
	public ArrayList<String[]> showAllOrderedByName() throws SQLException {
		Connection con= ConnectionDB.getConnection();
		ArrayList<String[]> allFurnitures =new ArrayList<String[]>();
		try {
			String query="Select * from furniture ORDER BY nameFurniture";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				String[] oneRow= new String[100];
				for(int i=0; i<4;i++) {		
					oneRow[i]=result.getString(i+2);
					System.out.println(oneRow[i]);
				}
				allFurnitures.add(oneRow);
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
	//	con.close();
		return allFurnitures;
	}
	
	
	public ArrayList<String[]> showAllOrderedByType() throws SQLException {
		Connection con= ConnectionDB.getConnection();
		ArrayList<String[]> allFurnitures =new ArrayList<String[]>();
		try {
			String query="Select * from furniture ORDER BY type";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				String[] oneRow= new String[100];
				for(int i=0; i<4;i++) {		
					oneRow[i]=result.getString(i+2);
					System.out.println(oneRow[i]);
				}
				allFurnitures.add(oneRow);
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
	//	con.close();
		return allFurnitures;
	}
	
	
	public ArrayList<String[]> showAllOrderedByPrice() throws SQLException {
		Connection con= ConnectionDB.getConnection();
		ArrayList<String[]> allFurnitures =new ArrayList<String[]>();
		try {
			String query="Select * from furniture ORDER BY price";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(query);
			while(result.next()) {
				String[] oneRow= new String[100];
				for(int i=0; i<4;i++) {		
					oneRow[i]=result.getString(i+2);
					System.out.println(oneRow[i]);
				}
				allFurnitures.add(oneRow);
			}
		}catch (Exception e) {
			System.out.println("Cannot contect!");
		}
	//	con.close();
		return allFurnitures;
	}
	
	
	public void addFurniture(Furniture f) throws SQLException {
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement =null;
		try {
			String query="Insert into furniture (nameFurniture, type, discount, price, number) values (?,?,?,?,?)";
			statement=con.prepareStatement(query);
			statement.setString(1, f.getNameFurniture());
			statement.setString(2, f.getType());
			statement.setString(3, f.getDiscount());
			statement.setString(4, f.getPrice());
			statement.setString(5, f.getQuantity()+"");
			statement.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("cannot add into database!=> "+e);
		}		
		//con.close();
	}
	
	
	public int searchFruniture(Furniture f) throws SQLException{
		Connection con=ConnectionDB.getConnection();
		Statement statement=null;
		ResultSet result=null;
		try {
			String query="Select count(nameFurniture) AS total from furniture where nameFurniture='"+f.getNameFurniture()+"'";
			statement=con.createStatement();
			result=statement.executeQuery(query);
			result.next();
			int noUser=result.getInt("total");
			return noUser;
		}catch (Exception e) {
			System.out.println("can't find the furniture "+e);
		}
	//	con.close();
		return 0;
	}
	
	
	public void deleteFurniture(Furniture f)throws SQLException{
		Connection con=ConnectionDB.getConnection();
		PreparedStatement statement=null;
		try {
			String query="Delete from furniture where nameFurniture="+"'"+f.getNameFurniture()+"'";
			statement=con.prepareStatement(query);
			statement.executeUpdate();
		//	con.close();
		}catch (Exception e) {
			System.out.println("no database "+e);
		}
	}
	
	public String getPrice(Furniture f)throws SQLException{
		Connection con=ConnectionDB.getConnection();
		Statement statement=null;
		ResultSet result=null;
		String price="";
		try {
			String query="Select price from furniture where nameFurniture='"+f.getNameFurniture()+"'";
			statement=con.createStatement();
			result=statement.executeQuery(query);
			result.next();
			price = result.getString("price");
			System.out.println(price);
			return price;
		}catch (Exception e) {
			System.out.println("error getPrice: "+e);
		}
		return price;

	}
	
	public String getDiscount(Furniture f)throws SQLException{
		Connection con=ConnectionDB.getConnection();
		Statement statement=null;
		ResultSet result=null;
		String discount="";
		try {
			String query="Select discount from furniture where nameFurniture='"+f.getNameFurniture()+"'";
			statement=con.createStatement();
			result=statement.executeQuery(query);
			result.next();
			discount = result.getString("discount");
			System.out.println(discount);
			return discount;
		}catch (Exception e) {
			System.out.println("error getPrice: "+e);
		}
		return discount;

	}
	
	public int getCantity(Furniture f)throws SQLException{
		Connection con=ConnectionDB.getConnection();
		Statement statement=null;
		ResultSet result=null;
		int cantity=0;
		try {
			String query="Select quantity from furniture where nameFurniture='"+f.getNameFurniture()+"'";
			statement=con.createStatement();
			result=statement.executeQuery(query);
			result.next();
			cantity = result.getInt("quantity");		
			return cantity;
		}catch (Exception e) {
			System.out.println("error getCantiate: "+e);
		}
		return cantity;
	}
	
	public void updateCanity(Furniture f)throws SQLException{
		Connection con=ConnectionDB.getConnection();
		PreparedStatement st=null;
		int res=0;
		try { 
			String query="Update furniture set quantity="+f.getQuantity()+" where nameFurniture='"+f.getNameFurniture()+"'";
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
			String query="Update furniture set price="+f.getPrice()+" where nameFurniture='"+f.getNameFurniture()+"'";
			st=con.prepareStatement(query);
			st.executeUpdate();
			res=st.executeUpdate();	
		}catch (Exception e) {
			System.out.println("no database "+e);
		}
	}
	
	public void applyDiscount(Furniture f)throws SQLException{
		Connection con=ConnectionDB.getConnection();
		PreparedStatement st=null;
		int res=0;
		try { 
			String query="Update furniture set discount="+f.getDiscount()+" where nameFurniture='"+f.getNameFurniture()+"'";
			st=con.prepareStatement(query);
			st.executeUpdate();
			res=st.executeUpdate();	
		}catch (Exception e) {
			System.out.println("no database "+e);
		}
	}
}
