package com.ibm.bean;

import java.io.Serializable;

public class Admin implements Serializable {
    private long id;
    private String name;
    private String email;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return password;
    }

    public void setMobile(String password) {
        this.password = password;
    }

    
    public Admin(long id, String name, String email, String password) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Admin(){
        
    }
}