package br.com.adn.extrator.batch.broadband;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import br.com.adn.extrator.domain.BroadBand;


@Component
public class BroadBandProcessor implements ItemProcessor<BroadBand, BroadBand>
{
	private static final Logger logger = LoggerFactory.getLogger(BroadBandProcessor.class);

    public BroadBand process(BroadBand broadband) throws Exception
    {
        logger.info("Insert na BroadBand {} ",  broadband );
        return broadband;
    }
}

