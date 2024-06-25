package com.example.university.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.university.model.Professor;
import com.example.university.model.ProfessorMapper;
import com.example.university.repository.ProfessorRepository;
@Service
public class ProfessorService implements ProfessorRepository {
    @Autowired
    private JdbcTemplate db;
    @Override
    public ArrayList<Professor> getProfessors() {
        List<Professor> li = db.query("select * from professor", new ProfessorMapper());
        ArrayList<Professor> professors = new ArrayList<>(li);
        return professors;
    }

    @Override
    public Professor getProfessorById(int professorId) {
        Professor professor = db.queryForObject("select * from professor where id=?",new ProfessorMapper(),professorId);
        return professor;
    }

    @Override
    public Professor addProfessor(Professor professor) {
        db.update("insert into professor values (?,?)", professor.getProfessorName(),professor.getDepartment());
        Professor added = db.queryForObject("select * from professor where name=? and department=?", new ProfessorMapper(),
        professor.getProfessorName(),professor.getDepartment());
        return added;
    }

    @Override
    public Professor updateProfessor(int professorId, Professor professor) {
        db.update("update professor set name=? where id=?", professor.getProfessorName(),professorId);
        db.update("update professor set department=? where id=?", professor.getDepartment(),professorId);
        return getProfessorById(professorId);
    }

    @Override
    public void deleteProfessor(int professorId) {
        db.update("delete from professor where id=?",professorId);
    }
    
}
