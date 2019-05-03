package net.codeJava.BestDealsWeb.model;

import java.util.Optional;

public class Item {
	private Optional<Furniture> furniture;
	private int quantity;
	
	public Item(Optional<Furniture> optional, int quantity) {
		furniture=optional;
		this.quantity=quantity;
	}
	public Item() {}
	
	public Optional<Furniture> getFurniture() {
		return furniture;
	}
	public void setFurniture(Optional<Furniture> furniture) {
		this.furniture = furniture;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
