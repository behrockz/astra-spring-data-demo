package com.Maersk.demo.apps;

import com.Maersk.demo.Rockstar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CassandraOperationsApp implements App{
    @Autowired
    CassandraOperations template;

    public void run(){
        Rockstar rockstar = new Rockstar(new Random().nextInt(), "Jim", "Morrison");
        template.insert(rockstar);
        var rs = template.select("select * from rockstar", Rockstar.class);
        rs.stream().map(r -> r.toString()).forEach(r -> System.out.println(r));
    }
}
