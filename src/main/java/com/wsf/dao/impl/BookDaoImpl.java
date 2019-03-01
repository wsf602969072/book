package com.wsf.dao.impl;

import com.wsf.Condition.BookCondition;
import com.wsf.dao.BookDao;
import com.wsf.model.TBook;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 4:49
 * @tel:18738322951
 */
@Repository
public class BookDaoImpl extends SqlSessionDaoSupport implements BookDao{

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    String str = "com.wsf.mapper.TBookMapper.";

    @Override
    public void saveBook(TBook book) {
        this.getSqlSession().insert(str+"insert",book);
    }

    @Override
    public void updateBook(TBook book) {
        this.getSqlSession().update(str+"updateByPrimaryKeySelective",book);
    }

    @Override
    public Integer selectBookRecordByCondition(BookCondition condition) {
        return this.getSqlSession().selectOne(str+"selectBookRecordByCondition",condition);
    }

    @Override
    public List<TBook> selectBookByCondition(BookCondition condition) {

        return this.getSqlSession().selectList(str+"selectBookByCondition",condition);
    }

    @Override
    public TBook selectBookById(Integer bookId) {
        return this.getSqlSession().selectOne(str+"selectBookById",bookId);
    }

    @Override
    public void deleteBookById(Integer bookId) {
        this.getSqlSession().delete(str+"deleteByPrimaryKey",bookId);
    }

    @Override
    public TBook selectByBookNo(String bookNo) {
        return this.getSqlSession().selectOne(str+"selectByBookNo",bookNo);
    }

    @Override
    public TBook selectByBookId(Integer bookId) {
        return this.getSqlSession().selectOne(str+"selectByPrimaryKey",bookId);
    }

}
