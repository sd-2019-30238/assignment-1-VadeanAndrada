package dataAcces;

public class Order {
	private int idOrder;
	private String username;
	private String totalPrice;
	private int delivered;
	
	public Order(String username, String totalPrice, int delivered) {
		this.username=username;
		this.totalPrice=totalPrice;
		this.delivered=delivered;
	}
	
	public Order() {
		
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
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
