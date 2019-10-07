package br.com.adn.extrator.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.adn.extrator.domain.BroadBand;

@Service
public class SendFilaService {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	static final String queueName = "enviar_provider";

	public void Send(BroadBand model) {
		ObjectMapper object = new ObjectMapper();
		try {
			String jsonEnvio = object.writeValueAsString(model);
			rabbitTemplate.convertAndSend(queueName, jsonEnvio);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
