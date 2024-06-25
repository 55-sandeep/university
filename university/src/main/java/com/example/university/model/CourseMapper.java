package com.example.university.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CourseMapper implements RowMapper<Course> {
    @Override
    public Course mapRow(ResultSet rs,int rownum) throws SQLException{
        return new Course(rs.getInt("id"), rs.getString("name"), rs.getInt("credits"), rs.getInt("profid"));
    }
}
