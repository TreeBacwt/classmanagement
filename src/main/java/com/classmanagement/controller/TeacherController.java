package com.classmanagement.controller;

import com.classmanagement.entity.Teacher;
import com.classmanagement.service.TeacherService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    final
    TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PutMapping("/upd")
    public Result updateTeacher(Teacher teacher){
        Integer updateTeacher = teacherService.updateTeacher(teacher);
        if (updateTeacher == 1) {
            return Result.success("信息更新成功！");
        }else return Result.fail("信息更新失败！");
    }

    @GetMapping("/queryByUid/{uid}")
    public Result queryTeacherByUserId(@PathVariable("uid") Integer uid){
        Teacher teacher = teacherService.queryTeacherByUserId(uid);
        if (teacher != null) {
            return Result.success("查询成功！", teacher);
        }else return Result.fail("没有相关数据,请尝试重新登录！");
    }
}
