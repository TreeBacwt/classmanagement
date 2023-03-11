package com.classmanagement.dao;

import com.classmanagement.entity.Parent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ParentMapper {

    Integer insertParent(Parent parent);
    Parent queryParentById(Integer id);
    Integer updateParent(Parent parent);
    Integer deleteParentById(Integer id);
}
