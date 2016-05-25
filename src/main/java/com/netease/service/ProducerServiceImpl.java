package com.netease.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;


import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by hz-lpf on 16-5-25.
 */
public class ProducerServiceImpl {
    JmsTemplate jmsTemplate;


    public boolean sendMsg(Destination destination, final String msg) {
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
        return true;
    }

    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    @Autowired
    @Qualifier("jmsTemplate")
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}
