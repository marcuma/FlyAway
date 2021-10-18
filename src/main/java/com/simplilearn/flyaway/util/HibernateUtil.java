package com.simplilearn.flyaway.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


/**
 * Created: 10/07/2021 - 1:55 PM
 * Project: FlyAway
 *
 * @author marcuma
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static Session session;

    static {
        try {
            StandardServiceRegistry standardServiceRegistry =
                    new StandardServiceRegistryBuilder()
                            .configure("hibernate.cfg.xml")
                            .build();
            Metadata metadata = new MetadataSources(standardServiceRegistry)
                    .getMetadataBuilder().build();

            sessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static Session getSession() {
        session = sessionFactory.openSession();
        return session;
    }

    public static void closeSession() {
        session.close();
    }
}
