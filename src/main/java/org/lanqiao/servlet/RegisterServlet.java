package org.lanqiao.servlet;

import org.lanqiao.dao.RegisterDaoImpl;
import org.lanqiao.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取数据
        String name = request.getParameter("userName");
        String pwd = request.getParameter("userPwd");
        System.out.println(name);
        if (!name.equals("") && !pwd.equals("")) {
            // 封装数据
            User u = new User();
            u.setUser_name(name);
            u.setUser_pwd(pwd);
            // dao操作哦
            // 查询是否已注册
            List<User> list = new RegisterDaoImpl().select(u);
            System.out.println(list);
            PrintWriter pw = response.getWriter();
            if(list.size() > 0){
                pw.print(0);
            }else {
                int rst = new RegisterDaoImpl().insert(u);
                System.out.println(rst);
               pw.print(rst);
            }
            pw.flush();
            pw.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
