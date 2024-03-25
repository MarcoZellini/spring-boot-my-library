package com.example.MyLibraryBackendSpringBoot.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

    @SuppressWarnings("null")
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        User person = new User();
        person.setId(resultSet.getLong("id"));
        person.setName(resultSet.getString("name"));
        person.setLastname(resultSet.getString("lastname"));
        person.setEmail(resultSet.getString("email"));
        return person;
    }
}