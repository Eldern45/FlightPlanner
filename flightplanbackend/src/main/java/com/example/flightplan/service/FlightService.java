package com.example.flightplan.service;

import com.example.flightplan.repository.Flight;
import com.example.flightplan.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> getAllFlights(String sortBy, String order) {
        List<Flight> flights = flightRepository.findAll();
        if (sortBy != null && !sortBy.isEmpty()) {
            Comparator<Flight> comparator = switch (sortBy) {
                case "departure_date" -> Comparator.comparing(Flight::getDepartureTime);
                case "duration" -> Comparator.comparing(flight ->
                        Duration.between(flight.getDepartureTime(), flight.getArrivalTime()));
                case "price" -> Comparator.comparing(Flight::getPrice);
                default -> null;
            };
            if (comparator != null) {

                if ("desc".equalsIgnoreCase(order)) {
                    comparator = comparator.reversed();
                }
                flights.sort(comparator);
            }
        }
        return flights;
    }

}
