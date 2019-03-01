package com.wsf.dao.impl;

import com.wsf.Condition.StudentCondition;
import com.wsf.dao.StudentDao;
import com.wsf.model.TStudent;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 7:25
 * @tel:18738322951
 */
@Repository
public class StudentDaoImpl extends SqlSessionDaoSupport implements StudentDao{

    @Autowired
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    String str = "com.wsf.mapper.TStudentMapper.";

    //查询所有的学生
    public void selectAllStu(){

    }

    @Override
    public void save(TStudent student) {
        this.getSqlSession().insert(str+"insert",student);
    }

    public void update(TStudent student){
        this.getSqlSession().update(str+"updateByPrimaryKeySelective",student);
    }

    @Override
    public List<TStudent> selectAllStudent(StudentCondition condition) {
        return this.getSqlSession().selectList(str+"selectAllStudent",condition);
    }

    @Override
    public TStudent selectStudentByUserId(Integer stuId) {
        return this.getSqlSession().selectOne(str+"selectByPrimaryKey",stuId);
    }

    @Override
    public void deleteStudentByStuId(Integer stuId) {
        this.getSqlSession().delete(str+"deleteByPrimaryKey",stuId);
    }

    @Override
    public Integer selectAllRecord(StudentCondition condition) {
        return this.getSqlSession().selectOne(str+"selectAllRecord",condition);
    }

    @Override
    public TStudent selectStuByStuNo(@Param("stuNo") String stuNo) {
        System.out.println(stuNo);
        return this.getSqlSession().selectOne(str+"selectStuByStuNo",stuNo);
    }
}
