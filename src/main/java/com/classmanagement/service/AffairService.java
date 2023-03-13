package com.classmanagement.service;

import com.classmanagement.entity.Affair;

import java.util.List;

public interface AffairService {

    Integer addAffair(Affair affair);
    Affair queryAffairById(Integer id);
    List<Affair> queryAffairsByAffairNameKeyWordLimitIn10(String keyWord, Integer page);
    List<Affair> queryAffairsLimitIn10(Integer page);
    Integer updateAffair(Affair affair);
    Integer deleteAffairById(Integer id);
}
