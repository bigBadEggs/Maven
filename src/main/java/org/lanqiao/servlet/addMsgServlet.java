package org.lanqiao.servlet;

import org.lanqiao.dao.MsgDao;
import org.lanqiao.entity.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addMsg")
public class addMsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 获得表单对象
        String msg = request.getParameter("message");
        String name = request.getParameter("username");
        // 2. 封装对象
        Message m = new Message();
        m.setMessage(msg);
        m.setUsername(name);
        // 3. dao操作
        int num = new MsgDao().addUser(m);
        // 1. 重定向
        request.getSession().setAttribute("num", num);
        response.sendRedirect("/showMsg");

        // 4. 返回数据
//        PrintWriter pw = response.getWriter();
//        pw.print(num);
//        pw.flush();
//        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
