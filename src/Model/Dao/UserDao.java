package Model.Dao;

import Model.Entity.User;

import java.util.List;

public interface UserDao {
    boolean insert(User user);
    boolean delete(User user);
    List<User> getAll();
    User getById(String email);
}
