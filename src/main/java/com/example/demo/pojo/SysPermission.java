package com.example.demo.pojo;

public class SysPermission {
    private Integer id;

    private String available;

    private String name;

    private Integer parentId;

    private String parentIds;

    private String permission;

    private String resourceType;

    private String url;

    public SysPermission(Integer id, String available, String name, Integer parentId, String parentIds, String permission, String resourceType, String url) {
        this.id = id;
        this.available = available;
        this.name = name;
        this.parentId = parentId;
        this.parentIds = parentIds;
        this.permission = permission;
        this.resourceType = resourceType;
        this.url = url;
    }

    public SysPermission() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available == null ? null : available.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType == null ? null : resourceType.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}