package com.ibm.restcontroller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.ibm.bean.Course;
// import com.ibm.bean.RegisteredCourse;
import com.ibm.bean.Student;
import com.ibm.bean.User;
import com.ibm.dao.StudentDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentDAO studentDAO;
    
    @RequestMapping("/students")
	public List getStudent() {

		return studentDAO.list();
	}

    //======================================================================================================================
    /** 
     * register RESTendpoint is used by student to register themselves
     * @param student
     * @return new student details
     * url:/course/registrationStudent
     * description: register student
     */
    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.POST, value = "/course/registrationStudent")
    @ResponseBody
    public ResponseEntity<Student> registerCourse(@RequestBody Student student) {
        studentDAO.register(student);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    /** 
     * deleteCourse RESTendpoint is used by student to drop the course
     * @param id
     * @return id of course dropped
     * url:/drop/students/course/{id}
     * description: drop the course
     */
    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.DELETE, value = "/drop/students/course/{id}")
    @ResponseBody
    public ResponseEntity<Integer> deleteCourse(@PathVariable int id) {
        studentDAO.drop(id);
        return new ResponseEntity<Integer>(id, HttpStatus.OK);
    }
    

    /** 
     * payFees RESTendpoint is used by student to view/pay the course fees
     * @param id
     * @return fees amount
     * url:/pay/students/fees/{id}
     * description: view the fees of the registered course
     */
    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.GET, value = "/pay/students/fees/{id}")
    @ResponseBody
    public int payFees(@PathVariable int id) {
        return studentDAO.payFees(id);
    }

    /** 
     * getAllStudents RESTendpoint is used to view list of students
     * @return List of students
     * url:/students/registrations
     * description: view list of registered students
     */
    @RequestMapping("/students/registrations")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<List<Student>>(studentDAO.list(), HttpStatus.OK);
    }

    /** 
     * getStudentGrades RESTendpoint is used by Student to view course grades
     * @param id, id2
     * @return String of grades
     * url:/students/grades/{id}/{id2}
     * description: view grades of a course from database
     */
   @RequestMapping("/students/grades/{id}/{id2}")
   public ResponseEntity<String> getStudentGrades(@PathVariable("id") int id, @PathVariable("id2") int id2) {
        String x="Student id:"+id+"\n"+"Course Grade:"+studentDAO.viewGrades(id,id2);
        return new ResponseEntity<String>(x, HttpStatus.OK);
   }

    /** 
     * addCourse RESTendpoint is used by Student to add course to his/her list of courses
     * @param Course
     * @return newly added course
     * url:/course/add
     * description: adds new course to the database table course
     */
    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.POST, value = "/course/add")
    @ResponseBody
    public ResponseEntity<Course> addCourse(@RequestBody Course Course) {
        studentDAO.addCourse(Course);
        return new ResponseEntity<Course>(Course, HttpStatus.OK);
    }

    /** 
     * addProfile RESTendpoint is used by Student to add email and password to the database.
     * @param user
     * @return the updated user
     * url:/users
     * description: update username and password
     */
    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.POST, value = "/users")
    @ResponseBody
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        studentDAO.addProfile(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


}


 
