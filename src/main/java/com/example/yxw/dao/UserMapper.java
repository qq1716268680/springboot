package com.example.yxw.dao;

import com.example.yxw.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectUserByName(String username);
}
