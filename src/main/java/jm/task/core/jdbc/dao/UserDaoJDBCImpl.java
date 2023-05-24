package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    private ResultSet resultSet;

//    private void exeMethod(String qwery) {
//        try {
//            Util util = new Util();
//            Connection conn = util.getConnection();
//            Statement statement = conn.createStatement();
//            statement.execute(qwery);
//            util.getConnection().close();
//        } catch (SQLException e) {
//            // ignored
//        }
//
//    }

    private void exeMethod(String qwery) {

        Util util = null;
        try {
            util = new Util();
        } catch (SQLException e) {
//            ignored
        }

        try (Connection conn = util.getConnection();){
            Statement statement = conn.createStatement();
            statement.execute(qwery);
        } catch (SQLException e) {
            // ignored
        }

    }

    public void createUsersTable() {
        String qwery = "CREATE TABLE Users (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NOT NULL,\n" +
                "  `lastName` VARCHAR(45) NOT NULL,\n" +
                "  `age` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);";
        exeMethod(qwery);
    }

    public void dropUsersTable() {
        String qwery = "DROP TABLE  Users;";
        exeMethod(qwery);
    }

    public void saveUser(String name, String lastName, byte age) {
        String qwery = "INSERT INTO Users (`name`, `lastName`, `age`) VALUES ('" + name + "', '" + lastName + "', '" + age + "');";
        exeMethod(qwery);
    }

    public void removeUserById(long id) {
        String qwery = "DELETE FROM Users WHERE (`id` = '" + id + "');";
        exeMethod(qwery);
    }

    public List<User> getAllUsers() {

        List<User> listUser = new ArrayList<>();

        Util util = null;
        try {
            util = new Util();
        } catch (SQLException e) {
//            throw new RuntimeException(e);
        }

        try (Connection conn = util.getConnection();){
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Users");

            while (resultSet.next()) {
                listUser.add(new User(
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getByte(4)));
            }
            listUser.stream().forEach(System.out::println);
        } catch (SQLException e) {
            // ignored
        }
        return listUser;
    }

    public void cleanUsersTable() {
        String qwery = "DELETE FROM Users;";
        exeMethod(qwery);
    }
}
