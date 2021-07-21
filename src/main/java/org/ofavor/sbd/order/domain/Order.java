package org.ofavor.sbd.order.domain;

import lombok.Data;
import org.ofavor.sbd.order.domain.exception.OrderInvalidStatusException;
import org.ofavor.sbd.order.domain.exception.OrderItemNotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Order entity
 */
@Data
public class Order {
    private UUID id;

    private List<OrderItem> items;

    private BigDecimal price;

    private OrderStatus status;

    public void addProduct(Product product, int count) {
        if (status != OrderStatus.CREATED) {
            throw new OrderInvalidStatusException();
        }
        if (items == null) {
            items = new ArrayList<>();
        }
        price = price.add(product.getPrice().multiply(BigDecimal.valueOf(count)));
        boolean exists = false;
        UUID pid = product.getId();
        for (OrderItem i : items) {
            if (i.getProductId().equals(pid)) {
                i.setCount(i.getCount() + count);
                exists = true;
                break;
            }
        }
        if (!exists) {
            OrderItem oi = new OrderItem();
            oi.setProductId(pid);
            oi.setProductName(product.getName());
            oi.setPrice(product.getPrice());
            oi.setCount(count);
            items.add(oi);
        }
    }

    public void deleteProduct(Product product, int count) {
        if (status != OrderStatus.CREATED) {
            throw new OrderInvalidStatusException();
        }

        UUID pid = product.getId();
        for (OrderItem i : items) {
            if (i.getProductId().equals(pid)) {
                i.setCount(Math.max(0, i.getCount() - count));
                if (i.getCount() == 0) { // remove item
                    items.remove(i);
                }
                break;
            }
        }

        // re-calculate price
        price = BigDecimal.valueOf(0);
        items.forEach(i -> {
            BigDecimal b = i.getPrice().multiply(BigDecimal.valueOf(i.getCount()));
            price = price.add(b);
        });
    }

    public void confirm() {

    }

    public void pay() {

    }

    public void cancel() {

    }
}
