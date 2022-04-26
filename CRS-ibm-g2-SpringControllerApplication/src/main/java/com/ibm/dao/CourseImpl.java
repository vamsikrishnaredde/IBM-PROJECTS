package com.ibm.dao;

import java.util.ArrayList;
import java.util.List;

import com.ibm.bean.Course;

public class CourseImpl implements CourseDAO {

    private static List<Course> courses;
    {
        courses = new ArrayList<>();
        courses.add(new Course(1, "Course 1", 10000,10,"prof1"));
    }
    @Override
    public void checkSeats(String cName) {
        // TODO Auto-generated method stub
        
        for(Course course:courses){
            if(course.getCourseName().equals(cName)){
                if(course.getSeats()>0){
                    System.out.println("Seats available "+course.getSeats());
                }
                else{
                    System.out.println("No seats available");
                }
            }
        }
        
        
    }

   

    @Override
    public void getDetails(String cName) {
        // TODO Auto-generated method stub
        for(Course course:courses){
            if(course.getCourseName().equals(cName)){
                System.out.println("Course Name: "+course.getCourseName());
                System.out.println("Course ID: "+course.getCourseId());
                System.out.println("Course Fees: "+course.getFees());
                System.out.println("Course Seats: "+course.getSeats());
                System.out.println("Course Professor: "+course.getProf());
            }
        }
        
    }

    @Override
    public void getStudents(String cName) {
        // TODO Auto-generated method stub
        
    }
    
}