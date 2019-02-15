package com.mgp.usermanager.service;

import com.mgp.usermanager.beans.User;

import java.util.List;

public interface UserService {

    public List<User> getUserInfo(String name);
}
