package com.classmanagement.service.impl;

import com.classmanagement.dao.StudentMapper;
import com.classmanagement.dao.VoteCommentMapper;
import com.classmanagement.entity.Student;
import com.classmanagement.entity.VoteComment;
import com.classmanagement.entity.VoteCommentWithStudentNameVo;
import com.classmanagement.service.VoteCommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoteCommentServiceImpl implements VoteCommentService {

    final VoteCommentMapper voteCommentMapper;
    final StudentMapper studentMapper;

    public VoteCommentServiceImpl(VoteCommentMapper voteCommentMapper, StudentMapper studentMapper) {
        this.voteCommentMapper = voteCommentMapper;
        this.studentMapper = studentMapper;
    }

    @Override
    public Integer insertVoteComment(VoteComment voteComment) {
        return voteCommentMapper.insertVoteComment(voteComment);
    }

    @Override
    public Integer deleteVoteCommentByStudentNumAndVoteId(Integer studentNum, Integer voteId) {
        return voteCommentMapper.deleteVoteCommentByStudentNumAndVoteId(studentNum, voteId);
    }

    @Override
    public List<VoteComment> queryAllVoteCommentsByVoteId(Integer vid) {
        return voteCommentMapper.queryAllVoteCommentsByVoteId(vid);
    }

    @Override
    public List<VoteCommentWithStudentNameVo> queryAllVoteCommentWithStudentNameVOsByVoteId(Integer vid) {
        List<VoteComment> voteComments = voteCommentMapper.queryAllVoteCommentsByVoteId(vid);
        List<VoteCommentWithStudentNameVo> voteCommentWithStudentNameVos = new ArrayList<>();
        for (VoteComment voteComment : voteComments) {
            Integer studentNum = voteComment.getStudentNum();
            Student student = studentMapper.queryStudentByStudentNum(studentNum);

            VoteCommentWithStudentNameVo voteCommentWithStudentNameVo = new VoteCommentWithStudentNameVo();
            voteCommentWithStudentNameVo.setVoteComment(voteComment);
            if (student != null) {
                voteCommentWithStudentNameVo.setStudentName(student.getStudentName());
            } else voteCommentWithStudentNameVo.setStudentName("账户已注销");

            voteCommentWithStudentNameVos.add(voteCommentWithStudentNameVo);
        }
        return voteCommentWithStudentNameVos;
    }

    @Override
    public Integer deleteVoteCommentById(Integer id) {
        return voteCommentMapper.deleteVoteCommentById(id);
    }
}
