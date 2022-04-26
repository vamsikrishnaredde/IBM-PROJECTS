package com.ibm.dao;

import java.util.List;

import com.ibm.bean.User;

public interface UserDAO {
    public List list();
    public User get(long id);
    public User create(User user);
    public User update(Long id, User user);
    public Long delete(Long id);
}