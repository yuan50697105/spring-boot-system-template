package com.yuan.spring.boot.dao.mybatis.plus.commons.dao;

import com.yuan.spring.boot.dao.mybatis.plus.commons.entity.po.BaseDomain;

/**
 * @author yuane
 * @date 2019/6/15 23:26
 **/
public interface BaseDao<T extends BaseDomain<ID>, ID> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {
}
