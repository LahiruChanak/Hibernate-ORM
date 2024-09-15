package lk.ijse.orm.hibernate;

import lk.ijse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

import java.util.ArrayList;

public class TransientState {

    public static void main(String[] args) {
        Session session = SessionFactoryConfig.getInstance().getSession();

        Customer customer = new Customer(1, "Kamal", "Galle", new ArrayList<>());

        System.out.println(isExistInSession(session, customer));
        session.close();
    }

    private static String isExistInSession(Session session, Customer customer) {
        return session.contains(customer) ? "This object is not Transient" : "This object is in Transient state";
    }
}
