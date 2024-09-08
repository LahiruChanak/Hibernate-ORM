package lk.ijse.orm.hibernate.config;

import lk.ijse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;

    private final SessionFactory sessionFactory;

    private SessionFactoryConfig() {
        /* 3 Steps of native Bootstrapping. */

        // Step 01 - Create StandardServiceRegistry Object

        // Step 02 - Create Metadata Object

        // Step 03 - Create SessionFactory Object
        sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure().build())
                .addAnnotatedClass(Customer.class)
                .getMetadataBuilder().build().buildSessionFactory();

        new Configuration().configure().addAnnotatedClass(Customer.class);
    }

    /* Singleton the class to avoid object recreation. */
    public static SessionFactoryConfig getInstance() {
        return (factoryConfig == null) ? factoryConfig = new SessionFactoryConfig() : factoryConfig;
    }

    /*  Get Session Object */
    public Session getSession() {
/*
        // ***** 3 Steps of native Bootstrapping *****

        // step 01 - Create StandardServiceRegistry Object
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        // step 02 - Create Metadata Object
        Metadata metadata = new MetadataSources()
                .addAnnotatedClass(Customer.class)
                .getMetadataBuilder().build();

        // step 03 - Create SessionFactory Object
        sessionFactory = metadata.buildSessionFactory();
*/

        return sessionFactory.openSession();
    }

}
