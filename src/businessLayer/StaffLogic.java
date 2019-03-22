package businessLayer;

import dataAcces.ManageStaff;
import dataAcces.ManageUser;
import dataAcces.Staff;
import dataAcces.User;

public class StaffLogic {
	public int logInStaff(String name, String password) {
		ManageStaff manageStaff= new ManageStaff();
		if(manageStaff.searchStaffByNamePassword(name, password)==0) {
			System.out.println("We can't find your account!");	
			return 0;
		}		
		return 1; 
	}
	public void addFurniture(String name, String type, String price, int number, String discount) {
		FurnitureLogic furniture= new FurnitureLogic();
		furniture.addNewFurniture(name, type, price, number, discount);
	}
	
	

}
