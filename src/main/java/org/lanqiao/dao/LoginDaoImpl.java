package org.lanqiao.dao;

import org.lanqiao.entity.User;

import java.util.List;

public class LoginDaoImpl extends BaseDao<User> implements LoginDao {
    @Override
    public List<User> select(User u) {
        return executeQuery("select * from user where user_name = ? " +
                "and user_pwd = ?", new Object[]{u.getUser_name(), u.getUser_pwd()});
    }
}
