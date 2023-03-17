package com.classmanagement.controller;

import com.classmanagement.entity.Answer;
import com.classmanagement.service.AnswerService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/add")
    public Result addAnswer(Answer answer){
        Integer insertAnswer = answerService.insertAnswer(answer);
        if (insertAnswer == 1) {
            return Result.success("回答添加成功！", answer);
        }else return Result.fail("回答添加失败！");
    }

    @GetMapping("/list/{qid}")
    public Result queryAnswerByQuestionId(@PathVariable("qid") Integer questionId){
        List<Answer> answers = answerService.queryAnswerByQuestionId(questionId);
        if (answers.size() != 0) {
            return Result.success("回答查询成功！", answers);
        }else return Result.fail("回答查询失败！");
    }
}
