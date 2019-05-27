package businessLogic;

import java.sql.SQLException;

import dataAccess.ManageStaff;
import dataAccess.ManageUser;
import dataAccess.Staff;
import dataAccess.User;

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
	
	public int checkNewStaff(String name,String password) {
		ManageStaff manageStaff= new ManageStaff();		
		Staff staff=new Staff();
		staff.setNameStaff(name);
		staff.setPassword(password);
		if(name.length()==0||password.length()==0)
			return 0;
		int noStaff=manageStaff.searchStaff(staff);
		if(noStaff!=0 )
			return 2;
		if(name.length()<6)
			return 0;
		if(password.length()<8)
			return 0;
		return 1;	
	}
	
	public int addNewStaff(String name, String password) {
		Staff staff=new Staff();
		staff.setNameStaff(name);
		staff.setPassword(password);
		ManageStaff manageStaff= new ManageStaff();
		int isOK=checkNewStaff(staff.getNameStaff(),staff.getPassword());
		if(isOK==2)
			return 2;//nu am gasit stafful;
		if(isOK==0)
			return 0;
		
		manageStaff.addStaff(staff);
		System.out.println(staff.getNameStaff()+staff.getPassword());
		
		return 1;
	}
	

}
