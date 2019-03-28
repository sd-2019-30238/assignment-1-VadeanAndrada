package businessLogic;

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
		User user=onlineUser.getIsOnlineUserName();
		order.setOrderDelivered(user.getNameUser());
	}

}
