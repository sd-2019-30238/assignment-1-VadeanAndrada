package net.codeJava.BestDealsWeb.mediator;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

import net.codeJava.BestDealsWeb.handler.Handler;

@Component
public interface Mediator {

	public void handle(String command, Handler handler) ;
	void addHandler(Handler handler);
}
