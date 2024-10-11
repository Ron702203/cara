package ron.dev.data.dao;

import java.util.List;

import ron.dev.data.dao.model.Product;

public interface ProductDao {

    public boolean insert(Product product);

    public boolean update(Product product);

    public boolean delete(int id);

    public Product find(int id);

    public List<Product> findAll();

    public List<Product> findByName(String name);

    public List<Product> findbyCategory(int category_id);

    public int countProduct();
}
