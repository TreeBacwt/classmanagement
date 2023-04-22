package com.classmanagement.controller;

import com.classmanagement.entity.Answer;
import com.classmanagement.service.AnswerService;
import com.classmanagement.service.ParentQuestionnaireService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/answer")
public class AnswerController {

    final AnswerService answerService;
    final ParentQuestionnaireService parentQuestionnaireService;

    public AnswerController(AnswerService answerService, ParentQuestionnaireService parentQuestionnaireService) {
        this.answerService = answerService;
        this.parentQuestionnaireService = parentQuestionnaireService;
    }

    @PostMapping("/add")
    public Result addAnswer(Answer answer) {
        Integer insertAnswer = answerService.insertAnswer(answer);
        if (insertAnswer == 1) {
            return Result.success("回答添加成功！", answer);
        } else return Result.fail("回答添加失败！");
    }

    @GetMapping("/list/{qid}")
    public Result queryAnswerByQuestionId(@PathVariable("qid") Integer questionId) {
        List<Answer> answers = answerService.queryAnswerByQuestionId(questionId);
        if (answers.size() != 0) {
            return Result.success("回答查询成功！", answers);
        } else return Result.fail("回答查询失败！");
    }

    @PostMapping("/submit")
    public Result submitAnswersOfQuestionnaire(@RequestBody List<Answer> answers) {
        Integer insertAnswers = answerService.insertAnswers(answers);
        if (insertAnswers != 0) {
            return Result.success("问卷提交成功！");
        } else {
            return Result.fail("问卷提交失败！");
        }
    }
}
