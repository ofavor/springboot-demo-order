package org.ofavor.sbd.order.domain;

import lombok.Data;

import java.math.BigDecimal;
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

    }

    public void deleteProduct(Product product, int count) {

    }

    public void confirm() {

    }

    public void pay() {

    }

    public void cancel() {

    }
}
