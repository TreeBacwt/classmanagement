package com.classmanagement.controller;

import com.classmanagement.entity.ExaminationWithScoresVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class IndexController {

    @GetMapping("/111")
    public String index() {
        return "index";
    }

    @PostMapping("/test")
    public String test(@RequestBody ExaminationWithScoresVO examinationWithScoresVO) {
        System.out.println(examinationWithScoresVO);
        return "test";
    }
}
