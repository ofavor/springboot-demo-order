package org.ofavor.sbd.order.interfaces.response;

import lombok.Data;

@Data
public class Response {

    private int code;

    private String message;

    private Object data;

    private Response(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Response success(Object data) {
        return new Response(0, "Success", data);
    }

    public static Response error(int code, String message) {
        return new Response(code, message, null);
    }
}
