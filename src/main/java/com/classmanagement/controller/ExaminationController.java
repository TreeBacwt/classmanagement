package com.classmanagement.controller;

import com.classmanagement.entity.Examination;
import com.classmanagement.service.ExaminationService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examination")
public class ExaminationController {

    final ExaminationService examinationService;

    public ExaminationController(ExaminationService examinationService) {
        this.examinationService = examinationService;
    }

    @PostMapping("/add")
    public Result addExamination(Examination examination){
        Integer insertExamination = examinationService.insertExamination(examination);
        if (insertExamination == 1) {
            return Result.success("添加考试成功！", examination);
        }else return Result.fail("添加考试失败！");
    }

    @GetMapping("/query/{id}")
    public Result queryExaminationById(@PathVariable("id") Integer id){
        Examination examination = examinationService.queryExaminationById(id);
        if (examination != null) {
            return Result.success("考试信息查询成功！", examination);
        }else return Result.fail("考试信息查询失败！");
    }

    @PutMapping("/upd")
    public Result updateExamination(Examination examination){
        Integer updateExamination = examinationService.updateExamination(examination);
        if (updateExamination == 1) {
            return Result.success("考试信息更新成功！", examination);
        }else return Result.fail("考试信息更新失败！");
    }

    @DeleteMapping("/delete")
    public Result deleteExaminationById(Integer id){
        Integer deleteExaminationById = examinationService.deleteExaminationById(id);
        if (deleteExaminationById == 1) {
            return Result.success("考试删除成功！");
        }else return Result.fail("考试删除失败！");
    }

    @GetMapping("/list/{page}")
    public Result queryExaminationByPageSize10(@PathVariable("page") Integer page){
        List<Examination> examinations = examinationService.queryExaminationLimitIn10(page);
        if (examinations.size() != 0) {
            return Result.success("第" + page + "页查询成功！", examinations);
        }else return Result.fail("没有相关数据");
    }

}
