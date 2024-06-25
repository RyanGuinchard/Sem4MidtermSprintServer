package sprint.airports;

import com.fasterxml.jackson.annotation.*;
import sprint.aircraft.Aircraft;
import sprint.cities.City;
import sprint.passengers.Passenger;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Airport {
    private int id;
    private String name;
    private String code;

    private City city;

    private List<Passenger> passengers;

    private List<Aircraft> aircrafts;

    public Airport() {}

    public Airport(int id, String name, String code, City city, List<Aircraft> aircrafts) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.city = city;
        this.aircrafts = aircrafts;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(List<Aircraft> aircrafts) {
        this.aircrafts = aircrafts;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
