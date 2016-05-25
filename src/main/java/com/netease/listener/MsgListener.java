package com.netease.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by hz-lpf on 16-5-25.
 */
public class MsgListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage txt = (TextMessage) message;
        try {
            System.out.println(txt.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
