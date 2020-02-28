import antlr.debug.MessageAdapter;
import model2.Message;
import model2.ModelDao;
import model2.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception
    {
        Transaction transaction = null;

        ModelDao modelDao = new ModelDao();

        Student student = new Student("Andrew", "Test", "TestNewtEST");

        Message message = new Message("Hello, this message printed by Andrew Test");
        Message newMessage = new Message("new message by Andrew test");

        student.addMessage(message);
        student.addMessage(newMessage);

        modelDao.addEntity(student);

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
