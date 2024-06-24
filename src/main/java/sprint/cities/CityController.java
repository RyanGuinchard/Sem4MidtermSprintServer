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
    public City getCityById(@PathVariable int id) {
        return cityService.getCityById(id);
    }


    @GetMapping("/{cityId}/airports")
    public List<Airport> getAirportsByCityId(@PathVariable int cityId) {
        return cityService.getAirportsByCityId(cityId);
    }

    // Post request
    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityService.createCity(city);
    }

    @PutMapping("/{id}")
    public City updateCity(@PathVariable int id, @RequestBody City city) {
        return cityService.updateCity(id, city);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable int id) {
        cityService.deleteCity(id);
    }
}
