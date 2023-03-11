package com.classmanagement.service.impl;

import com.classmanagement.dao.AffairMapper;
import com.classmanagement.entity.Affair;
import com.classmanagement.service.AffairService;
import org.springframework.stereotype.Service;

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
}
