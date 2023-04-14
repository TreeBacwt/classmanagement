package com.classmanagement.service.impl;

import com.classmanagement.dao.AffairMapper;
import com.classmanagement.entity.Affair;
import com.classmanagement.service.AffairService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffairServiceImpl implements AffairService {

    final
    AffairMapper affairMapper;

    public AffairServiceImpl(AffairMapper affairMapper) {
        this.affairMapper = affairMapper;
    }

    @Override
    public Integer addAffair(Affair affair) {
        return affairMapper.insertAffair(affair);
    }

    @Override
    public Affair queryAffairById(Integer id) {
        return affairMapper.queryAffairById(id);
    }

    @Override
    public List<Affair> queryAffairsByAffairNameKeyWordLimitIn10(String keyWord, Integer page) {
        return affairMapper.queryAffairsByAffairNameKeyWordLimit(keyWord, (page - 1) * 10, 10);
    }

    @Override
    public List<Affair> queryAffairsLimitIn10(Integer page) {
        return affairMapper.queryAffairsLimit((page - 1) * 10, 10);
    }

    @Override
    public Integer updateAffair(Affair affair) {
        return affairMapper.updateAffair(affair);
    }

    @Override
    public Integer deleteAffairById(Integer id) {
        return affairMapper.deleteAffairById(id);
    }

    @Override
    public Integer queryAffairsCount() {
        return affairMapper.queryAffairsCount();
    }
}
