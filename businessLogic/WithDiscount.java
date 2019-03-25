package businessLogic;

import java.sql.SQLException;

import dataAcces.Furniture;
import dataAcces.ManageFurniture;

public class WithDiscount implements Discount{

	public void updateDiscount(String nameFurniture, String dicount) throws SQLException {
		
		Furniture f=new Furniture();
		f.setNameFurniture(nameFurniture);
		ManageFurniture manageFurniture=new ManageFurniture();
		f.setDiscount(dicount);
		manageFurniture.applyDiscount(f);
		String priceString=manageFurniture.getPrice(f);
		float price=Float.parseFloat(priceString);
		System.out.println("fara discount "+price);
		float dicountFloat=Float.parseFloat(dicount);
		float newPrice=price-( (dicountFloat/100)*price);
		priceString=newPrice+"";
		f.setPrice(priceString);
		System.out.println("cu discount "+f.getPrice());
		manageFurniture.updatePrice(f);
			
	}
	
	public String checkDiscount(String nameFurniture) throws SQLException {
		
		Furniture f= new Furniture();
		ManageFurniture manageFurniture=new ManageFurniture();
		f.setNameFurniture(nameFurniture);
		String discountString= manageFurniture.getDiscount(f);
		float discount= Float.parseFloat(discountString);
		float newDiscount=100-discount;
		String priceString=manageFurniture.getPrice(f);
		float price= Float.parseFloat(priceString);
		
		
		if(discount>0) {
			float oldPrice=(price/100)/newDiscount;
			priceString=oldPrice+"";
			f.setPrice(priceString);
			manageFurniture.updatePrice(f);
			f.setDiscount(0+"");
			manageFurniture.applyDiscount(f);
		}	
		return "";
	}

}
