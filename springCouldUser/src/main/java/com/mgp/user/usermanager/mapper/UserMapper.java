package com.mgp.user.usermanager.mapper;

import com.mgp.user.usermanager.beans.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("userMapper")
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //@Select("select * from sys_user where username=#{username}")
    List<User> selectByName(Map<String,Object> map);
}