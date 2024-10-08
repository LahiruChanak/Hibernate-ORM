package lk.ijse.orm.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "Customer")
public class Customer { // Customer main character, Order is a object character

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "customer_id")
    private int id;

    @Column (name = "customer_name")
    private String name;

    @Column (name = "customer_address")
    private String address;

            //There are two FetchTypes available, EAGER and LAZY
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")  // mappedBy = "customer" => Which name Customer is in Order class
    private List<Order> orders = new ArrayList<>();

    public Customer() {}

    public Customer(int id, String name, String address, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.orders = orders;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", orders=" + orders +
                '}';
    }
}
