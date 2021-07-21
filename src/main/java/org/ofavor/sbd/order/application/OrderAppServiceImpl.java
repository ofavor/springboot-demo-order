package org.ofavor.sbd.order.application;

import lombok.AllArgsConstructor;
import org.ofavor.sbd.order.domain.Order;
import org.ofavor.sbd.order.domain.Product;
import org.ofavor.sbd.order.domain.exception.OrderNotFoundException;
import org.ofavor.sbd.order.domain.repository.OrderRepository;
import org.ofavor.sbd.order.domain.service.OrderDomainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderAppServiceImpl implements OrderAppService {

    private OrderRepository orderRepository;

    private OrderDomainService orderDomainService;

    @Override
    public Order getOrder(UUID orderId) {
        Order order = orderRepository.getOrder(orderId);
        if (order == null) {
            throw new OrderNotFoundException();
        }
        return order;
    }

    @Override
    public int getTotalOrders() {
        return orderRepository.getTotalOrders();
    }

    @Override
    public List<Order> getOrders(int page, int pageSize) {
        return orderRepository.getOrders(page, pageSize);
    }

    @Override
    public UUID createOrder(Product product, int count) {
        Order order = orderDomainService.createOrder(product, count);
        orderRepository.createOrder(order);
        return order.getId();
    }

    @Override
    public void addProduct(UUID orderId, Product product, int count) {
        Order order = orderRepository.getOrder(orderId);
        if (order == null) {
            throw new OrderNotFoundException();
        }
        order.addProduct(product, count);
        orderRepository.updateOrder(order);
    }

    @Override
    public void deleteProduct(UUID orderId, Product product, int count) {
        Order order = orderRepository.getOrder(orderId);
        if (order == null) {
            throw new OrderNotFoundException();
        }
        order.deleteProduct(product, count);
        orderRepository.updateOrder(order);
    }

    @Override
    public void confirmOrder(UUID orderId) {
        Order order = orderRepository.getOrder(orderId);
        if (order == null) {
            throw new OrderNotFoundException();
        }
        order.confirm();
        orderRepository.updateOrder(order);
    }

    @Override
    public void payOrder(UUID orderId) {
        Order order = orderRepository.getOrder(orderId);
        if (order == null) {
            throw new OrderNotFoundException();
        }
        order.pay();
        orderRepository.updateOrder(order);
    }

    @Override
    public void cancelOrder(UUID orderId) {
        Order order = orderRepository.getOrder(orderId);
        if (order == null) {
            throw new OrderNotFoundException();
        }
        order.cancel();
        orderRepository.updateOrder(order);
    }
}
