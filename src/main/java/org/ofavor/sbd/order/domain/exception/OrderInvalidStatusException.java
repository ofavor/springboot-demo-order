package org.ofavor.sbd.order.domain.exception;

public class OrderInvalidStatusException extends Exception {

    public OrderInvalidStatusException() {
        super(2, "Order status is invalid");
    }
}
