package businessLayer;

import java.util.ArrayList;

import dataAcces.ManageUser;
import dataAcces.User;

public class UserLogic {
	
	
	public int checkNewUser(String name, String email, String phone, String password) {
		ManageUser mangeUser=new ManageUser();
		if(name.length()==0||email.length()==0||phone.length()==0||password.length()==0)
			return 0;
		int noUser=mangeUser.searchUserByName(name);
		if(noUser!=0 )
			return 0;
		if(checkPhone(phone)!=1)
			return 0;
		if(password.length()<8)
			return 0;
		return 1;	
	}
	
	public int addUser(String name, String email, String phone, String pasword) {
		ManageUser manageUser=new ManageUser();
		if(checkNewUser(name, email,phone,pasword)==0)
			return 0;
		User user=new User(name, email,phone, pasword);
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
		if(manageUser.searchUserByNamePassword(name, password)==0) {
			System.out.println("We can't find your account!");	
			return 0;
		}		
		return 1; 
	}
	public ArrayList<String[]> showFurniture(String section, String name, String password){
		ArrayList<String[]> allFurnitures=new ArrayList<String[]>();
		
		ManageUser manageUser=new ManageUser();
		int userValid=manageUser.searchUserByNamePassword(name, password);
		if(userValid==1) {
			FurnitureLogic furniture=new FurnitureLogic();
			allFurnitures= furniture.seeFurniture(section);
		}
		return allFurnitures;
	}

}
