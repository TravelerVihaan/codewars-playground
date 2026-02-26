package com.github.vihaan.loadbalancertask.loadbalancer;

import static com.github.vihaan.loadbalancertask.storage.ServiceStorageFactory.createDefaultInMemoryStorage;

public class LoadBalancerFactory {

    public static LoadBalancer createDefaultLoadBalancer() {
        return new LoadBalancer(createDefaultInMemoryStorage());
    }
}
