package org.lanqiao.dao;

import org.lanqiao.entity.Message;
import java.util.List;

public class MsgDao extends BaseDao<Message>{
    public List<Message> showMsg(int pageNum, int pageSize){
        List<Message> userList = executeQuery("select * from msgDB limit ?,?",
                new Object[]{(pageNum-1)*pageSize, pageSize});
        return userList;
    }
    public int addUser(Message m){
        return executeUpdate("insert into msgDB(username, message) values (?,?)",
                new Object[]{m.getUsername(), m.getMessage()});
    }
    public int getMsgCount(){
        return getRecordCount("select count(*) from msgDB");
    }
}
