package com.revature.Repository;

import com.revature.Model.Gremlin;
import com.revature.Util.ConnectionUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GremlinRepository implements DAO<Gremlin>{

    private static final Logger logger = LoggerFactory.getLogger(GremlinRepository.class);

    @Override
    public Gremlin create(Gremlin gremlin) {

        try(Connection connection = ConnectionUtility.getMyConnection()){

            String Sql = "insert into gremlins(name, age, color, isevil) values(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(Sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, gremlin.getName());
            statement.setInt(2, gremlin.getAge());
            statement.setString(3, gremlin.getColor());
            statement.setBoolean(4, gremlin.getIsEvil());

            int success = statement.executeUpdate();

            ResultSet keys = statement.getGeneratedKeys();
            if(keys.next()){
                int id = keys.getInt(1);
                return gremlin.setId(id);
            }


        }catch (SQLException e){
            logger.warn(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Gremlin> getAll() {

        List<Gremlin> gremlins = new ArrayList<>();
        String Sql = "select * from gremlims";

        try(Connection connection = ConnectionUtility.getMyConnection()){

            PreparedStatement statement = connection.prepareStatement(Sql);

            ResultSet results = statement.executeQuery();

            while(results.next()){
                Gremlin gremlin = new Gremlin();

                gremlin.setName(results.getString("name"));
                gremlin.setAge(results.getInt("age"));
                gremlin.setColor(results.getString("color"));
                gremlin.setIsEvil(results.getBoolean("is evil"));

                gremlins.add(gremlin);

            }
        }catch(SQLException e){
            logger.warn(e.getMessage());
        }

        return gremlins;
    }
}
