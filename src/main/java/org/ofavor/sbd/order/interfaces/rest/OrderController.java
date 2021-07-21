package org.ofavor.sbd.order.interfaces.rest;

import lombok.AllArgsConstructor;
import org.ofavor.sbd.order.application.OrderAppService;
import org.ofavor.sbd.order.domain.Order;
import org.ofavor.sbd.order.interfaces.assembler.OrderAssembler;
import org.ofavor.sbd.order.interfaces.dto.ListDTO;
import org.ofavor.sbd.order.interfaces.dto.OrderDTO;
import org.ofavor.sbd.order.interfaces.request.CreateOrderRequest;
import org.ofavor.sbd.order.interfaces.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    // Use constructor injection
    private OrderAppService orderAppService;

    @PostMapping
    public Response createOrder(@RequestBody final CreateOrderRequest request) {
        UUID id = orderAppService.createOrder(request.getProduct(), request.getCount());
        Order order = orderAppService.getOrder(id);
        return Response.success(OrderAssembler.toDTO(order));
    }

    @GetMapping
    public Response getOrderList(@RequestParam(required = false, defaultValue = "1") final int page, @RequestParam(required = false, defaultValue = "10") final int pageSize) {
        int total = orderAppService.getTotalOrders();
        List<Order> orders = orderAppService.getOrders(page, pageSize);
        List<OrderDTO> list = new ArrayList<>();
        orders.forEach(o -> list.add(OrderAssembler.toDTO(o)));
        return Response.success(new ListDTO(total, list));
    }

    @GetMapping("/{id}")
    public Response getOrder(@PathVariable final UUID id) {
        Order order = orderAppService.getOrder(id);
        return Response.success(OrderAssembler.toDTO(order));
    }

    @PostMapping("/{id}/products")
    public Response addProduct(@PathVariable final UUID id) {
        return Response.error(-1, "Not implemented");
    }

    @DeleteMapping("/{id}/products")
    public Response removeProduct(@PathVariable final UUID id) {
        return Response.error(-1, "Not implemented");
    }

    @PutMapping("/{id}/confirm")
    public Response confirmOrder(@PathVariable final UUID id) {
        return Response.error(-1, "Not implemented");
    }

    @PutMapping("/{id}/cancel")
    public Response cancelOrder(@PathVariable final UUID id) {
        return Response.error(-1, "Not implemented");
    }
}
