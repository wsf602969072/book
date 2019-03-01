package com.wsf.controller;

import com.wsf.Condition.LoseCondition;
import com.wsf.model.Page;
import com.wsf.model.TLose;
import com.wsf.service.LoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 10:00
 * @tel:18738322951
 */
@Controller
@RequestMapping("/lose")
public class LoseController {
    @Autowired
    private LoseService loseService;

    @RequestMapping("/addLoseInfo.do")
    public String addLoseInfo(TLose lose,Integer borrowId){
        System.out.println(lose);
        loseService.addLoseInfo(lose,borrowId);
        return "redirect:selectLoseByCondition.do";
    }


    @RequestMapping("/selectLoseByCondition.do")
    public String selectLoseByCondition(LoseCondition condition, Model model){
        String searchType = condition.getSearchType();
        String searchValue = condition.getSearchValue();
        if("bookNo".equals(searchType)){
            condition.setBookNo(searchValue);
        }else if("stuNo".equals(searchType)){
            condition.setStuNo(searchValue);
        }
        if(condition.getPageNo()==null){
            condition.setPageNo(1);
        }
        Page<TLose> page = loseService.selectTloseByCondition(condition);
        model.addAttribute("page",page);
        return "page/lose";
    }


    @ResponseBody
    @RequestMapping("/deleteLoseById.do")
    public String deleteLoseById(Integer loseId){
        try {
            loseService.deleteLoseById(loseId);
            return "删除成功";
        }catch (Exception e){
            return "删除失败,服务器繁忙";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/dealLoseById.do",produces = {"text/html;charset=utf-8"})
    public String dealLoseById(Integer loseId){
        try {
            loseService.dealLoseById(loseId);
            return  "处理成功";
        }catch (Exception e){
            return "处理失败";
        }
    }


}
