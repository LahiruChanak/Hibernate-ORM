package lk.ijse.orm.hibernate;

import lk.ijse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

import java.util.ArrayList;

public class PersistentState {

    public static void main(String[] args) {

        Session session = SessionFactoryConfig.getInstance().getSession();

        Customer customer = new Customer(1, "Kamal", "Galle", new ArrayList<>());

        // Change persistent state of object
        int customerId = (int) session.save(customer);  // Default customer data type is import by serializable method. Want to cast it into an int type
        System.out.println("Customer Id: " + customerId);

        System.out.println(isExistInSession(session, customer));
        session.close();
    }

    private static String isExistInSession(Session session, Customer customer) {
        return session.contains(customer) ? "This object is Persistent" : "This object is in Persistent state";
    }
}
