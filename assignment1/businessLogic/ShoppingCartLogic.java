package businessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import dataAccess.Furniture;
import dataAccess.ManageFurniture;
import dataAccess.ManageShoppingCart;
import dataAccess.ManageUser;
import dataAccess.User;

public class ShoppingCartLogic {

	public boolean addShoppingCart(String nameFurniture) throws SQLException {
		Furniture f=new Furniture();
		f.setNameFurniture(nameFurniture);
		ManageFurniture manageFurniture=new ManageFurniture();
		int quantity=manageFurniture.getQuantity(f);
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
			manageFurniture.updateQuantity(f);
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
		int quantity=manageFurniture.getQuantity(f);
		quantity++;
		f.setQuantity(quantity);
		manageFurniture.updateQuantity(f);
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
	public float getTotal() {
		ArrayList<String[]> list=getShoppingCart();
		float total=0.0f;
		if(list.isEmpty())
			return total;
		else {
			for(String[] aux: list) {
				float price=Float.parseFloat(aux[1]);
				total+=price;	
			}
			System.out.println(total);}
		return total;
	}
	
	public void setCartDone() {
		
		ManageUser manageUser=new ManageUser();
		User user=manageUser.getIsOnlineUserName();
		ManageShoppingCart cart= new ManageShoppingCart();
		cart.setCartDone(user);
	}
	
	public void deleteCart() {
		ManageUser manageUser=new ManageUser();
		User user=manageUser.getIsOnlineUserName();
		ManageShoppingCart cart= new ManageShoppingCart();
		cart.deleteShoppingCart(user);
			
	}
	
	public void updateQuantity(String name) throws SQLException {
		Furniture f=new Furniture();
		f.setNameFurniture(name);
		ManageFurniture manageFurniture=new ManageFurniture();
		manageFurniture.updateQuantity(f);
		
	}

	
	


}
