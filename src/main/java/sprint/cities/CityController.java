package sprint.cities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sprint.airports.Airport;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable("id") int id) {
        return cityService.getCityById(id);
    }


    @GetMapping("/{cityId}/airports")
    public List<Airport> getAirportsByCityId(@PathVariable("cityId") int cityId) {
        return cityService.getAirportsByCityId(cityId);
    }

    // Post request
    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @PutMapping("/{id}")
    public City updateCity(@PathVariable("id") int id, @RequestBody City city) {
        return cityService.updateCity(id, city);
    }

    @PutMapping("/{cityId}/assignAirport")
    public void assignAirportToCity(@PathVariable("cityId") int cityId, @RequestBody Airport airport) {
        cityService.assignAirportToCity(cityId, airport);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable("id") int id) {
        cityService.deleteCity(id);
    }
}
