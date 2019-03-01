package com.wsf.dao;

import com.wsf.Condition.BookCondition;
import com.wsf.model.TBook;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 4:49
 * @tel:18738322951
 */
public interface BookDao {
    public void saveBook(TBook book);

    public void updateBook(TBook book);

    public Integer selectBookRecordByCondition(BookCondition condition);

    public List<TBook> selectBookByCondition(BookCondition condition);

    public TBook selectBookById(Integer bookId);

    public void deleteBookById(Integer bookId);

    public TBook selectByBookNo(String bookNo);

    public TBook selectByBookId(Integer bookId);
}
