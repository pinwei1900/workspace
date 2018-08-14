package com.neo.service.base;

import java.util.List;

/**
 * 用来作为抽象使用的mapper，作为一些比较通用的函数作为查询处理
 * @param <T>
 */
public interface BaseMapper<T> {

    T getById(long id);
    List<T> getAll();
    void delete(Long id);
}