package net.codeJava.BestDealsWeb.model;

import org.springframework.mail.javamail.JavaMailSender;

public interface Observer {
	public void update(String email,JavaMailSender javaMailSender);
}
