import org.hibernate.SessionFactory;
import utils.HibernateSessionFactoryUtil;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    }
}
