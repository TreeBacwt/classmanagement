package com.classmanagement.controller;

import com.classmanagement.entity.Score;
import com.classmanagement.entity.ScoresVO;
import com.classmanagement.service.ScoreService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/score")
public class ScoreController {

    final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping("/add")
    public Result addScore(Score score) {
        Integer insertScore = scoreService.insertScore(score);
        if (insertScore == 1) {
            return Result.success("添加成绩成功！", score);
        } else return Result.fail("添加成绩失败！");
    }

    @PutMapping("/upd")
    public Result updateScore(Score score) {
        Integer updateScore = scoreService.updateScore(score);
        if (updateScore == 1) {
            return Result.success("成绩修改成功！", score);
        } else return Result.fail("成绩修改失败！");
    }

    @DeleteMapping("/delete")
    public Result deleteScore(Score score) {
        Integer deleteScore = scoreService.deleteScore(score);
        if (deleteScore == 1) {
            return Result.success("成绩删除成功！");
        } else return Result.fail("成绩删除失败！");
    }

    @GetMapping("/listBySubject/{subjectId}/{page}")
    public Result queryScoresBySubjectId(@PathVariable("subjectId") Integer subjectId, @PathVariable("page") Integer page) {
        List<Score> scores = scoreService.queryScoresBySubjectId(subjectId, page);
        if (scores.size() != 0) {
            return Result.success("第" + page + "页成绩查询成功！", scores);
        } else return Result.fail("没有相关数据！");
    }

    @GetMapping("/listByExamination/{examinationId}/{page}")
    public Result queryScoresByExaminationId(@PathVariable("examinationId") Integer examinationId, @PathVariable("page") Integer page) {
        List<Score> scores = scoreService.queryScoresByExaminationId(examinationId, page);
        if (scores.size() != 0) {
            return Result.success("第" + page + "页成绩查询成功！", scores);
        } else return Result.fail("没有相关数据！");
    }

    @GetMapping("/listByStudent/{studentNum}/{page}")
    public Result queryScoresByStudentNum(@PathVariable("studentNum") Integer studentNum, @PathVariable("page") Integer page) {
        List<Score> scores = scoreService.queryScoresByStudentNum(studentNum, page);
        if (scores.size() != 0) {
            return Result.success("第" + page + "页成绩查询成功！", scores);
        } else return Result.fail("没有相关数据！");
    }

    @PostMapping("/addMulti")
    public Result addScores(@RequestBody List<Score> scores) {
        Integer insertScores = scoreService.insertScores(scores);
        if (insertScores != 0) {
            return Result.success("批量添加成绩成功！");
        } else return Result.fail("批量添加成绩失败");
    }

    @GetMapping("/getScoresOfExam/{examId}")
    public Result getScoresOfExamination(@PathVariable Integer examId) {
        List<ScoresVO> scoresVO = scoreService.queryScoresOfExamination(examId);
        if (scoresVO.size() != 0) {
            return Result.success("本次考试成绩查询成功！", scoresVO);
        } else return Result.fail("本次考试成绩暂无数据！");
    }

    @PutMapping("/updMulti")
    public Result updateMultiScores(@RequestBody List<Score> scores){
        Integer updateScores = scoreService.updateScores(scores);
        if (updateScores!=0) {
            return Result.success("编辑分数成功！");
        }else return Result.fail("编辑分数失败！");
    }

}
