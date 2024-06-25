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

import com.example.university.model.Student;
import com.example.university.service.StudentService;
@RestController
public class StudentController {
    @Autowired
    private StudentService ser;
    @GetMapping("/students")
    public ArrayList<Student> getStudents(){
        return ser.getStudents();
    }
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable("studentId")int studentId){
        return ser.getStudentById(studentId);
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return ser.addStudent(student);
    }
    @PutMapping("/students/{studentId}")
    public Student updateStudent(@PathVariable("studentId") int studentId,@RequestBody Student student){
        return ser.updateStudent(studentId, student);
    }
    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable("studentId") int studentId){
        ser.deleteStudent(studentId);
    }
}
