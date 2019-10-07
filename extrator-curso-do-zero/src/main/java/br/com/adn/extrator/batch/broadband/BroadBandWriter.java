package br.com.adn.extrator.batch.broadband;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import br.com.adn.extrator.service.BroadBandService;
import br.com.adn.extrator.service.SendFilaService;
import br.com.adn.extrator.domain.BroadBand;
import br.com.adn.extrator.schedule.ScheduledTasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class BroadBandWriter implements ItemWriter<BroadBand> {

	private static final Logger logger = LoggerFactory.getLogger(BroadBandWriter.class);
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	@Autowired
	private BroadBandService broadBandService;

	@Autowired
	private SendFilaService sendFilaService;
	
	@Override
	public void write(List<? extends BroadBand> items) throws Exception {
		if (!CollectionUtils.isEmpty(items)) {
            for (BroadBand entity : items) {
            	logger.info("Gravando no banco de dados ", dateTimeFormatter.format(LocalDateTime.now()) );
            	broadBandService.save(entity);
            	logger.info("Enviando para RabbitMQ ", dateTimeFormatter.format(LocalDateTime.now()) );
            	//sendFilaService.Send(entity);
            }
		}
		
	}

}



