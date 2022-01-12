package com.mpinfo.servicosprof.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.mpinfo.servicosprof.domain.Chamado;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Chamado obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(Chamado obj);
	
	void sendHtmlEmail(MimeMessage msg);
}
