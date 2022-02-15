package DAO;


import java.sql.Connection;

import static java.sql.DriverManager.getConnection;

public class Datahepler {
    private static String DB_URL = "jdbc:mysql://localhost:3306/doanjava";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";

    public static Connection openConnection() throws Exception {

            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            return conn;

    }

}
