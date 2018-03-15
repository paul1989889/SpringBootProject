package com.example.demo.pojo;

public class SysRolePermission {
    private Integer permissionId;

    private Integer roleId;

    public SysRolePermission(Integer permissionId, Integer roleId) {
        this.permissionId = permissionId;
        this.roleId = roleId;
    }

    public SysRolePermission() {
        super();
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}