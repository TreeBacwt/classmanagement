package com.classmanagement.controller;

import com.classmanagement.entity.Questionnaire;
import com.classmanagement.entity.QuestionnaireWithQuestionsAndOptionsVO;
import com.classmanagement.service.QuestionnaireService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

    final QuestionnaireService questionnaireService;

    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @PostMapping("/add")
    public Result addQuestionnaire(Questionnaire questionnaire) {
        Integer insertQuestionnaire = questionnaireService.insertQuestionnaire(questionnaire);
        if (insertQuestionnaire == 1) {
            return Result.success("问卷创建成功！", questionnaire);
        } else return Result.fail("问卷创建失败！");
    }

    @GetMapping("/queryById/{id}")
    public Result queryQuestionnaireById(@PathVariable("id") Integer id) {
        Questionnaire questionnaire = questionnaireService.queryQuestionnaireById(id);
        if (questionnaire != null) {
            return Result.success("问卷查询成功！", questionnaire);
        } else return Result.fail("问卷查询失败！");
    }

    @PutMapping("/upd")
    public Result updateQuestionnaire(Questionnaire questionnaire) {
        Integer updateQuestionnaire = questionnaireService.updateQuestionnaire(questionnaire);
        if (updateQuestionnaire == 1) {
            return Result.success("问卷修改成功！", questionnaire);
        } else return Result.fail("问卷修改失败！");
    }

    @DeleteMapping("/delete")
    public Result deleteQuestionnaireById(Integer id) {
        Integer deleteQuestionnaireById = questionnaireService.deleteQuestionnaireById(id);
        if (deleteQuestionnaireById == 1) {
            return Result.success("问卷删除成功！");
        } else return Result.fail("问卷删除失败！");
    }

    @GetMapping("/list/{page}")
    public Result queryQuestionnairesByPageSize10(@PathVariable("page") Integer page) {
        List<Questionnaire> questionnaires = questionnaireService.queryQuestionnairesLimitIn10(page);
        if (questionnaires.size() != 0) {
            return Result.success("第" + page + "页问卷查询成功！", questionnaires);
        } else return Result.fail("没有相关数据！");
    }

    @PostMapping("/add/questionnaireWithQuestionsAndOptions")
    public Result addQuestionnaireWithQuestionsAndOptions(@RequestBody QuestionnaireWithQuestionsAndOptionsVO questionnaireWithQuestionsAndOptionsVO) {
        Integer addQuestionnaireWithQuestionsAndOptions = questionnaireService.addQuestionnaireWithQuestionsAndOptions(questionnaireWithQuestionsAndOptionsVO);
        if (addQuestionnaireWithQuestionsAndOptions == 1) {
            return Result.success("添加调查问卷成功！");
        } else return Result.fail("添加调查问卷失败！");
    }

    @GetMapping("/getQuestionnaireWithQuestionsAndOptionsById/{id}")
    public Result getQuestionnaireWithQuestionsAndOptionsById(@PathVariable Integer id) {
        QuestionnaireWithQuestionsAndOptionsVO questionnaireWithQuestionsAndOptionsVO = questionnaireService.queryQuestionnaireWithQuestionsAndOptionsById(id);
        if (questionnaireWithQuestionsAndOptionsVO != null) {
            return Result.success("问卷查询成功！", questionnaireWithQuestionsAndOptionsVO);
        } else return Result.fail("问卷查询失败！");
    }
}
