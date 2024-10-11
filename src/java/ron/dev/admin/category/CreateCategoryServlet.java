/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ron.dev.admin.category;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import ron.dev.admin.BaseAdminServlet;
import ron.dev.data.dao.CategoryDao;
import ron.dev.data.dao.DatabaseDao;
import ron.dev.data.dao.model.Category;

/**
 * 
 * @author ACER
 */

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class CreateCategoryServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
//        List<Category> categoryList = categoryDao.findAll();
//
//        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("admin/categories/create.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        String uploadPath = getServletContext().getRealPath("") + File.separator + "upload";

        // Lưu hình ảnh sản phẩm vào thư mục trên server
        // Lưu file vào thư mục trên server
        Part filePart = request.getPart("image");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = filePart.getInputStream();
        Files.copy(fileContent, new File(uploadPath + File.separator + fileName).toPath());

// Lưu thông tin sản phẩm vào cơ sở dữ liệu
        String imageUrl = "upload/" + fileName;
        String name = request.getParameter("name");

        String description = request.getParameter("description");
       

        Category category = new Category(name, imageUrl, description);
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        categoryDao.insert(category);

        response.sendRedirect("IndexCategoryServlet");
    }

}
