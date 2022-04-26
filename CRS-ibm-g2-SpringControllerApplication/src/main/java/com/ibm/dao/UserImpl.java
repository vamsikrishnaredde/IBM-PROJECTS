package com.ibm.dao;

import java.util.ArrayList;
import java.util.List;

import com.ibm.bean.User;

import org.springframework.stereotype.Repository;
@Repository
public class UserImpl implements UserDAO {

    private static List<User> users;
    {
        users = new ArrayList<>();
        users.add(new User(1, "User 1", "user1@gmail.com","3100001"));
        users.add(new User(2, "User 2", "user2@gmail.com","3100002"));
        users.add(new User(3, "User 3", "user3@gmail.com","3100003"));
    }
    @Override
    public List list() {
        //List all users
        return users;
    }

    @Override
    public User get(long id) {
        // get info of particular user
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User create(User user) {
        // create new user
        users.add(user);
        return user;
    }

    @Override
    public User update(Long id, User user) {
        // Update student info

            for(User p : users) {
                if(p.getId() == id) {
                    user.setId(p.getId());
                    users.remove(p);
                    users.add(user);
                    return p;
                }
            }
        return null;
    }

    @Override
    public Long delete(Long id) {
        // delete student info
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return id;
            }
        }
        return null;
    }

}