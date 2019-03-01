package com.wsf.dao.impl;

import com.wsf.dao.SpecialtyDao;
import com.wsf.model.TSpecialty;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 7:36
 * @tel:18738322951
 */
@Repository
public class SpecialtyDaoImpl extends SqlSessionDaoSupport implements SpecialtyDao{


    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    String str = "com.wsf.mapper.TSpecialtyMapper.";


    @Override
    public List<TSpecialty> selectSpecialtyByDeptNo(Integer deptNo) {
        return this.getSqlSession().selectList(str+"selectSpecialtyByDeptNo",deptNo);
    }
}
