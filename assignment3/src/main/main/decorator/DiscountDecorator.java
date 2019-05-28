package net.codeJava.BestDealsWeb.decorator;

public class DiscountDecorator extends ShopCartDecorator {

	
	
	public DiscountDecorator(ShopCart decoratedShopCart) {
		super(decoratedShopCart);
	}

	@Override
	public void setPrice(float price) {
		decoratedShopCart.setPrice(price);
		
	}

	@Override
	public float getPrice() {
		return decoratedShopCart.getPrice();
	}

	@Override
	public float getTotalPrice() {
		float total =getPrice();
	    total=(float) (total-(0.3*total));
		return total;
	}





	
}
