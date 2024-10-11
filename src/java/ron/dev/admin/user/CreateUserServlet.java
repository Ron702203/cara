/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ron.dev.admin.user;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ron.dev.admin.BaseAdminServlet;
import ron.dev.data.dao.DatabaseDao;
import ron.dev.data.dao.UserDao;
import ron.dev.until.Flash;
import ron.dev.data.dao.model.User;

/**
 *
 * @author ACER
 */
public class CreateUserServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("admin/user/create.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User findUser = userDao.findByEmail(email);
        if (findUser != null) {
            Flash.init((HttpSession) request.getSession());
            Flash.pushError("Email is existed!");
            response.sendRedirect("CreateUserServlet");
        } else {
            User user = new User(name, email, password, role);
            userDao.insert(user);
            response.sendRedirect("IndexUserServlet");
        }
    }

}
