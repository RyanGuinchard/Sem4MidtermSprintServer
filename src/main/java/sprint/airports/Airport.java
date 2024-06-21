package sprint.airports;
import sprint.cities.City;

public class Airport {
    private int id;
    private String name;
    private String code;
    private City city;

    public Airport() {}

    public Airport(int id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public City getCity() {
        return this.city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
