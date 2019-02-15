package com.mgp.usermanager.controller;

import com.mgp.usermanager.beans.User;
import com.mgp.usermanager.service.UserService;
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

    @GetMapping(value="userInfo/{username}", produces = "application/json")
    public List<User> userInfo(@PathVariable("username") String username){
        return  userService.getUserInfo(username);
    }

}
