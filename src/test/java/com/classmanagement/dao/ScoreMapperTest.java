package com.classmanagement.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ScoreMapperTest {
    @Autowired
    ScoreMapper scoreMapper;

    @Test
    void Test() {
        System.out.println(scoreMapper.queryScoreBySubjectIdAndExaminationIdAndStudentNum(1, 1, 1));
    }
}
