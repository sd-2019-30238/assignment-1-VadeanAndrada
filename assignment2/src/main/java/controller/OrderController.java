package net.codeJava.BestDealsWeb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.codeJava.BestDealsWeb.model.Order;
import net.codeJava.BestDealsWeb.model.User;
import net.codeJava.BestDealsWeb.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@ModelAttribute("order")
	public Order order() {
		
		return new Order();
	}
	

	@RequestMapping(value="/orders",method = RequestMethod.GET)
	public String showAllOrders(ModelMap modelMap) {
		modelMap.put("orders", orderService.findAll());   
		return "orders";
	}
	
	@RequestMapping(value="order/edit/{id}")
	public String getOrder(Model model,
			@PathVariable("id")int id) {
		Order order=orderService.find(id).get();
		order.setDelivered(1);
		model.addAttribute("order", order);  
		System.out.println("+++++++++++++++++");
//		orderService.update(order);
		return "orders";
	}
	

	@RequestMapping(value="order",method = RequestMethod.POST)
	public String getOrder(@Valid Order order) {

		System.out.println("+++++++++++++++++");
		orderService.update(order);
		return "redirect:orders";
	}
	
	@PostMapping("/ok")
	public String changeState(@ModelAttribute("order") Order order) {
		orderService.update(order);
		return "redirect:../../orders";
	}
	
	
}
