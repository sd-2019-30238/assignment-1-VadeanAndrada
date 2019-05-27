package net.codeJava.BestDealsWeb.service;

import net.codeJava.BestDealsWeb.model.Order;

public interface OrderCommandService {

	public void update( int id);
	public void createOrder(Order order);
}
