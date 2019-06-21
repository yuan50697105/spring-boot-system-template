package com.yuan.springbootwebmybatisplus.commons.entity.bo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/20 22:56
 **/
@Data
public abstract class BaseBo implements Serializable {
    private Long id;
    private Long[] ids;
    private Iterable<Long> iterable;
    private String createUser;
    private String updateUser;
    private Date createDate;
    private Date updateDate;
    private Date createDateStart;
    private Date createDateEnd;
    private Date updateDateStart;
    private Date updateDateEnd;

    public BaseBo() {
    }

    public BaseBo(Long id, Long[] ids, Iterable<Long> iterable, String createUser, String updateUser, Date createDate, Date updateDate, Date createDateStart, Date createDateEnd, Date updateDateStart, Date updateDateEnd) {
        this.id = id;
        this.ids = ids;
        this.iterable = iterable;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
        this.updateDateStart = updateDateStart;
        this.updateDateEnd = updateDateEnd;
    }

}
