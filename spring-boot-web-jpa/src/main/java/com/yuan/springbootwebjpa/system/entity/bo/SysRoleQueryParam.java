package com.yuan.springbootwebjpa.system.entity.bo;

import com.yuan.springbootwebjpa.commons.entity.bo.BaseQueryParam;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/21 22:46
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SysRoleQueryParam extends BaseQueryParam {
    private String name;

    public SysRoleQueryParam() {
    }

    public SysRoleQueryParam(String name) {
        this.name = name;
    }

    @Builder
    public SysRoleQueryParam(String id, String[] ids, Iterable<String> iterable, String createUser, String updateUser, Date createDate, Date createDateStart, Date createDateEnd, Date updateDate, Date updateDateStart, Date updateDateEnd, String name) {
        super(id, ids, iterable, createUser, updateUser, createDate, createDateStart, createDateEnd, updateDate, updateDateStart, updateDateEnd);
        this.name = name;
    }
}
