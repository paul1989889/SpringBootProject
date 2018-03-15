package com.example.demo.pojo;

public class User {
    private String uid;
    //帐号
    private String username;
    //名称（昵称或者真实姓名，不同系统不同定义）
    private String name;
    //密码
    private String password;
    //加密密码的盐
    private String salt;
    ////用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
    private String state;

    public User(String uid, String username, String name, String password, String salt, String state) {
        this.uid = uid;
        this.username = username;
        this.name = name;
        this.password = password;
        this.salt = salt;
        this.state = state;
    }

    public User() {
        super();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}