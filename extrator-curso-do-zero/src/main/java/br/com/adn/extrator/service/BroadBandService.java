package br.com.adn.extrator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.adn.extrator.domain.BroadBand;
import br.com.adn.extrator.repository.IBroadBandRepository;


@Service
public class BroadBandService {

	@Autowired
	private IBroadBandRepository broadBandRepository ;

	
	public void save( BroadBand entity) {
		broadBandRepository.save(entity);
	}

}

