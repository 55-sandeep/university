package com.example.university.model;

public class Professor {
    private int professorId;
    private String professorName;
    private String department;
    public Professor(int professorId,String professorName,String department){
        this.professorId=professorId;
        this.professorName=professorName;
        this.department=department;
    }
    public int getProfessorId(){
        return professorId;
    }
    public void setProfessorId(int professorId){
        this.professorId = professorId;
    }
    public String getProfessorName(){
        return professorName;
    }
    public void setProfessorName(String professorName){
        this.professorName=professorName;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department=department;
    }
}
