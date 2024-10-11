/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ron.dev.admin.category;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ron.dev.admin.BaseAdminServlet;
import ron.dev.data.dao.CategoryDao;
import ron.dev.data.dao.DatabaseDao;

/**
 *
 * @author ACER
 */
public class DeleteCategoryServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int categoryId = Integer.parseInt(request.getParameter("category_id"));
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        categoryDao.delete(categoryId);

        response.sendRedirect("IndexCategoryServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
