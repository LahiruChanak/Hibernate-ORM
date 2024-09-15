package lk.ijse.orm.hibernate;

import lk.ijse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RemovedState {

    public static void main(String[] args) {
        Session session = SessionFactoryConfig.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, 1);

        System.out.println(isExistInSession(session, customer));
        session.delete(customer);   // Removed State

        System.out.println(isExistInSession(session, customer));

        transaction.commit();
        session.close();
        /* Garbage collector will remove this object from memory */
    }

    private static String isExistInSession(Session session, Customer customer) {
        return session.contains(customer) ? "This object is Persistent state" : "This object is in Removed state";
    }

}
