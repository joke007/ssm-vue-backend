package com.example.mapper;

import com.example.pojo.Role;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    // 插入用户
    public int insertUser(User user);

    // 将用户角色插入到用户和角色的关联表中
    // @Param允许传递单个参数给xml
    public int insertRoleIdAndUserId(@Param("userId") int userId, @Param("roleId") int roleId);

    // 查询所有用户
    public List<User> selectAllUsers();

    // 查询某个用户
    public User selectUser(User user);

    // 更新某个用户
    public int updateUser(User user);
}
