package factory;

import java.sql.SQLException;

import dataAcces.Furniture;
import dataAcces.ManageFurniture;
import dataAcces.ManageShoppingCart;

public class WithDiscount20 implements Discount{

	private String name;
	
	public WithDiscount20(String name) {
		this.name=name;
	}
	public void applyDiscount() throws SQLException {
		Furniture f=new Furniture();		
		ManageFurniture manageFurniture=new ManageFurniture();
		ManageShoppingCart cart =new ManageShoppingCart();
		System.out.println("discounttttttt");
		f.setNameFurniture(getName());

		String priceString=manageFurniture.getPrice(f);
		float price = Float.parseFloat(priceString);
		System.out.println("fara discount " + price);
		float dicountFloat=Float.parseFloat("20");
		float newPrice=price-( (dicountFloat/100)*price);
		priceString=newPrice+"";
		f.setPrice(priceString);
		cart.updatePrice(f);
		
	}


	public String getName() {
		return name;
	}

}
