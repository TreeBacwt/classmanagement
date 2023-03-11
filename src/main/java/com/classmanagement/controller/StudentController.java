package com.classmanagement.controller;

import com.classmanagement.entity.Student;
import com.classmanagement.service.StudentService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    final
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PutMapping("/upd")
    public Result updateStudent(Student student){
        Integer updateStudent = studentService.updateStudent(student);
        if (updateStudent == 1){
            return Result.success("信息更新成功！");
        }else return Result.fail("信息更新失败！");
    }
}
