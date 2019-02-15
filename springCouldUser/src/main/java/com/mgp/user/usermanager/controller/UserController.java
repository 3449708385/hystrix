package com.mgp.user.usermanager.controller;

import com.mgp.user.usermanager.beans.User;
import com.mgp.user.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired(required = false)@Qualifier("userService")
    private UserService userService;

    @GetMapping(value = "/user2/getUser", produces="application/json")
    public List<User> getUser(String userName){
        return userService.getUserName(userName);
    }

    @GetMapping(value = "user/{userName}", produces="application/json")
    public List<User> getUserName(@PathVariable("userName") String userName){
        return userService.getUserName(userName);
    }


}
