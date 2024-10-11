/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ron.dev;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ron.dev.data.dao.DatabaseDao;
import ron.dev.data.dao.UserDao;
import ron.dev.until.Flash;
import ron.dev.until.MD5Hashing;
import ron.dev.data.dao.model.User;

/**
 *
 * @author ACER
 */
public class LoginServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("user") != null) {
            response.sendRedirect("HomeServlet");
        } else {
            Flash.init(request.getSession());
            request.setAttribute("error", Flash.getError());
            request.getRequestDispatcher("login.jsp").forward(request, response);
            Flash.pushError("");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDao userDao = DatabaseDao.getInstance().getUserDao();

        String email = request.getParameter("email");
        String password = MD5Hashing.getMD5(request.getParameter("password"));

        User findUser = userDao.findByEmail(email);
        if (findUser != null) {
            if (findUser.getPassword().equals(password)) {
                //Set session login
                HttpSession session = request.getSession();
                session.setAttribute("user", findUser);
                if (findUser.getRole().equals("admin")) {
                    response.sendRedirect("DashBoardServlet");
                } else {
                    response.sendRedirect("HomeServlet");
                }   
            } else {
                response.sendRedirect("LoginServlet");
                Flash.init(request.getSession());
                Flash.pushError("Password not correct");
            }
        } else {
            Flash.init(request.getSession());
            Flash.pushError("Email not exist");
            response.sendRedirect("LoginServlet");
        }

    }

}
