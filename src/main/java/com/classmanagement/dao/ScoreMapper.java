package com.classmanagement.dao;

import com.classmanagement.entity.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScoreMapper {

    Integer insertScore(Score score);

    Integer updateScore(Score score);

    Integer deleteScore(Score score);

    /*默认分页*/
    List<Score> queryScoresBySubjectId(Integer subjectId, Integer start, Integer limit);

    List<Score> queryScoresByExaminationId(Integer examinationId, Integer start, Integer limit);

    List<Score> queryScoresByStudentNum(Integer studentNum, Integer start, Integer limit);

    Integer insertScores(List<Score> scores);

    Score queryScoreBySubjectIdAndExaminationIdAndStudentNum(Integer subjectId, Integer examinationId, Integer studentNum);

}
