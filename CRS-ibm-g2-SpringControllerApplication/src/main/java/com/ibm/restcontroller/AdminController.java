package com.ibm.restcontroller;

import java.util.List;

import javax.ws.rs.core.MediaType;
import com.ibm.bean.Admin;
import com.ibm.dao.AdminDAO;

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
public class AdminController {
    @Autowired
    private AdminDAO adminDAO;

    @RequestMapping("/admins")
    public List getAllAdmins() {
        return adminDAO.list();
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.GET, value = "/admin/{id}")
    @ResponseBody
    public ResponseEntity getAdmin(@PathVariable("id") Long id) {
        Admin admin = adminDAO.get(id);
        if (admin == null) {
            return new ResponseEntity("No Admin found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(admin, HttpStatus.OK);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.POST, value = "/post/admins")
    @ResponseBody
    public ResponseEntity createAdmin(@RequestBody Admin admin) {
        adminDAO.create(admin);
        return new ResponseEntity(admin, HttpStatus.OK);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.PUT, value = "/put/admins/{id}")
    @ResponseBody
    public ResponseEntity updateAdmin(@PathVariable("id") Long id,@RequestBody Admin admin) {
        Admin p = adminDAO.update(id, admin);
        if(null == admin){
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(p, HttpStatus.OK);
    }

    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.DELETE, value = "/delete/admins/{id}")
    @ResponseBody
    public ResponseEntity deleteAdmin(@PathVariable Long id) {
       if(null == adminDAO.delete(id)){
            return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(id, HttpStatus.OK);
    }

}