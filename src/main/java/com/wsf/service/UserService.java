package com.wsf.service;

import com.wsf.Condition.UserCondition;
import com.wsf.model.Page;
import com.wsf.model.TUser;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 10:00
 * @tel:18738322951
 */
public interface UserService{
    public TUser login(TUser user);

    public TUser validate(String username);

    public void regist(TUser user);

    public Page<TUser> selectAllUser(UserCondition condition);

    public List<TUser> selectAll();

    public TUser selectUserById(Integer userId);

    public void updateUserById(TUser user);

    public void deleteUserById(Integer userId);
}
