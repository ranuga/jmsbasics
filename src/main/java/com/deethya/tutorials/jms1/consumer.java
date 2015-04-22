package com.deethya.tutorials.jms1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

public class consumer {
    final static Logger logger = LoggerFactory.getLogger(consumer.class);
    public static void main(String[] args) throws Exception {
        Context ctx = new InitialContext();
        Connection connection  = ((ConnectionFactory)ctx.lookup("connectionFactory")).createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = (Queue)ctx.lookup("ETRADE.Q");
        MessageConsumer consumer = session.createConsumer(queue);
        TextMessage msg = (TextMessage)consumer.receive();
        logger.info("Message Received {}",msg.getText());
        connection.close();
    }
}
