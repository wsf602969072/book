package com.wsf.controller;

import com.wsf.Condition.BorrowCondition;
import com.wsf.exception.BorrowException;
import com.wsf.model.Page;
import com.wsf.model.TBorrow;
import com.wsf.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 9:54
 * @tel:18738322951
 */
@RequestMapping("/borrow")
@Controller
public class BorrowController {

    @Autowired
    private BorrowService borrowService;


    @ResponseBody
    @RequestMapping(value="/borrowBook.do",produces = "application/json; charset=utf-8")
    public String borrowBook(TBorrow borrow){
        System.out.println(borrow);
        try {
            borrowService.borrowBook(borrow);
        } catch (BorrowException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "借书成功";
    }

    @RequestMapping("/selectBorrowByCondition.do")
    public String selectBorrowByCondition(BorrowCondition condition, Model model){
        System.out.println(condition);
        //默认页
        if(condition.getPageNo()==null){
            condition.setPageNo(1);
        }
        String searchType = condition.getSearchType();
        String searchValue = condition.getSearchValue();
        if("bookNo".equals(searchType)){
            condition.setBookNo(searchValue);
        }else if("bookName".equals(searchType)){
            condition.setBookName(searchValue);
        }else if("stuNo".equals(searchType)){
            condition.setStuNo(searchValue);
        }else if("stuName".equals(searchType)){
            condition.setStuName(searchValue);
        }else if("islose".equals(searchType)){
            condition.setIslose(Integer.valueOf(searchValue));
        }

        Page<TBorrow> page = borrowService.selectBorrowByCondition(condition);
        model.addAttribute("page",page);
        model.addAttribute("condition",condition);
        System.out.println(page);
        return "page/borrow";
    }


    /**
     * 删除
     * @param borrowId
     */
    @RequestMapping("/deleteBorrowById.do")
    public void deleteBorrowById(Integer borrowId){
        borrowService.deleteBorrowById(borrowId);

    }

    /**
     * 根据id进行查询
     * @param borrowId
     * @return
     */
    @ResponseBody
    @RequestMapping("/selectBorrowById.do")
    public  TBorrow selectBorrowById(Integer borrowId){
        TBorrow borrow = borrowService.selectBorrowById(borrowId);
        return borrow;
    }


    /**
     * 更新借阅信息
     * @param borrow
     * @return
     */
    @RequestMapping("/UpdateBorrow.do")
    public String UpdateBorrow(TBorrow borrow){
        borrowService.UpdateBorrow(borrow);
        return "redirect:/borrow/selectBorrowByCondition.do";
    }

    @ResponseBody
    @RequestMapping("/returnBookByBorrowId.do")
    public String returnBookByBorrowId(Integer borrowId,Integer bookId){
        System.out.println(borrowId);
        System.out.println(bookId);
        try{
            borrowService.returnBookByBorrowId(borrowId,bookId);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    @ResponseBody
    @RequestMapping("/checkBorrowIsLose.do")
    public String checkBorrowIsLose(Integer borrowId){
        Integer isLose = borrowService.checkBorrowIsLose(borrowId);
        if(isLose == 2){
            return "2";
        }else if(isLose == 1){
            return "1";
        }else {
            return "0";
        }
    }
}
