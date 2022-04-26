package com.ibm.dao;

// import java.util.ArrayList;
import java.util.List;
import com.ibm.bean.RegisteredCourse;
import com.ibm.bean.Student;
import com.ibm.mapper.StudentMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class ProfessorImpl implements ProfessorDAO {
    @Autowired
    private JdbcTemplate jdbcTemplateObject;
    /** 
     * list method is used by ProfessorController to get all student details
     * @return list of student details
     * description: gets list of student details
     */
    @Override
    @Transactional
    public List<Student> list() {
        // List all professors
        String SQL = "SELECT * FROM student";
        List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
        return students;
    }
    
    /** 
     * grade method is used by adminController to assign grade to a student
     * @return registeredCourse
     * @param registeredCourse
     * description: assign a grade to student's course
     */
    @Override
    @Transactional
    public RegisteredCourse grade(RegisteredCourse registeredCourse) {
        //Assign grade to student's course
        String SQL = "INSERT INTO registerations (studentId, courseId, grade) VALUES (?, ?, ?)";
        jdbcTemplateObject.update(SQL,new Object[] {registeredCourse.getStudentId(), registeredCourse.getCourseId(), registeredCourse.getGrade()});
        return registeredCourse;
    }
    

    

}
    
