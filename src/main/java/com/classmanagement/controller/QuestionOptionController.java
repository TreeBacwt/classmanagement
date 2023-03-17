package com.classmanagement.controller;

import com.classmanagement.entity.QuestionOption;
import com.classmanagement.service.QuestionOptionService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionOption")
public class QuestionOptionController {

    final QuestionOptionService questionOptionService;

    public QuestionOptionController(QuestionOptionService questionOptionService) {
        this.questionOptionService = questionOptionService;
    }

    @PostMapping("/add")
    public Result addQuestionOption(QuestionOption questionOption){
        Integer insertQuestionOption = questionOptionService.insertQuestionOption(questionOption);
        if (insertQuestionOption == 1) {
            return Result.success("题目选项创建成功！", questionOption);
        }else return Result.fail("题目选项创建失败！");
    }

    @GetMapping("/list/{qid}")
    public Result queryQuestionOptionByQuestionId(@PathVariable("qid") Integer questionId){
        List<QuestionOption> questionOptions = questionOptionService.queryQuestionOptionByQuestionId(questionId);
        if (questionOptions.size() != 0) {
            return Result.success("选项查询成功！", questionOptions);
        }else return Result.fail("选项查询失败！");
    }

    @PutMapping("/upd")
    public Result updateQuestionOption(QuestionOption questionOption){
        Integer updateQuestionOption = questionOptionService.updateQuestionOption(questionOption);
        if (updateQuestionOption == 1) {
            return Result.success("选项修改成功！", questionOption);
        }else return Result.fail("选项修改失败！");
    }

    @DeleteMapping("/delete")
    public Result deleteQuestionOptionById(Integer id){
        Integer deleteQuestionOptionById = questionOptionService.deleteQuestionOptionById(id);
        if (deleteQuestionOptionById == 1) {
            return Result.success("选项删除成功！");
        }else return Result.fail("选项删除失败！");
    }
}
