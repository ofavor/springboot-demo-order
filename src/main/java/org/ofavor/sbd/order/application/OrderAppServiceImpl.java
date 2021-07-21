package org.ofavor.sbd.order.application;

import org.ofavor.sbd.order.domain.Order;
import org.ofavor.sbd.order.domain.Product;
import org.ofavor.sbd.order.domain.exception.OrderNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderAppServiceImpl implements OrderAppService {

    @Override
    public Order getOrder(UUID orderId) {
        if (true) {
            throw new OrderNotFoundException();
        }
        return null;
    }

    @Override
    public int getTotalOrders() {
        return 0;
    }

    @Override
    public List<Order> getOrders(int page, int pageSize) {
        return null;
    }

    @Override
    public UUID createOrder(Product product, int count) {
        return null;
    }

    @Override
    public void addProduct(UUID orderId, Product product, int count) {

    }

    @Override
    public void deleteProduct(Product product, int count) {

    }

    @Override
    public void confirmOrder(UUID orderId) {

    }

    @Override
    public void payOrder(UUID orderId) {

    }

    @Override
    public void cancelOrder(UUID orderId) {

    }
}
