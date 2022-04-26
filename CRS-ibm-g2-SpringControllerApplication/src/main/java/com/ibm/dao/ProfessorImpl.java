package com.ibm.dao;

import java.util.ArrayList;
import java.util.List;

import com.ibm.bean.Professor;

import org.springframework.stereotype.Repository;
@Repository
public class ProfessorImpl implements ProfessorDAO {

    private static List<Professor> professors;
    {
        professors = new ArrayList<>();
        professors.add(new Professor(1, "Professor 1", "prof1@gmail.com","100001"));
        professors.add(new Professor(2, "Professor 2", "prof2@gmail.com","100002"));
        professors.add(new Professor(3, "Professor 3", "prof3@gmail.com","100003"));
    }
    @Override
    public List list() {
        // List all professors
        return professors;
    }

    @Override
    public Professor get(long id) {
        // Get professor info
        for (Professor professor : professors) {
            if (professor.getId() == id) {
                return professor;
            }
        }
        return null;
    }

    @Override
    public Professor create(Professor professor) {
        // Add new professor
        professors.add(professor);
        return professor;
    }

    @Override
    public Professor update(Long id, Professor professor) {
        // update new professor info

            for(Professor p : professors) {
                if(p.getId() == id) {
                    professor.setId(p.getId());
                    professors.remove(p);
                    professors.add(professor);
                    return p;
                }
            }
        return null;
    }

    @Override
    public Long delete(Long id) {
        // delete a professor
        for (Professor professor : professors) {
            if (professor.getId() == id) {
                professors.remove(professor);
                return id;
            }
        }
        return null;
    }

}