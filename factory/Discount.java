package factory;

import java.sql.SQLException;

import dataAcces.Furniture;

public interface Discount {
	
	void applyDiscount(String name) throws SQLException;

}
