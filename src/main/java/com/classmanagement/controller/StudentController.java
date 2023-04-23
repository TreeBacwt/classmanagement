package com.classmanagement.controller;

import com.classmanagement.entity.Student;
import com.classmanagement.service.StudentService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

    final
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PutMapping("/upd")
    public Result updateStudent(Student student) {
        Integer updateStudent = studentService.updateStudent(student);
        if (updateStudent == 1) {
            return Result.success("学生信息更新成功！");
        } else return Result.fail("学生信息更新失败！");
    }

    @GetMapping("/list/{page}")
    public Result getStudentsByPageSize10(@PathVariable("page") Integer page) {
        List<Student> students = studentService.queryStudentsLimitIn10(page);
        if (students.size() != 0) {
            return Result.success("第" + page + "页查找成功！", students);
        } else return Result.fail("没有相关数据");
    }

    @GetMapping("/all")
    public Result getAllStudents() {
        List<Student> students = studentService.queryAllStudents();
        if (students.size() != 0) {
            return Result.success("学生列表查询成功！", students);
        } else return Result.fail("没有相关数据");
    }

    @GetMapping("/isLeader/{uid}")
    public Result queryStudentIsLeaderByUserId(@PathVariable("uid") Integer uid) {
        Integer isLeader = studentService.queryStudentIsLeaderByUserId(uid);
        return new Result(isLeader, "");
    }

    @PutMapping("/updateIsLeader")
    public Result updateStudentIsLeader(Integer uid, Integer isLeader) {
        Integer updateStudentIsLeader = studentService.updateStudentIsLeader(uid, isLeader);
        if (updateStudentIsLeader == 1) {
            String message = isLeader == 1 ? "已成功设为班干部！" : "已成功撤销班干部！";
            return Result.success(message);
        } else return Result.fail("更改出错，请稍后再试！");
    }

    @GetMapping("/getStudentByUserId/{uid}")
    public Result getStudentByUserId(@PathVariable("uid") Integer uid) {
        Student student = studentService.queryStudentByUserId(uid);
        if (student != null) {
            return Result.success("学生信息查询成功！", student);
        } else return Result.fail("学生信息查询失败！");
    }
}
