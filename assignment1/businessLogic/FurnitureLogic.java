package businessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import dataAccess.Furniture;
import dataAccess.ManageFurniture;

public class FurnitureLogic {
	public ArrayList<String[]> seeFurniture(String selection) throws SQLException{
		ArrayList<String[]> allFurnitures=new ArrayList<String[]>();
		ManageFurniture manageFurniture=new ManageFurniture();
		switch(selection) {
		case "nume":
			allFurnitures=manageFurniture.showAllOrderedByName();
			break;
		case "pret":
			allFurnitures=manageFurniture.showAllOrderedByPrice();
			break;
		case "tip":
			allFurnitures=manageFurniture.showAllOrderedByType();
			break;
		default:
			allFurnitures=manageFurniture.showAllFurnitures();		

		}
		return allFurnitures;
	}
	public int addNewFurniture(String name, String type, String price, int quantity, String discount) throws SQLException {
		float priceOk=Float.parseFloat(price);
		if(priceOk<=0)
			return 0;
		if(quantity<=0)
			return 0;
		Furniture f=new Furniture(name,type,discount, price, quantity );
		ManageFurniture manageFurniture=new ManageFurniture();
		int exist=manageFurniture.searchFruniture(f);
		if(exist!=0)
			return 2;
		manageFurniture.addFurniture(f);
		return 1;
	}
	
	public ArrayList<String[]> seeFurnitureStaff() throws SQLException{
		ArrayList<String[]> allFurnitures=new ArrayList<String[]>();
		ManageFurniture manageFurniture=new ManageFurniture();
		allFurnitures=manageFurniture.showAll();
		return allFurnitures;
	}
	
	public void deleteFurniture(String name) throws SQLException {
		Furniture f=new Furniture();
		ManageFurniture fDao=new ManageFurniture();
		f.setNameFurniture(name);
		fDao.deleteFurniture(f);
	}
	
	public boolean updateStoc(String name, String quantity) throws SQLException {
		Furniture f=new Furniture();
		ManageFurniture fDao=new ManageFurniture();
		int quantityInt=Integer.parseInt(quantity);
		if(quantityInt<=0)
			return false;
		f.setNameFurniture(name);
		f.setQuantity(quantityInt);
		fDao.updateQuantity(f);
		return true;
	}
	
	public void updateDiscount(String product, String deal) throws SQLException {
		Furniture f=new Furniture();
		ManageFurniture fDao=new ManageFurniture();
		f.setNameFurniture(product);
		f.setDiscount(deal);
		fDao.applyDiscount(f);
		
		
	}
}
