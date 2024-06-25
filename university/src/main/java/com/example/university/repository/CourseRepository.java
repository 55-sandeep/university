package com.example.university.repository;
import com.example.university.model.Course;
import java.util.ArrayList;
public interface CourseRepository {
    ArrayList<Course> getCourses();
    Course getCourseById(int courseId);
    Course addCourse(Course course);
    Course updateCourse(int courseId,Course course);
    void deleteCourse(int courseId);
} 
