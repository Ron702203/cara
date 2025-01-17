/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ron.dev.data.dao;

import java.util.List;
import ron.dev.data.dao.model.Order;

/**
 *
 * @author ACER
 */
public interface OrderDao {

    public void insert(Order order);

    public void update(Order order);

    public void delete(int orderId);

    public Order find(int orderId);

    public Order find(String code);

    public List<Order> findAll();

    public List<Order> findByStatus(String status);

    public int countOrderByDay(String date);

    public int countOrder();

    public int countPendingOrder();

    public int countShippingOrder();

    public int countDeliveredOrder();

    public int countCanceledOrder();

}
