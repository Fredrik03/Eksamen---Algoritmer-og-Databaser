package shared;

public class City {
    private String city;
    private String cityAscii;
    private double lat;
    private double lng;
    private String country;
    private String iso2;
    private String iso3;
    private String adminName;
    private String capital;
    private String population;
    private String id;

    public City(String city, String cityAscii, double lat, double lng, String country,
                String iso2, String iso3, String adminName, String capital, String population, String id) {
        this.city = city;
        this.cityAscii = cityAscii;
        this.lat = lat;
        this.lng = lng;
        this.country = country;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.adminName = adminName;
        this.capital = capital;
        this.population = population;
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    @Override
    public String toString() {
        return city + " (" + lat + ")";
    }
}
