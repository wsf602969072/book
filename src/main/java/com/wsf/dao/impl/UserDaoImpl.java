package com.wsf.dao.impl;

import com.wsf.Condition.UserCondition;
import com.wsf.dao.UserDao;
import com.wsf.model.TUser;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 10:01
 * @tel:18738322951
 */
@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    String str = "com.wsf.mapper.TUserMapper.";
    @Override
    public TUser login(Map<String,Object> map) {
        System.out.println(map.get("username"));
        System.out.println(map.get("password"));
        List<TUser> list = this.getSqlSession().selectList(str + "selectUserByUsernameAndPassword", map);
        if(list!=null && list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }

    /**
     * 注册验证
     * @param username
     * @return
     */
    @Override
    public TUser validate(String username) {
        TUser user = this.getSqlSession().selectOne(str + "selectUserByUsername", username);
        return user;
    }

    /**
     * 用户注册
     * @param user
     */
    @Override
    public void regist(TUser user) {
        int i = this.getSqlSession().insert(str + "insert", user);
        System.out.println(i);
    }

    @Override
    public List<TUser> selectAllUser(UserCondition condition) {
        List<TUser> list = this.getSqlSession().selectList(str + "selectAllUser",condition);
        return list;
    }

    @Override
    public List<TUser> selectAll() {
        List<TUser> list = this.getSqlSession().selectList(str +"selectAll");
        return list;
    }

    @Override
    public Integer selectAllRecord(UserCondition condition) {
        Integer record = this.getSqlSession().selectOne(str + "selectAllRecord", condition);
        return record;
    }

    @Override
    public TUser selectUserById(Integer userId) {
      return this.getSqlSession().selectOne(str + "selectByPrimaryKey", userId);
    }

    @Override
    public void updateUserById(TUser user) {
        this.getSqlSession().update(str+"updateByPrimaryKeySelective",user);
    }

    @Override
    public void deleteUserById(Integer userId) {
        this.getSqlSession().delete(str+"deleteByPrimaryKey",userId);
    }
}
