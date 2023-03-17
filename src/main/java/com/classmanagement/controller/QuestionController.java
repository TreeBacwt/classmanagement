package com.classmanagement.controller;

import com.classmanagement.entity.Question;
import com.classmanagement.service.QuestionService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/add")
    public Result addQuestion(Question question){
        Integer insertQuestion = questionService.insertQuestion(question);
        if (insertQuestion == 1) {
            return Result.success("题目创建成功！", question);
        }else return Result.fail("题目创建失败！");
    }

    @GetMapping("/list/{qid}")
    public Result queryQuestionsByQuestionnaireId(@PathVariable("qid") Integer questionnaireId){
        List<Question> questions = questionService.queryQuestionsByQuestionnaireId(questionnaireId);
        if (questions.size() != 0) {
            return Result.success("问卷题目查成功！", questions);
        }else return Result.fail("问卷题目查成功！");
    }

    @PutMapping("/upd")
    public Result updateQuestion(Question question){
        Integer updateQuestion = questionService.updateQuestion(question);
        if (updateQuestion == 1) {
            return Result.success("题目修改成功！", question);
        }else return Result.fail("题目修改成功！");
    }

    @DeleteMapping("/delete")
    public Result deleteQuestionById(Integer id){
        Integer deleteQuestionById = questionService.deleteQuestionById(id);
        if (deleteQuestionById == 1) {
            return Result.success("题目删除成功！");
        }else return Result.fail("题目删除失败！");
    }
}
