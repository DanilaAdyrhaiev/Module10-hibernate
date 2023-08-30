package org.goit.utils;

import org.goit.entities.Client;
import org.goit.entities.Planet;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final HibernateUtil INSTANCE = new HibernateUtil();

    private final SessionFactory sessionFactory;

    private HibernateUtil() {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void close() {
        sessionFactory.close();
    }
}
