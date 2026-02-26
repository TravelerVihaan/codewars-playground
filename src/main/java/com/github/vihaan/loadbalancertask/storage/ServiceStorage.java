package com.github.vihaan.loadbalancertask.storage;

import com.github.vihaan.loadbalancertask.model.Service;

public interface ServiceStorage<T extends Service> {

    void save(T service);

    T getRandom();

    int getServiceCount();
}
