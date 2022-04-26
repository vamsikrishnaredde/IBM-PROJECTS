package com.ibm.dao;

// import java.util.ArrayList;
import java.util.List;

import com.ibm.bean.Admin;
import com.ibm.bean.Professor;
import com.ibm.bean.Student;
import com.ibm.bean.User;
import com.ibm.mapper.AdminMapper;
import com.ibm.mapper.StudentMapper;
import com.ibm.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class AdminImpl implements AdminDAO {

    @Autowired
    private JdbcTemplate jdbcTemplateObject;
    
    /** 
     * list method is used by AdminController to list all admins
     * @return list of admins
     * description: list all admins
     */
    @Override
    @Transactional
    public List<Admin> list() {
        String SQL = "select * from admin";
            List <Admin> admins = jdbcTemplateObject.query(SQL, 
                                    new AdminMapper());
                    
            return admins;
    }
    
    /** 
     * create method is used by adminController to create an admin
     * @return admin
     * @param admin
     * description: creates new admin
     */
    @Override
    @Transactional
    public Admin create(Admin admin) {
        String SQL = "insert into admin (name, email, password ) values ( ?, ?, ?)";
		      
        jdbcTemplateObject.update( SQL,new Object[] {admin.getName(),admin.getEmail(),admin.getPassword()});
        System.out.println("Created Record Name = " + admin.getName());
       
        return admin;
    }
    
    /** 
     * update method is used by adminController to update an admin info
     * @return admin
     * @param admin
     * description: updates admin info
     */
    @Override
    @Transactional
    public Admin update(Admin admin) {

        String SQL = "update admin set password = ? where id = ?";
        jdbcTemplateObject.update(SQL, new Object[]{admin.getName(),admin.getPassword()});
        System.out.println("Updated Record with ID = " + admin.getId() );
        return admin;
    }
    
    /** 
     * delete method is used by adminController to delete an admin profile
     * @return admin
     * @param id
     * description: delete an admin 
     */
    @Override
    public Long delete(Long id) {
        String SQL = "delete from admin where id = ?";
		      jdbcTemplateObject.update(SQL, id);
		      System.out.println("Deleted Record with ID = " + id );
		      return 0L;
    }
    
    /** 
     * listStudents method is used by adminController to get student list
     * @return list of students
     * description: get a list of students
     */
    @Override
    @Transactional
    public List<Student> listStudents() {
        // list all students
            String SQL = "select * from student";
            List <Student> students = jdbcTemplateObject.query(SQL, 
                                    new StudentMapper());
                    
            return students;
    }
    
    /** 
     * deleteStudent method is used by adminController to delete student info
     * @param id
     * description: delete student info
     */
    @Override
    public void deleteStudent(Integer id) {
        // Delete student profile
        String SQL = "delete from student where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
        
    }
    
    /** 
     * addProfessor method is used by adminController to add a professor
     * @return professor details
     * @param professor
     * description: creates a professor profile
     */
    @Override
    @Transactional
    public Professor addProfessor(Professor professor) {
        // Add professor profile
        String SQL = "insert into admin (id, name, email, password ) values (?, ?, ?, ?)";
		      
        jdbcTemplateObject.update( SQL,new Object[] {professor.getId(),professor.getName(),professor.getEmail(),professor.getMobile()});
        System.out.println("Created Record Name = " + professor.getName());
       
        return professor;
    }
    
    /** 
     * deleteProfessor method is used by adminController to delete a professor
     * @param id
     * description: updates admin info
     */
    @Override
    public void deleteProfessor(Integer id) {
        String SQL = "delete from professor where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
        
    }
    
    /** 
     * addProfileMain method is used by adminController to create credentials
     * @return user credentials
     * @param user
     * description: creates credential
     */
    @Override
    public User addProfileMain(User user) {
        String SQL = "insert into user (id, email, password) values (?, ?, ?)";
        jdbcTemplateObject.update( SQL,new Object[] {user.getId(),user.getEmail(),user.getPassword()});
        return user;
    }
    
    /** 
     * getAllUsers method is used by adminController to get list of user credentials
     * @return list of user credentials
     * description: get list of user credentials
     */
    @Override
    public List<User> getAllUsers() {
        String SQL = "select * from user";
            List <User> users = jdbcTemplateObject.query(SQL, 
                                    new UserMapper());
                    
            return users;
    }

    

}
    