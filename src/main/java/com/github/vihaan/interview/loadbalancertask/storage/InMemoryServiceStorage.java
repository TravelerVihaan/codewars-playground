package com.github.vihaan.interview.loadbalancertask.storage;

import com.github.vihaan.interview.loadbalancertask.model.Service;
import com.github.vihaan.interview.loadbalancertask.storage.exception.StorageLimitReachedException;
import com.github.vihaan.interview.loadbalancertask.storage.selection.RandomSelectionStrategy;
import com.github.vihaan.interview.loadbalancertask.storage.selection.SelectionStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

public class InMemoryServiceStorage implements ServiceStorage<Service> {

    private final int capacity;
    private final ReentrantLock lock = new ReentrantLock();
    private final Map<String, Service> services = new HashMap<>();
    private final SelectionStrategy selectionStrategy;

    public InMemoryServiceStorage (SelectionStrategy selectionStrategy, int capacity) {
        this.capacity = capacity;
        this.selectionStrategy = selectionStrategy != null ? selectionStrategy : new RandomSelectionStrategy();
    }

    @Override
    public void save(Service service) {
        String ipAddress = service.ipAddress();
        withLock(() -> {
            if (capacity > 0 && services.size() >= capacity) {
                throw new StorageLimitReachedException(String.format("Maximum storage capacity reached %d", capacity));
            } else if (services.containsKey(ipAddress)) {
                throw new IllegalArgumentException(String.format("Service with address %s already exists in storage", ipAddress));
            }
            services.put(ipAddress, service);
            return null;
        });
    }

    @Override
    public Service getRandom() {
        return withLock(() -> selectionStrategy.select(services.values()));
    }

    @Override
    public int getServiceCount() {
        return withLock(services::size);
    }

    private <T> T withLock(Supplier<T> operation) {
        lock.lock();
        try {
            return operation.get();
        } finally {
            lock.unlock();
        }
    }
}
