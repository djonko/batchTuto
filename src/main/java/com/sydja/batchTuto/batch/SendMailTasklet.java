package com.sydja.batchTuto.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;

import com.sydja.batchTuto.batch.mail.SendMailService;


public class SendMailTasklet implements Tasklet {
	
	private static final Log log = LogFactory.getLog(SendMailTasklet.class);
    private SendMailService sendMailService;
    private JavaMailSender mailSender;
    private String senderAddress;
    private String recipient;
    private String attachmentFilePath;
	
	
	
	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
		log.debug("execute(StepContribution contribution, ChunkContext chunkContext) begin");
        sendMailService.setFields(mailSender, senderAddress, recipient, attachmentFilePath);
        sendMailService.sendMail();
        log.debug("execute(StepContribution contribution, ChunkContext chunkContext) end");
        return RepeatStatus.FINISHED;
	}



	public SendMailService getSendMailService() {
		return sendMailService;
	}



	public void setSendMailService(SendMailService sendMailService) {
		this.sendMailService = sendMailService;
	}



	public JavaMailSender getMailSender() {
		return mailSender;
	}



	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}



	public String getSenderAddress() {
		return senderAddress;
	}



	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}



	public String getRecipient() {
		return recipient;
	}



	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}



	public String getAttachmentFilePath() {
		return attachmentFilePath;
	}



	public void setAttachmentFilePath(String attachmentFilePath) {
		this.attachmentFilePath = attachmentFilePath;
	}



	public static Log getLog() {
		return log;
	}

	
	
	
	
	
	
	
	
	
	
	
}
