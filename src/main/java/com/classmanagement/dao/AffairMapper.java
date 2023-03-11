package com.classmanagement.dao;

import com.classmanagement.entity.Affair;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AffairMapper {

    Integer insertAffair(Affair affair);
    Affair queryAffairById(Integer id);
    Integer updateAffair(Affair affair);
    Integer deleteAffairById(Integer id);

}
