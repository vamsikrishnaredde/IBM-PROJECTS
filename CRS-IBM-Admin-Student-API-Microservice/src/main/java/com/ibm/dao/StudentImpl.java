package com.ibm.dao;

import java.util.ArrayList;
import java.util.List;

import com.ibm.bean.Catalog;
import com.ibm.bean.Course;
import com.ibm.bean.RegisteredCourse;
import com.ibm.bean.Student;
import com.ibm.bean.User;
import com.ibm.mapper.CatalogMapper;
import com.ibm.mapper.RegisteredCourseMapper;
import com.ibm.mapper.StudentMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class StudentImpl implements StudentDAO {

  


   Logger logger = LoggerFactory.getLogger(StudentImpl.class);

   @Autowired
   private JdbcTemplate jdbcTemplateObject;
   
   /** 
    * register method is used by RESTController to register the student 
    * @param student
    * @return new student info
    * description: register new student
    */
   @Override
    @Transactional
    public Student register(Student student) {
        // Register student in the database
        
        
        String SQL = "insert into student (id, name, email, mobile) values (?, ?, ?, ?)";
            
        jdbcTemplateObject.update(SQL, new Object[]{student.getId(), student.getName(), student.getEmail(), student.getMobile()});
        System.out.println("Created Record Name with studentId = " + student.getId());
    
        return student;
        
    }

   /** 
    * addCourse method is used by StudentController to add the course 
    * @param course
    * description: add new course into student profile
    */
    @Override
    public void addCourse(Course course) {

        String SQL = "insert into course (studentId, courseId) values (?, ?)";
        jdbcTemplateObject.update(SQL, new Object[]{course.getStudentId(), course.getCourseId()});
        
    }
    
    /** 
     * payFees method is used by StudentController to display fees
     * @param id
     * @return fees
     * description: show/pay the fees of the course
     */
    @Override
    public int payFees(Integer id) {
        // Pay fees for course
        
        String SQL = "select fees from catalog where id = ?";
            Catalog course = jdbcTemplateObject.queryForObject(SQL, 
                            new Object[]{id}, new CatalogMapper());
            logger.debug("value", jdbcTemplateObject.queryForObject(SQL, 
                            new Object[]{id}, new CatalogMapper()));;
            logger.debug("value of emp-->" +course.toString());
            return course.getFees();
           
    }
    
    /** 
     * viewGrades method is used by StudentController to view the assigned grades
     * @param courseid and studentid
     * @return course grade
     * description: shows the grade for a course selected by a student
     */
    @Override
    public String viewGrades(Integer id, Integer stdId) {
        // view grades for course
        String SQL = "select * from registerations where course_id = ? and student_id = ?";
            RegisteredCourse course = jdbcTemplateObject.queryForObject(SQL, 
                            new Object[]{id,stdId}, new RegisteredCourseMapper());
            
            logger.debug("value", jdbcTemplateObject.queryForObject(SQL, 
                            new Object[]{id,stdId}, new RegisteredCourseMapper()));;
            logger.debug("value of fees-->" +course.toString());
            return course.getGrade();
          
    }
    
    /** 
     * list method is used by StudentController to show all students
     * @return students
     * description: shows the list of students
     */
    @Override
    @Transactional
    public List<Student> list() {
        // list all students
            String SQL = "select * from student";
            List <Student> students = jdbcTemplateObject.query(SQL, 
                                    new StudentMapper());
                    logger.debug("in debug");
            return students;
    }

    
    /** 
     * drop method is used by StudentController to drop the student from a registered course
     * @param id
     * description: drops the student from a registered course
     */
    @Override
    public void drop(Integer id) {
        // TODO Auto-generated method stub
        
            String SQL = "delete from student where id = ?";
            jdbcTemplateObject.update(SQL, id);
            System.out.println("Deleted Record with ID = " + id );
            return;
    }
    
    /** 
     * addProfile method is used by StudentController to create new profile credentials
     * @param user
     * description: create new userid and password (email will be used as userid)
     */
    @Override
    @Transactional
    public User addProfile(User user) {
        // Give username and password to a user
        String SQL = "insert into user (email, password) values (?, ?, ?)";
        jdbcTemplateObject.update( SQL,new Object[] {user.getEmail(),user.getPassword()});
        return null;
    }

  






    
}
    