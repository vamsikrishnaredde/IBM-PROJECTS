package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.User;


public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		  User user = new User();
		   user.setId(rs.getInt("id"));
		  user.setEmail(rs.getString("email"));
		  user.setPassword(rs.getString("password"));
		  
	      return user;
		
	}

}