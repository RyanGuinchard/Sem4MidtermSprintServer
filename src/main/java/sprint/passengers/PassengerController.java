package sprint.passengers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sprint.aircraft.Aircraft;
import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("/{id}")
    public Passenger getPassengerById(@PathVariable("id") int id) {
        return passengerService.getPassengerById(id);
    }

    @GetMapping("/{passengerId}/aircrafts")
    public List<Aircraft> getAircraftsByPassengerId(@PathVariable("passengerId") int passengerId) {
        return passengerService.getAircraftsByPassengerId(passengerId);
    }
    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerService.createPassenger(passenger);
    }

    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable("id") int id, @RequestBody Passenger passenger) {
        return passengerService.updatePassenger(id, passenger);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable("id") int id) {
        passengerService.deletePassenger(id);
    }
}
