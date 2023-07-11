package com.iwufang.merge.controller;

import com.iwufang.merge.model.UserInfo;
import com.iwufang.merge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/test", method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json;charset=UTF-8")
    public UserInfo login(@RequestBody UserInfo request){
        UserInfo userInfoResponse = new UserInfo();
        userInfoResponse = userService.getUserInfo(request);
        return userInfoResponse;
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public UserInfo login(@RequestParam String username, @RequestParam String password){
        UserInfo request = new UserInfo();
        request.setUsername("test");
        request.setPassword("123456");
        UserInfo userInfoResponse = userService.getUserInfo(request);
        System.out.println(userInfoResponse.getId());
        return userInfoResponse;
    }
}
