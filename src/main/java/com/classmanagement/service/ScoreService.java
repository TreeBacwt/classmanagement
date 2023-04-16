package com.classmanagement.service;

import com.classmanagement.entity.Score;
import com.classmanagement.entity.ScoresVO;

import java.util.List;

public interface ScoreService {

    Integer insertScore(Score score);

    Integer updateScore(Score score);

    Integer deleteScore(Score score);

    List<Score> queryScoresBySubjectId(Integer subjectId, Integer page);

    List<Score> queryScoresByExaminationId(Integer examinationId, Integer page);

    List<Score> queryScoresByStudentNum(Integer studentNum, Integer page);

    Integer insertScores(List<Score> scores);

    List<ScoresVO> queryScoresOfExamination(Integer examinationId);

}
