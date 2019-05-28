package net.codeJava.BestDealsWeb.decorator;

public abstract class ShopCartDecorator implements ShopCart{
	
	protected ShopCart decoratedShopCart;
	
	public ShopCartDecorator(ShopCart decoratedShopCart) {
		super();
		this.decoratedShopCart=decoratedShopCart;
	}

	public ShopCart getDecoratedShopCart() {
		return decoratedShopCart;
	}

	public void setDecoratedShopCart(ShopCart decoratedShopCart) {
		this.decoratedShopCart = decoratedShopCart;
	}
	
	
}
