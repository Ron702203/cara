/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ron.dev.admin.user;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ron.dev.admin.BaseAdminServlet;
import ron.dev.data.dao.DatabaseDao;
import ron.dev.data.dao.UserDao;
import ron.dev.data.dao.model.User;

/**
 *
 * @author ACER
 */
public class EditUserServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(userId);

        request.setAttribute("user", user);
        request.getRequestDispatcher("admin/users/edit.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));

        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(userId);

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        user.setRole(role);

        userDao.update(user);
        response.sendRedirect("IndexUserServlet");
    }

}
