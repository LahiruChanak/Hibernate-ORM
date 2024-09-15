package lk.ijse.orm.hibernate;

import lk.ijse.orm.hibernate.config.SessionFactoryConfig;
import lk.ijse.orm.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SQLQueryEvaluator {

    public static void main(String[] args) {

        Session session = SessionFactoryConfig.getInstance().getSession();

        String sql = "SELECT C FROM Customer AS C"; // Can get required entity as 'C.name', 'C.address'. To get all use 'C'

        Query query = session.createQuery(sql);
        List<Customer> list = query.list();

        for (Customer customer : list) {
            System.out.println(customer);
        }
    }
}
