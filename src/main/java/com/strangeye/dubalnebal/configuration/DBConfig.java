package com.strangeye.dubalnebal.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan (basePackages = "com.strangeye.dubalnebal.dao")
public class DBConfig {

//	@ConfigurationProperties(prefix = "spring.datasource")
//	public DataSource dataSource() {
//		return DataSourceBuilder.create().build();
//	}

}