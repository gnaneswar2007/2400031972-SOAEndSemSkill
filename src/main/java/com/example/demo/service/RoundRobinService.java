package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

@Service
public class RoundRobinService {

    private final List<String> instances =
            Arrays.asList("Instance-1", "Instance-2", "Instance-3");

    private final AtomicInteger counter = new AtomicInteger(0);

    public String getNextInstance() {

        int index = Math.floorMod(counter.getAndIncrement(), instances.size());

        return instances.get(index);
    }
}