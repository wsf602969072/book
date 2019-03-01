package com.wsf.dao;

import com.wsf.Condition.LoseCondition;
import com.wsf.model.TLose;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 4:21
 * @tel:18738322951
 */
public interface LoseDao {

    public  void addLoseInfo(TLose lose);

    public List<TLose> selectLoseByConditon(LoseCondition condition);

    public Integer selectAllRecordByCondition(LoseCondition condition);

    public void deleteLoseById(Integer loseId);

    public void dealLoseById(Integer loseId);
}
