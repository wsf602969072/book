package com.wsf.controller;

import com.wsf.Condition.BookCondition;
import com.wsf.model.Page;
import com.wsf.model.TBook;
import com.wsf.model.TCatalog;
import com.wsf.service.BookService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 4:01
 * @tel:18738322951
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;


    @ResponseBody
    @RequestMapping("/selectCatalogByParentId.do")
    public List<TCatalog> selectCatalogByParentId(Integer parentId){
        //查询二级分类
        List<TCatalog> catalogList =  bookService.selectCatalogByParentId(parentId);
        return catalogList;
    }

    /**
     * 添加或者修改图书
     */
    @RequestMapping("/saveOrUpdateBook.do")
    public String saveOrUpdateBook(TBook book){
        System.out.println(book);
        bookService.saveOrUpdateBook(book);
        return "redirect:/book/selectBookByCondition.do";
    }

    /**
     * 通过条件进行查询
     * @param condition
     */
    @RequestMapping("/selectBookByCondition.do")
    public String selectBookByCondition(BookCondition condition,Model model){
        System.out.println(condition);
        //查询图书的一级分类
        List<TCatalog> catalogList = bookService.selectAllCatalog();
        model.addAttribute("catalogList",catalogList);

        String searchType = condition.getSearchType();
        String searchValue = condition.getSearchValue();
        if("bookNo".equals(searchType)){
            condition.setBookNo(searchValue);
        }else if("bookName".equals(searchType)){
            condition.setBookName(searchValue);
        }else if("bookAuthor".equals(searchType)){
            condition.setBookAuthor(searchValue);
        }else if("bookStatus".equals(searchType)){
            condition.setBookStatus(Integer.valueOf(searchValue));
        }else if("cataName".equals(searchType)){
            condition.setCataName(searchValue);
        }
        if(condition.getPageNo() == null){
            condition.setPageNo(1);
        }
        Page<TBook> page =  bookService.selectBookByCondition(condition);
        model.addAttribute("page",page);
        model.addAttribute("condition",condition);
        return "page/book";
    }

    /**
     * 修改
     * @param bookId
     * @return
     */
    @ResponseBody
    @RequestMapping("/alterBook.do")
    public TBook alterBook(Integer bookId){
        TBook book = bookService.selectBookById(bookId);
        return book;
    }

    @RequestMapping("/deleteBookById.do")
    public void deleteBookById(Integer bookId){
        System.out.println(bookId);
        bookService.deleteBookById(bookId);
    }

    @ResponseBody
    @RequestMapping("/selectByBookNo.do")
    public TBook selectByBookNo(String bookNo){
        TBook book = bookService.selectByBookNo(bookNo);
        return book;
    }

    @ResponseBody
    @RequestMapping("/selectkByBookId.do")
    public TBook selectkByBookId(Integer bookId){
        TBook book = bookService.selectByBookId(bookId);
        return book;
    }
}
