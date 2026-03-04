package com.github.vihaan.interview.loadbalancertask.loadbalancer;

import static com.github.vihaan.interview.loadbalancertask.storage.ServiceStorageFactory.createDefaultInMemoryStorage;

public class LoadBalancerFactory {

    public static LoadBalancer createDefaultLoadBalancer() {
        return new LoadBalancer(createDefaultInMemoryStorage());
    }
}
