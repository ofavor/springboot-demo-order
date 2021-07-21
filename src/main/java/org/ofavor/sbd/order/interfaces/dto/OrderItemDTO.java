package org.ofavor.sbd.order.interfaces.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class OrderItemDTO {
    private UUID id;

    private UUID productId;

    private String productName;

    private BigDecimal price;

    private int count;
}
