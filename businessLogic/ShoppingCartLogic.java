package businessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import dataAcces.Furniture;
import dataAcces.ManageFurniture;
import dataAcces.ManageShoppingCart;
import dataAcces.ManageUser;
import dataAcces.User;

public class ShoppingCartLogic {
	
	public boolean addShoppingCart(String nameFurniture) throws SQLException {
		Furniture f=new Furniture();
		f.setNameFurniture(nameFurniture);
		ManageFurniture manageFurniture=new ManageFurniture();
		int quantity=manageFurniture.getCantity(f);
		String price=manageFurniture.getPrice(f);
		if(quantity>0) {
			ManageUser manageUser=new ManageUser();
			User u=manageUser.getIsOnlineUserName();
			ManageShoppingCart cart=new ManageShoppingCart();
			f.setQuantity(1);
			f.setPrice(price);
			cart.addProduct(f, u);
			quantity--;
			f.setQuantity(quantity);
			manageFurniture.updateCanity(f);
			return true;
		}
	
		return false;
	}
	
	
	public void deleteProduct(String nameFurniture) throws SQLException {
		Furniture f=new Furniture();
		f.setNameFurniture(nameFurniture);
		ManageFurniture manageFurniture=new ManageFurniture();
		ManageShoppingCart cart=new ManageShoppingCart();
		cart.deleteProduct(f);
		int quantity=manageFurniture.getCantity(f);
		quantity++;
		f.setQuantity(quantity);
		manageFurniture.updateCanity(f);
	}
	
	public ArrayList<String[]> getShoppingCart(){
		
		ArrayList<String[]> list= new ArrayList<String[]>();
		ManageUser manageUser= new ManageUser();
		User user=manageUser.getIsOnlineUserName();
		System.out.println(user.getNameUser()+"aiciiii");
		ManageShoppingCart cart=new ManageShoppingCart();
		list=cart.getShoppingCart(user);

		return list;

	}
	
	

}
