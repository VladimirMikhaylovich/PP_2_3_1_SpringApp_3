package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {

    public User getUser(int id);

    public void save(User user);

    public void update(int id, User updatedUser);

    public void delete(int id);

    List<User> getAllUsers();

}
