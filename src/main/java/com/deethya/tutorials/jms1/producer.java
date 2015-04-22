package com.deethya.tutorials.jms1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

public class producer {
    final static Logger logger = LoggerFactory.getLogger(producer.class);
    public static void main(String[] args) throws Exception {
        Context ctx = new InitialContext();
        Connection connection = ((ConnectionFactory)ctx.lookup("connectionFactory")).createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue destQueue = (Queue)ctx.lookup("ETRADE.Q");
        MessageProducer sender = session.createProducer(destQueue);
        TextMessage msg = session.createTextMessage("Apple Shares Trading at 103.88");
        sender.send(msg);
        logger.info("Message Sent {}", msg.getJMSMessageID());
        connection.close();

    }
}
