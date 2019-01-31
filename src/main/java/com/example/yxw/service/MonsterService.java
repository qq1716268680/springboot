package com.example.yxw.service;

import com.example.yxw.domain.Monster;

public interface MonsterService {
    int insert(Monster record);

    int insertSelective(Monster record);
}
