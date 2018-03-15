package com.example.demo.pojo;

public class SysUserRole {
    private Integer roleId;

    private Integer uid;

    public SysUserRole(Integer roleId, Integer uid) {
        this.roleId = roleId;
        this.uid = uid;
    }

    public SysUserRole() {
        super();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}