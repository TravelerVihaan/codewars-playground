package com.github.vihaan.interview.loadbalancertask.storage;

import com.github.vihaan.interview.loadbalancertask.model.Service;

public interface ServiceStorage<T extends Service> {

    void save(T service);

    T getRandom();

    int getServiceCount();
}
