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
    public Boolean create(Gremlin gremlin) {

        try(Connection connection = ConnectionUtility.getMyConnection()){

            String Sql = "insert into gremlins(name, age, color, isevil) values(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(Sql);

            statement.setString(1, gremlin.getName());
            statement.setInt(2, gremlin.getAge());
            statement.setString(3, gremlin.getColor());
            statement.setBoolean(4, gremlin.getIsEvil());

            int success = statement.executeUpdate();
            return success != 0;


        }catch (SQLException e){
            logger.warn(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Gremlin> getAll() {

        List<Gremlin> gremlins = new ArrayList<>();
        String Sql = "select * from gremlins";

        try(Connection connection = ConnectionUtility.getMyConnection()){

            PreparedStatement stmt = connection.prepareStatement(Sql);

            ResultSet results = stmt.executeQuery();

            while(results.next()){
                Gremlin gremlin = new Gremlin();

                gremlin.setName(results.getString("name"));
                gremlin.setAge(results.getInt("age"));
                gremlin.setColor(results.getString("color"));
                gremlin.setIsEvil(results.getBoolean("isevil"));
                gremlin.setId(results.getInt("gremlin_id"));

                gremlins.add(gremlin);

            }
        }catch(SQLException e){
            logger.warn(e.getMessage());
        }

        return gremlins;
    }
}
