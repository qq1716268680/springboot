package com.example.yxw.dao;

import com.example.yxw.domain.Monster;

public interface MonsterMapper {
    int insert(Monster record);

    int insertSelective(Monster record);
}