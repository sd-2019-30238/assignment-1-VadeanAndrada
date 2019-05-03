package net.codeJava.BestDealsWeb.contoller;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import antlr.collections.List;
import net.codeJava.BestDealsWeb.model.Furniture;
import net.codeJava.BestDealsWeb.model.Item;
import net.codeJava.BestDealsWeb.service.FurnitureService;

@Controller
@RequestMapping("/cart")
public class CartController {

		@Autowired
		private FurnitureService furnitureService;


		@RequestMapping(method = RequestMethod.GET)
		public String cart() {
			return "cart";
		}


		@RequestMapping(value= "/buy/{id}",method = RequestMethod.GET)
		public String buy(@PathVariable("id") int id,
				ModelMap modelMap,
				HttpSession session) {
			if(session.getAttribute("cart")==null) {
				ArrayList<Furniture> cart=new ArrayList<Furniture>();
				cart.add(furnitureService.find(id).orElse(null));
				session.setAttribute("cart", cart);	
			}
			else
			{
				ArrayList<Furniture> cart=(ArrayList<Furniture>) session.getAttribute("cart");
				cart.add(furnitureService.find(id).orElse(null));
				//System.out.println("aiciiii"+cart.get(0).getFurniture());
				session.setAttribute("cart", cart);	
			}
			return "redirect:../../cart";
		}


	}

