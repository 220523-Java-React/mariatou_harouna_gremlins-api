package com.revature.Service;

import com.revature.Model.Gremlin;
import com.revature.Repository.GremlinRepository;

import java.util.List;

public class GremlinService {

    private final GremlinRepository gremlinRepository = new GremlinRepository();

    public Boolean createGremlin(Gremlin gremlin){
        return gremlinRepository.create(gremlin);
    }

    public List<Gremlin> getAllGremlins(){
        return gremlinRepository.getAll();
    }
}
