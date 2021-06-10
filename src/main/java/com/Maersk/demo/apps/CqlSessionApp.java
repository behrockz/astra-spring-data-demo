package com.Maersk.demo.apps;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CqlSessionApp implements App {
    @Autowired
    CqlSession session;

    public void run(){
        var rs = session.execute("select * from rockstar");
        rs.map(r -> r.getFormattedContents()).forEach(System.out::println);
    }
}
