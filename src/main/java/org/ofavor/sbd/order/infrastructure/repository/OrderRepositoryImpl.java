package org.ofavor.sbd.order.infrastructure.repository;

import org.ofavor.sbd.order.domain.Order;
import org.ofavor.sbd.order.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public Order getOrder(UUID id) {
        return null;
    }

    @Override
    public List<Order> getOrders(int page, int pageSize) {
        return null;
    }

    @Override
    public int getTotalOrders() {
        return 0;
    }

    @Override
    public void createOrder(Order order) {

    }

    @Override
    public void updateOrder(Order order) {

    }
}
