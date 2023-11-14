package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {

        UserDao userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();

        userDaoJDBC.saveUser("Мария", "Шереметьевская", (byte) 23);
        userDaoJDBC.saveUser("Денис", "Иванов", (byte) 25);
        userDaoJDBC.saveUser("Михаил", "Гальвас", (byte) 23);
        userDaoJDBC.saveUser("Владик", "Зайцев", (byte) 24);

        System.out.println(userDaoJDBC.getAllUsers());

        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();

    }
}
