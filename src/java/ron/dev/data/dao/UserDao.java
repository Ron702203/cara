package ron.dev.data.dao;

import java.util.List;

import ron.dev.data.dao.model.User;

public interface UserDao {

    public boolean insert(User user);

    public boolean update(User user);

    public boolean delete(int id);

    public User find(int id);

    public User find(String email, String password);

    public User findByEmail(String email);

    public List<User> findAll();
    
    public int countUser();

}
