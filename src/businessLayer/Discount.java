package businessLayer;

import java.sql.SQLException;

import dataAcces.Furniture;

public interface Discount {
	
	public abstract void updateDiscount(String nameFurniture, String dicount) throws SQLException;
	
}
