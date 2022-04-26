package com.ibm.dao;

// import java.util.ArrayList;
import java.util.List;

import com.ibm.bean.User;

import org.springframework.stereotype.Repository;
@Repository
public class UserImpl implements UserDAO {

    private static List<User> users;
    // {
    //     users = new ArrayList<>();
    //     users.add(new User(1, "User 1", "user1@gmail.com","3100001"));
    //     users.add(new User(2, "User 2", "user2@gmail.com","3100002"));
    //     users.add(new User(3, "User 3", "user3@gmail.com","3100003"));
    // }
    @Override
    public List<User> list() {
        //List all users
        return users;
    }

    @Override
    public User get(long id) {
        // get info of particular user
        
        return null;
    }

    @Override
    public User create(User user) {
        // create new user
        return null;
    }

    @Override
    public User update(Long id, User user) {
        // Update student info

           
        return null;
    }

    @Override
    public Long delete(Long id) {
        // delete student info
        
        return null;
    }

}
    