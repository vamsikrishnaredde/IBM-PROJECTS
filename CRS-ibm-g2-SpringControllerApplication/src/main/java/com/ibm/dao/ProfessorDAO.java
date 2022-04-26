package com.ibm.dao;

import java.util.List;

import com.ibm.bean.Professor;

public interface ProfessorDAO {
    public List list();
    public Professor get(long id);
    public Professor create(Professor professor);
    public Professor update(Long id, Professor professor);
    public Long delete(Long id);
}