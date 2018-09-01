package org.lanqiao.dao;

import org.lanqiao.entity.User;

import java.util.List;

public interface LoginDao {
    // 查询
    public List<User> select(User u);
}
