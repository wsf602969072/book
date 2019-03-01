package com.wsf.dao;

import com.wsf.Condition.UserCondition;
import com.wsf.model.TUser;

import java.util.List;
import java.util.Map;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 10:00
 * @tel:18738322951
 */
public interface UserDao {
    public TUser login(Map<String,Object> map);

    public TUser validate(String username);

    public void regist(TUser user);

    public List<TUser> selectAllUser(UserCondition condition);

    public List<TUser> selectAll();

    public Integer selectAllRecord(UserCondition condition);


    public TUser selectUserById(Integer userId);

    public void updateUserById(TUser user);

    public void deleteUserById(Integer userId);
}
