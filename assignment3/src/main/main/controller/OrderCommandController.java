package net.codeJava.BestDealsWeb.controller;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import net.codeJava.BestDealsWeb.model.Order;
import net.codeJava.BestDealsWeb.model.User;
import net.codeJava.BestDealsWeb.repository.UserRepository;
import net.codeJava.BestDealsWeb.service.OrderCommandService;
import net.codeJava.BestDealsWeb.service.OrderQueryService;
import net.codeJava.BestDealsWeb.service.UserQueryService;

@Controller
@Transactional
@RequestMapping("/orders")
public class OrderCommandController {
	@Autowired
	OrderQueryService orderService;
	
	@Autowired
	OrderCommandService orderCommandService;
	
	@Autowired
	UserQueryService userService;
	
	
	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	JavaMailSender javaMailSender;
	
	private org.slf4j.Logger logger= org.slf4j.LoggerFactory.getLogger(OrderCommandController.class);
	
	@ModelAttribute("order")
	public Order order() {
		
		return new Order();
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/edit/{id}")
	public String updateOrder(
			@PathVariable("id")Integer id) {
		
		orderCommandService.update(id);	
		Order order=orderService.find(id).get();
		
		try {
		User user=userRepository.findUserByNameUser(order.getUsername()).get();
		order.notifyObserver(user,javaMailSender);}
		catch(MailException e) {
			logger.info("Error: "+e);
		}

		return "redirect:../../orders";
	}
		
}
