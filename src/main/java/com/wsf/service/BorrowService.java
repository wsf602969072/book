package com.wsf.service;

import com.wsf.Condition.BorrowCondition;
import com.wsf.exception.BorrowException;
import com.wsf.model.Page;
import com.wsf.model.TBorrow;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 8:36
 * @tel:18738322951
 */

public interface BorrowService {

    public void borrowBook(TBorrow borrow) throws BorrowException;

    public Page<TBorrow> selectBorrowByCondition(BorrowCondition condition);


    public void deleteBorrowById(Integer borrowId);

    public TBorrow selectBorrowById(Integer borrowId);


   public void UpdateBorrow(TBorrow borrow);

   public void returnBookByBorrowId(Integer borrowId,Integer bookId);

    public Integer checkBorrowIsLose(Integer borrowId);
}
