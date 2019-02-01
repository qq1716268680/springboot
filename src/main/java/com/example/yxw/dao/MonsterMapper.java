package com.example.yxw.dao;

import com.example.yxw.domain.Monster;

import java.util.List;

public interface MonsterMapper {
    int insert(Monster record);

    int insertSelective(Monster record);

    List listAll();
}