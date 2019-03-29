package businessLogic.factory;

import java.sql.SQLException;

import dataAccess.Furniture;
import dataAccess.ManageFurniture;
import dataAccess.ManageShoppingCart;

public class WithDiscount20 implements Discount{

	public void applyDiscount(String name) throws SQLException {
		Furniture f=new Furniture();		
		ManageFurniture manageFurniture=new ManageFurniture();
		ManageShoppingCart cart =new ManageShoppingCart();
		f.setNameFurniture(name);

		String priceString=manageFurniture.getPrice(f);
		float price = Float.parseFloat(priceString);
		float dicountFloat=Float.parseFloat("20");
		float newPrice=price-( (dicountFloat/100)*price);
		priceString=newPrice+"";
		f.setPrice(priceString);
		cart.updatePrice(f);
		
	}


}
