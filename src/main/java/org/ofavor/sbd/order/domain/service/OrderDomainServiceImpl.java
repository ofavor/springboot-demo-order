package org.ofavor.sbd.order.domain.service;

import org.ofavor.sbd.order.domain.Order;
import org.ofavor.sbd.order.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class OrderDomainServiceImpl implements OrderDomainService {
    @Override
    public Order createOrder(Product product, int count) {
        return null;
    }
}
