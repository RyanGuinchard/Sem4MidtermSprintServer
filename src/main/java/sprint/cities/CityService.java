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

    public void assignAirportToCity(int cityId, Airport airport) {
        // Retrieve the city by cityId
        Optional<City> optionalCity = cities.stream()
                .filter(city -> city.getId() == cityId)
                .findFirst();

        if (optionalCity.isPresent()) {
            City city = optionalCity.get();

            // Ensure currentAirports is initialized
            if (city.getAirports() == null) {
                city.setAirports(new ArrayList<>());
            }

            // Retrieve the list of airports assigned to the city
            List<Airport> currentAirports = city.getAirports();

            // Add the new airport to the list
            currentAirports.add(airport);

            // Update the city with the new list of airports
            city.setAirports(currentAirports);
        } else {
            throw new IllegalArgumentException("City not found with id: " + cityId);
        }
    }

}
