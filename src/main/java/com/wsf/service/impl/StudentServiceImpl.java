package com.wsf.service.impl;

import com.wsf.Condition.StudentCondition;
import com.wsf.dao.DeptDao;
import com.wsf.dao.SpecialtyDao;
import com.wsf.dao.StudentDao;
import com.wsf.model.Page;
import com.wsf.model.TDept;
import com.wsf.model.TSpecialty;
import com.wsf.model.TStudent;
import com.wsf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 7:24
 * @tel:18738322951
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao stuDao;

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private SpecialtyDao specialtyDao;

    @Override
    public List<TDept> selectAllDept() {
        return deptDao.selectAllDept();
    }

    @Override
    public List<TSpecialty> selectSpecialtyByDeptNo(Integer deptNo) {
        List<TSpecialty> specialtyList=  specialtyDao.selectSpecialtyByDeptNo(deptNo);
        System.out.println(specialtyList);
        return specialtyList;
    }

    @Override
    public void saveOrUpdate(TStudent student) {
        if(student.getStuId()==null){
            //没有stuId,是保存信息
            stuDao.save(student);

        }else{
            //如果有stuId那么就是更新信息
            stuDao.update(student);
        }

    }

    @Override
    public Page<TStudent> selectAllStudent(StudentCondition condition) {
        Page<TStudent> page = new Page<>();
        //设置数据
        List<TStudent> studentList = stuDao.selectAllStudent(condition);
        page.setData(studentList);
        //设置页码
        page.setPageNo(condition.getPageNo());
        //设置一页记录的数量
        page.setPageNums(condition.getPageNums());
        //设置总记录数
        Integer recored = stuDao.selectAllRecord(condition);
        page.setTotalRecord(recored);
        return page;
    }

    @Override
    public TStudent selectStudentByUserId(Integer stuId) {
        return stuDao.selectStudentByUserId(stuId);
    }

    @Override
    public void deleteStudentByStuId(Integer stuId) {
        stuDao.deleteStudentByStuId(stuId);
    }

    @Override
    public TStudent selectStuByStuNo(String stuNo) {
        return stuDao.selectStuByStuNo(stuNo);
    }
}
