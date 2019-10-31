package com.example.springbatch.batchrestcontroller;

import java.util.Date;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartBatchRestController {

	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job myjob;
	
	
	@RequestMapping("/startjob")
	public BatchStatus startBatchJob() {
		
		JobParameters jobParameters = new JobParametersBuilder()
											.addDate("date", new Date())
											.addLong("time", System.currentTimeMillis())
											.toJobParameters();
		
		JobExecution jobExecution = null;
		
		try {
			jobExecution = jobLauncher.run(myjob, jobParameters);
		} catch (JobExecutionAlreadyRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobRestartException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobInstanceAlreadyCompleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Batchjob started...." + jobExecution.getStatus());
		
		while (jobExecution.isRunning()) {
			System.out.println(".. running ..");
		}

		return jobExecution.getStatus();
		
	}
}
