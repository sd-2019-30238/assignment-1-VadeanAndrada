package dataAcces;

public class ShoppingCart {
	private int idShoppingCart;
	private String nameProduct;
	private String priceProduct;
	private int quantity;
	private String username;
	private int delivered;
	
	public ShoppingCart(String nameProduct, String priceProduct,int quantity, String username, int delivered) {
		this.nameProduct=nameProduct;
		this.priceProduct=priceProduct;
		this.quantity=quantity;
		this.username=username;
		this.delivered=delivered;
	}
	
	public ShoppingCart() {
		
	}

	public int getIdShoppingCart() {
		return idShoppingCart;
	}

	public void setIdShoppingCart(int idShoppingCart) {
		this.idShoppingCart = idShoppingCart;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(String priceProduct) {
		this.priceProduct = priceProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getDelivered() {
		return delivered;
	}

	public void setDelivered(int delivered) {
		this.delivered = delivered;
	}
	
	
}
