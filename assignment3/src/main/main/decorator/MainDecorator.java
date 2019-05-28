package net.codeJava.BestDealsWeb.decorator;

public class MainDecorator {

	public static void main(String[] args) {
		ShopCart shopCart=new ShopCartImpl();
		shopCart.setPrice(160);
		System.out.println("initial price: "+shopCart.getPrice());
		ShopCart decoratedShopCart=new DiscountDecorator(shopCart);
		System.out.println("decoratedPrice: "+decoratedShopCart.getTotalPrice());
	}
}
