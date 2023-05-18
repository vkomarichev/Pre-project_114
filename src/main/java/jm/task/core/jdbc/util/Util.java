package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private final String NAME = "root";
    private final String PASS = "12345678";

    private Connection connection = DriverManager.getConnection(URL, NAME, PASS);

    public Util() throws SQLException {
    }

    public Connection getConnection() {
        return this.connection;
    }


}
