package br.com.adn.extrator.batch;

import java.beans.PropertyEditor;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import br.com.adn.extrator.batch.broadband.BroadBandProcessor;
import br.com.adn.extrator.batch.broadband.BroadBandWriter;
import br.com.adn.extrator.domain.BroadBand;

@Configuration
@EnableBatchProcessing
public class BatchBroadBand {

	private static final Logger logger = LoggerFactory.getLogger(BatchBroadBand.class);
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Value("input/PAPO_SVOD_28092020.txt")
	private String inputResource;

	@Autowired
	private BroadBandWriter broadBandWriter;

	@Autowired
	private BroadBandProcessor broadBandProcessor;


	@StepScope
	@Bean
	public FlatFileItemReader<BroadBand> reader( @Value("#{jobParameters['fileName']}") String fileName ) {
		FlatFileItemReader<BroadBand> itemReader = new FlatFileItemReader<BroadBand>();
		itemReader.setLineMapper(lineMapper());
		itemReader.setLinesToSkip(1);
		logger.info("***************************** {}", fileName );
		itemReader.setResource(new ClassPathResource(fileName));
		return itemReader;
	}
	
	@Bean
	public LineMapper<BroadBand> lineMapper() {

		final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		final Map<Class, PropertyEditor> customEditors = Stream
				.of(new AbstractMap.SimpleEntry<>(Date.class, new CustomDateEditor(df, false)))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		

		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(";");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] { "MSISDN", "PLANO", "ACTIVATION_DATE" });
		lineTokenizer.setIncludedFields(new int[] { 0, 1, 2 });

		BeanWrapperFieldSetMapper<BroadBand> fieldSetMapper = new BeanWrapperFieldSetMapper<BroadBand>();
		fieldSetMapper.setTargetType(BroadBand.class);
		fieldSetMapper.setCustomEditors(customEditors);
		
		DefaultLineMapper<BroadBand> lineMapper = new DefaultLineMapper<BroadBand>();
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		
		// MSISDN;PLANO;ATIVACAO;MIGRACAO;ADESAO_CAMPANHA_ATUAL;CAMPANHA_ATUAL;FIXO;VELOCIDADE_BL;CPF;NOME;
		// CEP;UF;CIDADE;BAIRRO;TIPO_LOGR;LOGR;COMPL1;NUM1;COMPL2;NUM2;COMPL3;NUM3;STATUS_BL;STATUS_TIT;
		// STATUS_BUNDLE;ALTERACAO;OPCAO_DADOS;PLANO_TV;COD_PLANO;BENEFICIO
	
		return lineMapper;
	}
	
	@Bean
	public Step passo1() throws Exception {
		return stepBuilderFactory.get("passo1").<BroadBand, BroadBand>chunk(10).reader(reader(null))
				.processor(broadBandProcessor).writer(broadBandWriter).build();
	}
	
	@Bean
	public Job readBroadBand() throws Exception {
		return jobBuilderFactory.get("readCSVFileJob").incrementer(new RunIdIncrementer()).start(passo1()).build();
	}




}

