package com.wsf.dao.impl;

import com.wsf.dao.CatalogDao;
import com.wsf.model.TCatalog;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 4:52
 * @tel:18738322951
 */
@Repository
public class CatalogDaoImpl extends SqlSessionDaoSupport implements CatalogDao{

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    String str = "com.wsf.mapper.TCatalogMapper.";

    @Override
    public List<TCatalog> selectAllCatalog(){
       return  this.getSqlSession().selectList(str+"selectAllCatalog");
    }

    @Override
    public List<TCatalog> selectCatalogByParentId(Integer parentId) {
        return this.getSqlSession().selectList(str+"selectCatalogByParentId",parentId);
    }

}
