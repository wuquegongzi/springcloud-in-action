package com.iwufang.merge.service.impl;

import com.iwufang.merge.annotation.DS;
import com.iwufang.merge.mapper.UserMapper;
import com.iwufang.merge.model.UserInfo;
import com.iwufang.merge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @package: com.iwufang.merge.service.impl
 * @author: 陈明磊<swchenminglei@163.com>
 * @date: 2018/4/12 10:19
 * @ModificarionHistory who     when   what
 * --------------|------------------|--------------
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @DS(name = "test1")
    public UserInfo getUserInfo(UserInfo request) {
        return userMapper.getUserInfo(request);
    }
}

