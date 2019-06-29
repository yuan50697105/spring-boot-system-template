package com.yuan.springbootwebmapper.system.entity.po;

import com.yuan.springbootwebmapper.commons.entity.po.BasePo;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;
import java.util.Date;

/**
 * @author yuane
 * @date 2019/6/29 14:22
 **/
@EqualsAndHashCode(callSuper = true)
@Table(name = "sys_user")
@Data
public class SysUser extends BasePo {
    private String username;
    private String password;
    private String name;
    private String nameSpellFull;
    private String nameSpellSimple;
    private Integer enabled;

    public SysUser() {
    }

    public SysUser(String username, String password, String name, String nameSpellFull, String nameSpellSimple, Integer enabled) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.nameSpellFull = nameSpellFull;
        this.nameSpellSimple = nameSpellSimple;
        this.enabled = enabled;
    }

    @Builder
    public SysUser(String id, String createUser, String updateUser, Date createDate, Date updateDate, String username, String password, String name, String nameSpellFull, String nameSpellSimple, Integer enabled) {
        super(id, createUser, updateUser, createDate, updateDate);
        this.username = username;
        this.password = password;
        this.name = name;
        this.nameSpellFull = nameSpellFull;
        this.nameSpellSimple = nameSpellSimple;
        this.enabled = enabled;
    }
}
