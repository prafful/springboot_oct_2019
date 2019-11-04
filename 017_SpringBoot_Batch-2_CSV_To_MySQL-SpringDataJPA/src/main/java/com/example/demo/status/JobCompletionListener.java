package com.example.demo.status;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class JobCompletionListener  extends JobExecutionListenerSupport{

	@Override
	public void afterJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("Batch Job Success!");
		}
	}

}
