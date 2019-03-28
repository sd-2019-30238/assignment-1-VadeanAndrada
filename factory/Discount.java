package factory;

import java.sql.SQLException;

import dataAcces.Furniture;

public interface Discount {
	
	void applyDiscount() throws SQLException;
	
	String getName();
}
