package org.ofavor.sbd.order.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ListDTO<T> {

    private int total;

    private List<T> list;
}
