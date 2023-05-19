package com.strangeye.dubalnebal.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan (basePackages = "com.strangeye.dubalnebal.dao")
public class DBConfig {

}