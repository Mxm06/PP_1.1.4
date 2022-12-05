package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;


import java.sql.*;
import java.util.Properties;


public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/firstdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Ardashov06";
    static private Connection connection;
    static private SessionFactory sessionFactory;

    static private Properties property = new Properties();

    static {
        try {
            property.put(Environment.URL, "jdbc:mysql://localhost:3306/firstdb");
            property.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            property.put(Environment.USER, "root");
            property.put(Environment.PASS, "Ardashov06");
            property.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            property.put(Environment.SHOW_SQL, "true");
            property.put(Environment.FORMAT_SQL, "true");
            sessionFactory = new Configuration().addProperties(property).addAnnotatedClass(User.class).buildSessionFactory();

        } catch (Exception e) {
            throw e;
        }
    }


    static {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static SessionFactory getSession() throws HibernateException {
        return sessionFactory;
    }

    public static void closeSession() {
        sessionFactory.close();
    }

}
