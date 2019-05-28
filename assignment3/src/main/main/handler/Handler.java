package net.codeJava.BestDealsWeb.handler;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

import net.codeJava.BestDealsWeb.mediator.Mediator;

@Component
public interface Handler {
	public void execute(String command) ;
	
	public String getCommand();
	
}
