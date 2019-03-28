package businessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import dataAcces.ManageOrder;
import dataAcces.ManageShoppingCart;
import dataAcces.ManageUser;
import dataAcces.User;

public class OrderLogic {
	
	public void addOrder(String totalPrice) {
		ManageOrder order=new ManageOrder();
		ManageUser onlineUser= new ManageUser();
		User user=onlineUser.getIsOnlineUserName();
		order.addOrder(user.getNameUser(), totalPrice);
	}
	
	public void changeStatusOrder(String username) {
		ManageOrder order=new ManageOrder();
		ManageUser onlineUser= new ManageUser();
		User user=new User();
		user.setNameUser(username);
		order.setOrderDelivered(user.getNameUser());
	}
	
	public ArrayList<String[]> getAllOrders() throws SQLException{
		ArrayList<String[]> list= new ArrayList<String[]>();
		ManageOrder order=new ManageOrder();
		list=order.showAll();
		return list;
		
	}
	
	public ArrayList<String[]> getDeliveredUserOrders() throws SQLException{
		ArrayList<String[]> list= new ArrayList<String[]>();
		ManageOrder order=new ManageOrder();
		ManageUser onlineUser= new ManageUser();
		User user=onlineUser.getIsOnlineUserName();
		list=order.getDeliveredUserOrders(user);
		return list;
		
	}
	
	public ArrayList<String[]> getNotDeliveredUserOrders() throws SQLException{
		ArrayList<String[]> list= new ArrayList<String[]>();
		ManageOrder order=new ManageOrder();
		ManageUser onlineUser= new ManageUser();
		User user=onlineUser.getIsOnlineUserName();
		list=order.getDeliveredUserOrders(user);
		return list;
		
	}

}
