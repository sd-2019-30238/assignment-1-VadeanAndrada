package net.codeJava.BestDealsWeb.handler;

import org.springframework.beans.factory.annotation.Autowired;

import net.codeJava.BestDealsWeb.model.Furniture;
import net.codeJava.BestDealsWeb.service.FurnitureCommandService;

public class AddNewFurnitureHandler implements Handler {

	@Autowired
	private FurnitureCommandService furnitureCommandService;
	
	Furniture furniture;

	@Override
	public void execute(String command) {
		furnitureCommandService.add(getFurniture());
		
	}

	@Override
	public String getCommand() {
		return "addNewFurniture";
	}

	public Furniture getFurniture() {
		return furniture;
	}

	public void setFurniture(Furniture furniture) {
		this.furniture = furniture;
	}
	
	
}
