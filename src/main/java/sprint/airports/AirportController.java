package sprint.airports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/{id}")
    public Airport getAirportById(@PathVariable("id") int id) {
        return airportService.getAirportById(id);
    }

    @GetMapping("/passenger/{passengerId}")
    public List<Airport> getAirportsUsedByPassengerId(@PathVariable("passengerId") int passengerId) {
        return airportService.getAirportsUsedByPassengerId(passengerId);
    }

    @PostMapping
    public Airport createAirport(@RequestBody Airport airport) {
        return airportService.createAirport(airport);
    }

    @PutMapping("/{id}")
    public Airport updateAirport(@PathVariable("id") int id, @RequestBody Airport airport) {
        return airportService.updateAirport(id, airport);
    }

    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable("id") int id) {
        airportService.deleteAirport(id);
    }
}
