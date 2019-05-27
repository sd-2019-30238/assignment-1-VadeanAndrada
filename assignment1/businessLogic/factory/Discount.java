package businessLogic.factory;

import java.sql.SQLException;

import dataAccess.Furniture;

public interface Discount {
	
	void applyDiscount(String name) throws SQLException;

}
