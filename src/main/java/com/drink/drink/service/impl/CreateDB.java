package com.drink.drink.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLException;

//@Component
public class CreateDB {

    @Value("classpath:static/sql/init_db.sql")
    Resource script;
    @Value("classpath:static/sql/destroy_db.sql")
    Resource destroyScript;

    @Autowired
    JdbcTemplate jdbcTemplate;

//    @PostConstruct
//    public void initDb() throws SQLException {
//
//        ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection(), script);
//    }
    @PreDestroy
    public void destroyDb() throws SQLException {

        ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection(), destroyScript);
    }


}