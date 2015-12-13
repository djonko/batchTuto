package com.sydja.batchTuto.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring/config.xml");
		
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job=(Job) context.getBean("mysql_to_xml_job");
		try {
			JobParameters param = new JobParametersBuilder().addString("statut", "URGENT").toJobParameters();
			JobExecution jobExecution =jobLauncher.run(job, param);
			System.out.println("Exit Status : " + jobExecution.getStatus());
			System.out.println("Exit Status : " + jobExecution.getAllFailureExceptions());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
