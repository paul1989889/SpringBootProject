package com.example.demo.pojo;

public class SysRole {
    private Integer id;

    private String available;

    private String description;

    private String role;

    public SysRole(Integer id, String available, String description, String role) {
        this.id = id;
        this.available = available;
        this.description = description;
        this.role = role;
    }

    public SysRole() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }
}