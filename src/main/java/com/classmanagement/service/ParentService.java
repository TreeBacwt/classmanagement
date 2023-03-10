package com.classmanagement.service;

import com.classmanagement.entity.Parent;
import com.classmanagement.entity.User;

public interface ParentService {

    /*返回userId*/
    public Integer addParent(User user, Parent parent);
    public Integer deleteParentById(Integer id);
    public Integer updateParent(Parent parent);
    public Parent queryParentById(Integer id);
}
