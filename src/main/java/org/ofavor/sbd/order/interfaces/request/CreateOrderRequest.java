package org.ofavor.sbd.order.interfaces.request;

import lombok.Data;
import org.ofavor.sbd.order.domain.Product;

@Data
public class CreateOrderRequest {
    private Product product;

    private int count;
}
