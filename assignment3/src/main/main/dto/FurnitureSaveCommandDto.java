package net.codeJava.BestDealsWeb.dto;

public class FurnitureSaveCommandDto {

	private int id;
	private String nameFurniture;
	private String price;
	private int quantity;
	private String discount;
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNameFurniture() {
		return nameFurniture;
	}
	public void setNameFurniture(String nameFurniture) {
		this.nameFurniture = nameFurniture;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
