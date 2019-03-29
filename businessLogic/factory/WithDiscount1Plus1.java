package businessLogic.factory;

import java.sql.SQLException;

import dataAccess.Furniture;
import dataAccess.ManageFurniture;
import dataAccess.ManageOrder;
import dataAccess.ManageShoppingCart;

public class WithDiscount1Plus1 implements Discount{


	public void applyDiscount(String name) throws SQLException {
		Furniture f=new Furniture();		
		ManageFurniture manageFurniture=new ManageFurniture();
		ManageShoppingCart cart=new ManageShoppingCart();
		
		f.setNameFurniture(name);
		int quantity=manageFurniture.getQuantity(f);
		quantity-=2;
		f.setQuantity(quantity);
		manageFurniture.updateQuantity(f);
		cart.updateQuantity(f);
		

		
	}


}
