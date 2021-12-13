package com.example.pojo;

import java.util.List;

public class Role {
    // 角色ID
    private String id;

    // 角色名称
    private String roleName;

    // 角色对应的用户，一对多关系
    private List<User> userList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                ", roleName='" + roleName + '\'' +
                ", userList=" + userList +
                '}';
    }
}
