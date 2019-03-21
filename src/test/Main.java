package test;

import java.sql.Connection;
import java.util.ArrayList;

import businessLayer.UserLogic;
import dataAcces.ConnectionDB;
import dataAcces.Furniture;
import dataAcces.ManageFurniture;
import dataAcces.ManageUser;
import dataAcces.User;

public class Main {
	public static void main(String[] args) {
	//	Connection con= ConnectionDB.getConnection();

		User u=new User("AndradaVadean","andrada","0758632232", "editeaza");
		ManageUser m=new ManageUser();
	//	m.addUser(u);
		/*m.showAllUserrs();
		
		UserLogic userLogic= new UserLogic();
		int a=userLogic.logInUser("AndradaVadean", "editeaza");
		System.out.println(a);
		*/
		
		Furniture f1=new Furniture("scaun","bucatarie","0","50");
		Furniture f2=new Furniture("scaun2","bucatarie","0","50");
		Furniture f3=new Furniture("scaun3","bucatarie","0","50");
		ManageFurniture mf=new ManageFurniture();
		//mf.addFurniture(f1);
	//	mf.addFurniture(f2);
	//	mf.addFurniture(f3);
		ArrayList<String[]> aux=new ArrayList<String[]>();
		aux=mf.showAllOrderByName();
		System.out.println(aux);
		
	}
}
