package lk.ijse.orm.hibernate;

import lk.ijse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.orm.hibernate.entity.Customer;
import org.hibernate.Session;

public class EagerVsLazy {

    public static void main(String[] args) {
        Session session = SessionFactoryConfig.getInstance().getSession();

        Customer customer = new Customer();
        customer.setName("Kamal");
        customer.setAddress("Galle");

        session.save(customer);
        session.close();

        // 01. GET Method
        Session getSession = SessionFactoryConfig.getInstance().getSession();
        System.out.println("\n------------------ Calling Get Method ------------------");

        Customer existGetCustomer = getSession.get(Customer.class, 1);
        System.out.println("Customer Id of Get Method: " + existGetCustomer.getId());
        System.out.println("Customer Name of Get Method: " + existGetCustomer.getName());
        getSession.close();


        // 02. LOAD Method
        Session loadSession = SessionFactoryConfig.getInstance().getSession();
        System.out.println("\n------------------ Calling Load Method ------------------");

        Customer existLoadCustomer = loadSession.load(Customer.class, 1);
        System.out.println("Customer Id of Load Method: " + existLoadCustomer.getId());
        System.out.println("Customer Name of Load Method: " + existLoadCustomer.getName());
        loadSession.close();
    }

}
