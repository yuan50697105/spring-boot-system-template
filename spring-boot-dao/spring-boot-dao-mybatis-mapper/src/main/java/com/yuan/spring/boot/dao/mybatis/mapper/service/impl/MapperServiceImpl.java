package com.yuan.spring.boot.dao.mybatis.mapper.service.impl;

import com.github.pagehelper.IPage;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuan.spring.boot.dao.commons.entity.dto.ServiceResult;
import com.yuan.spring.boot.dao.commons.utils.ServiceResultUtils;
import com.yuan.spring.boot.dao.mybatis.mapper.dao.MapperDao;
import com.yuan.spring.boot.dao.mybatis.mapper.entity.domain.MapperDomain;
import com.yuan.spring.boot.dao.mybatis.mapper.service.MapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author yuane
 * @date 2019/6/15 23:10
 **/
@Transactional(rollbackFor = Exception.class)
public abstract class MapperServiceImpl<T extends MapperDomain<ID>, ID extends Serializable, S extends MapperDao<T, ID>> implements MapperService<T, ID> {
    @Autowired
    protected S baseDao;

    public S getBaseDao() {
        return baseDao;
    }

    protected abstract T setId(T t);

    protected abstract T setCommonsParameters(T t);

    protected boolean isNew(T t) {
        return StringUtils.isEmpty(t.getId()) && get(t.getId()) == null;
    }

    @Override
    public ServiceResult saveOrUpdate(T t) {
        if (isNew(t)) {
            return save(t);
        } else {
            return update(t);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult saveOrUpdateBatch(T[] arrays) {
        return saveOrUpdateBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult saveOrUpdateBatch(Collection<T> collection) {
        collection.forEach(this::saveOrUpdate);
        return ServiceResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult save(T t) {
        setId(t);
        setCommonsParameters(t);
        getBaseDao().insert(t);
        return ServiceResultUtils.ok();
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult saveBatch(T[] arrays) {
        return saveBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult saveBatch(Collection<T> collection) {
        collection.forEach(this::save);
        return ServiceResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult update(T t) {
        setCommonsParameters(t);
        getBaseDao().updateByPrimaryKeySelective(t);
        return ServiceResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult updateBatch(T[] arrays) {
        return updateBatch(Arrays.asList(arrays));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult updateBatch(Collection<T> collection) {
        collection.forEach(this::update);
        return ServiceResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult deleteById(ID id) {
        getBaseDao().deleteByPrimaryKey(id);
        return ServiceResultUtils.ok();
    }

    @Override
    public ServiceResult deleteById(ID[] ids) {
        return deleteById(Arrays.asList(ids));
    }

    @Override
    public ServiceResult deleteById(Collection<ID> collection) {
        collection.stream().forEach(this::deleteById);
        return ServiceResultUtils.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServiceResult delete(T t) {
        getBaseDao().delete(t);
        return ServiceResultUtils.ok();
    }


    @Override
    public ServiceResult delete(T[] arrays) {
        return delete(Arrays.asList(arrays));
    }

    @Override
    public ServiceResult delete(Collection<T> collection) {
        collection.forEach(this::delete);
        return ServiceResultUtils.ok();
    }

    @Override
    public T get(ID id) {
        return getBaseDao().selectByPrimaryKey(id);
    }

    @Override
    public T findOne(T t) {
        return getBaseDao().selectOne(t);
    }


    @Override
    public PageInfo<T> findAll(IPage page) {
        PageHelper.startPage(page);
        return PageInfo.of(getBaseDao().selectAll());
    }

    @Override
    public PageInfo<T> findAll(T t, IPage page) {
        PageHelper.startPage(page);
        return PageInfo.of(getBaseDao().select(t));
    }

    @Override
    public List<T> findAll() {
        return getBaseDao().selectAll();
    }

    @Override
    public List<T> findAll(T t) {
        return getBaseDao().select(t);
    }


}
