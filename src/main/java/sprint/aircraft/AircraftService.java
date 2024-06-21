package sprint.aircraft;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    private final List<Aircraft> aircrafts = new ArrayList<>();
    private int nextId = 1;

    public List<Aircraft> getAllAircrafts() {
        return new ArrayList<>(aircrafts);
    }

    public Aircraft getAircraftById(int id) {
        Optional<Aircraft> match = aircrafts.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
        return match.orElse(null);
    }

    public Aircraft createAircraft(Aircraft aircraft) {
        aircraft.setId(nextId++);
        aircrafts.add(aircraft);
        return aircraft;
    }

    public Aircraft updateAircraft(int id, Aircraft updatedAircraft) {
        Optional<Aircraft> match = aircrafts.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
        if (match.isPresent()) {
            Aircraft aircraft = match.get();
            aircraft.setType(updatedAircraft.getType());
            aircraft.setAirlineName(updatedAircraft.getAirlineName());
            aircraft.setNumberOfPassengers(updatedAircraft.getNumberOfPassengers());
            aircraft.setPassengers(updatedAircraft.getPassengers());
            aircraft.setAirports(updatedAircraft.getAirports());
            return aircraft;
        }
        return null;
    }

    public void deleteAircraft(int id) {
        aircrafts.removeIf(a -> a.getId() == id);
    }
}
