package com.example.spring.mark;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MarkRowMapper implements RowMapper<Double> {
    @Override
    public Double mapRow(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getDouble(1);
    }
}
