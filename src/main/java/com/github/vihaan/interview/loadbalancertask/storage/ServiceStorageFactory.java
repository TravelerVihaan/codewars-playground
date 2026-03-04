package com.github.vihaan.interview.loadbalancertask.storage;

import com.github.vihaan.interview.loadbalancertask.model.Service;
import com.github.vihaan.interview.loadbalancertask.storage.selection.RandomSelectionStrategy;

public class ServiceStorageFactory {

    public static ServiceStorage<Service> createDefaultInMemoryStorage() {
        return new InMemoryServiceStorage(new RandomSelectionStrategy(), 10);
    }

    public static ServiceStorage<Service> createDefaultInMemoryStorageWithCapacity(int capacity) {
        return new InMemoryServiceStorage(new RandomSelectionStrategy(), capacity);
    }
}
