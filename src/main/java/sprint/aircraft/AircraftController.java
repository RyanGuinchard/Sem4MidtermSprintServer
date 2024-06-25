package sprint.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sprint.airports.Airport;
import java.util.List;

@RestController
@RequestMapping("/aircrafts")
public class AircraftController {

    @Autowired
    private AircraftService aircraftService;

    @GetMapping
    public List<Aircraft> getAllAircrafts() {
        return aircraftService.getAllAircrafts();
    }

    @GetMapping("/{id}")
    public Aircraft getAircraftById(@PathVariable("id") int id) {
        return aircraftService.getAircraftById(id);
    }

    @GetMapping("/{aircraftId}/airports")
    public List<Airport> getAirportsByAircraftId(@PathVariable("aircraftId") int aircraftId) {
        return aircraftService.getAirportsByAircraftId(aircraftId);
    }

    @PostMapping
    public Aircraft createAircraft(@RequestBody Aircraft aircraft) {
        return aircraftService.createAircraft(aircraft);
    }

    @PutMapping("/{id}")
    public Aircraft updateAircraft(@PathVariable("id") int id, @RequestBody Aircraft aircraft) {
        return aircraftService.updateAircraft(id, aircraft);
    }

    @DeleteMapping("/{id}")
    public void deleteAircraft(@PathVariable("id") int id) {
        aircraftService.deleteAircraft(id);
    }
}
