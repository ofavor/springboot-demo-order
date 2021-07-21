package org.ofavor.sbd.order.domain.exception;

public class Exception extends RuntimeException {

    private int code;

    public Exception(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
