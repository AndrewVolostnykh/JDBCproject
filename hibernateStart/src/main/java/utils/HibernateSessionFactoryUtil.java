package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Parameter;

public class HibernateSessionFactoryUtil {
    private static StandardServiceRegistry standardServiceRegistry;
    private static SessionFactory sessionFactory;

    static {
        try {
            if (sessionFactory == null) {
                standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
                Metadata metadata = metadataSources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            if(standardServiceRegistry != null)
            {
                StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
            }
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public static void shutDown()
    {
        if(standardServiceRegistry != null)
        {
            StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
        }
    }
}
