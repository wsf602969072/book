package com.wsf.service;

import com.wsf.Condition.BookCondition;
import com.wsf.model.Page;
import com.wsf.model.TBook;
import com.wsf.model.TCatalog;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 4:48
 * @tel:18738322951
 */
public interface BookService {

    public List<TCatalog> selectAllCatalog();


    public List<TCatalog> selectCatalogByParentId(Integer parentId);

    public void saveOrUpdateBook(TBook book);

    public Page<TBook> selectBookByCondition(BookCondition condition);

    public TBook selectBookById(Integer bookId);

    public void deleteBookById(Integer bookId);

    public TBook selectByBookNo(String bookNo);

    public TBook selectByBookId(Integer bookId);
}
