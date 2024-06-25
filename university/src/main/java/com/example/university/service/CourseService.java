package com.example.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.university.model.CourseMapper;
import com.example.university.repository.CourseRepository;
import com.example.university.model.Course;
import java.util.List;
import java.util.ArrayList;
@Service
public class CourseService implements CourseRepository {
    @Autowired
    private JdbcTemplate db;
    @Override
    public ArrayList<Course> getCourses(){
        List<Course> li = db.query("select * from course", new CourseMapper());
        ArrayList<Course> courses = new ArrayList<>(li);
        return courses;
    }
    @Override
    public Course getCourseById(int courseId){
        Course course = db.queryForObject("select * from course where id=?",new CourseMapper(),courseId);
        return course;
    }
    @Override
    public Course addCourse(Course course){
        db.update("insert into course values(?,?,?)",course.getCourseName(),course.getCredits(),course.getProfessorId());
        Course added = db.queryForObject("select * from course where name=? and credits=? and profid=?",new CourseMapper(),
        course.getCourseName(),course.getCredits(),course.getProfessorId());
        return added;
    }
    @Override
    public Course updateCourse(int courseId,Course course){
        db.update("update course set name=? where id=?",course.getCourseName(),courseId);
        db.update("update course set credits=? where id=?",course.getCredits(),courseId);
        db.update("update course set profid=? where id=?",course.getProfessorId(),courseId);
        return getCourseById(courseId);
    }
    @Override
    public void deleteCourse(int courseId){
        db.update("delete from course where id=?",courseId);
    }
}
