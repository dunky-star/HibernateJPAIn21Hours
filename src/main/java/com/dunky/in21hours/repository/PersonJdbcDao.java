package com.dunky.in21hours.repository;

import com.dunky.in21hours.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Using Spring JDBC for database access.
 */

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll(){
        return jdbcTemplate.query("Select * from person",
                new BeanPropertyRowMapper<Person>(Person.class));
    }

}
