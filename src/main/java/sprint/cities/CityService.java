package sprint.cities;

import org.springframework.stereotype.Service;
import sprint.airports.Airport;

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

    public City getCityById(int id) {
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
            city.setAirports(updatedCity.getAirports());
            return city;
        }
        return null;
    }

    public void deleteCity(int id) {
        cities.removeIf(c -> c.getId() == id);
    }

    public List<Airport> getAirportsByCityId(int cityId) {
        City city = getCityById(cityId);
        return city != null ? city.getAirports() : null;
    }

}
