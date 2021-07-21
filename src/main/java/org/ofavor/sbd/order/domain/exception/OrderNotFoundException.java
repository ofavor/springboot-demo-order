package org.ofavor.sbd.order.domain.exception;

public class OrderNotFoundException extends Exception {

    public OrderNotFoundException() {
        super(1, "Order not found");
    }
}
