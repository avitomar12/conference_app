package com.pypred.conferenceapp.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {

        public DataSource dataSource(){
            DataSourceBuilder builder=DataSourceBuilder.create();
            builder.url("jdbc:mariadb://localhost:3306/conference_demo");
            System.out.println("My cuson datasource bean has been initialized");

            return builder.build();
        }
}