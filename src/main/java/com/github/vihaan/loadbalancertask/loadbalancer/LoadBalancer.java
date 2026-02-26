package com.github.vihaan.loadbalancertask.loadbalancer;

import com.github.vihaan.loadbalancertask.model.Service;
import com.github.vihaan.loadbalancertask.storage.ServiceStorage;

/**
 * 1. 	Create a LoadBalancer class that has a method to register backend instances
 * 	Each backend instance address should be unique, it should not be possible to register the same address two times
 * 	Load balancer should accept up to 10 backend instances
 * 	The code should be production ready
 * 	The Loadbalancer will be released as a library
 *
 * 2. 	Develop an algorithm that, when invoking the Load Balancer's get() method multiple times,
 * should return one backend-instance choosing between the registered ones randomly.
 *
 * Technical (Load Balancer Design): Implement a load balancer with Random/Round Robin algorithms in TDD style.
 * Covered concurrency handling, locking mechanisms, and TDD approach. The focus was on covering all scenarios with tests and SOLID principles.
 */
public class LoadBalancer {

    private final ServiceStorage<Service> serviceStorage;

    public LoadBalancer (ServiceStorage<Service> serviceStorage) {
        this.serviceStorage = serviceStorage;
    }

    public void register(Service service) {
        serviceStorage.save(service);
    }

    public Service getService() {
        return serviceStorage.getRandom();
    }
}
