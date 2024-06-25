package com.example.university.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.university.model.Professor;
import com.example.university.service.ProfessorService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class ProfessorController {
    @Autowired
    private ProfessorService ser;
    @GetMapping("/professors")
    public ArrayList<Professor> getProfessors(){
        return ser.getProfessors();
    }
    @GetMapping("/professors/{professorId}")
    public Professor getProfessorById(@PathVariable("professorId") int professorId) {
        return ser.getProfessorById(professorId);
    }
    @PostMapping("/professors")
    public Professor addProfessor(@RequestBody Professor professor){
        return ser.addProfessor(professor);
    }
    @PutMapping("/professors/{professorId}")
    public Professor updateProfessor(@PathVariable("professorId") int professorId,@RequestBody Professor professor){
        return ser.updateProfessor(professorId, professor);
    }
    @DeleteMapping("/professors/{professorId}")
    public void deleteProfessor(@PathVariable("professorId") int professorId){
        ser.deleteProfessor(professorId);
    }
}
