package sprint.passengers;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    private final List<Passenger> passengers = new ArrayList<>();
    private int nextId = 1;

    public List<Passenger> getAllPassengers() {
        return new ArrayList<>(passengers);
    }

    public Passenger getPassengerById(int id) {
        Optional<Passenger> match = passengers.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
        return match.orElse(null);
    }

    public Passenger createPassenger(Passenger passenger) {
        passenger.setId(nextId++);
        passengers.add(passenger);
        return passenger;
    }

    public Passenger updatePassenger(int id, Passenger updatedPassenger) {
        Optional<Passenger> match = passengers.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
        if (match.isPresent()) {
            Passenger passenger = match.get();
            passenger.setId(updatedPassenger.getId());
            passenger.setFirstName(updatedPassenger.getFirstName());
            passenger.setLastName(updatedPassenger.getLastName());
            passenger.setPhoneNumber(updatedPassenger.getPhoneNumber());
            return passenger;
        }
        return null;
    }

    public void deletePassenger(int id) {
        passengers.removeIf(a -> a.getId() == id);
    }
}
