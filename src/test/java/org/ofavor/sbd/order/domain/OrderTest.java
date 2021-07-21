package org.ofavor.sbd.order.domain;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.internal.matchers.Or;
import org.ofavor.sbd.order.domain.exception.OrderInvalidStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class OrderTest {

    @Test
    public void addProduct_Success() {
        UUID id = new UUID(1, 1);
        Product product = new Product();
        product.setId(id);
        product.setName("Product");
        product.setPrice(BigDecimal.valueOf(5));
        Order order = new Order();
        order.setStatus(OrderStatus.CREATED);
        order.setPrice(BigDecimal.valueOf(3));

        order.addProduct(product, 2);

        Assertions.assertNotNull(order.getItems());
        Assertions.assertEquals(1, order.getItems().size());
        Assertions.assertEquals(BigDecimal.valueOf(13), order.getPrice());
    }

    @Test
    public void addProduct_Failed_OrderStatusIsConfirmed() throws Exception {
        Order order = new Order();
        order.setStatus(OrderStatus.CONFIRMED);

        try {
            order.addProduct(null, 0);
            Assertions.assertTrue(false, "OrderInvalidStatusException was expected");
        } catch (Exception ex) {
            Assertions.assertTrue(ex instanceof OrderInvalidStatusException);
        }
    }

    @Test
    public void deleteProduct_Success_ReduceCount() {
        UUID id = new UUID(1, 1);
        Product product = new Product();
        product.setId(id);
        product.setName("Product");
        product.setPrice(BigDecimal.valueOf(5));
        OrderItem orderItem = new OrderItem();
        orderItem.setCount(3);
        orderItem.setProductId(id);
        orderItem.setProductName("Product");
        orderItem.setPrice(BigDecimal.valueOf(5));
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setCount(1);
        orderItem1.setProductId(UUID.randomUUID());
        orderItem1.setProductName("Product1");
        orderItem1.setPrice(BigDecimal.valueOf(3));
        Order order = new Order();
        order.setStatus(OrderStatus.CREATED);
        order.setPrice(BigDecimal.valueOf(18));
        order.setItems(new ArrayList<OrderItem>() {{
            add(orderItem);
            add(orderItem1);
        }});

        order.deleteProduct(product, 2);

        Assertions.assertNotNull(order.getItems());
        Assertions.assertEquals(2, order.getItems().size());
        Assertions.assertEquals(BigDecimal.valueOf(8), order.getPrice());
    }


    @Test
    public void deleteProduct_Success_RemoveItem() {
        UUID id = new UUID(1, 1);
        Product product = new Product();
        product.setId(id);
        product.setName("Product");
        product.setPrice(BigDecimal.valueOf(5));
        OrderItem orderItem = new OrderItem();
        orderItem.setCount(3);
        orderItem.setProductId(id);
        orderItem.setProductName("Product");
        orderItem.setPrice(BigDecimal.valueOf(5));
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setCount(1);
        orderItem1.setProductId(UUID.randomUUID());
        orderItem1.setProductName("Product1");
        orderItem1.setPrice(BigDecimal.valueOf(3));
        Order order = new Order();
        order.setStatus(OrderStatus.CREATED);
        order.setPrice(BigDecimal.valueOf(18));
        order.setItems(new ArrayList<OrderItem>() {{
            add(orderItem);
            add(orderItem1);
        }});

        order.deleteProduct(product, 3);

        Assertions.assertNotNull(order.getItems());
        Assertions.assertEquals(1, order.getItems().size());
        Assertions.assertEquals(BigDecimal.valueOf(3), order.getPrice());
        Assertions.assertEquals("Product1", order.getItems().get(0).getProductName());
    }
}
