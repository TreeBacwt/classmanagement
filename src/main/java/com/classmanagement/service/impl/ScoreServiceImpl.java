package com.classmanagement.service.impl;

import com.classmanagement.dao.ScoreMapper;
import com.classmanagement.entity.Score;
import com.classmanagement.service.ScoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    final ScoreMapper scoreMapper;

    public ScoreServiceImpl(ScoreMapper scoreMapper) {
        this.scoreMapper = scoreMapper;
    }

    @Override
    public Integer insertScore(Score score) {
        return scoreMapper.insertScore(score);
    }

    @Override
    public Integer updateScore(Score score) {
        return scoreMapper.updateScore(score);
    }

    @Override
    public Integer deleteScore(Score score) {
        return scoreMapper.deleteScore(score);
    }

    @Override
    public List<Score> queryScoresBySubjectId(Integer subjectId, Integer page) {
        return scoreMapper.queryScoresBySubjectId(subjectId, (page - 1) * 10, 10);
    }

    @Override
    public List<Score> queryScoresByExaminationId(Integer examinationId, Integer page) {
        return scoreMapper.queryScoresByExaminationId(examinationId, (page - 1) * 10, 10);
    }

    @Override
    public List<Score> queryScoresByStudentNum(Integer studentNum, Integer page) {
        return scoreMapper.queryScoresByStudentNum(studentNum, (page - 1) * 10, 10);
    }

    @Override
    public Integer insertScores(List<Score> scores) {
        return scoreMapper.insertScores(scores);
    }

}
