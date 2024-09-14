package lk.ijse.orm.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "item")
public class Item {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "item_id")
    private int id;

    @Column (name = "item_name")
    private String name;

    @Column (name = "item_qty")
    private int qty;

    @Column (name = "unit_price")
    private double unitPrice;

    @ManyToMany (mappedBy = "items")
    private List<Order> orders = new ArrayList<>();

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetails = new ArrayList<>();

    public Item() {}

    public Item(int id, String name, int qty, double unitPrice, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.unitPrice = unitPrice;
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

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                ", orders=" + orders +
                '}';
    }
}
