package com.classmanagement.dao;

import com.classmanagement.entity.Affair;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AffairMapper {

    Integer insertAffair(Affair affair);

    Affair queryAffairById(Integer id);

    Integer updateAffair(Affair affair);

    Integer deleteAffairById(Integer id);

    List<Affair> queryAffairsByAffairNameKeyWordLimit(String keyWord, Integer start, Integer limit);

    List<Affair> queryAffairsLimit(Integer start, Integer limit);

    Integer queryAffairsCount();

}
