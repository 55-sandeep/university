package com.example.university.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.university.model.Course;
import com.example.university.service.CourseService;
@RestController
public class CourseController {
    @Autowired
    private CourseService ser;
    @GetMapping("/courses")
    public ArrayList<Course> getCourses(){
        return ser.getCourses();
    }
    @GetMapping("/courses/{courseId}")
    public Course getCourseById(@PathVariable("courseId") int courseId){
        return ser.getCourseById(courseId);
    }
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return ser.addCourse(course);
    }
    @PutMapping("/courses/{courseId}")
    public Course updateCourse(@PathVariable("courseId") int courseId,@RequestBody Course course){
        return ser.updateCourse(courseId, course);
    }
    @DeleteMapping("/courses/{courseId}")
    public void deleteCourse(@PathVariable("courseId") int courseId){
        ser.deleteCourse(courseId);
    }
}
