package com.example.yxw.service;

import com.example.yxw.domain.Monster;

import java.util.List;

public interface MonsterService {
    int insert(Monster record);

    int insertSelective(Monster record);

    List listAll();
}
