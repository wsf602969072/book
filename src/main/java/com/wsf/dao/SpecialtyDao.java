package com.wsf.dao;

import com.wsf.model.TSpecialty;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 7:36
 * @tel:18738322951
 */
public interface SpecialtyDao {
    public List<TSpecialty> selectSpecialtyByDeptNo(Integer deptNo);
}
