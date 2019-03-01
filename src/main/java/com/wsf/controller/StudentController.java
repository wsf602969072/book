package com.wsf.controller;

import com.wsf.Condition.StudentCondition;
import com.wsf.model.Page;
import com.wsf.model.TDept;
import com.wsf.model.TSpecialty;
import com.wsf.model.TStudent;
import com.wsf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 1:17
 * @tel:18738322951
 */
@RequestMapping("/student")
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/selectStudentByCondition.do")
    public String toStudent(Model model, StudentCondition condition){
        //查询所有的学院
        List<TDept> deptList = studentService.selectAllDept();
        model.addAttribute("deptList",deptList);

        //组装查询条件
        String searchType = condition.getSearchType();
        String searchValue = condition.getSearchValue();
        System.out.println(searchType+":"+searchValue);
        if("stuNo".equals(searchType)){
            condition.setstuNo(searchValue);
        }else if("stuName".equals(searchType)){
            condition.setStuName(searchValue);
        }else if("deptName".equals(searchType)){
            condition.setDeptName(searchValue);
        }else if("specName".equals(searchType)){
            condition.setSpecName(searchValue);
        }
        //pageNo
        if(condition.getPageNo()==null){
            condition.setPageNo(1);
        }
        //查询学生
        Page<TStudent> page = studentService.selectAllStudent(condition);
        model.addAttribute("page",page);
        return "page/student";
    }

    /**
     *
     */
    @RequestMapping("/saveOrUpdate.do")
    public String saveOrUpdate(TStudent student){
        studentService.saveOrUpdate(student);
        return "redirect:/student/selectStudentByCondition.do";
    }
    /**
     *
     * 根据学院的id查询所属的专业
     * @param deptNo
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectSpecialtyByDeptNo.do")
    public List<TSpecialty> selectSpecialtyByDeptNo(Integer deptNo){
        System.out.println(deptNo);
        List<TSpecialty> specialtyList = studentService.selectSpecialtyByDeptNo(deptNo);
        return specialtyList;
    }

    /**
     * 使用ajax查询student进行回显
     */
    @ResponseBody
    @RequestMapping("/alterStudent.do")
    public TStudent alterStudent(Integer stuId){
        TStudent student = studentService.selectStudentByUserId(stuId);
        return student;
    }

    /**
     * 删除这个student
     * @param stuId
     */
    @RequestMapping("/deleteStudent.do")
    public void deleteStudent(Integer stuId){
        studentService.deleteStudentByStuId(stuId);
    }

    /**
     * 根据学号查询学生
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectStuByStuNo.do")
    public TStudent selectStuByStuNo(String stuNo){
        System.out.println(stuNo);
        TStudent student = studentService.selectStuByStuNo(stuNo);
        System.out.println(student+"--------------student");
        return student;
    }
}
