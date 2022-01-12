package com.mpinfo.servicosprof.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.mpinfo.servicosprof.domain.Chamado;

public abstract class AbstractEmailService implements EmailService {

	@Value("${default.sender}")
	private String sender;

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendOrderConfirmationEmail(Chamado obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromChamado(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromChamado(Chamado obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getCliente().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Chamado confirmado: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}

	protected String htmlFromTemplateChamado(Chamado obj) {
		Context context = new Context();
		context.setVariable("chamado", obj);
		return templateEngine.process("email/confirmacaoChamado", context);
	}

	@Override
	public void sendOrderConfirmationHtmlEmail(Chamado obj) {
		try {
			MimeMessage mm = prepareMimeMessageFromChamado(obj);
			sendHtmlEmail(mm);
		} catch (MessagingException e) {
			sendOrderConfirmationEmail(obj);
		}
	}
//preciso desabilitar o antivirus
	protected MimeMessage prepareMimeMessageFromChamado(Chamado obj) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
		mmh.setTo(obj.getCliente().getEmail());
		mmh.setFrom(sender);
		mmh.setSubject("Chamado confirmado! Código: " + obj.getId());
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplateChamado(obj), true);
		return mimeMessage;
	}
}
