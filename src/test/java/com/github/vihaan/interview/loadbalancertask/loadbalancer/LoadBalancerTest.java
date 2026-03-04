package com.github.vihaan.interview.loadbalancertask.loadbalancer;

import com.github.vihaan.interview.loadbalancertask.loadbalancer.LoadBalancer;
import com.github.vihaan.interview.loadbalancertask.loadbalancer.LoadBalancerFactory;
import com.github.vihaan.interview.loadbalancertask.model.BackendService;
import com.github.vihaan.interview.loadbalancertask.model.Service;
import com.github.vihaan.interview.loadbalancertask.storage.ServiceStorage;
import com.github.vihaan.interview.loadbalancertask.storage.ServiceStorageFactory;
import com.github.vihaan.interview.loadbalancertask.storage.exception.StorageLimitReachedException;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class LoadBalancerTest {

    @Test
    void shouldRegisterService() {
        LoadBalancer lb = LoadBalancerFactory.createDefaultLoadBalancer();
        lb.register(new BackendService("192.168.0.1"));
        assertNotNull(lb.getService());
    }

    @Test
    void shouldNotRegisterWhenCapacityReached() {
        LoadBalancer lb = new LoadBalancer(ServiceStorageFactory.createDefaultInMemoryStorageWithCapacity(1));
        lb.register(new BackendService("192.168.0.1"));
        assertThrows(StorageLimitReachedException.class, () -> lb.register(new BackendService("192.168.0.2")));
    }

    @Test
    void shouldNotRegisterWhenDuplicated() {
        LoadBalancer lb = new LoadBalancer(ServiceStorageFactory.createDefaultInMemoryStorage());
        lb.register(new BackendService("192.168.0.1"));
        assertThrows(IllegalArgumentException.class, () -> lb.register(new BackendService("192.168.0.1")));
    }

    @Test
    void shouldRegisterConcurrently() throws InterruptedException {
        ServiceStorage<Service> storage = ServiceStorageFactory.createDefaultInMemoryStorage();
        LoadBalancer lb = new LoadBalancer(storage);
        int threadsCount = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(threadsCount);
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(threadsCount);

        AtomicInteger counter = new AtomicInteger();

        for (int i = 1; i <= threadsCount; i++) {
            String ipAddr = String.format("192.168.0.%d", i);
            executorService.submit(() -> {
                try {
                    startLatch.await();
                    lb.register(new BackendService(ipAddr));
                } catch (InterruptedException e) {
                } finally {
                    endLatch.countDown();
                }
            });


        }

        startLatch.countDown();
        endLatch.await();
        executorService.shutdown();

        assertEquals(10, storage.getServiceCount());
    }
}