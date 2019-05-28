package net.codeJava.BestDealsWeb.handler;

import org.springframework.beans.factory.annotation.Autowired;

import net.codeJava.BestDealsWeb.service.FurnitureCommandService;

public class DeleteFurnitureHandler implements Handler {

	@Autowired
	private FurnitureCommandService furnitureCommandService;
	private int id;
	
	@Override
	public void execute(String command) {
		furnitureCommandService.delete(getId());
	}

	@Override
	public String getCommand() {
		return "deleteFurniture";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
