package com.wsf.dao.impl;

import com.wsf.Condition.BorrowCondition;
import com.wsf.dao.BorrowDao;
import com.wsf.model.TBorrow;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 8:41
 * @tel:18738322951
 */
@Repository
public class BorrowDaoImpl extends SqlSessionDaoSupport implements BorrowDao{

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    String str = "com.wsf.mapper.TBorrowMapper.";

    @Override
    public void borrowBook(TBorrow borrow) {
        this.getSqlSession().insert(str+"insert",borrow);
    }

    @Override
    public List<TBorrow> selectBorrowByCondition(BorrowCondition condition) {

        return this.getSqlSession().selectList(str+"selectBorrowByCondition",condition);
    }

    public Integer selectAllRecord(BorrowCondition condition){
        return this.getSqlSession().selectOne(str+"selectAllRecord",condition);
    }

    @Override
    public void deleteBorrowById(Integer borrowId) {
        this.getSqlSession().delete(str+"deleteByPrimaryKey",borrowId);
    }

    @Override
    public TBorrow selectBorrowById(Integer borrowId) {
        return this.getSqlSession().selectOne(str+"selectBorrowById",borrowId);
    }

    @Override
    public void UpdateBorrow(TBorrow borrow) {
        this.getSqlSession().update(str+"updateByPrimaryKeySelective",borrow);
    }

    @Override
    public Integer checkBorrowIsLose(Integer borrowId) {
        return this.getSqlSession().selectOne(str+"checkBorrowIsLose",borrowId);
    }
}
