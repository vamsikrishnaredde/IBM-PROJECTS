package com.ibm.dao;

public interface CourseDAO {
    public void checkSeats(String cName);
    public void getStudents(String cName);
    public void getDetails(String cName);
}
