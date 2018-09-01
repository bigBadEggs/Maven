package org.lanqiao.dao;

import org.lanqiao.entity.User;

import java.util.List;

public interface RegisterDao {
    // 插入
    public int insert(User u);
    // 查询
    public List<User> select(User u);
}
