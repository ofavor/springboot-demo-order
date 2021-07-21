package org.ofavor.sbd.order.domain.exception;

public class OrderItemNotFoundException extends Exception {
    public OrderItemNotFoundException() {
        super(3, "Order item not found");
    }
}
