package com.store.msm.exceptions;

public class StockException extends RuntimeException {
    public StockException() {
        super("No hay suficientes productos en Stock");
    }
}
