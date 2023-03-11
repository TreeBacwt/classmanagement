package com.classmanagement.controller;

import com.classmanagement.entity.Affair;
import com.classmanagement.service.AffairService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/affair")
public class AffairController {

    final
    AffairService affairService;

    public AffairController(AffairService affairService) {
        this.affairService = affairService;
    }

    @PostMapping("/add")
    public Result addAffair(Affair affair){
        affairService.addAffair(affair);
        return Result.success("班级事务添加成功！", affair);
    }
}
