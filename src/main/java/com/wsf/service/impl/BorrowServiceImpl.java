package com.wsf.service.impl;

import com.wsf.Condition.BorrowCondition;
import com.wsf.dao.BookDao;
import com.wsf.dao.BorrowDao;
import com.wsf.exception.BorrowException;
import com.wsf.model.Page;
import com.wsf.model.TBook;
import com.wsf.model.TBorrow;
import com.wsf.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 8:39
 * @tel:18738322951
 */
@Service
public class BorrowServiceImpl implements BorrowService{

    @Autowired
    private BorrowDao borrowDao;

    @Autowired
    private BookDao bookDao;

    @Override
    public void borrowBook(TBorrow borrow) throws BorrowException {
        System.out.println(borrow.getBookId()+"------0000000000");
        //查询该图书在数据库中的数量
        TBook book = bookDao.selectBookById(borrow.getBookId());
        System.out.println(book);
        if(book.getBookNum()>0 && book.getBookStatus()==1){
            //数量大于0并且是上架的状态
            //添加借书记录
            System.out.println("借书成功");
            borrowDao.borrowBook(borrow);

            //减少书的数量
            book.setBookNum(book.getBookNum()-1);
            bookDao.updateBook(book);
        }else{
            throw new BorrowException("图书的数量不足或者是下架的状态");
        }

    }

    @Override
    public Page<TBorrow> selectBorrowByCondition(BorrowCondition condition) {
        Page page = new Page();
        //设置数据
        List<TBorrow> borrowList = borrowDao.selectBorrowByCondition(condition);
        page.setData(borrowList);
        //查询总的记录数
        Integer record = borrowDao.selectAllRecord(condition);
        page.setTotalRecord(record);
        //设置页码
        page.setPageNo(condition.getPageNo());
        //设置一页的记录数
        page.setPageNums(condition.getPageNums());
        return page;
    }

    @Override
    public void deleteBorrowById(Integer borrowId) {
        borrowDao.deleteBorrowById(borrowId);
    }

    @Override
    public TBorrow selectBorrowById(Integer borrowId) {
        return borrowDao.selectBorrowById(borrowId);
    }

    @Override
    public void UpdateBorrow(TBorrow borrow) {
        borrowDao.UpdateBorrow(borrow);
    }

    @Override
    public void returnBookByBorrowId(Integer borrowId,Integer bookId) {
        //修改islose字段
        TBorrow borrow = new TBorrow();
        borrow.setBorrowId(borrowId);
        borrow.setIslose(2);
        borrowDao.UpdateBorrow(borrow);
        //增加图书的数量
        TBook tbook = bookDao.selectByBookId(bookId);
        System.out.println(tbook);
        tbook.setBookNum(tbook.getBookNum()+1);
        bookDao.updateBook(tbook);
    }

    @Override
    public Integer checkBorrowIsLose(Integer borrowId) {
        return borrowDao.checkBorrowIsLose(borrowId);
    }
}
