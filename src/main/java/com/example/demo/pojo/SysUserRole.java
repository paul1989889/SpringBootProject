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

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SysUserRole that = (SysUserRole) o;

        if (!roleId.equals(that.roleId)){
            return false;
        }
        return uid.equals(that.uid);
    }

    @Override
    public int hashCode() {
        int result = roleId.hashCode();
        result = 31 * result + uid.hashCode();
        return result;
    }
}