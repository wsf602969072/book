package com.wsf.service.impl;

import com.wsf.Condition.BookCondition;
import com.wsf.dao.BookDao;
import com.wsf.dao.CatalogDao;
import com.wsf.model.Page;
import com.wsf.model.TBook;
import com.wsf.model.TCatalog;
import com.wsf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 4:49
 * @tel:18738322951
 */
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private CatalogDao catalogDao;

    @Autowired
    private BookDao bookDao;

    @Override
    public List<TCatalog> selectAllCatalog() {

        return catalogDao.selectAllCatalog();
    }

    @Override
    public List<TCatalog> selectCatalogByParentId(Integer parentId) {
        return catalogDao.selectCatalogByParentId(parentId);
    }

    @Override
    public void saveOrUpdateBook(TBook book) {
        if(book.getBookId() == null) {
            //说明是新增
            bookDao.saveBook(book);
        }else{
            //说明是修改
            bookDao.updateBook(book);
        }
    }


    @Override
    public Page<TBook> selectBookByCondition(BookCondition condition) {
        Page<TBook> page = new Page<>();
        //设置pageNo
        page.setPageNo(condition.getPageNo());
        //设置data
        List<TBook> bookList = bookDao.selectBookByCondition(condition);
        page.setData(bookList);
        //设置pageNums
        page.setPageNums(condition.getPageNums());
        //设置总的记录数
        Integer record = bookDao.selectBookRecordByCondition(condition);
        page.setTotalRecord(record);
        return page;
    }

    @Override
    public TBook selectBookById(Integer bookId) {
        return bookDao.selectBookById(bookId);
    }

    @Override
    public void deleteBookById(Integer bookId) {
        bookDao.deleteBookById(bookId);
    }

    @Override
    public TBook selectByBookNo(String bookNo) {
        return bookDao.selectByBookNo(bookNo);
    }

    @Override
    public TBook selectByBookId(Integer bookId) {
        return bookDao.selectByBookId(bookId);
    }
}
