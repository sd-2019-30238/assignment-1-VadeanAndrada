package businessLayer;

import java.util.ArrayList;

import dataAcces.ManageFurniture;

public class FurnitureLogic {
	public ArrayList<String[]> seeFurniture(String selection){
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
}
