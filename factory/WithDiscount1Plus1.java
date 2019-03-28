package factory;

import java.sql.SQLException;

import dataAccess.Furniture;
import dataAccess.ManageFurniture;
import dataAccess.ManageShoppingCart;

public class WithDiscount1Plus1 implements Discount{


	public void applyDiscount(String name) throws SQLException {
		Furniture f=new Furniture();		
		ManageFurniture manageFurniture=new ManageFurniture();
		
		f.setNameFurniture(name);
		int quantity=manageFurniture.getQuantity(f);
		System.out.println(quantity);
		quantity-=2;
		f.setQuantity(quantity);
		System.out.println(f.getQuantity());
		manageFurniture.updateQuantity(f);

		
	}


}
