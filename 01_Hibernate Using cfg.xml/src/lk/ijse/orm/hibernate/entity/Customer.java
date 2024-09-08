package lk.ijse.orm.hibernate.entity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/* We can define the @Entity and @Table(name = "customer") OR @Entity(name = "customer") without @Table */
@Entity
@Table (name = "customer")
public class Customer {

    @Id // Tells hibernate this is the primary key of the table
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "customer_id")
    private int id;

    @Column (name = "customer_name")
    private String name;

    @Column (name = "customer_address")
    private String address;

    @Column (name = "customer_salary")
    private double salary;

    public Customer() {
    }

    public Customer(int id, String name, String address, double salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }

}
