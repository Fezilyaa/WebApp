package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {

    public void addUser(User user);

    public void changeUser(User user);

    public void deleteUser(Long id);


    public User getUserById(Long id);

    public List<User> listOfUsers();


}
