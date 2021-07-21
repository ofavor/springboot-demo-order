package org.ofavor.sbd.order.domain;

/**
 * OrderStatus,
 * (create) -> created -> (confirm) -> confirmed -> (pay) -> paid
 *                                              |-> (cancel) -> canceled
 */
public enum OrderStatus {
    DELETED(0),
    CREATED(1),
    CONFIRMED(2),
    PAID(3),
    CANCELED(10);

    private final int value;

    OrderStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
