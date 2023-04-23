package com.classmanagement.controller;

import com.classmanagement.entity.*;
import com.classmanagement.service.StudentVoteService;
import com.classmanagement.service.VoteCommentService;
import com.classmanagement.service.VoteService;
import com.classmanagement.util.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/vote")
public class VoteController {

    final VoteService voteService;
    final VoteCommentService voteCommentService;
    final StudentVoteService studentVoteService;

    public VoteController(VoteService voteService, VoteCommentService voteCommentService, StudentVoteService studentVoteService) {
        this.voteService = voteService;
        this.voteCommentService = voteCommentService;
        this.studentVoteService = studentVoteService;
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
    public Result addVoteWithOptions(@RequestBody VoteWithOptionsVO voteWithOptionsVO) {
        Integer insertVoteWithOptions = voteService.insertVoteWithOptions(voteWithOptionsVO);
        if (insertVoteWithOptions != 0) {
            return Result.success("投票发起成功！");
        } else return Result.fail("投票发起失败！");
    }

    @GetMapping("/getTotal")
    public Result getTotal() {
        Integer total = voteService.getTotal();
        return Result.success("投票总数查询成功！", total);
    }

    @GetMapping("/getVoteWithOptionsByVoteId/{vid}")
    public Result getVoteWithOptionsByVoteId(@PathVariable("vid") Integer vid) {
        VoteWithOptionsVO voteWithOptionsVO = voteService.queryVoteWithOptionsByVoteId(vid);
        if (voteWithOptionsVO != null) {
            return Result.success("投票数据查询成功！", voteWithOptionsVO);
        } else return Result.fail("投票数据查询失败！");
    }

    @GetMapping("/getCommentsByVoteId/{vid}")
    public Result getCommentsByVoteId(@PathVariable("vid") Integer vid) {
        List<VoteCommentWithStudentNameVo> voteCommentWithStudentNameVos = voteCommentService.queryAllVoteCommentWithStudentNameVOsByVoteId(vid);
        if (voteCommentWithStudentNameVos.size() != 0) {
            return Result.success("评论区数据查询成功！", voteCommentWithStudentNameVos);
        } else return Result.fail("评论区数据查询失败！");
    }

    @PostMapping("/addMultiStudentVotes")
    public Result addMultiStudentVotes(@RequestBody List<StudentVote> studentVotes) {
        Integer insertStudentVotes = studentVoteService.insertStudentVotes(studentVotes);
        if (insertStudentVotes != 0) {
            return Result.success("投票成功！");
        } else return Result.fail("投票失败！");
    }

    @GetMapping("/queryIsStudentVoted/{num}/{vid}")
    public Result queryIsStudentVoted(@PathVariable("num") Integer studentNum, @PathVariable("vid") Integer vid) {
        Integer queryIsStudentVotedByStudentNum = studentVoteService.QueryIsStudentVotedByStudentNum(studentNum, vid);
        if (queryIsStudentVotedByStudentNum == 1) {
            return Result.success("已参与投票！", 1);
        } else return Result.success("尚未参与投票！", 0);
    }

    @GetMapping("/queryOptionsPercentageByVoteId/{vid}")
    public Result queryOptionsPercentageByVoteId(@PathVariable("vid") Integer vid) {
        HashMap<String, Float> stringFloatHashMap = voteService.queryStudentVotePercentageByVoteId(vid);
        if (stringFloatHashMap != null) {
            return Result.success("投票情况查询成功！", stringFloatHashMap);
        } else return Result.fail("投票情况查询失败！");
    }

    @PostMapping("/addComment")
    public Result addComment(VoteComment voteComment) {
        Integer insertVoteComment = voteCommentService.insertVoteComment(voteComment);
        if (insertVoteComment != 0) {
            return Result.success("评论成功！");
        } else return Result.fail("评论失败！");
    }

    @DeleteMapping("/deleteComment")
    public Result deleteComment(Integer id) {
        Integer deleteVoteCommentById = voteCommentService.deleteVoteCommentById(id);
        if (deleteVoteCommentById != 0) {
            return Result.success("删除评论成功！");
        } else return Result.fail("删除评论失败！");
    }
}
