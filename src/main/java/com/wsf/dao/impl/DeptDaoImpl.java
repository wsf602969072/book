package com.wsf.dao.impl;

import com.wsf.dao.DeptDao;
import com.wsf.model.TDept;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 7:35
 * @tel:18738322951
 */
@Repository
public class DeptDaoImpl extends SqlSessionDaoSupport implements DeptDao{

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    String str = "com.wsf.mapper.TDeptMapper.";

    /**
     * 查询所有的专业
     */
    public List<TDept> selectAllDept(){
        List<TDept> list = this.getSqlSession().selectList(str + "selectAllDept");
        return list;
    }
}
