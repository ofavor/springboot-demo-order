package org.ofavor.sbd.order.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Product value object
 */
@Data
public class Product {
    private UUID id;

    private String name;

    private BigDecimal price;
}
