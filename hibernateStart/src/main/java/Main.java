import model2.Message;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception
    {
        Message message = new Message("helllo, this is first message");
        Message message1 = new Message("hey, there is second message in one transaction :)");
        Transaction transaction = null;

        FirstCrud.saveMessage(message);
        FirstCrud.saveMessage(message1);
        message.setText("Another text in message");
        FirstCrud.saveOrUpdate(message);
//        FirstCrud.removeMessage(1);
//        FirstCrud.removeMessage(2);
//        System.out.println(FirstCrud.getMessageById(1).getText() + ": got by id");
//        System.out.println(FirstCrud.getMessageById(30).getText() + ": got by id");
        System.out.println(FirstCrud.getMessage(1).getText() + ": got by simple session.get()");

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
