package net.codeJava.BestDealsWeb.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codeJava.BestDealsWeb.model.Order;
import net.codeJava.BestDealsWeb.repository.OrderRepository;


@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;

	@Override
	public void createOrder(Order order) {
		orderRepository.save(order);
	}

}
