package com.mgp.user.usermanager.service.impl;

import com.mgp.user.usermanager.beans.User;
import com.mgp.user.usermanager.mapper.UserMapper;
import com.mgp.user.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired(required = false) @Qualifier("userMapper")
    private UserMapper userMapper;

    @Override
    public List<User> getUserName(String names) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("username",names);
        return userMapper.selectByName(map);
    }
}
