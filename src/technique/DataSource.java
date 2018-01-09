<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package technique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author YACINE
 */
public class DataSource {


//    String url = "jdbc:mysql://localhost:3306/symfony_espritforal";
//    String login = "root";
//    String password = "";
     String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3214864";
     String login = "sql3214864";
     String password = "AsqS46bvbR";
    private Connection connection;

    private static DataSource instance;

    private DataSource() {
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package technique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author YACINE
 */
public class DataSource {

    String url = "jdbc:mysql://sql3.freemysqlhosting.net:3306/sql3214864";
    String login = "sql3214864";
    String password = "AsqS46bvbR";
    //String url = "jdbc:mysql://localhost:3306/symfony_espritforal";
    //String login = "root";
    //String password = "";
    private Connection connection;

    private static DataSource instance;

    private DataSource() {
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
>>>>>>> e86f34c87360b9ca1efe575f7e9bc69bfa253036
