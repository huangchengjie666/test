package ch05.persistence;

import ch05.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
    private static final String INSERT_USER = "INSERT INTO userinfo (username,password,email,age,is_admin) VALUES (?,?,?,?,?)";
    private static final String FIND_USER = "SELECT *FROM userinfo WHERE id = ?";
    private static final String FIND_USER_BY_USERNAME_AND_PASSWORD = "SELECT *FROM userinfo WHERE username = ? AND password = ?";
    private static final String FIND_ALL_USER = "SELECT *FROM userinfo";

    private User resultSetToUser(ResultSet resultSet) {
        User user = new User();
        try {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setAge(resultSet.getInt("age"));
                user.setAdmin(resultSet.getBoolean("is_admin"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return user;
    }

    @Override
    public List<User> findAllUser() {
        List<User> userList = new ArrayList<>();
        try {
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL_USER);
            while(resultSet.next()){
                User user = resultSetToUser(resultSet);
                userList.add(user);
            }
            DBUtil.closeConnection(connection);
            DBUtil.closeStatement(statement);
            DBUtil.closeResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        User user = null;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_USERNAME_AND_PASSWORD);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = resultSetToUser(resultSet);
            }
            DBUtil.closeConnection(connection);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
      return user;
    }

    @Override
    public User findUser(int id) {
        User user = null;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = resultSetToUser(resultSet);
            }
            DBUtil.closeConnection(connection);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public boolean insertUser(User user) {
        int result = 0;
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setInt(4,user.getAge());
            preparedStatement.setInt(5,user.isAdmin()?1:0);

            result = preparedStatement.executeUpdate();
            DBUtil.closeConnection(connection);
            DBUtil.closeStatement(preparedStatement);
            //DBUtil.closeResultSet(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (result>0);

    }

    public static void main(String[] args) {
        UserDaoImpl test = new UserDaoImpl();
        System.out.println(test.findUserByUsernameAndPassword("李四","1234"));
    }
}
