package com.ibm.restcontroller;

import java.util.List;

import javax.print.attribute.standard.MediaSize.NA;
import javax.ws.rs.core.MediaType;

import com.ibm.bean.RegisteredCourse;
import com.ibm.bean.Student;
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
    
    // @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.GET, value = "/student/{id}")
    // @ResponseBody
    // public ResponseEntity getStudent(@PathVariable("id") Long id) {
    //     Student student = studentDAO.get(id);
    //     if (student == null) {
    //         return new ResponseEntity("No Student found for ID " + id, HttpStatus.NOT_FOUND);
    //     }
    //     return new ResponseEntity(student, HttpStatus.OK);
    // }

    // @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.POST, value = "/post/students")
    // @ResponseBody
    // public ResponseEntity createStudent(@RequestBody Student student) {
    //     studentDAO.create(student);
    //     return new ResponseEntity(student, HttpStatus.OK);
    // }

    // @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.PUT, value = "/put/students/{id}")
    // @ResponseBody
    // public ResponseEntity updateStudent(@PathVariable("id") Long id,@RequestBody Student student) {
    //     Student p = studentDAO.update(id, student);
    //     if(null == student){
    //         return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
    //     }
    //     return new ResponseEntity(p, HttpStatus.OK);
    // }

    // @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.DELETE, value = "/delete/students/{id}")
    // @ResponseBody
    // public ResponseEntity deleteStudent(@PathVariable Long id) {
    //    if(null == studentDAO.delete(id)){
    //         return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
    //     }
    //     return new ResponseEntity(id, HttpStatus.OK);
    // }

    //=================================================================
    //register course
    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.POST, value = "/post/students/course/{id}/{id2}")
    @ResponseBody
    public ResponseEntity registerCourse(@RequestBody RegisteredCourse registeredCourse, @PathVariable int id,@PathVariable int id2) {
        studentDAO.register(id,id2);
        return new ResponseEntity(registeredCourse, HttpStatus.OK);
    }

    // Drop course
    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.DELETE, value = "/drop/students/course/{id}")
    @ResponseBody
    public ResponseEntity deleteCourse(@PathVariable int id) {
        studentDAO.drop(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }
    

    //fees
    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.GET, value = "/pay/students/fees/{id}")
    @ResponseBody
    public int payFees(@PathVariable int id) {
        return studentDAO.payFees(id);
        // return new ResponseEntity(x, HttpStatus.OK);
    }

    //get all registrations
    @RequestMapping("/students/registrations")
    public ResponseEntity getAllStudents() {
        return new ResponseEntity(studentDAO.list(), HttpStatus.OK);
    }

    //view grades
    @RequestMapping("/students/grades/{id}/{id2}")
    public ResponseEntity getStudentGrades(@PathVariable("id") int id, @PathVariable("id2") int id2) {
         String x=studentDAO.viewGrades(id,id2);
         return new ResponseEntity(x, HttpStatus.OK);
    }

}