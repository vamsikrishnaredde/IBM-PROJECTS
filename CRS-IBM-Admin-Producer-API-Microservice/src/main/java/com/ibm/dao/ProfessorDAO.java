package com.ibm.dao;

import java.util.List;

// import com.ibm.bean.Professor;
import com.ibm.bean.RegisteredCourse;
import com.ibm.bean.Student;

public interface ProfessorDAO {
    public List<Student> list() ;
    public RegisteredCourse grade(RegisteredCourse registeredCourse);
}