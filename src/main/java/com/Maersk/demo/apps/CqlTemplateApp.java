package com.Maersk.demo.apps;

import com.Maersk.demo.Rockstar;
import com.datastax.oss.driver.api.core.DriverException;
import com.datastax.oss.driver.api.core.cql.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.cql.CqlTemplate;
import org.springframework.data.cassandra.core.cql.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CqlTemplateApp  implements App{
    @Autowired
    CqlTemplate template;

    public void run(){
        var rs = template.query("select * from rockstar", new RowMapper<Rockstar>() {
            @Override
            public Rockstar mapRow(Row row, int i) throws DriverException {
                return new Rockstar(row.get("id", Integer.class),
                        row.get("name", String.class),
                        row.get("surname", String.class));
            }
        });
        rs.stream().map(r -> r.toString()).forEach(r -> System.out.println(r));
    }
}
