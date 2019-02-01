package com.example.yxw.service.impl;

import com.example.yxw.dao.MonsterMapper;
import com.example.yxw.domain.Monster;
import com.example.yxw.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonsterServiceImpl  implements MonsterService{

    @Autowired
    private MonsterMapper monsterMapper;

    @Override
    public int insert(Monster record) {
        return monsterMapper.insert(record);
    }

    @Override
    public int insertSelective(Monster record) {
        return 0;
    }

    @Override
    public List listAll() {
        return monsterMapper.listAll();
    }
}
