package com.classmanagement.service.impl;

import com.classmanagement.dao.ScoreMapper;
import com.classmanagement.dao.StudentMapper;
import com.classmanagement.entity.Score;
import com.classmanagement.entity.ScoresVO;
import com.classmanagement.entity.Student;
import com.classmanagement.service.ScoreService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    final ScoreMapper scoreMapper;
    final StudentMapper studentMapper;

    public ScoreServiceImpl(ScoreMapper scoreMapper, StudentMapper studentMapper) {
        this.scoreMapper = scoreMapper;
        this.studentMapper = studentMapper;
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

    @Override
    public List<ScoresVO> queryScoresOfExamination(Integer examinationId) {
        List<Student> students = studentMapper.queryAllStudents();
        List<ScoresVO> scoresVOS = new ArrayList<>();
        for (Student student : students) {
            Score english = scoreMapper.queryScoreBySubjectIdAndExaminationIdAndStudentNum(1, examinationId, student.getStudentNum());
            Score math = scoreMapper.queryScoreBySubjectIdAndExaminationIdAndStudentNum(2, examinationId, student.getStudentNum());
            Score computer = scoreMapper.queryScoreBySubjectIdAndExaminationIdAndStudentNum(3, examinationId, student.getStudentNum());
            Score chinese = scoreMapper.queryScoreBySubjectIdAndExaminationIdAndStudentNum(4, examinationId, student.getStudentNum());
            scoresVOS.add(new ScoresVO(student.getStudentName(), english.getScore(), math.getScore(), chinese.getScore(), computer.getScore()));
        }
        return scoresVOS;
    }

}
