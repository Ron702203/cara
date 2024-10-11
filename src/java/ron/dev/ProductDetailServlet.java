/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ron.dev;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ron.dev.data.dao.DatabaseDao;
import ron.dev.data.dao.ProductDao;
import ron.dev.data.dao.model.Product;

/**
 *
 * @author ACER
 */
public class ProductDetailServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("product_id"));
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        Product product = productDao.find(productId);

        request.setAttribute("product", product);
        request.getRequestDispatcher("productDetail.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
