package com.classmanagement.controller;

import com.classmanagement.entity.Subject;
import com.classmanagement.service.SubjectService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/add")
    public Result addSubject(Subject subject){
        Integer insertSubject = subjectService.insertSubject(subject);
        if (insertSubject == 1) {
            return Result.success("课程添加成功！", subject);
        }else return Result.fail("课程添加失败！");
    }

    @GetMapping("/query/{id}")
    public Result querySubjectById(@PathVariable("id") Integer id){
        Subject subject = subjectService.querySubjectById(id);
        if (subject != null) {
            return Result.success("课程查询成功！", subject);
        }else return Result.fail("课程查询失败！");
    }

    @PutMapping("/upd")
    public Result updateSubject(Subject subject){
        Integer updateSubject = subjectService.updateSubject(subject);
        if (updateSubject == 1) {
            return Result.success("课程修改成功！");
        }else return Result.fail("课程修改失败");
    }

    @DeleteMapping("/delete")
    public Result deleteSubjectById(Integer id){
        Integer deleteSubjectById = subjectService.deleteSubjectById(id);
        if (deleteSubjectById == 1) {
            return Result.success("课程删除成功！");
        }else return Result.fail("课程删除失败！");
    }

    @GetMapping("/list/{page}")
    public Result getSubjectsByPageSize10(@PathVariable("page") Integer page){
        List<Subject> subjects = subjectService.querySubjectsLimitIn10(page);
        if (subjects.size() != 0) {
            return Result.success("第" + page + "页查询成功！", subjects);
        }else return Result.fail("没有相关数据！");
    }

    @PostMapping("/addMulti")
    public Result addSubjects(@RequestBody List<Subject> subjects){
        Integer insertSubjects = subjectService.insertSubjects(subjects);
        if (insertSubjects != 0) {
            return Result.success("批量添加课程成功！");
        }else return Result.fail("批量添加课程失败！");
    }
}
