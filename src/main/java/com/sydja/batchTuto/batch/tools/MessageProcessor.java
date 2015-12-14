package com.sydja.batchTuto.batch.tools;

import org.springframework.batch.item.ItemProcessor;

import com.sydja.batchTuto.model.Message;

public class MessageProcessor implements ItemProcessor<Message, Message> {

	@Override
	public Message process(Message inputMessage) throws Exception {
		
		return null;
	}

}
