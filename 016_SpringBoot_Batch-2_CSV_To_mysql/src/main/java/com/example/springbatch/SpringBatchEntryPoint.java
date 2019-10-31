package com.example.springbatch;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
public class SpringBatchEntryPoint {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job myjob;

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchEntryPoint.class, args);
	}

	//@Scheduled(cron="s  m  h dom m dow y")
	@Scheduled(cron = "30 01 11 * * *")
	public void execute() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		JobParameters jobParameters = new JobParametersBuilder()
				.addDate("date", new Date())
				.addLong("time", System.currentTimeMillis())
				.toJobParameters();
		
		JobExecution jobExecution = null;
		jobExecution = jobLauncher.run(myjob, jobParameters);
	}
	
	
}
