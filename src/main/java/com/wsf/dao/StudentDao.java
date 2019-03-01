package com.wsf.dao;

import com.wsf.Condition.StudentCondition;
import com.wsf.model.TStudent;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 7:25
 * @tel:18738322951
 */
public interface StudentDao {
    public void save(TStudent student);

    public void update(TStudent student);

    public List<TStudent> selectAllStudent(StudentCondition condition);

    public TStudent selectStudentByUserId(Integer stuId);

    public void deleteStudentByStuId(Integer stuId);

    public Integer selectAllRecord(StudentCondition condition);

    public TStudent selectStuByStuNo(String stuNo);
}
