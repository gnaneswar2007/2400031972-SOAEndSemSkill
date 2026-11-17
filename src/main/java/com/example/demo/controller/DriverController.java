package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Driver;
import com.example.demo.service.DriverService;
import com.example.demo.service.RoundRobinService;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;

    private final RoundRobinService roundRobinService;

    public DriverController(DriverService driverService,
                            RoundRobinService roundRobinService) {
        this.driverService = driverService;
        this.roundRobinService = roundRobinService;
    }

    @PostMapping
    public Driver addDriver(@RequestBody Driver driver) {
        return driverService.addDriver(driver);
    }

    @GetMapping
    public List<Driver> getAllDrivers() {

        String instance = roundRobinService.getNextInstance();

        System.out.println("Request handled by: " + instance);

        return driverService.getAllDrivers();
    }

    @GetMapping("/{id}")
    public Driver getDriverById(@PathVariable Long id) {
        return driverService.getDriverById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteDriver(@PathVariable Long id) {

        driverService.deleteDriver(id);

        return "Driver deleted successfully";
    }
}