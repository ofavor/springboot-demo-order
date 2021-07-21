package org.ofavor.sbd.order.domain.repository;

import org.ofavor.sbd.order.domain.Order;

import java.util.List;
import java.util.UUID;

public interface OrderRepository {

    Order getOrder(UUID id);

    List<Order> getOrders(int page, int pageSize);

    int getTotalOrders();

    void createOrder(Order order);

    void updateOrder(Order order);
}
