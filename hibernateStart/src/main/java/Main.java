import model2.Message;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Message message = new Message("helllo, this is first message");
        Message message1 = new Message("hey, there is second message in one transaction :)");
        Transaction transaction = null;
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession())
        {
            transaction = session.beginTransaction();
            session.save(message);
            session.save(message1);
            transaction.commit();
        } catch (Exception e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }

            e.printStackTrace();
        }

        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession())
        {
            List<Message> messages = session.createQuery("from Message", Message.class).list();
            messages.forEach(m -> System.out.println(m.getId() + ", message :  " + m.getText()));
        } catch(Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
}
