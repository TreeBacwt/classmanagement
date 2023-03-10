package com.classmanagement.dao;

import com.classmanagement.entity.Parent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParentMapper {

    public Integer insertParent(Parent parent);
    public Parent queryParentById(Integer id);
    public Integer updateParent(Parent parent);
    public Integer deleteParentById(Integer id);
}
