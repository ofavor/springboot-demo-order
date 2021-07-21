package org.ofavor.sbd.order.interfaces.assembler;

import org.ofavor.sbd.order.domain.Order;
import org.ofavor.sbd.order.domain.OrderItem;
import org.ofavor.sbd.order.interfaces.dto.OrderDTO;
import org.ofavor.sbd.order.interfaces.dto.OrderItemDTO;

import java.util.ArrayList;
import java.util.List;

public class OrderAssembler {

    public static OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setPrice(order.getPrice());
        dto.setStatus(order.getStatus().getValue());
        List<OrderItemDTO> items = new ArrayList<>();
        List<OrderItem> ois = order.getItems();
        if (ois != null) {
            ois.forEach(oi -> items.add(toItemDTO(oi)));
        }
        dto.setItems(items);
        return dto;
    }

    public static OrderItemDTO toItemDTO(OrderItem it) {
        OrderItemDTO dto = new OrderItemDTO();
        dto.setId(it.getId());
        dto.setProductId(it.getProductId());
        dto.setProductName(it.getProductName());
        dto.setPrice(it.getPrice());
        dto.setCount(it.getCount());
        return dto;
    }
}
