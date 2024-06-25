package com.example.university.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.university.model.Student;
import com.example.university.model.StudentMapper;
import com.example.university.repository.StudentRepository;
@Service
public class StudentService implements StudentRepository {
    @Autowired
    private JdbcTemplate db;
    @Override
    public ArrayList<Student> getStudents() {
        List<Student> li = db.query("select * from student",new StudentMapper());
        ArrayList<Student> students = new ArrayList<>(li);
        return students;
    }

    @Override
    public Student getStudentById(int studentId) {
        Student student = db.queryForObject("select * from student where id=?",new StudentMapper(),studentId);
        return student;
    }

    @Override
    public Student addStudent(Student student) {
        db.update("insert into student values (?,?)", student.getStudentName(),student.getEmail());
        Student added = db.queryForObject("select * from student where name=? and email=?",new StudentMapper(),
        student.getStudentName(),student.getEmail());
        return added;
    }

    @Override
    public Student updateStudent(int studentId, Student student) {
        db.update("update student set name=? where id=?", student.getStudentName(),studentId);
        db.update("update student set email=? where id=?",student.getEmail(),studentId);
        return getStudentById(studentId);
    }

    @Override
    public void deleteStudent(int studentId) {
        db.update("delete from student where id=?",studentId);
    }
    
}
