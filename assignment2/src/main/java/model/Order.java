package net.codeJava.BestDealsWeb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderr")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String username;
	@Column(name="total_price")
	private String totalPrice;
	@Column
	private int delivered;
	
	public Order(String username, String totalPrice, int delivered) {
		this.username=username;
		this.totalPrice=totalPrice;
		this.delivered=delivered;
	}
	
	public Order() {
		
	}

	public int getIdOrder() {
		return id;
	}

	public void setIdOrder(int idOrder) {
		this.id = idOrder;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getDelivered() {
		return delivered;
	}

	public void setDelivered(int delivered) {
		this.delivered = delivered;
	}
}
