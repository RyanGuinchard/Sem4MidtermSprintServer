package sprint.cities;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final List<City> cities = new ArrayList<>();
    private int nextId = 1;

    public List<City> getAllCities() {
        return new ArrayList<>(cities);
    }

    // Using optional to prevent null pointer exception
    public City getCityById(long id) {
        Optional<City> match = cities.stream()
            .filter(c -> c.getId() == id)
            .findFirst();
        return match.orElse(null);
    }

    public City createCity(City city) {
        city.setId(nextId++);
        cities.add(city);
        return city;
    }

    public City updateCity(int id, City updatedCity) {
        Optional<City> match = cities.stream()
            .filter(c -> c.getId() == id)
            .findFirst();
        if (match.isPresent()) {
            City city = match.get();
            city.setName(updatedCity.getName());
            city.setState(updatedCity.getState());
            city.setPopulation(updatedCity.getPopulation());
            return city;
        }
        return null;
    }

    public void deleteCity(int id) {
        cities.removeIf(c -> c.getId() == id);
    }
}
