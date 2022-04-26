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
    public void register(int id,int std_id);
    public void drop(int id);
    public void addCourse(int id,int id2);
    public String viewGrades(int id,int id2);
    public int payFees(int id);
    public List list();
}