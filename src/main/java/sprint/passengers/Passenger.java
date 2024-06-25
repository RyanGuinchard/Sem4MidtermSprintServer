package sprint.passengers;

import com.fasterxml.jackson.annotation.*;
import sprint.aircraft.Aircraft;
import sprint.cities.City;
import sprint.airports.Airport;

import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Passenger {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private City city;

    private List<Aircraft> aircrafts;

    private List<Airport> airports;

    public Passenger() {}

    public Passenger(int id, String firstName, String lastName, String phoneNumber, City city, List<Aircraft> aircrafts, List<Airport> airports) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.aircrafts = aircrafts;
        this.airports = airports;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }
}
