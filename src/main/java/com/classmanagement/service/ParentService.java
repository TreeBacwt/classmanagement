package com.classmanagement.service;

import com.classmanagement.entity.Parent;
import com.classmanagement.entity.User;

public interface ParentService {

    /*返回userId*/
    Integer addParent(User user, Parent parent);
    Integer deleteParentById(Integer id);
    Integer updateParent(Parent parent);
    Parent queryParentById(Integer id);
}
