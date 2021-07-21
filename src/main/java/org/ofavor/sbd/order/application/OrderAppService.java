package org.ofavor.sbd.order.application;

import org.ofavor.sbd.order.domain.Order;
import org.ofavor.sbd.order.domain.OrderStatus;
import org.ofavor.sbd.order.domain.Product;
import org.ofavor.sbd.order.domain.User;

import java.util.List;
import java.util.UUID;

/**
 * Order application service.
 * Defines all user cases of order domain.
 */
public interface OrderAppService {
    /**
     * Get order by specifying order ID
     * @param orderId UUID
     * @return Order
     */
    Order getOrder(UUID orderId);

    /**
     * Get total order count
     * @return
     */
    int getTotalOrders();

    /**
     * Get order list
     * @param page int
     * @param pageSize int
     * @return List contains orders
     */
    List<Order> getOrders(int page, int pageSize);

    /**
     * Create a new order
     * @param product Product
     * @param count int
     * @return UUID ID of created order
     */
    UUID createOrder(Product product, int count);

    /**
     * Add product to order
     * @param orderId UUID
     * @param product Product
     * @param count int
     */
    void addProduct(UUID orderId, Product product, int count);

    /**
     * Delete product from order
     * @param product
     * @param count
     */
    void deleteProduct(Product product, int count);

    /**
     * Confirm order
     * @param orderId
     */
    void confirmOrder(UUID orderId);

    /**
     * Pay order
     * @param orderId
     */
    void payOrder(UUID orderId);

    /**
     * Cancel order
     * @param orderId
     */
    void cancelOrder(UUID orderId);
}
