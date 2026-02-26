package com.github.vihaan.loadbalancertask.storage.exception;

public class StorageLimitReachedException extends RuntimeException {
    public StorageLimitReachedException (String message) {
        super(message);
    }
}
