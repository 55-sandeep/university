package com.example.university.model;

public class Course {
    private int courseId;
    private String courseName;
    private int credicts;
    private int professorId;
    public Course(int courseId,String courseName,int credicts,int professorId){
        this.courseId=courseId;
        this.courseName=courseName;
        this.credicts=credicts;
        this.professorId=professorId;
    }
    public int getCourseId(){
        return courseId;
    }
    public void setCourseId(int courseId){
        this.courseId = courseId;
    }
    public String getCourseName(){
        return courseName;
    }
    public void setCourseName(String courseName){
        this.courseName=courseName;
    }
    public int getCredits(){
        return credicts;
    }
    public void setCredits(int credicts){
        this.credicts= credicts;
    }
    public int getProfessorId(){
        return professorId;
    }
    public void setProfessorId(int professorId){
        this.professorId=professorId;
    }
}
