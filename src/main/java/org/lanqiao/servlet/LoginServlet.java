package org.lanqiao.servlet;

import net.sf.json.JSONArray;
import org.lanqiao.dao.LoginDaoImpl;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取数据
        String name = request.getParameter("userName");
        String pwd = request.getParameter("userPwd");
        if(!name.equals("") && !pwd.equals("")){
//            System.out.println(name);
            // 封装数据
            User u = new User();
            u.setUser_name(name);
            u.setUser_pwd(pwd);
            // dao操作
            List<User> list = new LoginDaoImpl().select(u);
//            System.out.println(list);
            // 返回数据
            PrintWriter pw = response.getWriter();
            pw.print(JSONArray.fromObject(list));
            pw.flush();
            pw.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
