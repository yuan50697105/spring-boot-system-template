package com.yuan.spring.boot.dao.mybatis.plus.commons.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yuan.spring.boot.dao.mybatis.plus.commons.entity.po.BasePo;

/**
 * @author yuane
 * @date 2019/6/15 23:27
 **/
public interface BaseService<T extends BasePo<ID>, ID> extends IService<T> {
    void checkSave(T t) throws RuntimeException;

    void checkUpdate(T t) throws RuntimeException;

    void checkSaveOrUpdate(T t) throws RuntimeException;

    boolean saveBatch(T[] arrays);

    boolean saveBatch(T[] arrays, int batchSize);

    boolean updateBatchById(T[] arrays);

    boolean updateBatchById(T[] arrays, int batchSize);

    boolean saveOrUpdateBatch(T[] arrays);

    boolean saveOrUpdateBatch(T[] arrays, int batchSize);
}
