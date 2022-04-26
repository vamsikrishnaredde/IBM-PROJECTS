package com.ibm.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.RegisteredCourse;


public class RegisteredCourseMapper implements RowMapper<RegisteredCourse>{

	@Override
	public RegisteredCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
        RegisteredCourse course = new RegisteredCourse();
            course.setStudentId(rs.getInt("studentId"));
            course.setCourseId(rs.getInt("courseId"));
            course.setGrade(rs.getString("grade"));
           
            return course;
    }
}