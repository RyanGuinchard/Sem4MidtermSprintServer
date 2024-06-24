package sprint.airports;

import org.springframework.stereotype.Service;
import sprint.aircraft.Aircraft;
import sprint.passengers.Passenger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AirportService {
    private final List<Airport> airports = new ArrayList<>();
    private int nextId = 1;

    public List<Airport> getAllAirports() {
        return new ArrayList<>(airports);
    }

    public Airport getAirportById(int id) {
        Optional<Airport> match = airports.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
        return match.orElse(null);
    }

    public Airport createAirport(Airport airport) {
        airport.setId(nextId++);
        airports.add(airport);
        return airport;
    }

    public Airport updateAirport(int id, Airport updatedAirport) {
        Optional<Airport> match = airports.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
        if (match.isPresent()) {
            Airport airport = match.get();
            airport.setName(updatedAirport.getName());
            airport.setCode(updatedAirport.getCode());
            airport.setCity(updatedAirport.getCity());
            airport.setAircrafts(updatedAirport.getAircrafts());
            return airport;
        }
        return null;
    }

    public void deleteAirport(int id) {
        airports.removeIf(a -> a.getId() == id);
    }

    public List<Airport> getAirportsUsedByPassengerId(int passengerId) {
        List<Airport> usedAirports = new ArrayList<>();
        for (Airport airport : airports) {
            for (Aircraft aircraft : airport.getAircrafts()) {
                for (Passenger passenger : aircraft.getPassengers()) {
                    if (passenger.getId() == passengerId) {
                        usedAirports.add(airport);
                        break;
                    }
                }
            }
        }
        return usedAirports;
    }

}

