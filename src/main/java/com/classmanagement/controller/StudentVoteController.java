package com.classmanagement.controller;

import com.classmanagement.entity.StudentVote;
import com.classmanagement.service.StudentVoteService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentVote")
public class StudentVoteController {

    final StudentVoteService studentVoteService;

    public StudentVoteController(StudentVoteService studentVoteService) {
        this.studentVoteService = studentVoteService;
    }

    @PostMapping("/add")
    public Result addStudentVote(StudentVote studentVote){
        Integer insertStudentVote = studentVoteService.insertStudentVote(studentVote);
        if (insertStudentVote == 1) {
            return Result.success("投票成功！", studentVote);
        }else return Result.fail("投票失败！");
    }

    @GetMapping("/list/{voteOptionId}")
    public Result queryStudentVotesByVoteOptionId(@PathVariable("voteOptionId") Integer voteOptionId){
        List<StudentVote> studentVotes = studentVoteService.queryStudentVotesByVoteOptionId(voteOptionId);
        if (studentVotes.size() != 0) {
            return Result.success("投票选项情况查询成功！", studentVotes);
        }else return Result.fail("没有相关数据");
    }

    @DeleteMapping("/delete")
    public Result deleteStudentVote(StudentVote studentVote){
        Integer deleteStudentVoteByStudentNumAndVoteOptionId = studentVoteService.deleteStudentVoteByStudentNumAndVoteOptionId(studentVote.getStudentNum(), studentVote.getVoteOptionId());
        if (deleteStudentVoteByStudentNumAndVoteOptionId == 1) {
            return Result.success("学生投票删除成功！");
        }else return Result.fail("学生投票删除失败！");
    }

}
