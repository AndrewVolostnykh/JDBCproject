package application.model;

import application.model.Entities.User;
import application.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao {

    public void persist(User user)
    {
        Transaction transaction = null;
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.persist(user);

            transaction.commit();
        } catch (Exception e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(int id)
    {

    }

    public void getUser(int id)
    {

    }

    public User getUserByLogin(String login, String password)
    {
        User user = null;
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM User ser where ser.name =:user_login and ser.password=:user_password");
            query.setParameter("user_login", login);
            query.setParameter("user_password", password);
            List result = query.list();

            if(!result.isEmpty())
            {
                return (User)result.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("NULL");
        return user;
    }

    public void updateUser(User user)
    {

    }
}
