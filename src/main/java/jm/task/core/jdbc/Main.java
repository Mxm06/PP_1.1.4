package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserServiceImpl usi = new UserServiceImpl();
        usi.createUsersTable();
        usi.saveUser("Alex", "Wilson", (byte) 20);
        System.out.println("User с именем – Alex добавлен в базу данных");
        usi.saveUser("Bob", "Rosco", (byte) 30);
        System.out.println("User с именем – Bob добавлен в базу данных");
        usi.saveUser("Ryan", "Gilbert", (byte) 40);
        System.out.println("User с именем – Ryan добавлен в базу данных");
        usi.saveUser("Lilly", "Nelson", (byte) 50);
        System.out.println("User с именем – Lilly добавлен в базу данных");
        System.out.println(usi.getAllUsers());
        usi.cleanUsersTable();
        usi.dropUsersTable();
    }
}
