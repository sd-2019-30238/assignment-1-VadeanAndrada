package net.codeJava.BestDealsWeb.model;

import org.springframework.mail.javamail.JavaMailSender;

public interface Observable {
	public void notifyObserver(User user,JavaMailSender javaMailSender);
}
