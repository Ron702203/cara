/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ron.dev.data.dao;
import ron.dev.data.dao.impl.CategoryDaoImp;
import ron.dev.data.dao.impl.OrderDaoImp;
import ron.dev.data.dao.impl.OrderDetailDaoImp;
import ron.dev.data.dao.impl.ProductDaoImp;
import ron.dev.data.dao.impl.UserDaoImp;

/**
 *
 * @author ACER
 */
public class Database extends DatabaseDao{
      @Override
    public UserDao getUserDao() {
        // TODO Auto-generated method stub
        return new UserDaoImp();
    }

    @Override
    public ProductDao getProductDao() {
        return new ProductDaoImp();
    }
    @Override
    public CategoryDao getCategoryDao() {
        return new CategoryDaoImp();
    }

    @Override
    public OrderDao getOrderDao() {
        return new OrderDaoImp();
    }

    @Override
    public OrderDetailDao getOrderDetailDao() {
        return new OrderDetailDaoImp();
    }

}
