package com.deethya.tutorials.jms2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

public class producer {
    final static Logger logger = LoggerFactory.getLogger(producer.class);
    public static void main(String[] args) throws Exception {
        Context ctx = new InitialContext();
        ConnectionFactory connectionFactory = (ConnectionFactory)ctx.lookup("connectionFactory");
        Queue destQueue = (Queue)ctx.lookup("ETRADE.Q");
//        try (JMSContext context = connectionFactory.createContext();){
//            context.createProducer().send(destQueue, "Apple Shares Trading at 103.88");
 //       } catch (JMSRuntimeException ex) {
 //           // handle exception (details omitted)
 //       }
        logger.info("JMS 2 Message Sent");
    }
}
