package com.classmanagement.dao;

import com.classmanagement.entity.Parent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParentMapper {

    Integer insertParent(Parent parent);

    Parent queryParentById(Integer id);

    Integer updateParent(Parent parent);

    Integer deleteParentById(Integer id);

    List<Parent> queryParentsLimit(Integer start, Integer limit);

    Integer deleteParentByUserId(Integer uid);
}
