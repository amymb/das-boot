package com.amy.config;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by pivotal on 4/14/17.
 */
@Configuration
public class PersistenceConfiguration {

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    @Primary
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix="datasource.flyway")
    @FlywayDataSource
    public DataSource flywayDataSource(){
        return DataSourceBuilder.create().build();
    }
}
