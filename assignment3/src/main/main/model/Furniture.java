package net.codeJava.BestDealsWeb.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



@Entity
@Table(name="furniture")
public class Furniture {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message="Please provide an username")
	@Column(name = "name_furniture")
	private String nameFurniture;
	@Column
	private String type;
	@Column
	private String discount;
	@Column
	private String price;
	@Column
	private int quantity;
	
	
	public Furniture(String nameFurniture,String type, String discount, String price, int quantity) {
		this.nameFurniture=nameFurniture;
		this.type=type;
		this.discount=discount;
		this.price=price;
		this.quantity=quantity;
	}
	
	
	public Furniture() {}
	



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
	
	
	public int getQuantity() {
		
		return quantity;
		
	}
	
	
	public void setQuantity(int quantity) {
		
		this.quantity = quantity;
		
	} 
}