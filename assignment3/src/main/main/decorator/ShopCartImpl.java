package net.codeJava.BestDealsWeb.decorator;

public class ShopCartImpl implements ShopCart {

	private float initialPrice;

	@Override
	public void setPrice(float price) {
		initialPrice=price;
		
	}

	@Override
	public float getPrice() {
		return initialPrice;
	}

	@Override
	public float getTotalPrice() {
		return 0;
	}


}
