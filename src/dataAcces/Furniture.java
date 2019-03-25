package dataAcces;

public class Furniture {
	private int idFurniture;
	private String nameFurniture;
	private String type;
	private String discount;
	private String price;
	private int number;
	
	
	public Furniture(String nameFurniture,String type, String discount, String price, int number) {
		this.nameFurniture=nameFurniture;
		this.type=type;
		this.discount=discount;
		this.price=price;
		this.number=number;
	}
	
	
	public Furniture() {}
	
	
	public int getIdFurniture() {
		
		return idFurniture;
		
	}
	
	
	public void setIdFurniture(int idFurniture) {
		
		this.idFurniture = idFurniture;
		
	}
	
	
	public String getNameFurniture() {
		
		return nameFurniture;
		
	}
	
	
	public void setNameFurniture(String nameFurniture) {
		
		this.nameFurniture = nameFurniture;
		
	}
	
	
	public String getType() {
		
		return type;
		
	}
	
	
	public void setType(String type) {
		
		this.type = type;
		
	}
	
	
	public String getDiscount() {
		
		return discount;
		
	}
	
	
	public void setDiscount(String discount) {
		
		this.discount = discount;
		
	}
	
	
	public String getPrice() {
		
		return price;
		
	}
	
	
	public void setPrice(String price) {
		
		this.price = price;
		
	}
	
	
	public int getNumber() {
		
		return number;
		
	}
	
	
	public void setNumber(int number) {
		
		this.number = number;
		
	} 
}
