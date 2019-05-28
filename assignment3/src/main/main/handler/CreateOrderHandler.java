package net.codeJava.BestDealsWeb.handler;


import org.springframework.beans.factory.annotation.Autowired;

import net.codeJava.BestDealsWeb.model.Order;
import net.codeJava.BestDealsWeb.service.OrderCommandService;

public class CreateOrderHandler implements Handler {

	@Autowired
	private OrderCommandService orderCommandService;
	
	Order order;
	
	@Override
	public void execute(String command) {
		orderCommandService.createOrder(getOrder());
	}

	@Override
	public String getCommand() {
		return "newOrder";
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	
}

