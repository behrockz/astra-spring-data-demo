package com.Maersk.demo;

import com.Maersk.demo.apps.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		App app = context.getBean(CqlSessionApp.class);
		app.run();
		app = context.getBean(CqlTemplateApp.class);
		app.run();
		app = context.getBean(CassandraOperationsApp.class);
		app.run();
		app = context.getBean(CassandraReactiveOperationsApp.class);
		app.run();
		System.exit(0);
	}

}
