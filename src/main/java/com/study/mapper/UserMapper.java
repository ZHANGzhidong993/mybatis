package com.study.mapper;

import com.study.pojo.User;

/**
 * @author zhangzhidong
 * @create: 2019-02-20 00:25
 */
public interface UserMapper {

    void insertUser(User user);

    User getUser(Integer id);
}
