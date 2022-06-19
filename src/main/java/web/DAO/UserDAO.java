package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDAO {

    public void addUser(User user);

    public void changeUser(User user);

    public void deleteUser(Long id);

    public User getUserById(Long id);

    public List<User> listOfUsers();

}
