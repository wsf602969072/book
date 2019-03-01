package com.wsf.dao;

import com.wsf.Condition.BorrowCondition;
import com.wsf.model.TBorrow;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 8:40
 * @tel:18738322951
 */
public interface BorrowDao {
    public void borrowBook(TBorrow borrow);

    public List<TBorrow> selectBorrowByCondition(BorrowCondition condition);

    public Integer selectAllRecord(BorrowCondition condition);

    public void deleteBorrowById(Integer borrowId);

    public TBorrow selectBorrowById(Integer borrowId);

    public void UpdateBorrow(TBorrow borrow);

    public Integer checkBorrowIsLose(Integer borrowId);
}
