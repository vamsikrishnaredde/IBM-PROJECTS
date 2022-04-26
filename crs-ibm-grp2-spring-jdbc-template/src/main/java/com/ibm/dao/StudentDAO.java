package com.ibm.dao;

import java.util.List;

import com.ibm.bean.Course;
import com.ibm.bean.Student;

public interface StudentDAO {
    // public List<Course> list();
    // public Student get(long id);
    // public Student create(Student student);
    // public Student update(Long id, Student student);
    // public Long delete(Long id);

    //new methods
    public Student register(Student student);
    public void drop(Integer id);
    public void addCourse(Course course);
    public String viewGrades(Integer id,Integer id2);
    public int payFees(Integer id);
    public List<Student> list();
}