package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.lanqiao.dao.MsgDao;
import org.lanqiao.entity.Message;
import org.lanqiao.util.JsonDateValueProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@WebServlet("/showMsg")
public class showMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int num = Integer.parseInt(request.getParameter("num"));
//        int size = Integer.parseInt(request.getParameter("size"));

        List<Message> list = new MsgDao().showMsg(1, 3);

        // 转发到jsp
        request.setAttribute("list", list); // 数据转递
        request.getRequestDispatcher("Msg.jsp").forward(request, response); //页面跳转

        // 日期格式化
//        JsonConfig jsonConfig = new JsonConfig();
//        jsonConfig.registerJsonValueProcessor(Date.class , new JsonDateValueProcessor());
//        JSONArray ja = JSONArray.fromObject(list, jsonConfig);
//
//        // 添加记录
//        ja.add(new MsgDao().getMsgCount());
//
//        PrintWriter pw = response.getWriter();
//        pw.print(ja);
//        pw.flush();
//        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
