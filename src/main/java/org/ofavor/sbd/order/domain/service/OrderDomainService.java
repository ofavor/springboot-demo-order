package org.ofavor.sbd.order.domain.service;

import org.ofavor.sbd.order.domain.Order;
import org.ofavor.sbd.order.domain.Product;

public interface OrderDomainService {
    Order createOrder(Product product, int count);
}
