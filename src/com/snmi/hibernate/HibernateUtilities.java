package com.snmi.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate utilities class which is using to configure the hibernate, open and close session
 * @author Stefan Mandradzhiyski
 * @version 1.0
 */
public class HibernateUtilities {

    /**
     * Constants
     */
    private static final String HIBERNATE_PATH = "/resources/hibernate.cfg.xml";
    private static final String SESSION_FACTORY_ERROR = "Problem creating session factory!";

    /**
     * Session factory variable
     */
    private static SessionFactory sessionFactory;

    /**
     * Private constructor
     */
    private HibernateUtilities() {}

    /**
     * Static block which is using to configure the hibernate, create a service registry and build session factory
     */
    static{
        try {
            //BE SURE THAT YOU SET THE USERNAME, PASSWORD AND PORT OF YOUR SERVER
            Configuration configuration = new Configuration().configure(HIBERNATE_PATH);

            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .buildServiceRegistry();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException exception) {
            System.out.println(SESSION_FACTORY_ERROR);
        }
    }

    /**
     * @return the session factory instance
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }
}
