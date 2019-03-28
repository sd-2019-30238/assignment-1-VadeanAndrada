package factory;

import java.sql.SQLException;

import dataAcces.Furniture;
import dataAcces.ManageFurniture;
import dataAcces.ManageShoppingCart;

public class WithDiscount1Plus1 implements Discount{

	private String name;
	
	public WithDiscount1Plus1(String name) {
		this.name=name;
	}
	public void applyDiscount() throws SQLException {
		Furniture f=new Furniture();		
		ManageFurniture manageFurniture=new ManageFurniture();
		
		f.setNameFurniture(getName());
		int quantity=manageFurniture.getQuantity(f);
		System.out.println(quantity);
		quantity-=2;
		f.setQuantity(quantity);
		System.out.println(f.getQuantity());
		manageFurniture.updateQuantity(f);

		
	}

	public String getName() {
		return this.name;
	}
	
}
