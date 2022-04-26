package com.ibm.restcontroller;

import java.util.List;

import javax.ws.rs.core.MediaType;
import com.ibm.bean.User;
import com.ibm.dao.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/users")
    public List getAllUsers() {
        return userDAO.list();
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.GET, value = "/user/{id}")
    @ResponseBody
    public ResponseEntity getUser(@PathVariable("id") Long id) {
        User user = userDAO.get(id);
        if (user == null) {
            return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.POST, value = "/post/users")
    @ResponseBody
    public ResponseEntity createUser(@RequestBody User user) {
        userDAO.create(user);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.PUT, value = "/put/users/{id}")
    @ResponseBody
    public ResponseEntity updateUser(@PathVariable("id") Long id,@RequestBody User user) {
        User p = userDAO.update(id, user);
        if(null == user){
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(p, HttpStatus.OK);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.DELETE, value = "/delete/users/{id}")
    @ResponseBody
    public ResponseEntity deleteUser(@PathVariable Long id) {
       if(null == userDAO.delete(id)){
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(id, HttpStatus.OK);
    }

}