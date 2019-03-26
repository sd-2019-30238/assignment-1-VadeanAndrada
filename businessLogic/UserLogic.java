package businessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

import dataAcces.ManageUser;
import dataAcces.User;

public class UserLogic {
	
	
	public int checkNewUser(String name, String email, String phone, String password, String address) {
		ManageUser mangeUser=new ManageUser();
		User user=new User();
		user.setNameUser(name);
		if(name.length()==0||email.length()==0||phone.length()==0||password.length()==0||address.length()==0)
			return 0;
		int noUser=mangeUser.searchUserByName(user);
		if(noUser!=0 )
			return 2;
		if(checkPhone(phone)!=1)
			return 0;
		if(password.length()<8)
			return 0;
		return 1;	
	}
	
	public int addUser(String name, String email, String phone, String pasword, String address) {
		ManageUser manageUser=new ManageUser();
		if(checkNewUser(name, email,phone,pasword,address)==2)
			return 2;//mai am un user cu acelasi nume
		if(checkNewUser(name, email,phone,pasword,address)==0)
			return 0;
		User user=new User(name, email,phone, pasword, address);
		user.setIsOnline(0);
		manageUser.addUser(user);
		return 1;
	}
	
	public int checkPhone(String phone) {
		if (phone.length()>10)
			return 0;
		for(char i: phone.toCharArray()) {
			int digit = Character.getNumericValue(i);
			if(i==-1)
				return 0;
		}	
		return 1;
	}
	
	public int logInUser(String name, String password) {
		ManageUser manageUser= new ManageUser();
		User user=new User();
		user.setNameUser(name);
		user.setPassword(password);
		if(manageUser.searchUserByNamePassword(user)==0) {
			System.out.println("We can't find your account!");	
			return 0;
		}		
		return 1; 
	}
	
	
	public ArrayList<String[]> showFurniture(String section, String name, String password) throws SQLException{
		ArrayList<String[]> allFurnitures=new ArrayList<String[]>();
		User user=new User();
		user.setNameUser(name);
		user.setPassword(password);
		ManageUser manageUser=new ManageUser();
		int userValid=manageUser.searchUserByNamePassword(user);
		if(userValid==1) {
			FurnitureLogic furniture=new FurnitureLogic();
			allFurnitures= furniture.seeFurniture(section);
		}
		return allFurnitures;
	}

}
