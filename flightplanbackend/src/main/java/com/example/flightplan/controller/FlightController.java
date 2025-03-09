package com.example.flightplan.controller;

import com.example.flightplan.repository.Flight;
import com.example.flightplan.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getFlights(@RequestParam(required = false, value = "sort") String sortBy,
                                   @RequestParam(required = false, defaultValue = "asc", value = "order") String order) {
        return flightService.getAllFlights(sortBy, order);
    }
}
