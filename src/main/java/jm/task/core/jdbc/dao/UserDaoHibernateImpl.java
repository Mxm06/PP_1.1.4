package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.OptimisticLockException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class UserDaoHibernateImpl implements UserDao {
    private static final Session session = Util.getSession().openSession();

    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        session.beginTransaction();
        Query query = session.createSQLQuery("CREATE TABLE IF NOT EXISTS `firstdb`.`Users` (\n" +
                "  `id` BIGINT(1) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NOT NULL,\n" +
                "  `lastName` VARCHAR(45) NOT NULL,\n" +
                "  `age` TINYINT(1) NOT NULL,\n" +
                "  PRIMARY KEY (`id`));\n");
        query.executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void dropUsersTable() {
        session.beginTransaction();
        session.createSQLQuery("DROP TABLE IF EXISTS Users").executeUpdate();
        session.getTransaction().commit();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        session.beginTransaction();
        session.save(new User(name, lastName, age));
        session.getTransaction().commit();
    }

    @Override
    public void removeUserById(long id) {
        session.beginTransaction();
        session.createSQLQuery("delete from users where id = :id").setParameter("id", id).executeUpdate();
        session.getTransaction().commit();

    }

    @Override
    public List<User> getAllUsers() {
        return session.createSQLQuery("SELECT * FROM users").addEntity(User.class).getResultList();
    }


    @Override
    public void cleanUsersTable() {
        session.beginTransaction();
        session.createSQLQuery("TRUNCATE TABLE Users").executeUpdate();
        session.getTransaction().commit();
    }
}
