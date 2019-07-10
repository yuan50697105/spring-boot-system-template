package com.yuan.spring.boot.dao.mybatis.plus.commons.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.spring.boot.dao.mybatis.plus.commons.dao.BaseDao;
import com.yuan.spring.boot.dao.mybatis.plus.commons.entity.po.BasePo;
import com.yuan.spring.boot.dao.mybatis.plus.commons.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * @author yuane
 * @date 2019/6/15 23:30
 **/
@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<M extends BaseDao<T, ID>, T extends BasePo<ID>, ID> extends ServiceImpl<M, T> implements BaseService<T, ID> {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(T entity) {
        setCommonsParameters(entity);
        return super.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveBatch(T[] arrays) {
        return saveBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveBatch(Collection<T> entityList) {
        entityList = entityList.parallelStream().map(this::setCommonsParameters).collect(Collectors.toList());
        return super.saveBatch(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveBatch(T[] arrays, int batchSize) {
        return saveBatch(Arrays.asList(arrays), batchSize);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        entityList = entityList.parallelStream().map(this::setCommonsParameters).collect(Collectors.toList());
        return super.saveBatch(entityList, batchSize);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateById(T entity) {
        setCommonsParameters(entity);
        return super.updateById(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatchById(T[] arrays) {
        return updateBatchById(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatchById(Collection<T> entityList) {
        entityList = entityList.parallelStream().map(this::setCommonsParameters).collect(Collectors.toList());
        return super.updateBatchById(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatchById(T[] arrays, int batchSize) {
        return updateBatchById(Arrays.asList(arrays), batchSize);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        entityList = entityList.parallelStream().map(this::setCommonsParameters).collect(Collectors.toList());
        return super.updateBatchById(entityList, batchSize);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdate(T entity) {
        setCommonsParameters(entity);
        return super.saveOrUpdate(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateBatch(T[] arrays) {
        return saveOrUpdateBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateBatch(Collection<T> entityList) {
        entityList = entityList.parallelStream().map(this::setCommonsParameters).collect(Collectors.toList());
        return super.saveOrUpdateBatch(entityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateBatch(T[] arrays, int batchSize) {
        return saveOrUpdateBatch(Arrays.asList(arrays), batchSize);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        entityList = entityList.parallelStream().map(this::setCommonsParameters).collect(Collectors.toList());
        return super.saveOrUpdateBatch(entityList, batchSize);
    }

    private T setCommonsParameters(T entity) {
        entity.setCreateDate(new Date());
        entity.setUpdateDate(new Date());
        entity.setCreateUser("");
        entity.setUpdateUser("");
        return entity;
    }


}
