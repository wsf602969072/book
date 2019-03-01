package com.wsf.service.impl;

import com.wsf.Condition.UserCondition;
import com.wsf.dao.UserDao;
import com.wsf.model.Page;
import com.wsf.model.TUser;
import com.wsf.service.UserService;
import com.wsf.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 10:01
 * @tel:18738322951
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public TUser login(TUser user) {
        String password = MD5.GetMD5Code(user.getPassword());
        user.setPassword(password);
        Map<String,Object> map = new HashMap<>();
        map.put("username",user.getUsername());
        map.put("password",password);
        TUser u = userDao.login(map);
        return u;
    }

    @Override
    public TUser validate(String username) {
        TUser user = userDao.validate(username);
        return user;
    }

    @Override
    public void regist(TUser user) {
        //进行加密
        user.setPassword(MD5.GetMD5Code(user.getPassword()));
        userDao.regist(user);
    }

    @Override
    public Page<TUser> selectAllUser(UserCondition condition) {
        Page<TUser> page = new Page<>();
        //一页的数据
        List<TUser> userList = userDao.selectAllUser(condition);
        page.setData(userList);
        //查询总的记录数
        Integer totalRecord = userDao.selectAllRecord(condition);
        page.setTotalRecord(totalRecord);
        //一页的记录数
        page.setPageNums(condition.getPageNums());
        //设置页码
        page.setPageNo(condition.getPageNo());
        return page;


    }

    @Override
    public List<TUser> selectAll() {

        return userDao.selectAll();
    }

    @Override
    public TUser selectUserById(Integer userId) {
        return userDao.selectUserById(userId);
    }

    @Override
    public void updateUserById(TUser user) {
        String password = MD5.GetMD5Code(user.getPassword());
        user.setPassword(password);
        userDao.updateUserById(user);
    }

    @Override
    public void deleteUserById(Integer userId) {
        userDao.deleteUserById(userId);
    }
}
