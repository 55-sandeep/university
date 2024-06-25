package com.example.university.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs,int rownum) throws SQLException{
        return new Student(rs.getInt("id"),rs.getString("name"),rs.getString("email"));
    }
}
