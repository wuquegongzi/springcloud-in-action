package com.iwufang.merge.mapper;

import com.iwufang.merge.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    UserInfo getUserInfo(UserInfo request);
}
