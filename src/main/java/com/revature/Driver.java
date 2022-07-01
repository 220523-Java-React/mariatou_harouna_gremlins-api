package com.revature;

import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Driver {

    static Logger logger = LoggerFactory.getLogger(Driver.class);

    public static void main(String[] args) {

        logger.error("Error");


        Javalin app = Javalin.create().start(8080);


    }
}
