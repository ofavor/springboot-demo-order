package org.ofavor.sbd.order.application;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.ofavor.sbd.order.domain.Order;
import org.ofavor.sbd.order.domain.OrderStatus;
import org.ofavor.sbd.order.domain.repository.OrderRepository;
import org.ofavor.sbd.order.domain.service.OrderDomainService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class OrderAppServiceTest {

    private OrderAppService orderAppService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderDomainService orderDomainService;

    @Before
    public void setUp() {
        orderAppService = new OrderAppServiceImpl(orderRepository, orderDomainService);
    }

    @Test
    public void getOrder_Success() throws Exception {
        // init
        UUID id = new UUID(1, 1);
        Order order = new Order();
        order.setId(id);

        // mock
        Mockito.when(orderRepository.getOrder(id)).thenReturn(order);

        // perform and check
        Order dummy = orderAppService.getOrder(id);
        Assertions.assertEquals(dummy.getId(), id);
    }

    @Test
    public void getTotalOrders_Success() throws Exception {
        // mock
        Mockito.when(orderRepository.getTotalOrders()).thenReturn(99);

        // perform and check
        int total = orderAppService.getTotalOrders();
        Assertions.assertEquals(total, 99);
    }

    @Test
    public void getOrders_Success() throws Exception {
        // init
        UUID id = new UUID(1, 1);
        Order order = new Order();
        order.setId(id);
        order.setPrice(new BigDecimal(10));
        order.setStatus(OrderStatus.CREATED);
        List<Order> orders = Arrays.asList(order);

        // mock
        Mockito.when(orderRepository.getOrders(3, 20)).thenReturn(orders);

        // perform and check
        List<Order> list = orderAppService.getOrders(3, 20);
        Assertions.assertEquals(list.size(), 1);
        Order o = list.get(0);
        Assertions.assertEquals(o.getId(), id);
    }
}
