 package net.codeJava.BestDealsWeb.mediator;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import net.codeJava.BestDealsWeb.handler.Handler;


@Component
public class MediatorImpl implements Mediator{

	private ArrayList<Handler> handlers;
	
	public MediatorImpl() {
		handlers=new ArrayList<Handler>();
	}
	
	
	public void addHandler(Handler handler) {
		handlers.add(handler);
	}
	
	
	@Override
	public void handle(String command, Handler handler) {
		for(Handler h: handlers) {
			if(h.getCommand().equals(command)) {
				h.execute(command);
			}
		}
		
	}

}
