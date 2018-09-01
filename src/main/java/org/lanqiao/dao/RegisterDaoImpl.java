package org.lanqiao.dao;

import org.lanqiao.entity.User;

import java.util.List;

public class RegisterDaoImpl extends BaseDao<User> implements RegisterDao{
    String phone = "1873511589";
    @Override
    public int insert(User u) {
        return executeUpdate("insert into user(user_phone, user_name, user_pwd) " +
                        "values('1873511589', ?, ?)",
                new Object[]{u.getUser_name(), u.getUser_pwd()});
    }

    @Override
    public List<User> select(User u) {
        return executeQuery("select user_name from user where user_name=?",
                new Object[]{u.getUser_name()});
    }
}
