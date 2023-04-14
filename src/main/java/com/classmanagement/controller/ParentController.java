package com.classmanagement.controller;

import com.classmanagement.entity.Parent;
import com.classmanagement.service.ParentService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/parent")
public class ParentController {

    final
    ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @PutMapping("/upd")
    public Result updateParent(Parent parent){
        Integer updateParent = parentService.updateParent(parent);
        if (updateParent == 1) {
            return Result.success("信息更新成功！");
        }else return Result.fail("信息更新失败！");
    }

    @GetMapping("/list/{page}")
    public Result getParentsByPageSize10(@PathVariable("page") Integer page){
        List<Parent> parents = parentService.queryParentsLimitIn10(page);
        if (parents.size() != 0) {
            return Result.success("第" + page + "页查找成功！", parents);
        }else return Result.fail("没有相关信息！");
    }
}
