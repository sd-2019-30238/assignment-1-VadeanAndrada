package businessLayer;

import java.sql.SQLException;
import java.util.ArrayList;

import dataAcces.Furniture;
import dataAcces.ManageFurniture;

public class FurnitureLogic {
	public ArrayList<String[]> seeFurniture(String selection) throws SQLException{
		ArrayList<String[]> allFurnitures=new ArrayList<String[]>();
		ManageFurniture manageFurniture=new ManageFurniture();
		switch(selection) {
		case "orderByName":
			allFurnitures=manageFurniture.showAllOrderByName();
			break;
		case "orderByPrice":
			allFurnitures=manageFurniture.showAllOrderByPrice();
			break;
		case "orderByType":
			allFurnitures=manageFurniture.showAllOrderByType();
			break;
		default:
			allFurnitures=manageFurniture.showAllFurnitures();		

		}
		return allFurnitures;
	}
	public int addNewFurniture(String name, String type, String price, int number, String discount) throws SQLException {
		Furniture f=new Furniture(name,type,discount, price, number );
		ManageFurniture manageFurniture=new ManageFurniture();
		manageFurniture.addFurniture(f);
		return 1;
	}
}
