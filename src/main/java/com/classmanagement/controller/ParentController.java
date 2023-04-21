package com.classmanagement.controller;

import com.classmanagement.entity.Parent;
import com.classmanagement.service.ParentQuestionnaireService;
import com.classmanagement.service.ParentService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/parent")
public class ParentController {

    final ParentService parentService;
    final ParentQuestionnaireService parentQuestionnaireService;

    public ParentController(ParentService parentService, ParentQuestionnaireService parentQuestionnaireService) {
        this.parentService = parentService;
        this.parentQuestionnaireService = parentQuestionnaireService;
    }

    @PutMapping("/upd")
    public Result updateParent(Parent parent) {
        Integer updateParent = parentService.updateParent(parent);
        if (updateParent == 1) {
            return Result.success("信息更新成功！");
        } else return Result.fail("信息更新失败！");
    }

    @GetMapping("/list/{page}")
    public Result getParentsByPageSize10(@PathVariable("page") Integer page) {
        List<Parent> parents = parentService.queryParentsLimitIn10(page);
        if (parents.size() != 0) {
            return Result.success("第" + page + "页查找成功！", parents);
        } else return Result.fail("没有相关信息！");
    }

    @GetMapping("/getParentByUserId/{uid}")
    public Result getParentByUserId(@PathVariable("uid") Integer uid) {
        Parent parent = parentService.queryParentByUserId(uid);
        if (parent != null) {
            return Result.success("家长信息查询成功！", parent);
        } else return Result.fail("家长信息查询失败！");
    }

}
