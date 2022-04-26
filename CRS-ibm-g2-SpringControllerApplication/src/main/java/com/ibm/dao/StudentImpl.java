package com.ibm.dao;

import java.util.ArrayList;
import java.util.List;

import com.ibm.bean.Course;
import com.ibm.bean.RegisteredCourse;
import com.ibm.bean.Student;

import org.springframework.stereotype.Repository;
@Repository
public class StudentImpl implements StudentDAO {

   private static List<RegisteredCourse> registrations;
   {
       registrations = new ArrayList<RegisteredCourse>();
       registrations.add(new RegisteredCourse(1,1,"A+"));
   }
    // List<ArrayList> students = new ArrayList<>();
    // {
    //     //student id,courseid, grades
    //     new ArrayList(Arrays.asList(1,1,"A+"));
    //     new ArrayList(Arrays.asList(2,2,"B+"));
    // }
    private static List<Student> students;
	{
		students = new ArrayList<Student>();
		students.add(new Student(101, "John", "Doe@nk.com", "9843783428"));
	}

    private static List<Course> courses;
    {
        courses = new ArrayList<Course>();
        // courses.add(new Course(Arrays.asList(1,"course1",1000,10,"prof1")));
        courses.add(new Course(1, "course1", 1000, 10, "prof1"));
    }


    @Override
    public void register(int id,int stdId) {
        // TODO Auto-generated method stub
        for(Course c:courses){
            if(c.getCourseId()==id && c.getSeats()>0){
                // ((Course) registrations).setCourseId(id);
                // ((RegisteredCourse) registrations).setStudentId(stdId);
                registrations.add(new RegisteredCourse(id,stdId,"A+"));
            }
            else{
                System.out.println("No seats available");
            }
        }
        
    }

    @Override
    public void drop(int id) {
        // TODO Auto-generated method stub
        for(RegisteredCourse c:registrations){
            // int maxSeats =10;
            if(c.getCourseId()==id){
                registrations.remove(c);
                
            }
            
            else System.out.println("Error");
        }
        
    }

    @Override
    public String viewGrades(int id,int stdId) {
        // TODO Auto-generated method stub
        for(RegisteredCourse c:registrations){
            if(c.getCourseId()==id && c.getStudentId()==stdId){
                // System.out.println("Grades: "+c.get(2));
                 String s = "Grades for courseId"+c.getCourseId()+": "+c.getGrade();
                 return s;
            }
            // else System.out.println("Error");
            else return "Error";
        }
        return null;
        
    }

    @Override
    public int payFees(int id) {
        // TODO Auto-generated method stub
        for(Course c:courses){
            if(c.getCourseId()==id ){
                return (c.getFees());
            }

        }
        return 0;
    }

    
    @Override
    public List list() {
        // TODO Auto-generated method stub
        return registrations;
        
    }

    @Override
    public void addCourse(int id, int id2) {
        //get course id

        
    }




    
}