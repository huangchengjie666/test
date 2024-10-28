package ch05.persistence;

import ch05.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAllUser();
    public User findUserByUsernameAndPassword(String username ,  String password);
    public User findUser(int id);
    public boolean insertUser(User user);
}
