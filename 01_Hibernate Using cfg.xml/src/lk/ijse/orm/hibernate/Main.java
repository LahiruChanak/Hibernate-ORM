package lk.ijse.orm.hibernate;

import lk.ijse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer();
//        customer.setId(1);
        customer.setName("Kamal");
        customer.setAddress("Galle");
        customer.setSalary(25000.00);


         // 01. Save New Customer
        Session saveSession = SessionFactoryConfig.getInstance().getSession();  // Request new Session from Factory

        Transaction saveTransaction = saveSession.beginTransaction();   // Start Transaction
        saveSession.save(customer); // Save Customer Object
        saveTransaction.commit();   // Commit Transaction
        saveSession.close();    // Close the Session

        /*
        // 02. Update Existing Customer
        Session updateSession = SessionFactoryConfig.getInstance().getSession();

        Transaction updateTransaction = updateSession.beginTransaction();
        customer.setName("Nimal");
        customer.setAddress("Colombo");
        customer.setSalary(50000.00);
        updateSession.update(customer);

        updateTransaction.commit();
        updateSession.close();


        // 03. Get Existing Customer
        Session getSession = SessionFactoryConfig.getInstance().getSession();

        Customer existingCustomer = getSession.get(Customer.class, 2);   // Get Customer Object
        System.out.println("\nExisting Customer: " + existingCustomer);


        // 04. Delete Existing Customer
        Session deleteSession = SessionFactoryConfig.getInstance().getSession();
        Transaction deleteTransaction = deleteSession.beginTransaction();

        deleteSession.delete(existingCustomer);
        deleteTransaction.commit();
        deleteSession.close();
*/
    }
}
