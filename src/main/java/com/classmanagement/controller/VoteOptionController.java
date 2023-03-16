package com.classmanagement.controller;

import com.classmanagement.entity.VoteOption;
import com.classmanagement.service.VoteOptionService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voteOption")
public class VoteOptionController {

    final VoteOptionService voteOptionService;

    public VoteOptionController(VoteOptionService voteOptionService) {
        this.voteOptionService = voteOptionService;
    }

    @PostMapping("/add")
    public Result addVoteOption(VoteOption voteOption){
        Integer insertVoteOption = voteOptionService.insertVoteOption(voteOption);
        if (insertVoteOption == 1) {
            return Result.success("投票选项创建成功！", voteOption);
        }else return Result.fail("投票选项创建失败！");
    }

    @GetMapping("/queryById/{id}")
    public Result queryVoteOptionById(@PathVariable("id") Integer id){
        VoteOption voteOption = voteOptionService.queryVoteOptionById(id);
        if (voteOption != null) {
            return Result.success("投票选项查询成功！", voteOption);
        }else return Result.fail("投票选项查询失败！");
    }

    @PutMapping("/upd")
    public Result updateVoteOption(VoteOption voteOption){
        Integer updateVoteOption = voteOptionService.updateVoteOption(voteOption);
        if (updateVoteOption == 1) {
            return Result.success("投票选项修改成功！", voteOption);
        }else return Result.fail("投票选项修改失败！");
    }

    @DeleteMapping("/delete")
    public Result deleteVoteOption(Integer id){
        Integer deleteVoteOptionById = voteOptionService.deleteVoteOptionById(id);
        if (deleteVoteOptionById == 1) {
            return Result.success("投票选项删除成功！");
        }else return Result.fail("投票选项删除失败！");
    }

    @GetMapping("/list/{voteId}/{page}")
    public Result queryVoteOptionsByPageSize10(@PathVariable("voteId") Integer voteId, @PathVariable("page") Integer page){
        List<VoteOption> voteOptions = voteOptionService.queryVoteOptionsByVoteIdLimitIn10(voteId, page);
        if (voteOptions.size() != 0) {
            return Result.success("第" + page + "页投票选项查询成功！", voteOptions);
        }else return Result.fail("没有相关数据！");
    }
}
