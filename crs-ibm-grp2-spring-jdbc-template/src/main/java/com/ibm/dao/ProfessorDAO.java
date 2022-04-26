package com.ibm.dao;

import java.util.List;

import com.ibm.bean.Professor;
import com.ibm.bean.RegisteredCourse;

public interface ProfessorDAO {
    public List<Professor> list() ;
    
    // public Professor create(Professor professor);
    // public Professor update(Long id, Professor professor);
    // public Long delete(Long id);
    public RegisteredCourse grade(RegisteredCourse registeredCourse);
}