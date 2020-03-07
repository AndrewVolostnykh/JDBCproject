package application.model;

import application.model.Entities.User;
import application.utils.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {

    public void persist(User user)
    {
        Transaction transaction = null;
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(user);

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

    public void testPersist(User user)
    {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {

            session.save(user);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void delete(int id)
    {

    }

    public void getUser(int id)
    {

    }

    public void updateUser(User user)
    {

    }
}
