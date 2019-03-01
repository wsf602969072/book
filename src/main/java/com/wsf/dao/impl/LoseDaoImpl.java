package com.wsf.dao.impl;

import com.wsf.Condition.LoseCondition;
import com.wsf.dao.LoseDao;
import com.wsf.model.TLose;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 4:22
 * @tel:18738322951
 */
@Repository
public class LoseDaoImpl extends SqlSessionDaoSupport implements LoseDao{

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    String str = "com.wsf.mapper.TLoseMapper.";


    @Override
    public void addLoseInfo(TLose lose) {
        lose.setIsDeal(0);
        this.getSqlSession().insert(str+"insert",lose);
    }

    @Override
    public List<TLose> selectLoseByConditon(LoseCondition condition) {
        return this.getSqlSession().selectList(str+"selectLoseByConditon",condition);
    }


    public Integer selectAllRecordByCondition(LoseCondition condition){
        return this.getSqlSession().selectOne(str+"selectAllRecordByCondition",condition);
    }

    @Override
    public void deleteLoseById(Integer loseId) {
        this.getSqlSession().delete(str+"deleteByPrimaryKey",loseId);
    }

    @Override
    public void dealLoseById(Integer loseId) {
        TLose lose = new TLose();
        lose.setLoseId(loseId);
        lose.setIsDeal(1);
        this.getSqlSession().update(str+"updateByPrimaryKeySelective",lose);
    }


}
