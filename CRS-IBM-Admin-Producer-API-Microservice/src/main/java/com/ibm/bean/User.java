package com.ibm.bean;


import java.io.Serializable;

public class User implements Serializable {
    private long id;
    private String email;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public User(long id, String email, String password) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public User(){
        
    }
}