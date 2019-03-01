package com.wsf.service.impl;

import com.wsf.Condition.LoseCondition;
import com.wsf.dao.BorrowDao;
import com.wsf.dao.LoseDao;
import com.wsf.model.Page;
import com.wsf.model.TBorrow;
import com.wsf.model.TLose;
import com.wsf.service.LoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 4:20
 * @tel:18738322951
 */
@Service
public class LoseServiceImpl implements LoseService{

    @Autowired
    private BorrowDao borrowDao;

    @Autowired
    private LoseDao loseDao;

    @Override
    public void addLoseInfo(TLose lose,Integer borrowId) {
        //修改借书的信息
        TBorrow borrow = new TBorrow();
        borrow.setBorrowId(borrowId);
        borrow.setIslose(1);
        borrowDao.UpdateBorrow(borrow);
        //添加丢失信息
        loseDao.addLoseInfo(lose);
    }

    @Override
    public Page<TLose> selectTloseByCondition(LoseCondition condition) {
        Page<TLose> page = new Page<>();
        //设置数据
        List<TLose> list = loseDao.selectLoseByConditon(condition);
        page.setData(list);
        //设置记录数
        Integer record = loseDao.selectAllRecordByCondition(condition);
        page.setTotalRecord(record);
        //设置一页的记录数
        page.setPageNums(condition.getPageNums());
        //设置当前页码
        page.setPageNo(condition.getPageNo());
        return page;
    }

    @Override
    public void deleteLoseById(Integer loseId) {
        loseDao.deleteLoseById(loseId);
    }

    @Override
    public void dealLoseById(Integer loseId) {
        loseDao.dealLoseById(loseId);
    }
}
