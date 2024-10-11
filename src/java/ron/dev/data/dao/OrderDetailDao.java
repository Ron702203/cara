/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ron.dev.data.dao;

import java.util.List;
import ron.dev.data.dao.model.OrderDetail;

/**
 *
 * @author ACER
 */
public interface OrderDetailDao {

    public void insert(OrderDetail orderdetail);

    public void update(OrderDetail orderdetail);

    public void delete(int orderdetailId);

    public OrderDetail find(int orderdetailId);

    public List<OrderDetail> findALL();

    public List<OrderDetail> findByOrder(int orderId);
}
