package com.classmanagement.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AffairMapperTest {

    @Autowired
    AffairMapper affairMapper;

    @Test
    void query(){
        System.out.println(affairMapper.queryAffairsByAffairNameKeyWordLimit("节", 1, 1));
    }
}
