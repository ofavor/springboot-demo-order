package org.ofavor.sbd.order.interfaces.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import org.ofavor.sbd.order.application.OrderAppService;
import org.ofavor.sbd.order.domain.Order;
import org.ofavor.sbd.order.domain.OrderStatus;
import org.ofavor.sbd.order.domain.Product;
import org.ofavor.sbd.order.domain.exception.OrderNotFoundException;
import org.ofavor.sbd.order.interfaces.request.CreateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    OrderAppService orderAppService;

    @Test
    public void getOrderList_Success() throws Exception {
        // init
        UUID id = new UUID(1, 1);
        Order order = new Order();
        order.setId(id);
        order.setPrice(new BigDecimal(10));
        order.setStatus(OrderStatus.CREATED);
        List<Order> orders = Arrays.asList(order);

        // mock
        when(orderAppService.getTotalOrders()).thenReturn(99);
        when(orderAppService.getOrders(3, 10)).thenReturn(orders);

        // perform and check
        mvc.perform(get("/orders?page=3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(0))
                .andExpect(jsonPath("$.data.total").value(99))
                .andExpect(jsonPath("$.data.list[0].id").value("00000000-0000-0001-0000-000000000001"))
                .andExpect(jsonPath("$.data.list[0].price").value(10))
                .andExpect(jsonPath("$.data.list[0].status").value(1))
                .andDo(print());
    }

    @Test
    public void getOrder_Success() throws Exception {
        // init
        UUID id = new UUID(1, 1);
        Order order = new Order();
        order.setId(id);
        order.setPrice(new BigDecimal(10));
        order.setStatus(OrderStatus.CREATED);

        // mock
        when(orderAppService.getOrder(id)).thenReturn(order);

        // perform and check
        mvc.perform(get("/orders/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(0))
                .andExpect(jsonPath("$.data.id").value("00000000-0000-0001-0000-000000000001"))
                .andExpect(jsonPath("$.data.status").value(1))
                .andExpect(jsonPath("$.data.price").value(10))
                .andDo(print());
    }

    @Test
    public void getOrder_Failed_OrderNotFound() throws Exception {
        // init
        UUID id = new UUID(1, 1);

        // mock
        when(orderAppService.getOrder(id)).thenThrow(new OrderNotFoundException());

        // perform and check
        mvc.perform(get("/orders/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(1))
                .andDo(print());
    }

    @Test
    public void createOrder_Success() throws Exception {
        // init
        Product product = new Product();
        product.setPrice(new BigDecimal(5));
        CreateOrderRequest request = new CreateOrderRequest();
        request.setProduct(product);
        request.setCount(2);
        UUID id = new UUID(1, 1);
        Order order = new Order();
        order.setId(id);
        order.setPrice(new BigDecimal(10));
        order.setStatus(OrderStatus.CREATED);

        // mock
        when(orderAppService.createOrder(product, 2)).thenReturn(id);
        when(orderAppService.getOrder(id)).thenReturn(order);

        // perform and check
        mvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(0))
                .andExpect(jsonPath("$.data.id").value("00000000-0000-0001-0000-000000000001"))
                .andExpect(jsonPath("$.data.status").value(1))
                .andExpect(jsonPath("$.data.price").value(10))
                .andDo(print());
    }
}
