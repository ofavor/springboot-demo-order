package org.ofavor.sbd.order.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * OrderItem value object
 */
@Data
public class OrderItem {

    private UUID productId;

    private String productName;

    private BigDecimal price;

    private int count;
}
