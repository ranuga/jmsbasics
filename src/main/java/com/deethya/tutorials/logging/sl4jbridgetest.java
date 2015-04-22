package com.deethya.tutorials.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class sl4jbridgetest {
    final static Logger logger = LoggerFactory.getLogger(sl4jbridgetest.class);
    public static void main(String[] args) throws Exception {
        logger.info("Info Loggged {} {}", "some text", "continued");

    }
}