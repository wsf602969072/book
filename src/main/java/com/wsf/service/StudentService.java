package com.wsf.service;

import com.wsf.Condition.StudentCondition;
import com.wsf.model.Page;
import com.wsf.model.TDept;
import com.wsf.model.TSpecialty;
import com.wsf.model.TStudent;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 7:24
 * @tel:18738322951
 */

public interface StudentService {

    public List<TDept> selectAllDept();

    public List<TSpecialty> selectSpecialtyByDeptNo(Integer deptNo);

    public void saveOrUpdate(TStudent student);

    public Page<TStudent> selectAllStudent(StudentCondition condition);

    public TStudent selectStudentByUserId(Integer stuId);

    public void deleteStudentByStuId(Integer stuId);

    public TStudent selectStuByStuNo(String stuNo);
}
