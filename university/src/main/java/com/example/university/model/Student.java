package com.example.university.model;

public class Student {
    private int studentId;
    private String studentName;
    private String email;
    public Student(int studentId,String studentName,String email){
        this.studentId=studentId;
        this.studentName=studentName;
        this.email=email;
    }
    public int getStudentId(){
        return studentId;
    }
    public void setStudentId(int studentId){
        this.studentId=studentId;
    }
    public String getStudentName(){
        return studentName;
    }
    public void setStudentName(String studentName){
        this.studentName=studentName;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
}
