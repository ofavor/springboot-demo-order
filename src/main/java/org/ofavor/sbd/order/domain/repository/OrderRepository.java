package org.ofavor.sbd.order.domain.repository;

import org.ofavor.sbd.order.domain.Order;

import java.util.List;

public interface OrderRepository {

    Order getOrder(String id);

    List<Order> getOrders();

    void createOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(Order order);
}
