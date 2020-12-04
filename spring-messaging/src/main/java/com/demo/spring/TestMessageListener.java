package com.demo.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TestMessageListener implements MessageListener {

	public void onMessage(Message message) {
		
		TextMessage tm=(TextMessage)message;
		try {
			System.out.println(tm.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
