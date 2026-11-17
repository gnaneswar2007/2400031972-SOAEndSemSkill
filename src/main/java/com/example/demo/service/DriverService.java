package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Driver;
import com.example.demo.repository.DriverRepository;

@Service
public class DriverService {

    private final DriverRepository repository;

    public DriverService(DriverRepository repository) {
        this.repository = repository;
    }

    public Driver addDriver(Driver driver) {
        return repository.save(driver);
    }

    public List<Driver> getAllDrivers() {
        return repository.findAll();
    }

    public Driver getDriverById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    public void deleteDriver(Long id) {
        repository.deleteById(id);
    }
}