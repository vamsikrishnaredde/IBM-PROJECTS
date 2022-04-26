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
    // public static List<Professor> professors;
    // {
    //     professors = new ArrayList<>();
    //     professors.add(new Professor(1, "Professor 1", "prof1@gmail.com","100001"));
    //     professors.add(new Professor(2, "Professor 2", "prof2@gmail.com","100002"));
    //     professors.add(new Professor(3, "Professor 3", "prof3@gmail.com","100003"));
    // }
    @Override
    @Transactional
    public List<Student> list() {
        // List all professors
        String SQL = "SELECT * FROM student";
        List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
        return students;
    }

    @Override
    @Transactional
    public RegisteredCourse grade(RegisteredCourse registeredCourse) {
        //Assign grade to student's course
        String SQL = "INSERT INTO registerations (studentId, courseId, grade) VALUES (?, ?, ?)";
        jdbcTemplateObject.update(SQL,new Object[] {registeredCourse.getStudentId(), registeredCourse.getCourseId(), registeredCourse.getGrade()});
        return registeredCourse;
    }
    

    

}
    
