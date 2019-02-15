package com.mgp.usermanager.service.impl.UserServiceImpl;

import com.mgp.usermanager.beans.User;
import com.mgp.usermanager.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired(required = false)@Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getUserInfoError") //进行容错处理, 出现异常，容错保护就会调用
    public List<User> getUserInfo(String name) {
        List<User> userList2 = new ArrayList<>();
        String serverName = "usermanager";  //再框架里面可以访问，外面不行
        String url = "http://"+serverName+":8077/user/mgp";
        List<User> userList = restTemplate.getForObject(url, List.class);//这是服务间相互调用
        if(userList.size()==4){
            userList2.add(userList.get(0));
            //int c = 1/0;//出现异常，容错保护就会调用
            return userList2;
        }
        return userList2;
    }

    //getUserInfo 失败执行的方法
    private List<User> getUserInfoError(String name){
        List<User> userList = new ArrayList<User>();
        User user = new User();
        user.setId(0L);
        user.setNickname("nickname");
        user.setUsername("username");
        userList.add(user);
        return userList;
    }
}
