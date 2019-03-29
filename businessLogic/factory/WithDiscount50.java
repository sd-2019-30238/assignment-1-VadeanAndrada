package businessLogic.factory;

import java.sql.SQLException;

import dataAccess.Furniture;
import dataAccess.ManageFurniture;
import dataAccess.ManageShoppingCart;

public class WithDiscount50 implements Discount {

private String name;
	
	public void applyDiscount(String name) throws SQLException {
		Furniture f=new Furniture();		
		ManageFurniture manageFurniture=new ManageFurniture();
		ManageShoppingCart cart =new ManageShoppingCart();
		
		f.setNameFurniture(name);

		String priceString=manageFurniture.getPrice(f);
		float price = Float.parseFloat(priceString);
		System.out.println("fara discount " + price);
		float dicountFloat=Float.parseFloat("50");
		float newPrice=price-( (dicountFloat/100)*price);
		priceString=newPrice+"";
		f.setPrice(priceString);
		cart.updatePrice(f);
		
	}


}
