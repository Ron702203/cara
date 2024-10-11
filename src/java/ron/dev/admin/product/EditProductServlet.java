/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ron.dev.admin.product;

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
import ron.dev.data.dao.ProductDao;
import ron.dev.data.dao.model.Product;
import ron.dev.data.dao.model.Category;
import ron.dev.until.Constants;

/**
 *
 * @author ACER
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)

public class EditProductServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("product_id"));
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        Product product = productDao.find(productId);

        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        List<Category> categoryList = categoryDao.findAll();

        request.setAttribute("categoryList", categoryList);
        request.setAttribute("product", product);
        request.getRequestDispatcher("admin/products/edit.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String oldImage = request.getParameter("oldImage");
        Part filePart = request.getPart("img");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String imagePath = null;
        if (!fileName.isEmpty()) {
            // Lưu file vào thư mục uploads
            InputStream fileContent = filePart.getInputStream();
            String uploadPath = getServletContext().getRealPath("") + File.separator + "upload";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            Files.copy(fileContent, new File(uploadPath + File.separator + fileName).toPath());

            // Cập nhật đường dẫn ảnh trong database
            imagePath = "upload/" + fileName;
        } else {
            // Nếu không có file ảnh mới được chọn, sử dụng đường dẫn ảnh cũ
            imagePath = oldImage;
        }

        int productId = Integer.parseInt(request.getParameter("product_id"));
        int categoryId = Integer.parseInt(request.getParameter("category_id"));

        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        Product product = productDao.find(productId);

        String name = request.getParameter("name");
        String img = request.getParameter("img");
        String description = request.getParameter("description");

        product.setName(name);
        product.setImg(imagePath);
        product.setDescription(description);
        product.setCategoryId(categoryId);

        productDao.update(product);
        response.sendRedirect("IndexProductServlet");
    }
}
