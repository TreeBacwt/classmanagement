package com.classmanagement.service;

import com.classmanagement.entity.Parent;
import com.classmanagement.entity.User;

import java.util.List;

public interface ParentService {

    /*返回userId*/
    Integer addParent(User user, Parent parent);
    Integer deleteParentById(Integer id);
    Integer updateParent(Parent parent);
    Parent queryParentById(Integer id);
    List<Parent> queryParentsLimitIn10(Integer page);
}
