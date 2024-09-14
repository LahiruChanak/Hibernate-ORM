package lk.ijse.orm.hibernate.entity;

import lk.ijse.orm.hibernate.embedded.OrderDetailPrimaryKey;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Column(name = "order_qty")
    private int qty;

    @Column(name = "order_price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false) // prevent data inserting & updating.
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id", insertable = false, updatable = false)
    private Item item;

    @EmbeddedId // want Embedded class to use this @EmbeddedId
    private OrderDetailPrimaryKey orderDetailPrimaryKey;
}