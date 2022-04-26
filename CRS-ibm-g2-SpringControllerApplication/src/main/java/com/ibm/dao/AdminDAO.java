package com.ibm.dao;

import java.util.List;

import com.ibm.bean.Admin;

public interface AdminDAO {
    public List list();
    public Admin get(long id);
    public Admin create(Admin admin);
    public Admin update(Long id, Admin admin);
    public Long delete(Long id);
}