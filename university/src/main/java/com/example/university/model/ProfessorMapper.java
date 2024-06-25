package com.example.university.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProfessorMapper implements RowMapper<Professor> {
    @Override
    public Professor mapRow(ResultSet rs,int rownum) throws SQLException{
        return new Professor(rs.getInt("id"), rs.getString("name"), rs.getString("department"));
    }
}
