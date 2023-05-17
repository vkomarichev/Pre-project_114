package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
//        userService.cleanUsersTable();
//        userService.dropUsersTable();
//        userService.createUsersTable();
        userService.getAllUsers();

        User user1 = new User("John", "Johnson", (byte)23);
        User user2 = new User("Olga", "Petrova", (byte)34);
        User user3 = new User("Steave", "Jobs", (byte)48);
        User user4 = new User("Lev", "Bushinskiy", (byte)56);

//        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
//        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
//        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
//        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

    }
}
