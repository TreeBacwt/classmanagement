package com.classmanagement.controller;

import com.classmanagement.entity.Parent;
import com.classmanagement.service.ParentService;
import com.classmanagement.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    ParentService parentService;

    @PutMapping("/upd")
    public Result updateParent(Parent parent){
        Integer updateParent = parentService.updateParent(parent);
        if (updateParent == 1) {
            return Result.success("信息更新成功！");
        }else return Result.fail("信息更新失败！");
    }
}
