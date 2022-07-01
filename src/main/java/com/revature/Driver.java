package com.revature;

import com.revature.Controller.GremlinController;
import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class Driver {

    static Logger logger = LoggerFactory.getLogger(Driver.class);

    public static void main(String[] args) {


        logger.error("Error");


        GremlinController gremlinController = new GremlinController();

        Javalin app = Javalin.create().start(8080);

        app.get("/gremlins", gremlinController.getAllGremlins);
        app.post("/gremlins", gremlinController.createNewGremlin);


    }
}
