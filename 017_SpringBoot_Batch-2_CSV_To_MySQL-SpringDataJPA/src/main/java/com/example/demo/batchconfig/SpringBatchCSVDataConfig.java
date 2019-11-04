package com.example.demo.batchconfig;

import javax.annotation.processing.Processor;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.example.demo.entity.Friend;
import com.example.demo.status.JobCompletionListener;
import com.example.demo.steps.FriendProcessor;
import com.example.demo.steps.FriendWriter;

@Configuration
@EnableBatchProcessing
public class SpringBatchCSVDataConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step buildStep() {
		return stepBuilderFactory.get("takeStep1")
					.<Friend, Friend>chunk(1)
					.reader(reader())
					.processor(processor())
					.writer(writer())
					.build();
	}
	
	@Bean
	public Job buildJob() {
		return jobBuilderFactory.get("job")
								.incrementer(new RunIdIncrementer())
								.listener(listener())
								.flow(buildStep())
								.end().build();
	}

	public JobExecutionListener listener() {
		// TODO Auto-generated method stub
		return new JobCompletionListener(); 
	
	}

	@Bean
	public ItemWriter<? super Friend> writer() {
		// TODO Auto-generated method stub
		return new FriendWriter();
	}

	@Bean
	public ItemProcessor<? super Friend, ? extends Friend> processor() {
		// TODO Auto-generated method stub
		return new FriendProcessor();
	}

	public ItemReader<? extends Friend> reader() {
		// TODO Auto-generated method stub
		FlatFileItemReader<Friend> flatFileReader = new FlatFileItemReader<Friend>();
		flatFileReader.setResource(new ClassPathResource("friends.csv"));
		flatFileReader.setLinesToSkip(1);
		flatFileReader.setLineMapper(lineMapper());
		return flatFileReader;
	}

	public LineMapper<Friend> lineMapper() {
		// TODO Auto-generated method stub
		DefaultLineMapper<Friend> defaultLineMapper = new DefaultLineMapper<Friend>();
		
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] {"id","name","location","year"});
		
		BeanWrapperFieldSetMapper<Friend> fieldSetMap = new BeanWrapperFieldSetMapper<Friend>();
		fieldSetMap.setTargetType(Friend.class);
		
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMap);
		
		return defaultLineMapper;
		
		
	
	}
	
}
