package com.ibm.dao;

import java.util.List;

import com.ibm.bean.Admin;
import com.ibm.bean.Professor;
import com.ibm.bean.Student;
import com.ibm.bean.User;

public interface AdminDAO {
    //Admin management
    public List<Admin> list();
    public Admin create(Admin admin);
    public Admin update(Admin admin);
    public Long delete(Long id);

    //Student management
    public List<Student> listStudents();
    public void deleteStudent(Integer id);

    //Professor management
    public Professor addProfessor(Professor professor);
    public void deleteProfessor(Integer id);

    //Profile management
    public User addProfileMain(User user);
    public List<User> getAllUsers();

}