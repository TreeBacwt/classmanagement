package com.classmanagement.dao;

import com.classmanagement.entity.Affair;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AffairMapper {

    public Integer insertAffair(Affair affair);
    public Affair queryAffairById(Integer id);
    public Integer updateAffair(Affair affair);
    public Integer deleteAffairById(Integer id);

}
