package org.ofavor.sbd.order.interfaces.dto;

import lombok.Data;
import org.ofavor.sbd.order.domain.OrderStatus;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
public class OrderDTO {

    private UUID id;

    private BigDecimal price;

    private List<OrderItemDTO> items;

    private int status;
}
