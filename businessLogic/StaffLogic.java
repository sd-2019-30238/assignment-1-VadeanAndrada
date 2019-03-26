package businessLogic;

import java.sql.SQLException;

import dataAcces.ManageStaff;
import dataAcces.ManageUser;
import dataAcces.Staff;
import dataAcces.User;

public class StaffLogic {
	public int logInStaff(String name, String password) {
		Staff s=new Staff();
		s.setNameStaff(name);
		s.setPassword(password);
		ManageStaff manageStaff= new ManageStaff();
		if(manageStaff.searchStaffByNamePassword(s)==0) {
			System.out.println("We can't find your account!");	
			return 0;
		}		
		return 1; 
	}
	public void addFurniture(String name, String type, String price, int quantity, String discount) throws SQLException {
		FurnitureLogic furniture= new FurnitureLogic();
		furniture.addNewFurniture(name, type, price, quantity, discount);
	}
	
	

}
