package com.classmanagement.service.impl;

import com.classmanagement.dao.ScoreMapper;
import com.classmanagement.dao.StudentMapper;
import com.classmanagement.dao.SubjectMapper;
import com.classmanagement.entity.Score;
import com.classmanagement.entity.ScoresVO;
import com.classmanagement.entity.Student;
import com.classmanagement.entity.Subject;
import com.classmanagement.service.ScoreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {

    final ScoreMapper scoreMapper;
    final StudentMapper studentMapper;
    final SubjectMapper subjectMapper;

    public ScoreServiceImpl(ScoreMapper scoreMapper, StudentMapper studentMapper, SubjectMapper subjectMapper) {
        this.scoreMapper = scoreMapper;
        this.studentMapper = studentMapper;
        this.subjectMapper = subjectMapper;
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
        List<Subject> subjects = subjectMapper.queryAllSubjects();
        List<ScoresVO> scoresVOS = new ArrayList<>();
        for (Student student : students) {
            Integer studentNum = student.getStudentNum();
            HashMap<String, Float> scores = new HashMap<>();
            for (Subject subject : subjects) {
                Integer subjectId = subject.getId();
                Score score = scoreMapper.queryScoreBySubjectIdAndExaminationIdAndStudentNum(subjectId, examinationId, studentNum);
                if (score != null) {
                    scores.put(subjectId.toString(), score.getScore());
                } else scores.put(subjectId.toString(), (float) -1);//无数据就为-1
            }
            ScoresVO scoresVO = new ScoresVO(student.getStudentName(), studentNum, 0, scores);
            scoresVOS.add(scoresVO);
        }
        return scoresVOS;
    }

    @Transactional
    @Override
    public Integer updateScores(List<Score> scores) {
        Integer result = 1;
        for (Score score : scores) {
            result *= scoreMapper.updateScore(score);
        }
        return result;
    }

}
