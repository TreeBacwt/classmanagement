package com.classmanagement.controller;

import com.classmanagement.entity.Affair;
import com.classmanagement.service.AffairService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/queryById/{id}")
    public Result queryAffairById(@PathVariable("id") Integer id){
        Affair affair = affairService.queryAffairById(id);
        if (affair != null) {
            return Result.success("班级事务查询成功！", affair);
        }else return Result.fail("查询不到相关数据！");
    }

    @GetMapping("/queryByName/{name}/{page}")
    public Result queryAffairsByAffairName(@PathVariable("name") String name, @PathVariable("page") Integer page){
        List<Affair> affairs = affairService.queryAffairsByAffairNameKeyWordLimitIn10(name, page);
        if (affairs.size() != 0) {
            return Result.success("第" + page + "页查找成功！", affairs);
        }else return Result.fail("没有相关数据！");
    }

    @GetMapping("/list/{page}")
    public Result getAffairsByPageSize10(@PathVariable("page") Integer page){
        List<Affair> affairs = affairService.queryAffairsLimitIn10(page);
        if (affairs.size() != 0) {
            return Result.success("第" + page + "页查找成功", affairs);
        }else return Result.fail("没有相关数据");
    }

    @PutMapping("/upd")
    public Result updateAffair(Affair affair){
        Integer updateAffair = affairService.updateAffair(affair);
        if (updateAffair == 1) {
            return Result.success("修改成功！", affair);
        }else return Result.fail("修改失败");
    }

    @DeleteMapping("/delete")
    public Result deleteAffairById(Integer id){
        Integer deleteAffairById = affairService.deleteAffairById(id);
        if (deleteAffairById == 1) {
            return Result.success("删除成功");
        }else return Result.fail("删除失败");
    }
}
