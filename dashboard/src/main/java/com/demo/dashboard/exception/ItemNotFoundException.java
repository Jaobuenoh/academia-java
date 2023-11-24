package com.demo.dashboard.exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        System.out.println("Item não localizado erro: " + message);
    }
}
