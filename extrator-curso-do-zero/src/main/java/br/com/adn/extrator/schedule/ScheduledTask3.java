package br.com.adn.extrator.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component  @EnableScheduling
@Profile ("environmentB") /* só executa se Run configurations... com profile = environmentB */
public class ScheduledTask3 {
	
	private static final Logger logger = LoggerFactory.getLogger(ScheduledTask3.class);
	
	@Scheduled(fixedDelay = 1000)
	public void scheduleTaskTarefaInicial() {
		
		logger.info("Teste Curso 3");
		
	}
}
