package com.example.yxw.dao;

import com.example.yxw.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectUserByName(@Param(value = "username") String username);
}
