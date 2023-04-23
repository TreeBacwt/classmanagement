package com.classmanagement.controller;

import com.classmanagement.entity.Vote;
import com.classmanagement.entity.VoteWithOptions;
import com.classmanagement.service.VoteService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/vote")
public class VoteController {

    final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @PostMapping("/add")
    public Result addVote(Vote vote) {
        Integer insertVote = voteService.insertVote(vote);
        if (insertVote == 1) {
            return Result.success("投票创建成功！", vote);
        } else return Result.fail("投票创建失败！");
    }

    @GetMapping("/queryById/{id}")
    public Result queryVoteById(@PathVariable("id") Integer id) {
        Vote vote = voteService.queryVoteById(id);
        if (vote != null) {
            return Result.success("投票查询成功！", vote);
        } else return Result.fail("没有相关数据！");
    }

    @PutMapping("/upd")
    public Result updateVote(Vote vote) {
        Integer updateVote = voteService.updateVote(vote);
        if (updateVote == 1) {
            return Result.success("投票修改成功！", vote);
        } else return Result.fail("投票修改失败！");
    }

    @DeleteMapping("/delete")
    public Result deleteVoteById(Integer id) {
        Integer deleteVoteById = voteService.deleteVoteById(id);
        if (deleteVoteById == 1) {
            return Result.success("投票删除成功！");
        } else return Result.fail("投票删除失败！");
    }

    @GetMapping("/list/{page}")
    public Result queryVotesByPageSize10(@PathVariable("page") Integer page) {
        List<Vote> votes = voteService.queryVotesLimitIn10(page);
        if (votes.size() != 0) {
            return Result.success("第" + page + "页查询成功！", votes);
        } else return Result.fail("没有相关数据！");
    }

    @PostMapping("/addVoteWithOptions")
    public Result addVoteWithOptions(@RequestBody VoteWithOptions voteWithOptions) {
        Integer insertVoteWithOptions = voteService.insertVoteWithOptions(voteWithOptions);
        if (insertVoteWithOptions != 0) {
            return Result.success("投票发起成功！");
        } else return Result.fail("投票发起失败！");
    }

    @GetMapping("/getTotal")
    public Result getTotal(){
        Integer total = voteService.getTotal();
        return Result.success("投票总数查询成功！", total);
    }
}
