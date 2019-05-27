package net.codeJava.BestDealsWeb.service;

import net.codeJava.BestDealsWeb.model.Furniture;

public interface FurnitureCommandService {
	public void delete(int id);
	public void add(Furniture f); 
}
