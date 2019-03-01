package com.wsf.dao;

import com.wsf.model.TCatalog;

import java.util.List;

/**
 * @author: WangShangfei
 * @date: 2019 -下午 4:51
 * @tel:18738322951
 */
public interface CatalogDao {
    public List<TCatalog> selectAllCatalog();

    public List<TCatalog> selectCatalogByParentId(Integer parentId);
}
