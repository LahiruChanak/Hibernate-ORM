package lk.ijse.orm.hibernate.embedded;

import lk.ijse.orm.hibernate.entity.OrderDetail;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDetailPrimaryKey implements Serializable {

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "item_id")
    private int itemId;

    public OrderDetailPrimaryKey() {}

    public OrderDetailPrimaryKey(int orderId, int itemId, OrderDetail orderDetail) {
        this.orderId = orderId;
        this.itemId = itemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "OrderDetailPrimaryKey{" +
                "orderId=" + orderId +
                ", itemId=" + itemId +
                '}';
    }
}
