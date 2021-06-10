package com.Maersk.demo.apps;

import com.Maersk.demo.Rockstar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.ReactiveCassandraOperations;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CassandraReactiveOperationsApp implements App {
    @Autowired
    ReactiveCassandraOperations template;

    public void run(){
        Rockstar rockstar = new Rockstar(new Random().nextInt(), "Jim", "Morrison");
        template.insert(rockstar).block();
        var rs = template.select("select * from rockstar", Rockstar.class);
        rs.map(r -> r.toString()).doOnEach(r -> System.out.println(r)).blockLast();
    }
}
