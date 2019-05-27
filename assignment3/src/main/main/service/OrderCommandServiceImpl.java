package net.codeJava.BestDealsWeb.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codeJava.BestDealsWeb.model.Order;
import net.codeJava.BestDealsWeb.repository.OrderRepository;

@Service
@Transactional
public class OrderCommandServiceImpl implements OrderCommandService{

	@Autowired
	OrderRepository orderRepository;

	@Override
	public void createOrder(Order order) {
		orderRepository.save(order);
	}

	@Override
	public void update( int id) {
	    
		Order order= orderRepository.findById(id).get();
		order.setDelivered(1);
	    orderRepository.save(order);
	    
	}

}
