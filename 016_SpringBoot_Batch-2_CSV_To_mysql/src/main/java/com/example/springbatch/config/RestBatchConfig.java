package com.example.springbatch.config;

import javax.sql.DataSource;

import org.apache.tomcat.util.digester.SetPropertiesRule;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.springbatch.pojo.User;
import com.example.springbatch.status.JobCompletionListener;
import com.example.springbatch.steps.CSVUserProcessor;

@Configuration
public class RestBatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	public DataSource dataSource;
	
	@Bean
	public Step takeStep() {
		return stepBuilderFactory.get("takeStep1")
							.<User, User>chunk(1)
							.reader(reader())
							.processor(processor())
							.writer(writer())
							.build();
	}
	
	
	@Bean
	public Job processJob() {
		return jobBuilderFactory.get("myjob")
							.incrementer(new RunIdIncrementer())
							.listener(listener())
							.flow(takeStep())
							.end()
							.build();
	}
	

	private JobExecutionListener listener() {
		// TODO Auto-generated method stub
		return new JobCompletionListener();
	}

	@Bean
	public ItemProcessor<? super User, ? extends User> processor() {
		// TODO Auto-generated method stub
		return new CSVUserProcessor();
	}


	@Bean
	public ItemWriter<? super User> writer() {
		// TODO Auto-generated method stub
		JdbcBatchItemWriter<User> writer = new JdbcBatchItemWriter<User>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<User>());
		writer.setSql("insert into user(name) values(:name)");
		writer.setDataSource(setDataSource());
		return writer;
	}
	
	//@Bean
	public DataSource setDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springbatchcsvmysqloct2019");
		ds.setUsername("root");
		ds.setPassword("root");
		
		
		return ds;
		
	}

	public ItemReader<? extends User> reader() {
		// TODO Auto-generated method stub
		FlatFileItemReader<User> reader = new FlatFileItemReader<User>();
		reader.setResource(new ClassPathResource("Users.csv"));
		reader.setLineMapper(lineMapper());
		return reader;
		
	}



	public LineMapper<User> lineMapper() {
		// TODO Auto-generated method stub
		DefaultLineMapper<User> defaultLineMapper = new DefaultLineMapper<User>();
		
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] {"name"});
		
		BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<User>();
		fieldSetMapper.setTargetType(User.class);
		
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		
		return defaultLineMapper;
	}



	
}
