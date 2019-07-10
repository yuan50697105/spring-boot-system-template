package com.yuan.spring.boot.dao.mybatis.enhance.commons.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseQueryParams<ID> implements Serializable {
    private ID id;
    private ID[] ids;
    private String createUser;
    private String updateUser;
    private Date createDate;
    private Date updateDate;
    private Date createDateStart;
    private Date createDateEnd;
    private Date updateDateStart;
    private Date updateDateEnd;
}
