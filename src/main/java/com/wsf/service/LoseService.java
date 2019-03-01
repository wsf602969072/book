package com.wsf.service;

import com.wsf.Condition.LoseCondition;
import com.wsf.model.Page;
import com.wsf.model.TLose;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 4:19
 * @tel:18738322951
 */
public interface LoseService {

    public void addLoseInfo(TLose lose,Integer borrowId);

    public Page<TLose> selectTloseByCondition(LoseCondition condition);

    public void deleteLoseById(Integer loseId);

    public void dealLoseById(Integer loseId);
}
