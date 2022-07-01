package com.revature.Controller;

import com.revature.Model.Gremlin;
import com.revature.Service.GremlinService;
import io.javalin.http.Handler;
import org.eclipse.jetty.http.HttpStatus;

import java.util.List;

public class GremlinController {

    private final GremlinService gremlinService = new GremlinService();


    public Handler createNewGremlin = context -> {
        Gremlin newGremlin = context.bodyAsClass(Gremlin.class);
        Boolean success = gremlinService.createGremlin(newGremlin);

        if(success) {
            context.status(HttpStatus.CREATED_201);
        } else {
            context.status(400).result("Gremlin not created");
        }
    };

    public Handler getAllGremlins = context -> {
        List<Gremlin> gremlins = gremlinService.getAllGremlins();
        context.json(gremlinService.getAllGremlins());
    };


}
