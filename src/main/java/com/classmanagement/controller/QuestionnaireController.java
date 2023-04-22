package com.classmanagement.controller;

import com.classmanagement.entity.Parent;
import com.classmanagement.entity.ParentQuestionnaire;
import com.classmanagement.entity.Questionnaire;
import com.classmanagement.entity.QuestionnaireWithQuestionsAndOptionsVO;
import com.classmanagement.service.ParentQuestionnaireService;
import com.classmanagement.service.ParentService;
import com.classmanagement.service.QuestionnaireService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

    final QuestionnaireService questionnaireService;
    final ParentQuestionnaireService parentQuestionnaireService;
    final ParentService parentService;

    public QuestionnaireController(QuestionnaireService questionnaireService, ParentQuestionnaireService parentQuestionnaireService, ParentService parentService) {
        this.questionnaireService = questionnaireService;
        this.parentQuestionnaireService = parentQuestionnaireService;
        this.parentService = parentService;
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

    @GetMapping("/getQuestionnairesByParentId/{pid}")
    public Result getUnDoneQuestionnairesByParentId(@PathVariable("pid") Integer pid) {
        Parent parent = parentService.queryParentById(pid);
        if (parent == null) {
            return Result.fail("家长数据不存在！");
        }
        //已完成的调查问卷
        List<ParentQuestionnaire> parentQuestionnaires = parentQuestionnaireService.queryParentQuestionnaireByParentId(pid);
        //所有问卷
        List<Questionnaire> questionnaires = questionnaireService.queryAllQuestionnaires();

        List<Questionnaire> questionnaireList = new ArrayList<>();
        if (parentQuestionnaires.size() != 0) {
            if (questionnaires.size() != 0) {
                for (Questionnaire questionnaire : questionnaires) {
                    boolean flag = true;
                    for (ParentQuestionnaire parentQuestionnaire : parentQuestionnaires) {
                        //不在完成问卷列表中
                        if (questionnaire.getId() == parentQuestionnaire.getQuestionnaireId()) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        questionnaireList.add(questionnaire);
                    }
                }
                if (questionnaireList.size() != 0) {
                    return Result.success("问卷信息查询成功！", questionnaireList);
                } else return Result.fail("暂无未完成问卷！");
            } else return Result.fail("出错了！");//不存在这种情况
        } else {
            if (questionnaires.size() != 0) {
                return Result.success("问卷信息查询成功！", questionnaires);
            } else return Result.fail("暂无未完成问卷！");
        }

    }

    @GetMapping("/getTotal")
    public Result getTotal() {
        Integer total = questionnaireService.getTotal();
        return Result.success("总数查询成功！", total);
    }
}
