package br.com.adn.extrator.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.adn.extrator.mail.SenderMailService;

@Component  @EnableScheduling
@Profile ("environmentA")
public class ScheduledTask {
	
	private static final Logger logger = LoggerFactory.getLogger(ScheduledTask.class);
	
	@Autowired
	private SenderMailService senderMailService;  
	
	@Scheduled(fixedDelay = 10000)
	public void scheduleTaskTarefaInicial() {
		
		senderMailService.enviar("rosynara.lima@adn.com.br", "Scheduled email", "email body");
		logger.info("Teste Curso 1");
		
	}
}
