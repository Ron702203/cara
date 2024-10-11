/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ron.dev.admin;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import ron.dev.data.dao.DatabaseDao;
import ron.dev.data.dao.OrderDao;
import ron.dev.data.dao.ProductDao;
import ron.dev.data.dao.UserDao;
import ron.dev.data.dao.model.Product;
import ron.dev.data.dao.model.Order;
import ron.dev.until.Constants;
import ron.dev.until.GetDateTime;
import ron.dev.data.dao.Database;
import ron.dev.data.dao.model.OrderDetail;

/**
 *
 * @author ACER
 */
public class DashBoardServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();

        int countUser = userDao.countUser();
        int countProduct = productDao.countProduct();
        int countOrder = orderDao.countOrder();
        int countPendingOrder = orderDao.countPendingOrder();
        int countShippingOrder = orderDao.countShippingOrder();
        int countDeliveredOrder = orderDao.countDeliveredOrder();
        int countCanceledOrder = orderDao.countCanceledOrder();

        List<String> dateList = GetDateTime.get7Date();
         List<Integer> countEachDay = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            countEachDay.add(orderDao.countOrderByDay(dateList.get(i)));
        }

        request.setAttribute("countEachDay", countEachDay);
        request.setAttribute("dateList", dateList);
        request.setAttribute("countProduct", countProduct);
        request.setAttribute("countOrder", countOrder);
        request.setAttribute("countUser", countUser);
        request.setAttribute("countPendingOrder", countPendingOrder);
        request.setAttribute("countShippingOrder", countShippingOrder);
        request.setAttribute("countDeliveredOrder", countDeliveredOrder);
        request.setAttribute("countCanceledOrder", countCanceledOrder);
        request.getRequestDispatcher("admin/dashboard.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    private double getTotal() {
        double total = 0;
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        List<Order> orderList = orderDao.findByStatus("finished");
        for (Order order : orderList) {
            List<OrderDetail> orderDetaiList = Database.getInstance().getOrderDetailDao().findByOrder(order.id);
            total += sum(orderDetaiList);
        }
        return total;
    }

    private double sum(List<OrderDetail> orderDetaiList) {
        double s = 0;
        for (OrderDetail orderDetail : orderDetaiList) {
            s += orderDetail.amount * orderDetail.price;
        }

        return s;
    }

}
