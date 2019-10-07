package br.com.adn.extrator.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SenderMailService {

	private static final Logger logger = LoggerFactory.getLogger(SenderMailService.class);

	@Autowired
	private JavaMailSender mailSender;

	public void enviar( String to, String subject, String body ) {
		logger.info("enviando email...");
		/* comentado para não enviar email no loop
		SimpleMailMessage email = new SimpleMailMessage(); 
		email.setTo(to);
		email.setSubject(subject);
		email.setText(body);
		mailSender.send(email);
		*/
	}
}
