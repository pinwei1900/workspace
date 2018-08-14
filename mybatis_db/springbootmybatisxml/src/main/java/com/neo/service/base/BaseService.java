package com.neo.service.base;

import java.util.List;

/**
 * 用来实现BaseMapper的基本实现类，用来实现BaseMapper里面的所有方法
 * @param <T>
 */
public class BaseService<T> implements BaseMapper<T> {

    protected BaseMapper<T> dao;

    public T getById(long id) {
        return dao.getById(id);
    }

    public List<T> getAll() {
        return dao.getAll();
    }

    public void delete(Long id) {
        dao.delete(id);
    }
}