package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	static Connection con=null;
	public static Connection getConnection() {
		try {
			if(con==null) {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost/best_furniture_deals?useSSL=false","root","editeaza");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}

