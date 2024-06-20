package sprint.passengers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public Passenger getPassengerById(@PathVariable int id) {
        return passengerService.getPassengerById(id);
    }

    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger airport) {
        return passengerService.createPassenger(airport);
    }

    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable int id, @RequestBody Passenger airport) {
        return passengerService.updatePassenger(id, airport);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable int id) {
        passengerService.deletePassenger(id);
    }
}
